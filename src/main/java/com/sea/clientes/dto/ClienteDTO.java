package com.sea.clientes.dto;

import javax.validation.constraints.*;
import lombok.Data;
import javax.validation.Valid;
import java.util.List;

@Data
public class ClienteDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^[A-Za-zÀ-ú0-9 ]+$")
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    private String cpf;

    @NotEmpty
    @Valid
    private List<EnderecoDTO> enderecos;

    @NotEmpty
    @Valid
    private List<TelefoneDTO> telefones;

    @NotEmpty
    @Valid
    private List<EmailDTO> emails;
}