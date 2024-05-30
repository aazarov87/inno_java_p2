package ru.inno.edu.task5.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.edu.task5.dto.ProductInput;
import ru.inno.edu.task5.service.TppProductService;
@RestController
@Validated
public class ProductController {

    @Autowired
    TppProductService tppProductService;

    @PostMapping("/corporate-settlement-instance/create")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Object> insProduct(@Valid @RequestBody ProductInput productInput) throws Exception {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(tppProductService.exec(productInput));
    }
}
