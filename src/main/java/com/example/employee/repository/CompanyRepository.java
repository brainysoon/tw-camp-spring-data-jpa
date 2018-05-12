package com.example.employee.repository;

import com.example.employee.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c")
    Page<Company> findByPage(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update Company set companyName=?2 , employeesNumber=?3 where id=?1", nativeQuery = true)
    int updateById(Integer id, String companyName, Integer employeesNumber);
}
