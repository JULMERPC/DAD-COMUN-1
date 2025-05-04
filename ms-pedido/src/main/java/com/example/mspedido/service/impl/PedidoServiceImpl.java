//package com.example.mspedido.service.impl;
//
//import com.example.mspedido.dto.Cliente;
//import com.example.mspedido.dto.Pago;
//import com.example.mspedido.entity.Pedido;
//import com.example.mspedido.entity.PedidoDetalle;
//import com.example.mspedido.feign.ClienteFeign;
//import com.example.mspedido.feign.PagoFeign;
//import com.example.mspedido.repository.PedidoRepository;
//import com.example.mspedido.service.PedidoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class PedidoServiceImpl implements PedidoService {
//
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private ClienteFeign clienteFeign;
//
//
//    @Autowired
//    private PagoFeign pagoFeign;
//
//
//
//
//
//
//
//
//    @Override
//    public List<Pedido> listar() {
//        return pedidoRepository.findAll();
//    }
//
//    @Override
//    public Optional<Pedido> buscar(Integer id) {
//        return pedidoRepository.findById(id);
//    }
//
//    @Override
//    public Pedido guardar(Pedido pedido) {
//        return pedidoRepository.save(pedido);
//    }
//
//    @Override
//    public Pedido actualizar(Integer id, Pedido pedido) {
//        pedido.setId(id);
//        return pedidoRepository.save(pedido);
//    }
//
//    @Override
//    public Optional<Pedido> listarPorId(Integer id) {
//        Pedido pedido = pedidoRepository.findById(id).get();
//        Cliente cliente = clienteFeign.listById(pedido.getClienteId()).getBody();
//        List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
//            Pago pago = pagoFeign.listById(pedidoDetalle.getPagoId()).getBody();
//            pedidoDetalle.setPago(pago);
//            return pedidoDetalle;
//        }).collect(Collectors.toList());
//        pedido.setDetalle(pedidoDetalles);
//        pedido.setClienteId(cliente.getId());
////        pedido.setCliente(cliente);
//        return Optional.of(pedido);
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//        pedidoRepository.deleteById(id);
//
//    }
//}





package com.example.mspedido.service.impl;

import com.example.mspedido.dto.Cliente;
import com.example.mspedido.dto.Pago;
import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.PagoFeign;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {



    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private PagoFeign pagoFeign;


    @Override
    public Optional<Pedido> buscar(Integer id) {
        return pedidoRepository.findById(id);
    }


    @Override
    public List<Pedido> listar(){ return pedidoRepository.findAll(); }


//    @Override
//    public Optional<Pedido> listarPorId(Integer id) {
//        Pedido pedido = pedidoRepository.findById(id).get();
//        Cliente cliente = clienteFeign.listById(pedido.getClienteId()).getBody();
//        List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
//            Pago pago = pagoFeign.listById(pedidoDetalle.getPagoId()).getBody();
//            pedidoDetalle.setPago(pago);
//            return pedidoDetalle;
//        }).collect(Collectors.toList());
//        pedido.setDetalle(pedidoDetalles);
//        pedido.setCliente(cliente);
//        return Optional.of(pedido);
//    }

    @Override
    public Optional<Pedido> listarPorId(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.map(pedido -> {
            Cliente cliente = clienteFeign.listById(pedido.getClienteId()).getBody();
            List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
                Pago pago = pagoFeign.listById(pedidoDetalle.getPagoId()).getBody();
                pedidoDetalle.setPago(pago);
                return pedidoDetalle;
            }).collect(Collectors.toList());
            pedido.setDetalle(pedidoDetalles);
            pedido.setCliente(cliente);
            return pedido;
        });
    }



//    @Override
//    public Optional<Pedido> listarPorId(Integer id) {
//        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
//
//        if (!pedidoOptional.isPresent()) {
//            return Optional.empty();
//        }
//
//        Pedido pedido = pedidoOptional.get();
//
//        Cliente cliente = clienteFeign.listById(pedido.getClienteId()).getBody();
//        if (cliente == null) {
//            throw new RuntimeException("Cliente no encontrado para el pedido con id: " + id);
//        }
//
//        List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
//            Pago pago = pagoFeign.listById(pedidoDetalle.getPagoId()).getBody();
//            if (pago == null) {
//                throw new RuntimeException("Pago no encontrado para el detalle de pedido con id: " + pedidoDetalle.getId());
//            }
//            pedidoDetalle.setPago(pago);
//            return pedidoDetalle;
//        }).collect(Collectors.toList());
//
//        pedido.setDetalle(pedidoDetalles);
//        pedido.setCliente(cliente);
//
//        return Optional.of(pedido);
//    }


    @Override
    public Pedido guardar(Pedido pedido){return pedidoRepository.save(pedido);}

    @Override
    public Pedido actualizar(Pedido pedido) {return pedidoRepository.save(pedido);}


    @Override
    public void eliminarPorId(Integer id) { pedidoRepository.deleteById(id); }
}

