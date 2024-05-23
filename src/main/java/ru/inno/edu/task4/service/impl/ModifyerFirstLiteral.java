package ru.inno.edu.task4.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.DataModifyer;

import java.util.List;

@Component
@Order(30)
public class ModifyerFirstLiteral implements DataModifyer {

    @Override
    public List<DataModel> modify(List<DataModel> data) {
        //System.out.println("ModifyerFirstLiteral start");

        for (DataModel line: data
        ) {
            line.setFirstName(line.getFirstName().substring(0, 1).toUpperCase() + line.getFirstName().substring(1));
            line.setFam(line.getFam().substring(0, 1).toUpperCase() + line.getFam().substring(1));
            line.setLastName(line.getLastName().substring(0, 1).toUpperCase() + line.getLastName().substring(1));
        }

        return data;
    }
}
