//package com.example.mspedido.entity;
//
//
//import com.example.mspedido.dto.Pago;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//import org.springframework.data.annotation.Transient;
//
//@Entity
//@Data
//public class PedidoDetalle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private Double cantidad;
//    private Double precio;
//    private Integer pagoId;
//
//    @Transient
//    private Pago pago ;
//
//    public PedidoDetalle() {
//        this.cantidad = (double) 0;
//        this.precio = (double) 0;
//    }
//}





package com.example.mspedido.entity;

import com.example.mspedido.dto.Pago;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPagoId() {
        return pagoId;
    }

    public void setPagoId(Integer pagoId) {
        this.pagoId = pagoId;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    private String producto;
    private Double cantidad;
    private Double precio;
    private Integer pagoId; // <-- Necesario para getPagoId()

    @Transient
    private Pago pago; // <-- Necesario para setPago()

    public PedidoDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", pagoId=" + pagoId +
                ", pago=" + pago +
                '}';
    }
}
