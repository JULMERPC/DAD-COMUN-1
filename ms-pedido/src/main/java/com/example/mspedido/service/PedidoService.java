package com.example.mspedido.service;

import com.example.mspedido.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listar();
    Optional<Pedido> buscar(Integer id);
    Pedido guardar(Pedido categoria);
    Pedido actualizar(Integer id, Pedido categoria );
    void eliminar(Integer id);
}


