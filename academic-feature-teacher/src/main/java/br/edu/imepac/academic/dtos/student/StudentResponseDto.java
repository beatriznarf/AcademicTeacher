package br.edu.imepac.academic.dtos.student;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String nome;
    private String matricula;

    public void setId(Object id) {
    }

    public void setNome(Object nome) {
    }

    public void setMatricula(Object matricula) {
    }
}
