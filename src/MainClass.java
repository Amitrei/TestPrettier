public class MainClass {

    public static void main(String[] args) {


        Table createTable = new Table(10);
        createTable.createHeaders("Header #1", "Header #2");
        createTable.createRow("Testing row#1","Testing row#2");
        createTable.initTable();





    }
}
