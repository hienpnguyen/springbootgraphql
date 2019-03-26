package com.nguyenh.graphql.service;

import com.nguyenh.graphql.model.Person;

public interface TestService {
    Person findByFirstName(String name);

    Person findById(long id);
}
