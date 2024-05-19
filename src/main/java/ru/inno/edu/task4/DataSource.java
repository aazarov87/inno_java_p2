package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class DataSource {

    @Value("${pathSource}")
    String folderName;

    /*public DataSource(@Value("pathSource")String a) {
        System.out.println("DataSource = " + a);
        folderName = a;
    }*/
}
