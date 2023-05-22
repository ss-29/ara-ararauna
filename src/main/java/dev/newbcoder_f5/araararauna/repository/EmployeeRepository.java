package dev.newbcoder_f5.araararauna.repository;

import dev.newbcoder_f5.araararauna.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    // select * from <table> where name='<name>' and location='<location>'
    List<Employee> findByNameAndLocation(String name, String location);

    // select * from <table> where name like '%<nameKeyword...>%'
    List<Employee> findByNameContaining(String keyword, Sort sort);
    // List<Employee> findByNameLike(String keyword); // check notes Timestamp 3:16:20 for better understanding

    List<Employee> findByNameOrLocation(String name, String location);

    @Query("from Employee where name = :name or location = :location")
    List<Employee> getEmployeesByNameAndLocationCustom(String name, String location);

    @Transactional
    @Modifying
    @Query("delete from Employee where name = :name")
    Integer deleteEmployeeByName(String name);

}