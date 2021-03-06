package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //以下所有的*都代表变量

    // 1.查询名字是*的第一个employee
    @Query(value = "select e.* from Employee e where e.name=:name order by e.name limit 1", nativeQuery = true)
    Employee findFirstByName(@Param("name") String name);

    //2.找出Employee表中第一个姓名包含`*`字符并且薪资大于*的雇员个人信息
    @Query(value = "select e.* from Employee e where locate(:ch,e.name) and e.salary>:salary order by e.id limit 1", nativeQuery = true)
    Employee findFirstByCharAndSalary(@Param("ch") String ch, @Param("salary") Integer salary);

    //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
    @Query(value = "select e.name from (select * from Employee where companyId=:companyId) e order by e.salary desc limit 1", nativeQuery = true)
    String findMaxSalaryEmployeeNameFrom(@Param("companyId") Integer companyId);

    //4.实现对Employee的分页查询，每页两个数据
    @Query("select e from Employee e")
    Page<Employee> findAllEmployees(Pageable pageable);

    //5.查找**的所在的公司的公司名称
    @Query(value = "select c.companyName from Company c where c.id = (select e.companyId from Employee e where e.name=:name)", nativeQuery = true)
    String findCompanyNameOf(@Param("name") String name);

    //6.将*的名字改成*,输出这次修改影响的行数
    @Modifying
    @Query(value = "update Employee set name=:name where id=:id", nativeQuery = true)
    Integer updateEmployeeNameById(@Param("id") Integer id, @Param("name") String name);

    //7.删除姓名是*的employee
    @Modifying
    @Query(value = "delete from Employee where name=:name", nativeQuery = true)
    Integer deleteByName(@Param("name") String name);

    @Query("select e from Employee e where e.gender=:gender")
    List<Employee> listByGender(@Param("gender") String gender);

    @Query(value = "select id from Employee e order by e.id desc limit 1", nativeQuery = true)
    Integer findLastId();
}
