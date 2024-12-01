package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class RegisterAccountPage {
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
    private SelenideElement addressStreetInput = element(Selectors.byId("customer.address.street"));
    private SelenideElement addressCityInput = element(Selectors.byId("customer.address.city"));
    private SelenideElement addressStateInput = element(Selectors.byId("customer.address.state"));
    private SelenideElement addressZipCodeInput = element(Selectors.byId("customer.address.zipCode"));
    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));
    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));
    private SelenideElement passwordConfirmInput = element(Selectors.byId("repeatedPassword"));

    //Success message for user creation

    private SelenideElement welcomeTitle = element(Selectors.byClassName("title"));

    //Button
    private SelenideElement registerButton =element(Selectors.byValue("Register"));

    // .. add errors elements

    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
    private SelenideElement addressCityError = element(Selectors.byId("customer.address.city.errors")); //City
    private SelenideElement addressStateError = element(Selectors.byId("customer.address.state.errors"));
    private SelenideElement addressZipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
    private SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));
    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
    private SelenideElement passwordConfirmError = element(Selectors.byId("repeatedPassword.errors"));


    public  void open() {
        Selenide.open("/parabank/register.htm");
        }



    public void register(BankAccount bankAccount) {
        firstNameInput.val(bankAccount.getFirstName());
        lastNameInput.val(bankAccount.getLastName());;
        addressStreetInput.val(bankAccount.getAddress());
        addressCityInput.val(bankAccount.getCity());
        addressStateInput.val(bankAccount.getState());
        addressZipCodeInput.val(bankAccount.getZip());
        ssnInput.val(bankAccount.getSSN());
        userNameInput.val(bankAccount.getUsername());
        passwordInput.val(bankAccount.getPassword());
        passwordConfirmInput.val(bankAccount.getPasswordConfirmation());

        registerButton.click();
    }
}
