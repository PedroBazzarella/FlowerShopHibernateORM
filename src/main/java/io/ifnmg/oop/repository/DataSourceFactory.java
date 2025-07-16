package io.ifnmg.oop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DataSourceFactory {
    private static EntityManagerFactory emf;
    private static final String PU_NAME = "FlowerShopPU";

    // EntityManagerFactory can have a persistent lifecycle
    private static EntityManagerFactory getEMFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PU_NAME);
        }

        return emf;
    }

    // EntityManager is not thread safe! A desktop application is
    // single threaded, but do not share the object for safety
    // (open and close in the processing method)
    public static EntityManager getEntityManager() {
        return DataSourceFactory.getEMFactory().createEntityManager();
    }
}
