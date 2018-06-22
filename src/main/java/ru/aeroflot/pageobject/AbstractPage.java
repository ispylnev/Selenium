package ru.aeroflot.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.lang.reflect.Field;

public abstract class AbstractPage
{
    public  SelenideElement get(String CucumberString)
    {
        Class<?> clazz = this.getClass();
        for (Field field : clazz.getDeclaredFields())
        {
            if (field.isAnnotationPresent(NameElement.class))
            {
                NameElement nameElement = field.getAnnotation(NameElement.class);
                if (nameElement.value().equals(CucumberString))
                {
                    try
                    {
                        return (SelenideElement) field.get(this);
                    } catch (IllegalAccessException e)
                    {
                        System.out.println("Ошибка получения элемента" + CucumberString + this.getClass().getName());
                    }
                }
            }
        }
        Selenide.screenshot("No element");
        throw new IllegalArgumentException("Не найден элемент " + CucumberString + " на странице " + this.getClass().getName());
    }
}