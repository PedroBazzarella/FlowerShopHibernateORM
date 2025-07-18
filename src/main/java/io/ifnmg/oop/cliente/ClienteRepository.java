package io.ifnmg.oop.cliente;

import io.ifnmg.oop.cliente.*;
import io.ifnmg.oop.repository.Repository;

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
}
