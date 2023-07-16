package com.brite.step_definitions;

import com.brite.pages.DashboardPage;
import com.brite.pages.LoginPage;
import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("the user enters valid {string} credentials")
    public void theUserEntersValidCredentials(String managerType) {
        loginPage.login(managerType);
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("channel_inbox"));//to be checked with requirements
       // Assert.assertTrue(Driver.getDriver().getTitle().equals("#Inbox - Odoo"));
    }


    @Then("the user enters valid manager's {string} and {string}")
    public void theUserEntersValidManagerSAnd(String username, String password) {
        loginPage.login2(username, password);
    }


    @Given("the user enters valid {string}")
    public void theUserEntersValid(String accountType) {
        loginPage.displayAccountType();
    }
}
