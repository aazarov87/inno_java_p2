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
import ru.inno.edu.task5.dto.PgRegistryInput;
import ru.inno.edu.task5.dto.Response;
import ru.inno.edu.task5.service.TppProductRegisterService;

@RestController
@Validated
public class ProductRegisterController {

    @Autowired
    TppProductRegisterService tppProductRegisterService;

    @PostMapping("/corporate-settlement-account/create")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Object> insPrReg(@Valid @RequestBody PgRegistryInput pgRegistryInput) throws Exception {

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Response(tppProductRegisterService.add(pgRegistryInput))
                );
    }
}
