package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class RegisterAccountPage {
    SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    // ... add all important web-elements into fields

    SelenideElement registerButton =element(Selectors.byValue("Register"));

    // .. add errors elements

    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    public  void open() {
        Selenide.open("/parabank/register.htm");
        }



    public void register(String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);

        registerButton.click();
    }
}
