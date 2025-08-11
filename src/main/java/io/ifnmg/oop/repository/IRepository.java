package io.ifnmg.oop.repository;
import java.util.List;

public interface IRepository<T> {
    Long saveOrUpdate(T e);
    List<T> findAll();
    T findById(Long id);
    boolean delete(T e);
    boolean delete(Long id);
}
