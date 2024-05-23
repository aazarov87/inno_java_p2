package ru.inno.edu.task4.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class DataSourceForReader {

    @Value("${pathSource}")
    public String folderName;
}
