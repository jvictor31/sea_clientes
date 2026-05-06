package com.sea.clientes.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private String cep;

    // 🔥 AGORA OPCIONAIS (ViaCEP preenche)
    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    private String complemento;
    private String numero;
}