package org.example.pages;

import org.example.components.AttributesComponent;
import org.example.components.NavigationTestData;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;

public class CreateUseCasePage extends BasePage{

    private final static String USE_CASE_LIST = ".//a[contains(@href,'/use-cases')]";

    public FluentWebElement getCreateCaseButton()
    {
        return getElementByDataTest(AttributesComponent.ANCHOR, NavigationTestData.CREATE_CASE.getComponent());
    }

    public FluentWebElement getUseCaseList()
    {
        return el(By.xpath(USE_CASE_LIST));
    }
}
