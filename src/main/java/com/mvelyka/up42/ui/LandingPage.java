package com.mvelyka.up42.ui;

import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {

    private SelenideElement startProject = $(By.xpath("//button[contains(text(), 'Start a Project')]"));
    private SelenideElement startProjectNameField = $(By.id("name"));
    private SelenideElement startProjectDescriptionField = $(By.id("description"));
    private SelenideElement saveProjectField = $(By.xpath("//button[@type='submit']"));

    public LandingPage() {
        startProject.waitUntil(visible, Constants.WAIT_TIME);
    }

    public ProjectDetailPage startProject(String projectName, String projectDescription) {
        startProject.click();
        $(By.xpath("//h4[.='Start Project']")).waitUntil(visible, Constants.WAIT_TIME);
        startProjectNameField.setValue(projectName);
        startProjectDescriptionField.setValue(projectDescription);
        saveProjectField.click();

        return new ProjectDetailPage();
    }

    public boolean isProjectInList(String projectName) {
        String projectInListLocator = "//h3[contains(text(), %s)]";
        $(By.xpath(String.format(projectInListLocator, projectName))).waitUntil(visible, Constants.WAIT_TIME);
        return $(By.xpath(String.format(projectInListLocator, projectName))).isDisplayed();
    }

    public ProjectDetailPage openProjectDetails(String projectName) {
        String projectInListLocator = "//h3[contains(text(), %s)]";
        $(By.xpath(String.format(projectInListLocator, projectName))).waitUntil(visible, Constants.WAIT_TIME);
        $(By.xpath(String.format(projectInListLocator, projectName))).click();

        //TODO investigate why do we need to wait longer then in other cases
        $(By.xpath("//h4[.='Workflows']")).waitUntil(visible, 10000);
        return new ProjectDetailPage();
    }

}
