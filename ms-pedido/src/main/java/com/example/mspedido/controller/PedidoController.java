package com.example.mspedido.controller;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.PagoFeign;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;



    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private PagoFeign pagoFeign;




    @GetMapping
    public ResponseEntity<List<Pedido>> list() {
        return ResponseEntity.ok(pedidoService.listar());
    }
    @RequestMapping("/{id}")
    public Optional<Pedido> buscar(@PathVariable Integer id) {
        return pedidoService.buscar(id);
    }

    @PostMapping()
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.guardar(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.actualizar(pedido));
    }




//    @GetMapping("/{id}")
//public ResponseEntity<Pedido> listById(@PathVariable(required = true) Integer id) {
//    return ResponseEntity.ok().body(pedidoService.listarPorId(id).get());
//}

//    @GetMapping("/{id}")
//    public ResponseEntity<Pedido> listById(@PathVariable(required = true) Integer id) {
//        return ResponseEntity.ok().body(pedidoService.listarPorId(id).get());
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listById(@PathVariable(required = true) Integer id) {
        Optional<Pedido> pedidoOptional = pedidoService.listarPorId(id) ;
//        Optional<Pedido> pedidoOptional = pedidoService.listarPorId(id);
        return pedidoOptional.map(pedido -> ResponseEntity.ok().body(pedido))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado con ID: " + id));
    }



//    @GetMapping("/{id}")
//    public ResponseEntity<Pedido> listById(@PathVariable Integer id) {
//        return pedidoService.listarPorId(id)
//                .map(pedido -> ResponseEntity.ok().body(pedido))
//                .orElse(ResponseEntity.notFound().build());
//    }



    @CircuitBreaker(name = "pedidoListarPorIdCB", fallbackMethod = "fallBackPedidoListarPorIdCB")


    private ResponseEntity<Pedido> fallBackPedidoListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Pedido pedido = new Pedido();
        pedido.setId(90000);
        return ResponseEntity.ok().body(pedido);
    }




}