package com.sea.clientes.dto;

import javax.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class ClienteDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9 ]+$")
    private String nome;

    @NotBlank
    private String cpf;

    @NotEmpty
    private List<EnderecoDTO> enderecos;

    @NotEmpty
    private List<TelefoneDTO> telefones;

    @NotEmpty
    private List<EmailDTO> emails;
}