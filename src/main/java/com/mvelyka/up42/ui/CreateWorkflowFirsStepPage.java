package com.mvelyka.up42.ui;

import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateWorkflowFirsStepPage {

    private static final String CREATE_WORKFLOW_HEADER_SELECTOR = "//h1[.='Create a Workflow']";
    private SelenideElement nameField = $(By.xpath("//input[@id='name']"));
    private SelenideElement descriptionField = $(By.xpath("//input[@id='description']"));
    private SelenideElement nextButton = $(By.xpath("//button[contains(text(),'Next' )]"));

    public CreateWorkflowFirsStepPage() {
        $(By.xpath(CREATE_WORKFLOW_HEADER_SELECTOR)).waitUntil(visible, Constants.WAIT_TIME);
    }

    public CreateWorkflowSecondStepPage completeFirstStep(String name, String description) {
        nameField.setValue(name);
        descriptionField.setValue(description);
        nextButton.click();
        $(By.xpath("//div[@role='button']")).click();
        return new CreateWorkflowSecondStepPage();
    }
}
