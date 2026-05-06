package com.sea.clientes.service;

import com.sea.clientes.dto.*;
import com.sea.clientes.model.*;
import com.sea.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repo;

    public Cliente salvar(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setCpf(limpar(dto.getCpf()));

        c.setEnderecos(dto.getEnderecos().stream().map(e -> {
            Endereco en = new Endereco();
            en.setCep(limpar(e.getCep()));
            en.setLogradouro(e.getLogradouro());
            en.setBairro(e.getBairro());
            en.setCidade(e.getCidade());
            en.setUf(e.getUf());
            en.setNumero(e.getNumero());
            en.setComplemento(e.getComplemento());
            en.setCliente(c);
            return en;
        }).collect(Collectors.toList()));

        c.setTelefones(dto.getTelefones().stream().map(t -> {
            Telefone tel = new Telefone();
            tel.setNumero(limpar(t.getNumero()));
            tel.setTipo(t.getTipo());
            tel.setCliente(c);
            return tel;
        }).collect(Collectors.toList()));

        c.setEmails(dto.getEmails().stream().map(em -> {
            Email email = new Email();
            email.setEndereco(em.getEndereco());
            email.setCliente(c);
            return email;
        }).collect(Collectors.toList()));

        return repo.save(c);
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    private String limpar(String v) {
        return v.replaceAll("[^0-9]", "");
    }

    public Cliente buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}