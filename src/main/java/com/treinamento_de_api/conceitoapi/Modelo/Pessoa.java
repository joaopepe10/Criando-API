package com.treinamento_de_api.conceitoapi.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private int idade;
}
