package com.nguyenh.graphql.service;

import com.nguyenh.graphql.model.Person;
import com.nguyenh.graphql.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    ITestRepository testRepository;

    @Override
    public Person findByFirstName(String name){

        return testRepository.findByFirstName(name);
    }

    @Override
    public Person findById(long id) {
        return testRepository.findById(id);
    }
}
