package com.amitrei.testprettier.beans;

import com.amitrei.testprettier.interfaces.TableParts;

public class Title  implements TableParts {
    SimpleBox simpleBox = new SimpleBox();

    private String[] template;
    private int width;
    private String titleContent;


    public Title(String[] template, int width, String titleContent) {
        this.template = template;
        this.width = width;
        this.titleContent = titleContent;

        startRender();
    }



    @Override
    public void startRender() {


        printUpperColBorder(width, template);
        System.out.println();
        printHeaderText(width, template, titleContent);
        System.out.println();
        printBotHeaderBorder(width, template);

    }

    @Override
    public void middleRender() {

    }

    @Override
    public void endRender() {

    }

    private void botHeaderBorder(int width, int templateLength, int location) {

        char lastCharAtBorder = ' ';
        char firstCharAtBorder = ' ';
        switch (location) {
            case 1:
                lastCharAtBorder = simpleBox.horizLine;
                firstCharAtBorder = simpleBox.leftBotCorner;
                break;

            case 3:
                lastCharAtBorder = simpleBox.rightBotCorner;
                break;

            default:
                lastCharAtBorder = simpleBox.horizLine;
                break;

        }

        int whiteSpaces = (templateLength + width);

        String finalBorder = String.format("%-" + whiteSpaces + "s" + lastCharAtBorder, firstCharAtBorder).replace(' ', simpleBox.horizLine);
        System.out.print(finalBorder);

    }




    private void createTitleText(int templateLength, String headContent, int width, Boolean isFirst) {
        String headerCentered = centerText(headContent, templateLength + width);
        int whiteSpaces = (templateLength);

        String addedDetailsContent = String.format("|%-" + whiteSpaces + "s|", headerCentered);
        System.out.print(addedDetailsContent);
    }

    private String centerText(String headerContent, int totalLength) {
        int center = (totalLength / 2) - (headerContent.length() / 2) ;
        return String.format("%" + center + "s", headerContent);
    }

    private void tableUpperBorder(int width, int templateLength, int location) {


        char lastCharAtBorder = ' ';
        char firstCharAtBorder = ' ';
        switch (location) {

            case 1:
                lastCharAtBorder = simpleBox.horizLine;
                firstCharAtBorder = simpleBox.leftTopCorner;
                break;

            case 3:
                lastCharAtBorder = simpleBox.rightTopCorner;
                break;

            default:
                lastCharAtBorder = simpleBox.horizLine;

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

    private void printHeaderText(int width, String[] template, String titleContent) {


        int totalWidth =0;

        for(String string : template) {
            totalWidth+=string.length() + width + 1 ;
        }




                createTitleText(totalWidth-2, titleContent, width, true);





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
