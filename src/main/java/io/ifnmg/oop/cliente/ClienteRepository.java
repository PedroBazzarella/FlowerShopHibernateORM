package io.ifnmg.oop.cliente;

import io.ifnmg.oop.repository.DataSourceFactory;
import io.ifnmg.oop.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteRepository
        extends Repository<Cliente> {

    @Override
    public String getJpqlFindAll() {
        return "SELECT c FROM Cliente c";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT c FROM Cliente c WHERE c.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Cliente c WHERE c.id = :id";
    }

    public Cliente findByName(String nome) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome", Cliente.class);

            query.setParameter("nome", nome);

            return query.getSingleResultOrNull();
        }
    }
}
