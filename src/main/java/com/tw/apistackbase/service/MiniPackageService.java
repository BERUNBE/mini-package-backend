package com.tw.apistackbase.service;

import com.tw.apistackbase.model.MiniPackage;
import com.tw.apistackbase.repository.MiniPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniPackageService {

    @Autowired
    private MiniPackageRepository miniPackageRepository;

    public MiniPackage createMiniPackage(MiniPackage miniPackage) {
        return miniPackageRepository.save(miniPackage);
    }

    public List<MiniPackage> getAllMiniPackages() {
        return null;
    }
}
