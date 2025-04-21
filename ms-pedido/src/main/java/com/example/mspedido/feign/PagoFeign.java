package com.example.mspedido.feign;

import com.example.mspedido.dto.Pago;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/pago")
public interface PagoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<Pago> listById(@PathVariable(required = true) Integer id);
}
