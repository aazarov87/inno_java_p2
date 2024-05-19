package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataWriterImpl implements DataWriter{

    @Autowired
    private UserRepo userRepo;
    @Override
    public void write(List<DataModel> data) {
        System.out.println("DataWriterImpl data= " + data);

        System.out.println("DataWriterImpl userRepo= " + userRepo);

        Users users = new Users();
        users.fio = "data.getFirst().firstName";
        users.username = "data.getFirst().lastName";
        userRepo.save(users);
    }
}
