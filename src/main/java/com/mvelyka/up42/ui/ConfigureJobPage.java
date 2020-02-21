package com.mvelyka.up42.ui;

import com.codeborne.selenide.Condition;
import com.mvelyka.up42.ui.helper.Constants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ConfigureJobPage {

    private static final String JOB_CONFIGURATION_SELECTOR = "//span[.='Job Configuration']";

    public ConfigureJobPage() {
        $(By.xpath(JOB_CONFIGURATION_SELECTOR)).waitUntil(Condition.visible, Constants.WAIT_TIME);
    }
}
