package com.nguyenh.graphql.controller;

import com.nguyenh.graphql.model.Person;
import com.nguyenh.graphql.service.TestService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@SuppressWarnings("Duplicates")
public class EligibilityController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public ResponseEntity<String> helloWorld(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getId(HttpServletRequest request, @PathVariable Long id){
        JSONObject jsonObject = new JSONObject();

        Person t = testService.findById(id);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", t.getFirstName() + " " + t.getLastName());
        jsonObject1.put("id", t.getPersonId());
        jsonObject1.put("address",t.getAddress().getAddress());

        jsonObject.put("data", jsonObject1);

        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> getName(HttpServletRequest request, @PathVariable String name){
        JSONObject jsonObject = new JSONObject();

        Person t = testService.findByFirstName(name);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", t.getFirstName() + " " + t.getLastName());
        jsonObject1.put("id", t.getPersonId());

        jsonObject.put("data", jsonObject1);

        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

}
