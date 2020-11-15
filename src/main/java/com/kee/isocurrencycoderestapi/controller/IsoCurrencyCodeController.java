package com.kee.isocurrencycoderestapi.controller;

import com.kee.isocurrencycoderestapi.entity.IsoCurrencyCode;
import com.kee.isocurrencycoderestapi.exception.ResourceNotFoundException;
import com.kee.isocurrencycoderestapi.repository.IsoCurrencyCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iso-currency-code")
public class IsoCurrencyCodeController {

    @Autowired
    private IsoCurrencyCodeRepository isoCurrencyCodeRepository;

    // get all ISO currency code
    @GetMapping
    public List<IsoCurrencyCode> getAllIsoCurrencyCodes() {
        return this.isoCurrencyCodeRepository.findAll();
    }

    // get ISO currency code by alphabetic code
    @GetMapping("/{id}")
    public IsoCurrencyCode getIsoCurrencyCodeById(@PathVariable (value = "id") long isoCurrencyCodeId) {
        return this.isoCurrencyCodeRepository.findById(isoCurrencyCodeId).orElseThrow(() ->
                new ResourceNotFoundException("ISO currency code not found with given id: " + isoCurrencyCodeId));
    }

    // create ISO currency code
    @PostMapping
    public IsoCurrencyCode createIsoCurrencyCode(@RequestBody IsoCurrencyCode isoCurrencyCode) {
        return this.isoCurrencyCodeRepository.save(isoCurrencyCode);
    }

    // update ISO currency code
    @PutMapping("/{id}")
    public IsoCurrencyCode updateIsoCurrencyCode(@RequestBody IsoCurrencyCode isoCurrencyCode,
                                                 @PathVariable (value = "id") long isoCurrencyCodeId) {
        IsoCurrencyCode existingIsoCurrencyCode =
                this.isoCurrencyCodeRepository.findById(isoCurrencyCodeId).orElseThrow(() ->
                        new ResourceNotFoundException("ISO currency code not found with given id: " + isoCurrencyCodeId));

        existingIsoCurrencyCode.setAlphabeticCode(isoCurrencyCode.getAlphabeticCode());
        existingIsoCurrencyCode.setCurrency(isoCurrencyCode.getCurrency());
        existingIsoCurrencyCode.setEntity(isoCurrencyCode.getEntity());
        existingIsoCurrencyCode.setMinorUnit(isoCurrencyCode.getMinorUnit());
        existingIsoCurrencyCode.setNumericCode(isoCurrencyCode.getNumericCode());

        return this.isoCurrencyCodeRepository.save(existingIsoCurrencyCode);
    }

    // delete ISO currency code by alphabetic code
    @DeleteMapping("/{id}")
    public ResponseEntity<IsoCurrencyCode> deleteIsoCurrencyCode(@PathVariable (value = "id") long isoCurrencyCodeId) {
        IsoCurrencyCode existingIsoCurrencyCode =
                this.isoCurrencyCodeRepository.findById(isoCurrencyCodeId).orElseThrow(() ->
                        new ResourceNotFoundException("ISO currency code not found with given id: " + isoCurrencyCodeId));

        this.isoCurrencyCodeRepository.delete(existingIsoCurrencyCode);

        return ResponseEntity.ok().build();
    }
}
