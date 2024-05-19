package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("application.properties")
@Order(40)
public class ModifyerDateLogin implements DataModifyer {

   /* @Override
    public Object convert(Object source) {

        System.out.println("checkDateLogin start");
        List<DataModel> dataModel = (List<DataModel>) source;

        for (int i =0; i < dataModel.size(); i++)
        {
            System.out.println("line.getDateLogin = " + dataModel.get(i).getDateLogin());
            if( dataModel.get(i).getDateLogin() == null || dataModel.get(i).getDateLogin().equals("null"))
                dataModel.remove(i);
        }

        return null;
    }*/

    @Autowired
    @Value("${pathLogEmptyDate}")
    String pathLog;

    @Override
    public List<DataModel> modify(List<DataModel> data) {
        System.out.println("ModifyerDateLogin start");

        List<String> emptyDate= new ArrayList<>();
        for (int i =0; i < data.size(); i++)
        {
            //System.out.println("line.getDateLogin = " + data.get(i).getDateLogin());
            if( data.get(i).getDateLogin() == null || data.get(i).getDateLogin().equals("null")) {
                emptyDate.add(data.get(i).toString());
                data.remove(i);

            }
        }

        if (emptyDate.size() > 0) {
            try {
                String filePackageName = '/' + pathLog.replace('.', '/');
                FileWriter writer = new FileWriter("src\\main\\resources\\" + filePackageName, true);


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

        return data;
    }
}
