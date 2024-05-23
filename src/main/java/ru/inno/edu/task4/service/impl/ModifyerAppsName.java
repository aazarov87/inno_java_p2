package ru.inno.edu.task4.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.inno.edu.task4.annotation.LogTransformation;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.DataModifyer;

import java.util.List;

@Component
@Order(10)
public class ModifyerAppsName implements DataModifyer {
    @Override
    @LogTransformation(lodFileName = "LogExecModifyer")
    public List<DataModel> modify(List<DataModel> data) {
        //System.out.println("ModifyerAppsName start");

        for (DataModel line: data
        ) {
            if (!line.getTypeApp().equals("web") && !line.getTypeApp().equals("mobile"))
                line.setTypeApp("other: " + line.getTypeApp());
        }
        return data;
    }
}
