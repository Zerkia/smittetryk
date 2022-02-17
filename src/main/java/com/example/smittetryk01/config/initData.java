package com.example.smittetryk01.config;

import com.example.smittetryk01.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.smittetryk01.model.County;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    CountyRepository countyRepository;

    @Override
    public void run(String... args) throws Exception {
        County roskilde = new County();
        roskilde.setName("Roskilde");
        roskilde.setCountyCode("0265");
        roskilde.setHref("http://localhost:8080/county/0265");
        countyRepository.save(roskilde);

        County solrød = new County();
        solrød.setName("Sølrød");
        solrød.setCountyCode("0269");
        solrød.setHref("http://localhost:8080/county/0269");
        countyRepository.save(solrød);
    }
}
