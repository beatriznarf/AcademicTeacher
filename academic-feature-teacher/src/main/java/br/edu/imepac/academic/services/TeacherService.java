package br.edu.imepac.academic.services;

import br.edu.imepac.academic.dtos.teacher.TeacherRequestDto;
import br.edu.imepac.academic.model.TeacherModel;
import br.edu.imepac.academic.repositories.TeacherRepository;

import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private br.edu.imepac.academic.model.TeacherModel TeacherModel;

    public TeacherService(TeacherRepository teacherRepository) {this.teacherRepository = teacherRepository;}
    public TeacherModel add(TeacherRequestDto teacherRequestDto) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setNome(teacherRequestDto.getNome());
        teacherModel.setMatricula(teacherRequestDto.getMatricula());

        
        return teacherRepository.save(TeacherModel);
    }

    public TeacherModel getById(Long id) {

        return teacherRepository.findById(id).orElse(null);
    }
}