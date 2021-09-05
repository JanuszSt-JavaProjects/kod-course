package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class FinderFacadeTestSuite {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    FinderFacade finderFacade;


    @BeforeEach
    void before() {
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }

    @Test
    void employeesByPartialNames() {

        //Given
        Employee johnSmith = new Employee("John", "Smixxxth");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckxxxson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee mitchKoval = new Employee("Mitch", "Koval");
        Employee antonyKovelics = new Employee("Anthony", "Kovelics");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(mitchKoval);
        employeeDao.save(antonyKovelics);

        //When
        Set<Employee> employees = finderFacade.employeesByPartialName("%xxx%");
        Set<Employee> employees1 = finderFacade.employeesByPartialName("%Kov%");

        Assertions.assertEquals(2, employees.size());
        Assertions.assertEquals(3, employees1.size());
    }

    @Test
    void companyByPartialNames() {

        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company dataMiners = new Company("Data Miners");
        Company greyMatter = new Company("Grey Matter");
        Company shadowMatter = new Company("Shadow Matter");
        Company blackMattriani = new Company("Black Mattriani");

        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);
        companyDao.save(dataMiners);
        companyDao.save(shadowMatter);
        companyDao.save(blackMattriani);

        //When
        Set<Company> companies = finderFacade.companiesByPartialName("%Matt%");
        Set<Company> companies1 = finderFacade.companiesByPartialName("%Ma%");

        //Then
        Assertions.assertEquals(3, companies.size());
        Assertions.assertEquals(5, companies1.size());
    }
}