package ru.inno.edu.task4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.edu.task4.model.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

}
