package br.edu.imepac.academic.controllers;

import br.edu.imepac.academic.dtos.student.StudentRequestDto;
import br.edu.imepac.academic.dtos.student.StudentResponseDto;
import br.edu.imepac.academic.model.StudentModel;
import br.edu.imepac.academic.services.StudentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public HttpEntity<?> addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            this.validadeFieldsRequired(studentRequestDto);

            StudentModel studentModel = studentService.add(studentRequestDto);

            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(studentModel.getId());
            studentResponseDto.setNome(studentModel.getNome());
            studentResponseDto.setMatricula(studentModel.getMatricula());

            return ResponseEntity.status(HttpStatus.CREATED).body(studentResponseDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Algo de errado aconceteu:" + exception.getMessage());
        }
    }

    private void validadeFieldsRequired(StudentRequestDto studentRequestDto) throws Exception {
        List<String> fieldsRequired = new ArrayList<>();

        if (studentRequestDto.getNome().isBlank()) {
            fieldsRequired.add("nome");
        }
        if (studentRequestDto.getMatricula().isBlank()) {
            fieldsRequired.add("matricula");
        }

        if (!fieldsRequired.isEmpty()) {
            throw new Exception("Campos obrigatórios: " + String.join(", ", fieldsRequired));
        }
    }

    @GetMapping("{id}")
    public HttpEntity<?> getStudent(@PathVariable Long id) throws Exception {
        this.validateIdRequired(id);

        StudentModel studentModel = studentService.getById(id);

        if (studentModel != null) {

            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setId(studentModel.getId());
            studentResponseDto.setNome(studentModel.getNome());
            studentResponseDto.setMatricula(studentModel.getMatricula());

            return ResponseEntity.status(HttpStatus.OK).body(studentResponseDto);
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
