package ru.inno.edu.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
public class DataReaderFileImpl implements DataReader {

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    DataSource dataSource;

    @Override
    public List<DataModel> read() {

        List list = new ArrayList();

        try {
            //String dataSource = "dataTask4";
           // String filePackageName = /*'/' +*/ dataSource.folderName.replace('.', '/');
            //System.out.println("filePackageName = " + filePackageName);
            // File f = new File("src/main/resources/" + filePackageName);
            File f = new File(dataSource.folderName);
            System.out.println("f = " + f);

            System.out.println("1 " + f.length() +  " " +f.listFiles());
            for (File file : f.listFiles()) {
                Scanner scanner = new Scanner(file);
                System.out.println(scanner);
                while (scanner.hasNextLine()) {
                    DataModel dataModel = new DataModel();
                    String line = scanner.nextLine();

                    String[] arrayLine = line.split(" ");

                    dataModel.login = arrayLine[0];
                    dataModel.fam = arrayLine[1];
                    dataModel.firstName = arrayLine[2];
                    dataModel.lastName = arrayLine[3];
                    dataModel.dateLogin = arrayLine[4];
                    dataModel.typeApp = arrayLine[5];

                    /*System.out.println("line = " + line);
                    System.out.println("dataModel = " + dataModel);*/
                    list.add(dataModel);
                }
                scanner.close();
            }
        } catch (Exception e){
            //System.out.println(e);
            throw new IllegalArgumentException(e);
        }

        return list;
    }
}
