import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {


        Table createTable = new Table(100);
        createTable.createHeaders("1234","124");
        createTable.createRow("123412355","12445655");
        createTable.createRow("Coupon{id=0, company=3, title='BestCoupon', Category : FOOD, description='Description', start_date=2020-07-30, end_date=2020-08-09, amount=100, price=100.0, image='image.png'}",
                "Coupon{id=0, company=3, title='BestCoupon', Category : FOOD, description='Description', start_date=2020-07-30, end_date=2020-08-09");
        createTable.render();




//        String test="123456789";
//        int templateLength=3;
//
//
//        System.out.println(String.format("%-15s|",""));


    }
}
