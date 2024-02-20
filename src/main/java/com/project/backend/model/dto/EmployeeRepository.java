package com.project.backend.model.dto;

import com.project.backend.model.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
