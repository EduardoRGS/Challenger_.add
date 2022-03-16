package com.api.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@ToString
public class Aluno {

    @Id
    @Column(name = "id_aluno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(name = "nome_aluno")
    private String nome;

    @Column(name = "dataDeNascimento")
    private LocalDateTime dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @OneToOne
    @JoinColumn(name = "id_escola")
    private Escola escola;
}
