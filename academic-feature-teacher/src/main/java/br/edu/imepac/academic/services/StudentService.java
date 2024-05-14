package br.edu.imepac.academic.services;

import br.edu.imepac.academic.dtos.student.StudentRequestDto;
import br.edu.imepac.academic.model.StudentModel;
import br.edu.imepac.academic.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentModel add(StudentRequestDto studentRequestDto) {
        StudentModel studentModel = new StudentModel();
        studentModel.setNome(studentRequestDto.getNome());
        studentModel.setMatricula(studentRequestDto.getMatricula());

        return studentRepository.save(studentModel);
    }

    public StudentModel getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
