package io.ifnmg.oop.pedido;

import io.ifnmg.oop.repository.Repository;

public class PedidoRepository
        extends Repository<Pedido> {

    @Override
    public String getJpqlFindAll() {
        return "SELECT a FROM Pedido a";
    }

    @Override
    public String getJpqlFindById() {
        return "SELECT a FROM Pedido a WHERE a.id = :id";
    }

    @Override
    public String getJpqlDeleteById() {
        return "DELETE FROM Pedido a WHERE a.id = :id";
    }
}
