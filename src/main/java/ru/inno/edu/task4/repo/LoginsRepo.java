package ru.inno.edu.task4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.edu.task4.model.Logins;

import java.util.List;

public interface LoginsRepo extends JpaRepository<Logins, Integer> {

   List<Logins> findByUserId(Integer userId);
}
