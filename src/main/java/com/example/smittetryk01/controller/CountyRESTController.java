package com.example.smittetryk01.controller;

import com.example.smittetryk01.model.County;
import com.example.smittetryk01.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountyRESTController {

    @Autowired
    CountyRepository countyRepository;

    @GetMapping("/")
    public String hej(){
        return "Hello world";
    }

    @GetMapping("/counties")
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

    @GetMapping("/county/{ID}")
    public County findCountyById(@PathVariable String ID){
        Optional<County> obj = countyRepository.findById(ID);
        if(obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }

    @PostMapping("/county")
    @ResponseStatus(HttpStatus.CREATED)
    public County postCounty(@RequestBody County county){
        System.out.println(county);
        return countyRepository.save(county);
    }

    @PutMapping("/county/{ID}")
    public ResponseEntity<County> updateCounty(@PathVariable String ID, @RequestBody County county) {
        Optional<County> optCounty = countyRepository.findById(ID);
        if (optCounty.isPresent()) {
            countyRepository.save(county);
            return new ResponseEntity<County>(county, HttpStatus.OK);
        } else {
            County countyNotFound = new County();
            countyNotFound.setName("404 County Not Found (ID = " + ID + ")");
            return new ResponseEntity<County>(countyNotFound, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/county/{ID}")
    public ResponseEntity<String> deleleleleleleteCounty(@PathVariable String ID) {
        try {
            countyRepository.deleteById(ID);
            return new ResponseEntity<>("ID " + ID + " deleted successfully", HttpStatus.OK);
        } catch (Exception delErr) {
            return new ResponseEntity<>("Error in deletion of ID = " + ID, HttpStatus.NOT_FOUND);
        }
    }
}
