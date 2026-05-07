package com.sea.clientes.service;

import com.sea.clientes.dto.*;
import com.sea.clientes.model.*;
import com.sea.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repo;

    public Cliente salvar(ClienteDTO dto) {

        String cpfLimpo = limpar(dto.getCpf());

        if (repo.existsByCpf(cpfLimpo)) {
            throw new RuntimeException("CPF já cadastrado");
        }

        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setCpf(cpfLimpo);

        c.setEnderecos(dto.getEnderecos().stream().map(e -> {

            Endereco en = new Endereco();
            en.setCep(limpar(e.getCep()));

            ViaCepResponse viaCep = buscarCep(en.getCep());

            en.setLogradouro(
                e.getLogradouro() != null && !e.getLogradouro().isEmpty()
                    ? e.getLogradouro()
                    : viaCep.getLogradouro()
            );

            en.setBairro(
                e.getBairro() != null && !e.getBairro().isEmpty()
                    ? e.getBairro()
                    : viaCep.getBairro()
            );

            en.setCidade(
                e.getCidade() != null && !e.getCidade().isEmpty()
                    ? e.getCidade()
                    : viaCep.getLocalidade()
            );

            en.setUf(
                e.getUf() != null && !e.getUf().isEmpty()
                    ? e.getUf()
                    : viaCep.getUf()
            );

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

    public Cliente buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    private String limpar(String v) {
        return v.replaceAll("[^0-9]", "");
    }

    private ViaCepResponse buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return new RestTemplate().getForObject(url, ViaCepResponse.class);
    }
}