package br.edu.imepac.academic.dtos.student;

import lombok.Data;

@Data
public class StudentRequestDto {
    private String nome;
    private String matricula;

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}