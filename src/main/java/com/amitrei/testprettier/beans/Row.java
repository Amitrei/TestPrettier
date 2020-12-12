package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.interfaces.Rows;
import java.util.ArrayList;
import java.util.List;

public class Row implements Rows {

    private int width;
    private SimpleBox simpleBox = new SimpleBox();
    private String[] template;
    private List<String> rowContent;

    public Row(int width, String template[], List<String> rowContent) {
        this.width = width;
        this.template = template;
        this.rowContent = rowContent;
    }


    @Override
    public void startRender() {
        rowRender();
    }

    @Override
    public void middleRender() {
        rowRender();
    }

    @Override
    public void endRender() {
        lastRowRender();
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


    protected void lastRowBottomBorder(int width, int templateLength, int location) {
        char lastCharAtBorder = ' ';
        char firstCharAtBorder = ' ';
        switch (location) {
            case 1:
                lastCharAtBorder = simpleBox.botJoinT;
                firstCharAtBorder = simpleBox.leftBotCorner;
                break;

            case 3:
                lastCharAtBorder = simpleBox.rightBotCorner;
                break;

            default:
                lastCharAtBorder = simpleBox.botJoinT;

        }

        int whiteSpaces = (templateLength + width);
        String finalBorder = String.format("%-" + whiteSpaces + "s" + lastCharAtBorder, firstCharAtBorder).replace(' ', simpleBox.horizLine);
        System.out.print(finalBorder);


    }


    protected void bottomRowBorder(int width, int templateLength, int location) {

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


    protected void printLastRowBotBorder() {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                lastRowBottomBorder(width, template[i].length(), 1);
                continue;
            }


            if (i == template.length - 1) {
                lastRowBottomBorder(width, template[i].length(), 3);
                continue;
            }


            lastRowBottomBorder(width, template[i].length(), 2);

        }
    }

    protected String createRowText(int templateLength, String rowContent, int width, Boolean isFirst) {

        String stringFormatSymbols = null;
        int whiteSpaces = (templateLength + width);

        if (isFirst == true) {
            stringFormatSymbols = "|%-";
            whiteSpaces--;
        } else {
            stringFormatSymbols = "%-";
        }
        String finalContent = String.format(stringFormatSymbols + whiteSpaces + "s|", rowContent);
        return finalContent;


    }


    private List<String> splitIntoRows(List<String> arr, int index) {




        if (arr.stream().allMatch(s -> s.length() < 2)) {

            printWithoutTrimmer(arr);
            return arr;
        }




        if (index == 0) {
            // Do not print new line
        } else {
            System.out.println();

        }

        index++;
        return splitIntoRows(trimmer(arr), index);

    }


    private List<String> trimmer(List<String> arr) {
        List<String> row = new ArrayList<>();
        List<String> nextRow = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int templateWidth = template[i].length() + width - 1;



            if (arr.get(i).length() >= templateWidth) {
                nextRow.add(arr.get(i).substring(templateWidth));
                row.add(arr.get(i).substring(0, templateWidth));

                continue;
            }

            row.add(arr.get(i));

            if (arr.get(i).length() % templateWidth != 0 || arr.get(i).length() % 9 == templateWidth) {
                nextRow.add(" ");
                continue;
            }

            nextRow.add(arr.get(i));


        }

        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                System.out.print(createRowText(template[i].length(), row.get(i), width, true));
                continue;
            }
            System.out.print(createRowText(template[i].length(), row.get(i), width, false));


        }
        return nextRow;
    }



private void printWithoutTrimmer(List<String> row) {


    for (int i = 0; i < row.size(); i++) {

        // Skip the empty new lines if there are.
        if(row.get(i).equals(" ")) continue;



        if (i == 0) {
            System.out.print(createRowText(template[i].length(), row.get(i), width, true));
            continue;
        }
        System.out.print(createRowText(template[i].length(), row.get(i), width, false));


    }
}

    protected void printRowText() {


        splitIntoRows(rowContent, 0);
    }


    protected void printBotRowBorder() {
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
