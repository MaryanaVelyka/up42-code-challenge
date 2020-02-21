package com.mvelyka.up42.ui;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Test
public class CreateWorkflowTest {

    private String projectName = "TestProject";

    @BeforeTest
    public void testSetup() {
        Configuration.startMaximized = true;
        open("https://console.up42.com/sign-in");
        $(By.xpath("//a[.='Accept cookies']")).click();

        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    public void createProjectAndWorkFlowTest() {
        String description = "description";
        String workFlowName = "workflow";

        LandingPage landingPage = new LandingPage();
        ProjectDetailPage projectDetailPage =  landingPage.startProject(projectName, description);
        CreateWorkflowFirsStepPage createWorkflowFirsStepPage = projectDetailPage.clickCreateWorkflow();

        CreateWorkflowSecondStepPage createWorkflowSecondStepPage =  createWorkflowFirsStepPage.completeFirstStep(workFlowName, description);
        CreateWorkflowThirdStepPage createWorkflowThirdStepPage = createWorkflowSecondStepPage.completeSecondStep();

        LandingPage backToLandingPage = createWorkflowThirdStepPage.backToProjectsList();
        Assert.assertTrue(backToLandingPage.isProjectInList(projectName));

    }

    @AfterTest
    public void cleanup() {
        LandingPage landingPage = new LandingPage();
        landingPage.isProjectInList(projectName);
        ProjectDetailPage projectDetailPage = landingPage.openProjectDetails(projectName);
        projectDetailPage.deleteProject();

    }

}
