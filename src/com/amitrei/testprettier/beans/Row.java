package com.amitrei.testprettier.beans;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private int width;
    private SimpleBox simpleBox = new SimpleBox();
    private String[] template;
    private List<String> rowContent;
    private int numOfRowsFlag = 1;

    public Row(int width, String template[], List<String> rowContent) {
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


    private void printLastRowBotBorder() {
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

    private String createRowText(int templateLength, String rowContent, int width, Boolean isFirst) {

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

    public List<String> splitIntoRows(List<String> arr, int index) {



        if(arr.stream().allMatch(s -> s.length()<2)) {
            return arr;
        }

        if(index==0) {
        // Do not print new line
        }
        else {
            System.out.println();

        }

        index++;
        return splitIntoRows(trimmer(arr),index);


    }


    private List<String> trimmer(List<String> arr) {
        List<String> row = new ArrayList<>();
        List<String> nextRow = new ArrayList<>();
        for (int i=0;i<arr.size();i++) {
            int templateWidth = template[i].length() + width -1;


            if (arr.get(i).length() >= templateWidth) {
                nextRow.add(arr.get(i).substring(templateWidth));
                row.add(arr.get(i).substring(0,templateWidth));
                continue;
            }


            row.add(arr.get(i));

            if(arr.get(i).length()%templateWidth!=0 || arr.get(i).length()%9==templateWidth){
                nextRow.add(" ");
                continue;
            }

            nextRow.add(arr.get(i));


        }


//        System.out.println("next" + nextRow);
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {

                System.out.print(createRowText(template[i].length(), row.get(i), width, true));
                continue;
            }

            System.out.print(createRowText(template[i].length(), row.get(i), width, false));



        }
        return nextRow;
    }


    private void printRowText() {


//       for (int i = 0; i < template.length; i++) {
//            if (i == 0) {
//                System.out.print(createRowText(template[i].length(), rowContent.get(i), width, true));
//                continue;
//            }
//            System.out.print(createRowText(template[i].length(), rowContent.get(i), width, false));
//        }



            splitIntoRows(rowContent,0);


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
