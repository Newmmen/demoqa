package demonqa.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    Faker faker = new Faker();
    String month;

    public String getRandomMonth() {

        switch (faker.random().nextInt(0,11)) {
            case 0:
                month = "January";
                break;
            case 1:
                month = "February";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                System.out.println("November");
                month = "November";
                break;
            case 11:
                month = "December";
                break;
            default:
                System.out.println("Unknown month!");
        }

        return month;
    }
}
