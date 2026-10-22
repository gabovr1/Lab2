package Lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Repositorio<K, T> {
    private HashMap<K, T> elementos = new HashMap<>();

    public void guardar(K id, T elemento) throws ElementoDuplicadoException{
        if (elementos.containsKey(id)) {
            throw new ElementoDuplicadoException("Ya existe un Cliente con el id " + id);
        }
        elementos.put(id, elemento);
    }

    public Optional<T> buscar(K id) {
        return Optional.ofNullable(elementos.get(id));
    }

    public ArrayList<T> listar() {
        return new ArrayList<>(elementos.values());
    }
}
