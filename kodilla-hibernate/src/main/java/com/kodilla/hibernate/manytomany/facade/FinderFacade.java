package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class FinderFacade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public Set<Employee> employeesByPartialName(String partialName) {
        return employeeDao.retrieveEmployeeByPartialName(partialName);
    }

    public Set<Company> companiesByPartialName(String partialName) {
        return companyDao.retrieveCompanyByPartialName(partialName);
    }


}
