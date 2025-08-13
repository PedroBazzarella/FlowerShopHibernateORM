package io.ifnmg.oop.repository;
import java.util.List;

public interface IRepository<T> {
    Long saveOrUpdate(T e);
    List<T> findAll();
    T findById(Long id);
    boolean delete(T e);
    boolean delete(Long id);

    Long moveToTrash(T e);
    boolean moveToTrashById(Long id);
    boolean moveListToTrash(List<T> e);
    List<T> findAllInTrash();
    T findByIdInTrash(Long id);
    boolean recoverAllFromTrash();
    boolean recoverFromTrash(Long id);
    boolean deleteFromTrash(T e);
    boolean deleteFromTrashId(Long id);
}
