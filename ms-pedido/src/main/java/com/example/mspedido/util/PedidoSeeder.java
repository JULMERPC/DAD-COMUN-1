package com.example.mspedido.util;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.repository.PedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PedidoSeeder implements CommandLineRunner {

    private final PedidoRepository pedidoRepository;

    public PedidoSeeder(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void run(String... args) {

        // Elimina todos los registros anteriores si es necesario
//         pedidoRepository.deleteAll();

        if (pedidoRepository.count() == 0) { // Verifica si la tabla está vacía
            // Crear objetos de pedidos
            Pedido pedido1 = new Pedido();
            pedido1.setSerie("S001");
            pedido1.setNumero("1001");
            pedido1.setDescripcion("Pedido de electrónicos");
            pedido1.setClienteId(1);

            Pedido pedido2 = new Pedido();
            pedido2.setSerie("S002");
            pedido2.setNumero("1002");
            pedido2.setDescripcion("Pedido de ropa");
            pedido2.setClienteId(2);

            Pedido pedido3 = new Pedido();
            pedido3.setSerie("S003");
            pedido3.setNumero("1003");
            pedido3.setDescripcion("Pedido de libros");
            pedido3.setClienteId(3);

            Pedido pedido4 = new Pedido();
            pedido4.setSerie("S004");
            pedido4.setNumero("1004");
            pedido4.setDescripcion("Pedido de juguetes");
            pedido4.setClienteId(4);

            Pedido pedido5 = new Pedido();
            pedido5.setSerie("S005");
            pedido5.setNumero("1005");
            pedido5.setDescripcion("Pedido de computadoras");
            pedido5.setClienteId(5);

            Pedido pedido6 = new Pedido();
            pedido6.setSerie("S006");
            pedido6.setNumero("1006");
            pedido6.setDescripcion("Pedido de artículos deportivos");
            pedido6.setClienteId(6);

            Pedido pedido7 = new Pedido();
            pedido7.setSerie("S007");
            pedido7.setNumero("1007");
            pedido7.setDescripcion("Pedido de salud y belleza");
            pedido7.setClienteId(7);

            // Guardar en la base de datos
            pedidoRepository.save(pedido1);
            pedidoRepository.save(pedido2);
            pedidoRepository.save(pedido3);
            pedidoRepository.save(pedido4);
            pedidoRepository.save(pedido5);
            pedidoRepository.save(pedido6);
            pedidoRepository.save(pedido7);

            System.out.println("✅ Datos de pedidos insertados correctamente.");
        } else {
            System.out.println("Los pedidos ya existen, no se insertaron datos.");
        }
    }
}
