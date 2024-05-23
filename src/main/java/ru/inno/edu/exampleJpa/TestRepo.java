package ru.inno.edu.exampleJpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TestRepo extends JpaRepository<Users, Integer> {
}
