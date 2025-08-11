package io.ifnmg.oop.cliente;

import io.ifnmg.oop.endereco.EnderecoRepository;
import io.ifnmg.oop.repository.DataSourceFactory;
import io.ifnmg.oop.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteRepository
        extends Repository<Cliente> {

    public ClienteRepository(){
        super();
    }

    public Cliente findByName(String nome) {
        try (EntityManager em = DataSourceFactory.getEntityManager()) {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome", Cliente.class);

            query.setParameter("nome", nome);

            return query.getSingleResultOrNull();
        }
    }
}
