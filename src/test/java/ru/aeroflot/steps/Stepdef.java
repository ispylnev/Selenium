package ru.aeroflot.steps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.aeroflot.pageobject.FirstPage;
import ru.aeroflot.pageobject.SecondPage;

import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class Stepdef {
    FirstPage firstPage = page(FirstPage.class);
    SecondPage secondPage = page(SecondPage.class);
    @Given("^open aeroflot\\.ru$")
    public void openAeroflotRu() {
        open("http://aeroflot.ru");
    }

    @Then("^press button with text \"([^\"]*)\" in the window on \"([^\"]*)\"$")
    public void changeCountry(String button , String page){
        //        if("первая страница".equals(page)) firstPage.get(button).click();
        switch (page){
            case "первая страница": firstPage.get(button).click();
            break;
            case "вторая страница" : secondPage.get(button).click();
            break;
        }
    }
    @And("user in field \"([^\"]*)\" set text \"([^\"]*)\" in the window on \"([^\"]*)\"$")
    public void setText(String field, String text, String page){
        switch(page){
            case "первая страница": firstPage.get(field).setValue(text);
        }
    }

    @When ("^go to select the direction from: (.*)$")
    public void fromContry(List<String> countries) throws InterruptedException {
        String fromDir = countries.get(0);
        String toDir = countries.get(1);
        String xpathVisElem = String.format("//span[contains(., \'%s\')]", fromDir);
        firstPage.get("Страна отправления").setValue(fromDir);
        $(By.xpath(xpathVisElem)).shouldBe(Condition.visible);
        firstPage.get("Страна назначения").setValue(toDir).pressEnter();
//
    }
//            firstPage.get(a).click();
//    @When("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\" on \"([^\"]*)\"$")
//     public void test(String a,String b,String c) {
//        if ("первая страница".equals(c)) {
//            firstPage.get(a).setValue(b);
//        }

//    }
}


