package com.api.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaRepository, Long> {
}