package com.sea.clientes.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private String cep;

    // 🔥 AGORA OPCIONAIS (ViaCEP preenche)
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    private String complemento;
    private String numero;
}