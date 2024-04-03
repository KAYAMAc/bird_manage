package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface waterDao extends JpaRepository<waterHistory, Long> {
}