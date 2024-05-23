package ru.inno.edu.task4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.DataModifyer;
import ru.inno.edu.task4.service.DataReader;
import ru.inno.edu.task4.service.DataWriter;

import java.util.ArrayList;
import java.util.List;

@Component
public class MigrationMaker {

    @Autowired
    DataReader datareader;
    @Autowired
    DataWriter writer;
    @Autowired
    List<DataModifyer> modifyerList = new ArrayList<>();

    public void make() {
        List<DataModel> linesFromFile = (List<DataModel>) datareader.read();

        for (DataModifyer dataModifyer : modifyerList) {
            linesFromFile = dataModifyer.modify(linesFromFile);
        }

        writer.write(linesFromFile);

    }
}
