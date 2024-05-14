package br.edu.imepac.academic.controllers;

import br.edu.imepac.academic.dtos.student.StudentResponseDto;
import br.edu.imepac.academic.dtos.teacher.TeacherRequestDto;
import br.edu.imepac.academic.dtos.teacher.TeacherResponseDto;
import br.edu.imepac.academic.model.StudentModel;
import br.edu.imepac.academic.model.TeacherModel;
import br.edu.imepac.academic.services.TeacherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private StudentResponseDto teacherResponseDto;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public HttpEntity<?> addTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        try {
            this.validadeFieldsRequired(teacherRequestDto);

            TeacherModel teacherModel = teacherService.add(teacherRequestDto);

            TeacherResponseDto studentResponseDto = new TeacherResponseDto();
            teacherResponseDto.setId(teacherModel.getId());
            teacherResponseDto.setNome(teacherModel.getNome());
            teacherResponseDto.setMatricula(teacherModel.getMatricula());

            return ResponseEntity.status(HttpStatus.CREATED).body(teacherResponseDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo de errado aconceteu:" + exception.getMessage());
        }
    }

    private void validadeFieldsRequired(TeacherRequestDto teacherRequestDto) throws Exception {
        List<String> fieldsRequired = new ArrayList<>();

        if (teacherRequestDto.getNome().isBlank()) {
            fieldsRequired.add("nome");
        }
        if (teacherRequestDto.getMatricula().isBlank()) {
            fieldsRequired.add("matricula");
        }

        if (!fieldsRequired.isEmpty()) {
            throw new Exception("Campos obrigatórios: " + String.join(", ", fieldsRequired));
        }
    }

    @GetMapping("{id}")
    public HttpEntity<?> getTeacher(@PathVariable Long id) throws Exception {
        this.validateIdRequired(id);

        TeacherModel teacherModel = teacherService.getById(id);

        if (teacherModel != null) {

            TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
            teacherResponseDto.setId(teacherModel.getId());
            teacherResponseDto.setNome(teacherModel.getNome());
            teacherResponseDto.setMatricula(teacherModel.getMatricula());


            return ResponseEntity.status(HttpStatus.OK).body(teacherResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado!");
        }
    }

    private void validateIdRequired(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Campo id obrigatórios");
        }
    }
}