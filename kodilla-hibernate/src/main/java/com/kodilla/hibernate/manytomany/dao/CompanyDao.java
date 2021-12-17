package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao  extends CrudRepository<Company, Integer> {

    List<Company> retrieveCompaniesNameStartingWith(@Param("COMPANY_FIRST_LETTERS") String startingLetters);

    @Query
    List<Company> retrieveCompaniesNameContainingText(@Param("TEXT") String text);
}
