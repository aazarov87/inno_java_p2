package ru.inno.edu.task4;

import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(30)
public class ModifyerFirstLiteral implements DataModifyer{
    /*@Override
    public Object modify(Object dataModel) {
        System.out.println("ConvertFirstLiteral start");
        List<DataModel> dataModel1 = (List<DataModel>) dataModel;

        for (DataModel line: dataModel1
        ) {
            line.setFirstName(line.getFirstName().substring(0, 1).toUpperCase() + line.getFirstName().substring(1));
            line.setFam(line.getFam().substring(0, 1).toUpperCase() + line.getFam().substring(1));
            line.setLastName(line.getLastName().substring(0, 1).toUpperCase() + line.getLastName().substring(1));
        }

        return dataModel1;
    }*/

    @Override
    public List<DataModel> modify(List<DataModel> data) {
        System.out.println("ModifyerFirstLiteral start");

        for (DataModel line: data
        ) {
            line.setFirstName(line.getFirstName().substring(0, 1).toUpperCase() + line.getFirstName().substring(1));
            line.setFam(line.getFam().substring(0, 1).toUpperCase() + line.getFam().substring(1));
            line.setLastName(line.getLastName().substring(0, 1).toUpperCase() + line.getLastName().substring(1));
        }

        return data;
    }
}
