package com.api.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@ToString
public class Endereco {

    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(name = "lograudouro")
    private String lograudouro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairoo")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    @Size(max = 2)
    private String estado;
}
