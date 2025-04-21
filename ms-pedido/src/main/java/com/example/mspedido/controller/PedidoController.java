package com.example.mspedido.controller;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @RequestMapping("/{id}")
    public Optional<Pedido> buscar(@PathVariable Integer id) {
        return pedidoService.buscar(id);
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido categoria) {
        System.out.println(categoria);
        return pedidoService.guardar(categoria);
    }

    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido categoria) {
        return pedidoService.actualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
    }
}
