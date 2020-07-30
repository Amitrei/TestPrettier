import java.util.ArrayList;
import java.util.List;


public class Table {
    private SimpleBox simpleBox = new SimpleBox();
    public String[] template = null;
    public String[] headerContent = null;
    public String[] rowContent = null;
    public List<Row> allRows= new ArrayList<>();
    private int width=2;


    public Table(int width) {
        this.width = width;

    }


    public Table() {
    }



    // NEED TO ADD Throw Exception if headers was already Made
    //
    public void createHeaders(String... headerContent) {
        this.headerContent = headerContent;
        template=headerContent.clone();

    }

    public void createRow(String... rowContent) {
        this.rowContent = rowContent;
        allRows.add(new Row(width,template,rowContent));

    }


    public void initTable() {
        System.out.println();
        Column column= new Column(width,template,headerContent);
        initRows();


    }

    private void initRows() {
        for(int i=0;i<allRows.size();i++) {

            if(i==allRows.size()-1) {
                allRows.get(i).lastRowRender();
                continue;
            }

            allRows.get(i).rowRender();

        }
    }


    // Testing purposes
    private void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        }




}
