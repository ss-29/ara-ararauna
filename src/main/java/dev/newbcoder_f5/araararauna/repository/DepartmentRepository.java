package dev.newbcoder_f5.araararauna.repository;

import dev.newbcoder_f5.araararauna.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
