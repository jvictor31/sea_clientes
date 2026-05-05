package com.sea.clientes.model;

import javax.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero; // sem máscara
    private String tipo;

    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}