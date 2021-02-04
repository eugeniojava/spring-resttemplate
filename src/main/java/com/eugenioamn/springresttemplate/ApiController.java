package com.eugenioamn.springresttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ApiController {

    private RestTemplate restTemplate;
    private static String url = "https://restcountries.eu/rest/v2/all";

    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/countries")
    public List<Object> getCountries() {
        Object[] countries = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(countries);
    }
}
