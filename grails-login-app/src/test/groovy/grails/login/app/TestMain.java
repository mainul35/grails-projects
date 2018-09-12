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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String val = scanner.nextLine();
            String returningVal = "";
            if (val.contains(".")) {
                String[] valueArr = val.split("\\.");

                if (Double.parseDouble("." + valueArr[1]) >= Double.parseDouble(".30") && Double.parseDouble("." + valueArr[1]) <= Double.parseDouble(".70")) {
                    returningVal = valueArr[0] + ".50";
                } else if (Double.parseDouble("." + valueArr[1]) >= Double.parseDouble(".00") && Double.parseDouble("." + valueArr[1]) < Double.parseDouble(".30")) {
                    returningVal = valueArr[0] + ".00";
                } else if (Double.parseDouble("." + valueArr[1]) > Double.parseDouble(".70") && Double.parseDouble("." + valueArr[1]) <= Double.parseDouble(".99")) {
                    returningVal = Integer.toString(Integer.parseInt(valueArr[0]) + 1) + ".00";
                }
            }
            System.out.println(Double.parseDouble(returningVal));
        }
    }
}
