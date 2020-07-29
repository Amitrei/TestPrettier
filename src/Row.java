import java.util.ArrayList;
import java.util.List;

public class Row {

    private int width;
    private String text;
    private SimpleBox simpleBox = new SimpleBox();
    private String[] template;
    private String[] rowContent;
    private int numOfRowsFlag = 1;
    List<String> rowParts = new ArrayList<>();


    public Row(int width, String template[], String... rowContent) {
        this.width = width;
        this.template = template;
        this.rowContent = rowContent;
    }


    public void rowRender() {
        System.out.println();
        printRowText();
        System.out.println();
        printBotRowBorder();
    }


    public void lastRowRender() {

        System.out.println();
        printRowText();
        System.out.println();
        printLastRowBotBorder();
    }





    private void lastRowBottomBorder(int width, int templateLength, int location) {
        char lastCharAtBorder =' ' ;
        char firstCharAtBorder =' ';
        switch (location){
            case 1:
               lastCharAtBorder =simpleBox.botLastT ;
               firstCharAtBorder =simpleBox.leftBotCorner;
               break;

            case 3:
                lastCharAtBorder =simpleBox.rightBotCorner ;
                break;

            default:
                lastCharAtBorder =simpleBox.botLastT ;

        }

        int whiteSpaces = (templateLength + width);
        String finalBorder = String.format("%-" + whiteSpaces + "s" + lastCharAtBorder, firstCharAtBorder).replace(' ', simpleBox.horizLine);
        System.out.print(finalBorder);


    }



    private void bottomRowBorder(int width, int templateLength, int location) {

        char lastCharAtBorder = ' ';
        char firstCharAtBorder = ' ';
        switch (location) {
            case 1:
                lastCharAtBorder = simpleBox.middleJoinStorke;
                firstCharAtBorder = simpleBox.leftJoinStroke;
                break;

            case 3:
                lastCharAtBorder = simpleBox.rightJoinStroke;
                break;

            default:
                lastCharAtBorder = simpleBox.middleJoinStorke;
                break;

        }

        int whiteSpaces = (templateLength + width);

        String finalBorder = String.format("%-" + whiteSpaces + "s" + lastCharAtBorder, firstCharAtBorder).replace(' ', simpleBox.horizLine);
        System.out.print(finalBorder);

    }


    private String createRowText(int templateLength, String rowContent, int width, Boolean isFirst) {

        if(numOfRowsFlag>1 && !rowParts.contains(rowContent) && rowContent.length() < templateLength+width - 1) {
            int amountOfWhiteSpace=templateLength+width-1;
            rowParts.add(String.format("%-"+amountOfWhiteSpace+"s",""));

        }

         if(rowContent.length() > templateLength+width - 1) {
             //NEED TO CHANTE THE HALF ITS NOT GOOD!
            final int splitToHalf = rowContent.length() / 2;
            rowParts.add(rowContent.substring(splitToHalf));
            rowContent = rowContent.substring(0, splitToHalf);
            numOfRowsFlag++;
        }

        String stringFormatSymbols = null;
        int whiteSpaces = (templateLength + width);

        if (isFirst == true) {
            stringFormatSymbols = "|%-";
            whiteSpaces--;
        } else {
            stringFormatSymbols = "%-";
        }


        String addedDetailsContent = String.format(stringFormatSymbols + whiteSpaces + "s|", rowContent);
        return addedDetailsContent;


    }

    private void printLastRowBotBorder() {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                lastRowBottomBorder(width, template[i].length(),1);
                continue;
            }


            if (i == template.length - 1) {
                lastRowBottomBorder(width, template[i].length(),3);
                continue;
            }


            lastRowBottomBorder(width, template[i].length(),2);

        }
    }

    private void printRowText() {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                System.out.print(createRowText(template[i].length(), rowContent[i], width, true));
                continue;
            }
            System.out.print(createRowText(template[i].length(), rowContent[i], width, false));
        }


        if(numOfRowsFlag>1) {
            System.out.println();


            for (int i = 0; i < template.length; i++) {
                if (i == 0) {
                    System.out.print(createRowText(template[i].length(), rowParts.get(i), width, true));
                    continue;
                }


                System.out.print(createRowText(template[i].length(), rowParts.get(i), width, false));
            }


        }
    }



    private void printBotRowBorder() {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                bottomRowBorder(width, template[i].length(), 1);
                continue;
            }


            if (i == template.length - 1) {
                bottomRowBorder(width, template[i].length(), 3);
                continue;
            }

            bottomRowBorder(width, template[i].length(), 2);


        }
    }

}
