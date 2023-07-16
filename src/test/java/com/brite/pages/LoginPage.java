package com.brite.pages;

import com.brite.utilities.ConfigurationReader;
import com.brite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passWordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    public void login(String email, String password) {
        emailInputBox.sendKeys(email);
        passWordInputBox.sendKeys(password);
        loginButton.click();
    }


    public void login(String managerType) {
        String email, passWord;

        if (managerType.contains(" ")) {
            managerType = managerType.replace(" ", "_");
        }

        boolean m1 = managerType.equalsIgnoreCase("posmanager");
        boolean m2 = managerType.equalsIgnoreCase("crm_manager");
        boolean m3 = managerType.equalsIgnoreCase("sales_manager");
        boolean m4 = managerType.equalsIgnoreCase("inventory_manager");
        boolean m5 = managerType.equalsIgnoreCase("expenses_manager");

        if (m1 || m2 || m3 || m4 || m5) {
            email = ConfigurationReader.getProperty(managerType + "_username") + "@info.com";
            passWord = ConfigurationReader.getProperty(managerType + "_password");

            login(email, passWord);
        }
    }
    //-----------------------------------------------------------------------------------------------

    public void login2(String username, String password) {//    posmanager55@info.com

        emailInputBox.sendKeys(ConfigurationReader.getProperty(username) + "@info.com");
        passWordInputBox.sendKeys(ConfigurationReader.getProperty(password));
        loginButton.click();

    }
    public void displayAccountType() {
        System.out.println();
    }

}
