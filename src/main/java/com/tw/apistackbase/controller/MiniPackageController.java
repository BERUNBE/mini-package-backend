package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.service.MiniPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packages")
public class MiniPackageController {

    @Autowired
    private MiniPackageService miniPackageService;

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<MiniPackage> createMiniPackage(@RequestBody MiniPackage miniPackage) {
        return new ResponseEntity<>(miniPackageService.createMiniPackage(miniPackage), HttpStatus.CREATED);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<Iterable<MiniPackage>> getAllMiniPackages() {
        return new ResponseEntity<>(miniPackageService.getAllMiniPackages(), HttpStatus.OK);
    }
}
