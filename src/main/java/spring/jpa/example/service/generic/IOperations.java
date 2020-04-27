package spring.jpa.example.service.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IOperations <T extends Serializable> {
    T findOne(final long id);

    T find(final T entity);

    List<T> findAll();

    Optional<T> create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
