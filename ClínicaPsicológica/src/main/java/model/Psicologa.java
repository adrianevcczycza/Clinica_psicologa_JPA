package model;

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
@Table (name = "Psicologa")
@Getter
@Setter

public class Psicologa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_psicologa", nullable = false)
    private String nome;

    @Column(name = "telefone_psicologa", nullable = false)
    private String telefone;
    
    @Column(name = "especialidade_psicologa", nullable = false)
    private String especialidade;

    @Column(name = "email_psicologa", nullable = false)
    private String email;

    public Psicologa(String nome, String telefone, String especialidade, String email){
        this.nome=nome;
        this.telefone=telefone;
        this.especialidade=especialidade;
        this.email=email;
    }

}
