package com.api.school.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "escola")
@Getter
@Setter
@ToString
public class Escola {

    @Id
    @Column(name = "id_escola")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idEscola;

    @Column(name = "nome_escola")
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_escola", referencedColumnName = "id_escola")
    public List<Turma> turmas;

}
