package io.ifnmg.oop.endereco;

import io.ifnmg.oop.repository.Repository;

public class EnderecoRepository
        extends Repository<Endereco> {

    @Override
    public String getJpqlFindAll() {
        return "SELECT e FROM Endereco e";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT e FROM Endereco e WHERE e.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Endereco e WHERE e.id = :id";
    }
}
