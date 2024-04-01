package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface foodDao extends JpaRepository<foodHistory, Long> {
}