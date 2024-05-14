package br.edu.imepac.academic.repositories;

import br.edu.imepac.academic.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
