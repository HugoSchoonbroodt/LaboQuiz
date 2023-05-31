package anthohugo.laboquiz.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<TKey, TEntity> {

    Optional<TEntity> getOne(Class<TEntity> entityClass, TKey id);

    List<TEntity> getAll(Class<TEntity> entityClass);

    void add(TEntity entity);

    void update(Class<TEntity> entityClass, TKey id, TEntity updatedEntity);

    void delete(Class<TEntity> entityClass, TKey id);
}