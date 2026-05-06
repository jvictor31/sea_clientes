package com.sea.clientes.controller;

import com.sea.clientes.dto.ClienteDTO;
import com.sea.clientes.model.Cliente;
import com.sea.clientes.service.ClienteService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public Cliente criar(@Valid @RequestBody ClienteDTO dto) {
        return service.salvar(dto);
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