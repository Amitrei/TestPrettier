public class SimpleBox {
    protected char leftTopCorner = '┌';
    protected char rightTopCorner = '┐';
    protected char leftJoinStroke = '├';
    protected char rightJoinStroke = '┤';
    protected char middleJoinStorke = '┼';
    protected char vertLine = '│';
    protected char horizLine = '─';
    protected char leftBotCorner = '└';
    protected char rightBotCorner = '┘';
    protected String whiteSpace = " ";
    protected char tBetween = '┬';
    protected char botLastT = '┴';


    public void createBox(String text, int width) {

        upperWrapper(width, text.length());
        System.out.println();
        centerText(text, width);
        System.out.println();
        lowerWrapper(width, text.length());

    }


    protected void upperWrapper(int width, int textLength) {
        System.out.print(leftTopCorner);
        for (int i = 0; i < textLength + width; i++) {
            System.out.print(horizLine);
        }
        System.out.print(rightTopCorner);

    }

    protected void lowerWrapper(int width, int textLength) {
        System.out.print(leftBotCorner);
        for (int i = 0; i < textLength + width; i++) {
            System.out.print(horizLine);
        }
        System.out.print(rightBotCorner);

    }

    protected void centerText(String text, int width) {
        System.out.print(vertLine);
        for (int i = 0; i < width / 2; i++) {
            System.out.print(whiteSpace);
        }

        System.out.print(text);

        for (int i = 0; i < width / 2; i++) {
            System.out.print(whiteSpace);
        }
        System.out.print(vertLine);

    }


}
