//package com.example.mspedido.entity;
//
//
//import com.example.mspedido.dto.Cliente;
//import com.example.mspedido.dto.Pago;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Pedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String serie;
//    private String numero;
//    private String descricao;
//    private Integer clienteId;
//
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "venta_id")
//    private List<PedidoDetalle> detalle;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getClienteId() {
//        return clienteId;
//    }
//
//
//
//
//    @Transient
//    private Cliente cliente;
//}



//
//package com.example.mspedido.entity;
//
//import com.example.mspedido.dto.Cliente;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Pedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String serie;
//    private String numero;
//    private String descricao;
//    private Integer clienteId;
//
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "venta_id")
//    private List<PedidoDetalle> detalle;
//
//    @Transient
//    private Cliente cliente;
//}







package com.example.mspedido.entity;

import com.example.mspedido.dto.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
//@Table(name = "pedido")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serie;
    private String numero;
    private String descricao;
    private Integer clienteId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<PedidoDetalle> detalle;

    @Transient
    private Cliente cliente;

    // --- Getters y Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<PedidoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<PedidoDetalle> detalle) {
        this.detalle = detalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
