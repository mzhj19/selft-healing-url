package org.zahidhasanjamil.selfHealingURL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahidhasanjamil.selfHealingURL.service.ApiService;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/fetch-data")
    public ResponseEntity<String> fetchData() {
        String response = apiService.makeRequest();
        return ResponseEntity.ok(response);
    }
}
