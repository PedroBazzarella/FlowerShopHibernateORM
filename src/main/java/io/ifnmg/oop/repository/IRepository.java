package io.ifnmg.oop.repository;
import java.util.List;

public interface IRepository<T> {
    Long saveOrUpdate(T e);
    String getJpqlFindAll();
    List<T> findAll();
    String getJpqlFindById();
    T findById(Long id);
    String getJpqlDeleteById();
    boolean delete(T e);
    boolean delete(Long id);
}
