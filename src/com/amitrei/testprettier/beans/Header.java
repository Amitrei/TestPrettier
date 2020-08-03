package com.amitrei.testprettier.beans;

public class Header {

    private SimpleBox simpleBox = new SimpleBox();


    public Header(int width, String template[], String... headerContent) {

        printUpperColBorder(width, template);

        System.out.println();
        printHeaderText(width, template, headerContent);
        System.out.println();

        printBotHeaderBorder(width, template);


    }


    private void botHeaderBorder(int width, int templateLength, int location) {

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


    private void createHeaderText(int templateLength, String headContent, int width, Boolean isFirst) {
        String headerCentered = centerText(headContent, templateLength + width);
        String stringFormatSymbols = null;
        int whiteSpaces = (templateLength + width);

        if (isFirst == true) {
            stringFormatSymbols = "|%-";
            whiteSpaces--;
        } else {
            stringFormatSymbols = "%-";
        }


        String addedDetailsContent = String.format(stringFormatSymbols + whiteSpaces + "s|", headerCentered);
        System.out.print(addedDetailsContent);
    }

    private String centerText(String headerContent, int totalLength) {
        int center = (totalLength / 2) + (headerContent.length() / 2);
        return String.format("%" + center + "s", headerContent);
    }

    private void tableUpperBorder(int width, int templateLength, int location) {


        char lastCharAtBorder = ' ';
        char firstCharAtBorder = ' ';
        switch (location) {

            case 1:
                lastCharAtBorder = simpleBox.topJoinT;
                firstCharAtBorder = simpleBox.leftTopCorner;
                break;

            case 3:
                lastCharAtBorder = simpleBox.rightTopCorner;
                break;

            default:
                lastCharAtBorder = simpleBox.topJoinT;

        }

        int whiteSpaces = (templateLength + width);
        String finalBorder = String.format("%-" + whiteSpaces + "s" + lastCharAtBorder, firstCharAtBorder).replace(' ', simpleBox.horizLine);
        System.out.print(finalBorder);
    }

    private void printBotHeaderBorder(int width, String[] template) {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                botHeaderBorder(width, template[i].length(), 1);
                continue;
            }


            if (i == template.length - 1) {
                botHeaderBorder(width, template[i].length(), 3);
                continue;
            }


            botHeaderBorder(width, template[i].length(), 2);

        }
    }

    private void printHeaderText(int width, String[] template, String[] headerContent) {
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                createHeaderText(template[i].length(), headerContent[i], width, true);
                continue;
            }

            createHeaderText(template[i].length(), headerContent[i], width, false);


        }
    }

    private void printUpperColBorder(int width, String[] template) {
        for (int i = 0; i < template.length; i++) {

            if (template.length == 1) {
                tableUpperBorder(width, template[i].length(), 3);
                break;


            }
            if (i == 0) {
                tableUpperBorder(width, template[i].length(), 1);
                continue;
            }


            if (i == template.length - 1) {
                tableUpperBorder(width, template[i].length(), 3);
                continue;
            }


            tableUpperBorder(width, template[i].length(), 2);

        }
    }


}
