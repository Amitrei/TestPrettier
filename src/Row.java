public class Row {

    private int width;
    private String text;
    private SimpleBox simpleBox = new SimpleBox();
    private String[] template;
    private String[] rowContent;

    public Row(int width, String template[], String... rowContent) {
        this.width = width;
        this.template = template;
        this.rowContent = rowContent;
    }


    public void rowRender() {

        System.out.println();
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                firstCenterText(template[i].length(), rowContent[i], width);
                continue;
            }

            centerText(template[i].length(), rowContent[i], width);


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


    public void lastRowRender() {

        System.out.println();
        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                firstCenterText(template[i].length(), rowContent[i], width);
                continue;
            }

            centerText(template[i].length(), rowContent[i], width);


        }

        System.out.println();

        for (int i = 0; i < template.length; i++) {
            if (i == 0) {
                lastRowFirstLowerColumnBorder(width, template[i].length());
                continue;
            }


            if (i == template.length - 1) {
                lastRowLastLowerColumnBorder(width, template[i].length());
                continue;
            }


            lastRowLowerColumnBorder(width, template[i].length());

        }
    }


    private void lowerColumnBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.middleJoinStorke);


    }


    private void lastRowLowerColumnBorder(int width, int templateLength) {


        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.botLastT);


    }

    private void lastRowFirstLowerColumnBorder(int width, int templateLength) {
        for (int i = 0; i < templateLength + width; i++) {

            if (i == 0) {
                System.out.print(simpleBox.leftBotCorner);
                continue;
            }

            System.out.print(simpleBox.horizLine);

        }
        System.out.print(simpleBox.botLastT);


    }

    private void lastRowLastLowerColumnBorder(int width, int templateLength) {

        for (int i = 0; i < templateLength + width; i++) {
            System.out.print(simpleBox.horizLine);
        }
        System.out.print(simpleBox.rightBotCorner);
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


    private void firstCenterText(int templateLength, String rowContent, int width) {


        System.out.print(simpleBox.vertLine);
        System.out.print(rowContent);
        for (int i = 0; i < (templateLength + width) - rowContent.length() - 1; i++) {


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

}
