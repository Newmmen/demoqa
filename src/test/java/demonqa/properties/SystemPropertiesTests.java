package demonqa.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("properties")
    void simplePropertyTest() {
        String browserName = System.getProperty("browser_name", "chrome");
        String browserVersion = System.getProperty("browser_version", "100");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);


    }

    @Tag("hello")
    @Test
    void simplePropertyTest1() {
        System.out.println("Hello " + System.getProperty("some_text", "ga.guru"));


    }

}
