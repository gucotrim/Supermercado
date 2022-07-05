package repositories;

import entities.Item;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ItemRepository implements Repository<Item> {
    Set<Item> listaDeItems;

    public ItemRepository() {
        this.listaDeItems = new HashSet<>();
    }

    @Override
    public void salvar(Item obj) {
        this.listaDeItems.add(obj);
    }

    @Override
    public void imprimir() {
        this.listaDeItems.forEach(System.out::println);
    }

    @Override
    public Optional<Item> buscarPorId(String codigo) {
        for (Item i : this.listaDeItems) {
            if(codigo.equals(i.getCodigo().toString())) {
                return Optional.of(i);
            }
        }
        System.out.println("Não foi encontrado um Item com esse Código.");
        return Optional.empty();
    }

    @Override
    public void deletarPorId(String codigo) {
        Optional<Item> i = this.buscarPorId(codigo);
        if(i.isEmpty()) {
            System.out.println("Erro ao deletar item.");
        } else {
            this.listaDeItems.remove(i);
            System.out.println(
                    "Item " + i.get().getNome() + " deletado com sucesso."
            );
        }
    }

    @Override
    public Set<Item> buscarTodos() {
        return this.listaDeItems;
    }
}
