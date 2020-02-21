package com.mvelyka.up42.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailPage {

    private static final String TEST_PROJECT_HEADER_SELECTOR = "//h1[.='TestProject']";
    private SelenideElement createWorkflowButton = $(By.xpath("//button[contains(text(), 'Create Workflow')]"));
    private SelenideElement settingsTab = $(By.xpath("//span[.='Settings']"));
    private SelenideElement deleteProject = $(By.xpath("//button[contains(text(),'Delete Project')]"));
    private SelenideElement deleteConfirmation = $(By.xpath("//div[contains(text(), 'You are about')]/following-sibling::*/div/button[contains(text(),'Delete')]"));

    public ProjectDetailPage() {
        $(By.xpath(TEST_PROJECT_HEADER_SELECTOR)).waitUntil(Condition.visible, Constants.WAIT_TIME);
    }

    public CreateWorkflowFirsStepPage clickCreateWorkflow() {
        createWorkflowButton.click();
        return new CreateWorkflowFirsStepPage();
    }

    public void deleteProject() {
        settingsTab.click();
        deleteProject.click();
        deleteConfirmation.waitUntil(Condition.visible, Constants.WAIT_TIME);
        deleteConfirmation.click();
    }
}
