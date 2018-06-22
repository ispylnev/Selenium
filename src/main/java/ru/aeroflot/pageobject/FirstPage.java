package ru.aeroflot.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends AbstractPage {
@NameElement("Изменить")
@FindBy (xpath = ".//*[@id='countryListToggle']")
public SelenideElement change;

@NameElement("Russian")
@FindBy (xpath = ".//*[@id='countryList']/ul/li[1]")
public SelenideElement Country;

@NameElement("Страна отправления")
@FindBy (xpath = ".//*[@id='ttOri0']")
public SelenideElement countryFrom;

@NameElement("Страна назначения")
@FindBy (xpath = ".//*[@id='ttDest0']")
public SelenideElement countryTo;


@NameElement("Очистить")
@FindBy (xpath = ".//*[@id='ttTROri0']/div[2]/div/span[4]")
public SelenideElement clear;

@NameElement("Логин")
@FindBy (xpath = ".//*[@id='header-menu']/a[3]")
public SelenideElement login;

}

