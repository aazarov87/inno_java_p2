package ru.inno.edu.task4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.model.Logins;
import ru.inno.edu.task4.model.Users;
import ru.inno.edu.task4.repo.LoginsRepo;
import ru.inno.edu.task4.repo.UserRepo;
import ru.inno.edu.task4.service.DataWriter;

import java.util.List;
@Component
public class DataWriterImpl implements DataWriter {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LoginsRepo loginsRepo;
    @Override
    public void write(List<DataModel> data) {
        for (DataModel datum : data) {
            Users userFromDB = userRepo.findByUsername(datum.getLogin());

            if (userFromDB == null){
                Users users = new Users(datum.getLogin(), datum.getFam() +" "+ datum.getFirstName() +" "+ datum.getLastName());
                userRepo.save(users);
                Logins logins = new Logins(datum.getDateLogin(), users.getId(), datum.getTypeApp());
                loginsRepo.save(logins);
            }
        else{
                Logins logins = new Logins(datum.getDateLogin(), userFromDB.getId(), datum.getTypeApp());
                loginsRepo.save(logins);
            }
        }

    }
}
