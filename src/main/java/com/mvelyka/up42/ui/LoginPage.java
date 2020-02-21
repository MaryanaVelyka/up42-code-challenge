package com.mvelyka.up42.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    //TODO move email and password as run parameter or env variable
    private SelenideElement emailAddressField = $(By.id("email"));
    private SelenideElement password = $(By.id("password"));
    private SelenideElement signInButton = $(By.xpath("//button[@type='submit']"));

    public LoginPage() {
        emailAddressField.waitUntil(Condition.visible, Constants.WAIT_TIME);
    }

    public void login() {
        emailAddressField.setValue("maryana.velyka@gmail.com");
        password.setValue("password");
        signInButton.click();
    }
}
