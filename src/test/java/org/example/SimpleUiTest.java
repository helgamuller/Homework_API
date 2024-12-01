package org.example;

import com.codeborne.selenide.*;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        Configuration.timeout = 10;

    }

    //DRY = Don't repeat yourself
    //Web-elements DON't searching in test they should be looking  for in PAGE OBJECT class
    //All Data created in a separated Dataclass

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {

        //Preparation of the page

        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Data preparation
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        //Steps
        registerAccountPage.register(bankAccount);

        //Result check
        registerAccountPage.getAddressError().shouldBe(Condition.exactText("Address is required."));
        registerAccountPage.getAddressCityError().shouldBe(Condition.exactText("City is required."));
        registerAccountPage.getAddressStateError().shouldBe(Condition.exactText("State is required."));
        registerAccountPage.getAddressZipCodeError().shouldBe(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldBe(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUserNameError().shouldBe(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldBe(Condition.exactText("Password is required."));
        registerAccountPage.getPasswordConfirmError().shouldBe(Condition.exactText("Password confirmation is required."));



    }
    @Test
    public void userCanBeCreatedWithMandatoryFields() {
        //Preparation of the page

        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Data preparation
        String pwd = RandomData.randomString();
        String username = RandomData.randomString();

        BankAccount bankAccount = BankAccount.builder()
               .firstName(RandomData.randomString())
               .lastName(RandomData.randomString())
               .address(RandomData.randomString())
               .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zip(RandomData.randomString())
                .SSN(RandomData.randomString())
                .username(username)
                .password(pwd)
                .passwordConfirmation(pwd).build();

        /* Steps */
        registerAccountPage.register(bankAccount);

        //Check result
        registerAccountPage.getWelcomeTitle().shouldBe(Condition.exactText("Welcome "+ username));
    }
}
