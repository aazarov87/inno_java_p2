package ru.inno.edu.task4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.DataReader;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class DataReaderFileImpl implements DataReader {

    @Autowired
    public DataSourceForReader dataSourceForReader;

    private final String delimeter = "#";
    @Override
    public List<DataModel> read() {

        List list = new ArrayList();

        try {
            File f = new File(dataSourceForReader.folderName);

            for (File file : f.listFiles()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    DataModel dataModel = new DataModel();
                    String line = scanner.nextLine();

                    String[] arrayLine = line.split(delimeter);
                    dataModel.setLogin(arrayLine[0]);
                    dataModel.setFam(arrayLine[1]);
                    dataModel.setFirstName(arrayLine[2]);
                    dataModel.setLastName(arrayLine[3]);

                    if ((arrayLine[4] != null) && !arrayLine[4].equals("null") && !arrayLine[4].isEmpty()) {
                        dataModel.setDateLogin(LocalDateTime.parse(arrayLine[4]));
                    }
                    dataModel.setTypeApp(arrayLine[5]);
                    list.add(dataModel);
                }
                scanner.close();
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }

        return list;
    }
}
