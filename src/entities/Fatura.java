package entities;

import java.util.Set;
import java.util.UUID;

public class Fatura {
    private UUID codigo;
    private Cliente cliente;
    private Set<Item> listaItems;
    private Double totalDaCompra;

    public Fatura(Cliente cliente, Set<Item> listaItems) {
        this.codigo = UUID.randomUUID();
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalDaCompra = this.calcularTotalDaCompra();
    }

    private Double calcularTotalDaCompra() {
        return this.listaItems.stream().reduce(0D, (subtotal, item) -> subtotal + item.getCustoUnitario(), Double::sum);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Set<Item> getListaItems() {
        return listaItems;
    }

    public void adicionarItem(Item item) {
        this.listaItems.add(item);
        this.calcularTotalDaCompra();
    }

    public Double getTotalDaCompra() {
        return totalDaCompra;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalDaCompra=" + totalDaCompra +
                '}';
    }
}
