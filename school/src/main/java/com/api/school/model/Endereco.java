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
    @Column(name = "id_enndereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;

    @Column(name = "locadouro")
    private String locadouro;

    @Column(name = "complemento")
    private String compelmento;

    @Column(name = "bairoo")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    @Size(max = 2)
    private String estado;
}
