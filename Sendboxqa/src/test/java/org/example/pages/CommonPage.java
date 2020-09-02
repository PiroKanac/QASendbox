package org.example.pages;

import org.example.components.AttributesComponent;
import org.example.components.NavigationTab;
import org.example.components.NavigationTestData;
import org.fluentlenium.core.domain.FluentWebElement;

import org.openqa.selenium.By;


public class CommonPage extends BasePage
{
	private static final String NAVIGATION_ITEM_SANDBOX = "a[href*='/dashboard']";
	private static final String NAVIGATION_ITEM_EXAM = "a[href*='/exam']";
	private static final String NAVIGATION_ITEM_INTRO = "a[href*='/intro']";
	private static final String AUTOMATED_SWITCH = "#root > div > div.container > div > div > div > form > div.pure-control-group.text-secondary.mx-auto.pt-1.ml-2 > div > div > label";
	private static final String POPUP_DELETE_BUTTON = "#root > div > div.container > div > div > div > form > span.input-group-btn.delete-button > div > div.sweet-alert > p > span:nth-child(2) > button";

	public FluentWebElement getNavigationTab(final NavigationTab navigationTab) throws Exception
	{
		switch (navigationTab)
		{
			case SANDBOX:
				return el(By.cssSelector(NAVIGATION_ITEM_SANDBOX));

			case EXAM:
				return el(By.cssSelector(NAVIGATION_ITEM_EXAM));

			case INTRO:
				return el(By.cssSelector(NAVIGATION_ITEM_INTRO));

			case USE_CASES:
				return getElementByDataTest(AttributesComponent.DIV, NavigationTestData.NAVIGATION_ITEM_USE_CASES.getComponent());

			case PLAYGROUND:
				return getElementByDataTest(AttributesComponent.DIV, NavigationTestData.NAVIGATION_ITEM_PLAYGROUND.getComponent());

			case REPORTING_ISSUES:
				return getElementByDataTest(AttributesComponent.DIV,NavigationTestData.NAVIGATION_ITEM_REPORTING_ISSUES.getComponent());


		default:
			throw new Exception("Unknown navigation tab item requested");
		}
	}

	public FluentWebElement getSubmitButton()
	{
		return getElementByDataTest(AttributesComponent.BUTTON, NavigationTestData.SUBMIT_BUTTON.getComponent());
	}

	public FluentWebElement getAutomatedSwitch()
	{
		return el(By.cssSelector(AUTOMATED_SWITCH));
	}

	public FluentWebElement getDeleteButton()
	{
		return getElementByDataTest(AttributesComponent.BUTTON, NavigationTestData.DELETE_BUTTON.getComponent());
	}
	public FluentWebElement getPopupElementDeleteButton()
	{
		return el(By.cssSelector(POPUP_DELETE_BUTTON));
	}
}
