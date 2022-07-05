package entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    private UUID codigo;
    private String nome;
    private Integer quantidadeComprada;
    private Double custoUnitario;

    public Item(String nome, Integer quantidadeComprada,Double custoUnitario) {
        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.quantidadeComprada = quantidadeComprada;
        this.custoUnitario = custoUnitario;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(Integer quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
    }

    public Double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(Double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    @Override
    public String toString() {
        return "entities.Item{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", quantidadeComprada=" + quantidadeComprada +
                ", custoUnitario=" + custoUnitario +
                '}';
    }
}
