package com.example.ClinicaPsicologica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Paciente")
@Getter
@Setter

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_paciente", nullable = false)
    private String nome;

    @Column(name = "idade_paciente", nullable = false)
    private int idade;

    @Column(name = "email_paciente", nullable = false)
    private String email;

    @Column(name = "telefone_paciente", nullable = false)
    private String telefone;

    public Paciente(String nome, int idade, String email, String telefone){
        this.nome=nome;
        this.idade=idade;
        this.email=email;
        this.telefone=telefone;
    }

}
