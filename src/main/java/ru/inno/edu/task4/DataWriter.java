package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DataWriter {

    void write(List<DataModel> data);
}
