package com.sea.clientes.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TelefoneDTO {

    @NotBlank
    private String numero;

    @NotBlank
    private String tipo;
}