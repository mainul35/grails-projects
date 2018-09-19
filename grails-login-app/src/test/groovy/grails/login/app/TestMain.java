package grails.login.app;

import org.junit.Assert;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Product Base price");
//        BigDecimal basePrice = new BigDecimal(scanner.nextLine());
//        System.out.println("Product Quantity");
//        int quantity = scanner.nextInt();

//        System.out.println(basePrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP));

        BigDecimal _6PercentOf10 =new BigDecimal(10).subtract((new BigDecimal(10).multiply(new BigDecimal(6))).divide(new BigDecimal(100)));

        System.out.println(_6PercentOf10.toString());
    }
}
