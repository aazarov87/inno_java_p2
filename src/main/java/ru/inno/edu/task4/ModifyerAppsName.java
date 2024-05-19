package ru.inno.edu.task4;

import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(10)
public class ModifyerAppsName implements DataModifyer {
    /*@Override
    public Object convert(Object source) {
        System.out.println("checkApps start");
        List<DataModel> dataModel = (List<DataModel>) source;

        for (DataModel line: dataModel
        ) {
            if (!line.getTypeApp().equals("web") && !line.getTypeApp().equals("mobile"))
                line.setTypeApp("other: " + line.getTypeApp());
        }
        return dataModel;

    }
*/
    @Override
    public List<DataModel> modify(List<DataModel> data) {
        System.out.println("ModifyerAppsName start");

        for (DataModel line: data
        ) {
            if (!line.getTypeApp().equals("web") && !line.getTypeApp().equals("mobile"))
                line.setTypeApp("other: " + line.getTypeApp());
        }
        return data;
    }
}
