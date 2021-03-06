package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;


@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Employee retrieveEmployeeByName(@Param("LASTNAME") String lastname);

    Set<Employee> retrieveEmployeeByPartialName(@Param("ARG") String partialLastname);
}
