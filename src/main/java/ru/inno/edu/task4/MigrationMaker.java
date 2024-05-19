package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class MigrationMaker {

    @Autowired
    DataReader datareader;
    @Autowired
    DataWriter writer;
    @Autowired
    List<DataModifyer> modifyerList = new ArrayList<>();

    public void make() {
        List<DataModel> linesFromFile = (List<DataModel>) datareader.read();

        System.out.println("modifyerList = " + modifyerList);

        System.out.println("linesFromFile = " + linesFromFile);
        //for (DataModel line: linesFromFile
       //      ) {
            /*line.res = operations
                    .get(line.op)
                    .apply(model.x, model.y);
            printer.accept(model);*/
            for (DataModifyer dataModifyer : modifyerList
                 ) {
                /*DataModel dataModelTemp = (DataModel) converter.convert(line);
                System.out.println("dataModelTemp = " + dataModelTemp);
                linesToWrite.add(dataModelTemp);*/
                linesFromFile = dataModifyer.modify(linesFromFile);
            }

            //System.out.println("line = " + line);
      //  }
        System.out.println("linesToWrite = " + linesFromFile);

        writer.write(linesFromFile);

    }
}
