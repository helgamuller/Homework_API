package org.example;

import com.codeborne.selenide.*;
import org.example.ui.pages.RegisterAccountPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;

    }

    //DRY = Don't repeat yourself
    //Web-elements DON't searching in test their are searching for in page object class

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {

        //Preparation

        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Steps
        registerAccountPage.register("Olga", "Miller");

        //Result check

         //Address

        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement addressCityError = element(Selectors.byId("customer.address.city.errors")); //City
        addressCityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement addressStateError = element(Selectors.byId("customer.address.state.errors"));
        addressStateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement addressZipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        addressZipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
        userNameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement passwordConfirmError = element(Selectors.byId("repeatedPassword.errors"));
        passwordConfirmError.shouldHave(Condition.exactText("Password confirmation is required."));






        //все оставшиеся обязательные поля



    }
    @Test
    public void userCanBeCreatedWithMandatoryFields() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        //Steps
        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Ольга");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Мюллер");

        SelenideElement addressStreet = element(Selectors.byId("customer.address.street")); //Address
        addressStreet.sendKeys("1650 Birch dr");

        SelenideElement addressCity = element(Selectors.byId("customer.address.city")); //City
        addressCity.sendKeys("Duluth");

        SelenideElement addressState = element(Selectors.byId("customer.address.state"));
        addressState.sendKeys("GA");

        SelenideElement addressZipCode = element(Selectors.byId("customer.address.zipCode"));
        addressZipCode.sendKeys("50005");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("123-56-675");

        SelenideElement userName = element(Selectors.byId("customer.username"));
        userName.sendKeys("helga1");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("1234567");

        SelenideElement passwordConfirm = element(Selectors.byId("repeatedPassword"));
        passwordConfirm.sendKeys("1234567");

        SelenideElement registerButton =element(Selectors.byValue("Register"));
        registerButton.click();
    }
}
