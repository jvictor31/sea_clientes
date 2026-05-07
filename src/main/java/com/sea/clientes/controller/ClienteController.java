package com.sea.clientes.controller;

import com.sea.clientes.dto.ClienteDTO;
import com.sea.clientes.model.Cliente;
import com.sea.clientes.service.ClienteService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody ClienteDTO dto) {

        try {

            return ResponseEntity.ok(service.salvar(dto));

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}