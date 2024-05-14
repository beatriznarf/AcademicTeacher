package br.edu.imepac.academic.dtos.teacher;

import lombok.Data;

@Data
public class TeacherResponseDto {
    private Long id;
    private String nome;
    private String matricula;

    public Object setMatricula(Object matricula) {
        return matricula;
    }

    public Object setNome(Object nome) {
        return nome;
    }

    public void setId(Object id) {
    }
}