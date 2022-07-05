package repositories;

import entities.Cliente;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClienteRepository implements Repository<Cliente>{
    Set<Cliente> listaDeClientes;

    public ClienteRepository() {
        this.listaDeClientes = new HashSet<>();
    }

    @Override
    public void salvar(Cliente obj) {
        this.listaDeClientes.add(obj);
    }

    @Override
    public void imprimir() {
        this.listaDeClientes.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        for (Cliente c : this.listaDeClientes) {
            if(id.equals(c.getId().toString())) {
                return Optional.of(c);
            }
        }
        System.out.println("Não foi encontrado um Cliente com esse ID.");
        return Optional.empty();
    }

    @Override
    public void deletarPorId(String id) {
        Optional<Cliente> c = this.buscarPorId(id);
        if(c.isEmpty()) {
            System.out.println("Erro ao deletar cliente.");
        } else {
            this.listaDeClientes.remove(c);
            System.out.println("Cliente " + c.get().getNome() + " deletado com sucesso.");
        }
    }

    @Override
    public Set<Cliente> buscarTodos() {
        return this.listaDeClientes;
    }
}
