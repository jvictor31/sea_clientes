package com.sea.clientes.model;

import javax.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep; // sem máscara
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}