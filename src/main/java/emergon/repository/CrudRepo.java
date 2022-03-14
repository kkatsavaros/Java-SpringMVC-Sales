package emergon.repository;

import java.util.List;

public interface CrudRepo<E> {
    
    E save(E e);
    void delete(int id);
    E findById(int id);
    List<E> findAll();
}
