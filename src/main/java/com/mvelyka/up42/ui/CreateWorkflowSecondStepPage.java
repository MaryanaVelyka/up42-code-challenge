package com.mvelyka.up42.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateWorkflowSecondStepPage {

    private SelenideElement addFirstBlockButton = $(By.xpath("//h4[contains(text(), 'Processing')]/preceding-sibling::*//button[contains(text(),'Add Block')]"));
    private SelenideElement searchFilter = $(By.xpath("//input[@type='text'] [@placeholder='Search']"));
    private SelenideElement blocksCatalogAddButton = $(By.xpath("//p[contains(text(),'By adding this block')]/../following-sibling::*/button[contains(text(), 'Add Block')]"));
    private SelenideElement addSecondBlockButton = $(By.xpath("//button[contains(text(),'Add Block')]"));
    private SelenideElement nextButton = $(By.xpath("//h4[contains(text(), 'Processing')]/following-sibling::*//button[contains(text(),'Next' )]"));

    public CreateWorkflowSecondStepPage() {
        addFirstBlockButton.waitUntil(visible, Constants.WAIT_TIME);
    }

    public CreateWorkflowThirdStepPage completeSecondStep() {
        String blocksCatalogBlockToSelect = "//div[contains(text(), '%s')]";

        addFirstBlockButton.click();
        searchFilter.setValue("Sentinel-2 L1C MSI AOI");

        String firstFilteredValue = String.format(blocksCatalogBlockToSelect, "Sentinel-2 L1C MSI AOI");
        $(By.xpath(firstFilteredValue)).waitUntil(visible, Constants.WAIT_TIME);
        $(By.xpath(firstFilteredValue)).click();

        addCatalogBlockClick();

        addSecondBlockButton.click();
        String secondFilteredValue = String.format(blocksCatalogBlockToSelect, "Sharpening Filter");
        $(By.xpath(secondFilteredValue)).waitUntil(visible, Constants.WAIT_TIME);
        $(By.xpath(secondFilteredValue)).click();

        addCatalogBlockClick();
        nextButton.click();

        return new CreateWorkflowThirdStepPage();

    }

    private void addCatalogBlockClick() {
        blocksCatalogAddButton.waitUntil(Condition.visible, Constants.WAIT_TIME);
        blocksCatalogAddButton.click();
    }

}
