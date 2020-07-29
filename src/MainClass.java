import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {


        Table createTable = new Table(5);
        createTable.createHeaders("1234","1234","2134");
        createTable.createRow("1234","12345","1243");
        createTable.createRow("1","12345","1343");
        createTable.render();

//        String test="123456789";
//        int templateLength=3;
//
//
//        System.out.println(String.format("%-15s|",test));


    }
}
