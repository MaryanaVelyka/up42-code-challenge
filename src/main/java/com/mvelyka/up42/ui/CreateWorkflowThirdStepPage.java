package com.mvelyka.up42.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateWorkflowThirdStepPage {

    private static final String CONFIRMATION_SELECTOR = "//span[.='You have successfully saved your workflow and can start configuring jobs.']";
    private SelenideElement configureJobButton = $(By.xpath("//button[contains(text(), 'Configure Job')]"));

    public CreateWorkflowThirdStepPage() {
        $(By.xpath(CONFIRMATION_SELECTOR)).waitUntil(Condition.visible, Constants.WAIT_TIME);
    }

    public ConfigureJobPage completeThirdStep() {
        configureJobButton.click();

        return new ConfigureJobPage();
    }

    public LandingPage backToProjectsList() {
        $(By.xpath("//a[contains(text(),'Projects')]")).click();
        return new LandingPage();
    }
}
