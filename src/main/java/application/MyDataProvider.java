package application;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[] > validLoginDataClassDP_LASTPROJECT(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[] > validREGDataClassDP(){

        List<Object[]> list= new ArrayList<>();

        list.add(new Object[]{"Sonya","Low","kit11@gmail.com","Ff12345$"});
        list.add(new Object[]{"Sonya","Low","kit12@gmail.com","Ff12345$"});
        list.add(new Object[]{"Sonya","Low","kit13@gmail.com","Ff12345$"});

        return list.iterator();
    }





    @DataProvider
    public Iterator <Object[]> dataFileCSV_LASTPROJECT() throws IOException {
        List<Object[]> list= new ArrayList<>();

        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line= reader.readLine();

        }
        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> registCSV()throws IOException{
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/reg.csv")));

        String line = reader.readLine();//Sony;Low;low@gmail.com;Ll12345$
        while (line!=null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User()
                    .withName(split[0])
                    .withLastName(split[1])
                    .withEmail(split[2])
                    .withPassword(split[3])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
