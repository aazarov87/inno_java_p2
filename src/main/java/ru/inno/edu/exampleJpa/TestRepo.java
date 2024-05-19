package ru.inno.edu.exampleJpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Users, Integer> {
}
