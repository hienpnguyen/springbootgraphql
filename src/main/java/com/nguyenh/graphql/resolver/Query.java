package com.nguyenh.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nguyenh.graphql.model.Person;
import com.nguyenh.graphql.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    ITestRepository iTestRepository;

    public Person findById(long id) {
        return iTestRepository.findById(id);
    }

    public Person findByFirstName(String name){
        return iTestRepository.findByFirstName(name);
    }

    public List<Person> person(){
        return iTestRepository.findAll();
    }
}
