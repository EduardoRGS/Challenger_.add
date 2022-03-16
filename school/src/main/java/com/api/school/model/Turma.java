package com.api.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "turma")
@Getter
@Setter
@ToString
public class Turma {

    @Id
    @Column(name = "id_turma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @Column(name = "nome_turma")
    @NotNull
    private String nome;

    @Column(name = "capacidade_turma")
    @NotNull
    private int capacidade;
}
