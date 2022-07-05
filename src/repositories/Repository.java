package repositories;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface Repository<T> {
    void salvar (T obj);
    void imprimir();
    Optional<T> buscarPorId (String id);
    void deletarPorId (String id);
    Set<T> buscarTodos();
}
