package repositories;

import entities.Fatura;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FaturaRepository implements Repository<Fatura> {
    Set<Fatura> listaDeFaturas;

    public FaturaRepository() {
        this.listaDeFaturas = new HashSet<>();
    }

    @Override
    public void salvar(Fatura obj) {
        this.listaDeFaturas.add(obj);
    }

    @Override
    public void imprimir() {
        this.listaDeFaturas.forEach(System.out::println);
    }

    @Override
    public Optional<Fatura> buscarPorId(String codigo) {
        for (Fatura f : this.listaDeFaturas) {
            if(codigo.equals(f.getCodigo().toString())) {
                return Optional.of(f);
            }
        }
        System.out.println("Não foi encontrado uma Fatura com esse codigo.");
        return Optional.empty();
    }

    @Override
    public void deletarPorId(String codigo) {
        Optional<Fatura> f = this.buscarPorId(codigo);
        if(f.isEmpty()) {
            System.out.println("Erro ao deletar fatura.");
        } else {
            this.listaDeFaturas.remove(f);
            System.out.println("Fatura " + f.get().getCodigo() + " deletada com sucesso.");
        }
    }

    @Override
    public Set<Fatura> buscarTodos() {
        return this.listaDeFaturas;
    }
}
