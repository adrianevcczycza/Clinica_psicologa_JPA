package com.example.ClinicaPsicologica.model;


import java.time.LocalDate;

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
@Table (name = "Consulta")
@Getter
@Setter
public class Consulta {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "data_consulta", nullable = false)
    private LocalDate data;

    @Column (name = "Psicologa_consulta", nullable = false)
    private Psicologa psicologa;

        @Column (name = "Paciente_consulta", nullable = false)
    private Paciente paciente;

    @Column (name = "Modalidade_consulta", nullable = false)
    private String modalidadeConsulta;

    public Consulta (String modalidade, LocalDate data, Psicologa psicologa, Paciente paciente){
        this.modalidadeConsulta= modalidade;
        this.data= data;
        this.psicologa=psicologa;
        this.paciente=paciente;
    }
}
