package app.repository;

import java.util.List;

public interface CRUDRepository<T> {
    public T create(T item);
    public T findById(Long id);
    public List<T> findAll();
    public T update(T item);
    public void delete(Long id);
}
