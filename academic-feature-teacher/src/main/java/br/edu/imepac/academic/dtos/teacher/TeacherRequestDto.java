package br.edu.imepac.academic.dtos.teacher;

import lombok.Data;

@Data
public class TeacherRequestDto {
        private String nome;
        private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
}