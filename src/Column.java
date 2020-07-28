public class Column {

    private SimpleBox simpleBox = new SimpleBox();


    public Column(int width, String template[], String... headerContent) {

        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                createFirstUpperBorder(width, template[i].length());
                continue;
            }


            if (i == template.length - 1) {
                createLastUpperBorder(width, template[i].length());
                continue;
            }


            createUpperBorder(width, template[i].length());

        }


        System.out.println();
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                firstCenterText(template[i].length(), headerContent[i], width);
                continue;
            }

            centerText(template[i].length(), headerContent[i], width);


        }

        System.out.println();

        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                firstLowerColumnBorder(width, template[i].length());
                continue;
            }


            if (i == template.length - 1) {
                lastLowerColumnBorder(width, template[i].length());
                continue;
            }


            lowerColumnBorder(width, template[i].length());

        }


    }


    private void lowerColumnBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.middleJoinStorke);


    }


    private void firstLowerColumnBorder(int width, int templateLength) {
        for (int i = 0; i < templateLength + width; i++) {

            if (i == 0) {
                System.out.print(simpleBox.leftJoinStroke);
                continue;
            }

            System.out.print(simpleBox.horizLine);

        }
        System.out.print(simpleBox.middleJoinStorke);


    }

    private void lastLowerColumnBorder(int width, int templateLength) {

        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.rightJoinStroke);
    }


    private void firstCenterText(int templateLength, String headerContent, int width) {


        System.out.print(simpleBox.vertLine);
        System.out.print(headerContent);
        for (int i = 0; i < (templateLength + width) - headerContent.length() - 1; i++) {


            System.out.print(simpleBox.whiteSpace);


        }

        System.out.print(simpleBox.vertLine);


    }


    private void centerText(int templateLength, String headerContent, int width) {


        System.out.print(headerContent);
        for (int i = 0; i < (templateLength + width) - headerContent.length(); i++) {


            System.out.print(simpleBox.whiteSpace);


        }

        System.out.print(simpleBox.vertLine);


    }


    private void createUpperBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.tBetween);


    }

    private void createLastUpperBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.rightTopCorner);


    }

    private void createFirstUpperBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {

            if (i == 0) {
                System.out.print(simpleBox.leftTopCorner);
                continue;
            }

            System.out.print(simpleBox.horizLine);

        }
        System.out.print(simpleBox.tBetween);


    }

}
