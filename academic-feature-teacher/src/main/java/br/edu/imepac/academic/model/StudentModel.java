package br.edu.imepac.academic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String matricula;

    public Object getId() {
        return id;
    }

    public Object getNome() {
        return nome;
    }

    public Object getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
    }

    public void setMatricula(String matricula) {
    }
}
