package br.edu.imepac.academic.repositories;

import br.edu.imepac.academic.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
}