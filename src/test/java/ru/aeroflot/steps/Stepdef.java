package ru.aeroflot.steps;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ru.aeroflot.pageobject.FirstPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Stepdef {
    FirstPage firstPage = page(FirstPage.class);
    @Given("^open aeroflot\\.ru$")
    public void openAeroflotRu() {
        open("http://aeroflot.ru");
    }

    @Then("^press button with text \"([^\"]*)\" in the window on \"([^\"]*)\"$")
    public void changeCountry(String button , String page){
        //        if("первая страница".equals(page)) firstPage.get(button).click();
        switch (page){
            case "первая страница": firstPage.get(button).click();
//            case "вторая страница"
        }
    }
    @When ("^go to select the direction from: (.*)$")
    public void fromContry(List<String> countries) throws InterruptedException {
        String fromDir = countries.get(0);
        String toDir = countries.get(1);
        firstPage.get("Страна отправления").setValue(fromDir);
        Thread.sleep(3000);
        firstPage.get("Страна назначения").setValue(toDir).pressEnter();
//
    }
//    @When("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\" on \"([^\"]*)\"$")
//     public void test(String a,String b,String c) {
//        if ("первая страница".equals(c)) {
//            firstPage.get(a).click();
//            firstPage.get(a).setValue(b);
//        }

//    }
}


