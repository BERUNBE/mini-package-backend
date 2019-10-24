package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.MiniPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniPackageRepository extends JpaRepository<MiniPackage, Long> {
}
