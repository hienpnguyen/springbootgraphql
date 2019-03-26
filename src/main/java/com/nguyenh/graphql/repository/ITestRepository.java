package com.nguyenh.graphql.repository;

import com.nguyenh.graphql.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestRepository extends CrudRepository<Person, Long> {

    Person findByFirstName(String firstName);

    Person findById(long id);

    List<Person> findAll();

}
