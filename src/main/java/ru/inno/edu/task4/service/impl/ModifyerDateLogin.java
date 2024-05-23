package ru.inno.edu.task4.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.annotation.LogTransformation;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.DataModifyer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(40)
public class ModifyerDateLogin implements DataModifyer {


    @Value("${pathLogEmptyDate}")
    public String pathLog;

    @Override
    @LogTransformation(lodFileName = "LogExecModifyer")
    public List<DataModel> modify(List<DataModel> data) {
        //System.out.println("ModifyerDateLogin start data.size() = " + data.size());

        List<String> emptyDate= new ArrayList<>();
        for (int i =0; i < data.size(); i++)
        {
            if(data.get(i).getDateLogin() == null) {
                emptyDate.add(data.get(i).toString());
            }
        }

        if ((emptyDate.size() > 0) && pathLog!=null) {
            try {
                FileWriter writer = new FileWriter(pathLog, true);
                for (String emptyLine: emptyDate
                     ) {
                    writer.write(emptyLine);
                    writer.write("\n");
                }

                writer.close();
            } catch (IOException e) {
                System.out.println("Возникла ошибка во время записи, проверьте данные.");
            }
        }

        data.removeIf(d -> d.getDateLogin() == null);

        return data;
    }
}
