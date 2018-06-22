package ru.aeroflot.runner;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)

@CucumberOptions(
//        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/ru/aeroflot/features",
        glue = "ru/aeroflot/steps",
        tags = "@test1"
        )


public class CucumberTest
{

    @BeforeClass
    static public void setupTimeout() {
//        Configuration.timeout = 10000;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        Configuration.browser = "chrome";
    }
}
