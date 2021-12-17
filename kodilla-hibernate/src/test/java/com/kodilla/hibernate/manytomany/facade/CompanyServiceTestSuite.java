package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CompanyServiceTestSuite {

    @Autowired
    CompanyServiceFacade companyService;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testFindByPartOfCompanyName() {
        //Given
        Company comarch = new Company("Comarch");
        Company objectivity = new Company("Objectivity");
        Company accenture = new Company("Accenture");

        Employee kowalski = new Employee("Jan", "Kowalski");
        Employee bak = new Employee("Janina", "Bąk");
        Employee kowal = new Employee("Krzysztof", "Kowal");
        Employee sokolowski = new Employee("Cezary", "Sokołowski");
        Employee kowalewski = new Employee("Jan", "Kowalewski");
        Employee janina = new Employee("Janina", "Bączyńska");
        Employee kowalik = new Employee("Krzysztof", "Kowalik");

        comarch.getEmployees().add(kowalski);
        comarch.getEmployees().add(bak);
        comarch.getEmployees().add(sokolowski);
        comarch.getEmployees().add(kowal);

        objectivity.getEmployees().add(janina);

        accenture.getEmployees().add(kowalik);
        accenture.getEmployees().add(kowalewski);

        kowalski.getCompanies().add(comarch);
        bak.getCompanies().add(comarch);
        sokolowski.getCompanies().add(comarch);
        kowal.getCompanies().add(comarch);
        janina.getCompanies().add(objectivity);
        kowalik.getCompanies().add(accenture);
        kowalewski.getCompanies().add(accenture);

        companyDao.save(comarch);
        companyDao.save(objectivity);
        companyDao.save(accenture);
        employeeDao.save(kowal);
        employeeDao.save(kowalewski);
        employeeDao.save(kowalik);
        employeeDao.save(kowalski);
        employeeDao.save(sokolowski);
        employeeDao.save(bak);
        employeeDao.save(janina);


        //When
        List<Company> result = companyService.findCompanyByContainingText("%c%");

        //Then
        assertEquals(3, result.size());

        //CleanUp
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    public void testFindByPartOfEmployeeName() {
        //Given
        Company comarch = new Company("Comarch");
        Company objectivity = new Company("Objectivity");
        Company accenture = new Company("Accenture");

        Employee kowalski = new Employee("Jan", "Kowalski");
        Employee bak = new Employee("Janina", "Bąk");
        Employee kowal = new Employee("Krzysztof", "Kowal");
        Employee sokolowski = new Employee("Cezary", "Sokołowski");
        Employee kowalewski = new Employee("Jan", "Kowalewski");
        Employee janina = new Employee("Janina", "Bączyńska");
        Employee kowalik = new Employee("Krzysztof", "Kowalik");

        comarch.getEmployees().add(kowalski);
        comarch.getEmployees().add(bak);
        comarch.getEmployees().add(sokolowski);
        comarch.getEmployees().add(kowal);

        objectivity.getEmployees().add(janina);

        accenture.getEmployees().add(kowalik);
        accenture.getEmployees().add(kowalewski);

        kowalski.getCompanies().add(comarch);
        bak.getCompanies().add(comarch);
        sokolowski.getCompanies().add(comarch);
        kowal.getCompanies().add(comarch);
        janina.getCompanies().add(objectivity);
        kowalik.getCompanies().add(accenture);
        kowalewski.getCompanies().add(accenture);

        companyDao.save(comarch);
        companyDao.save(objectivity);
        companyDao.save(accenture);
        employeeDao.save(kowal);
        employeeDao.save(kowalewski);
        employeeDao.save(kowalik);
        employeeDao.save(kowalski);
        employeeDao.save(sokolowski);
        employeeDao.save(bak);
        employeeDao.save(janina);


        //When
        List<Employee> result = companyService.findEmployeeByContainingText("%owal%");

        //Then
        assertEquals(4, result.size());

        //CleanUp
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }
}
