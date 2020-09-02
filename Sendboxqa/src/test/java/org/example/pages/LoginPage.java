package org.example.pages;

import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage
{

	private static final String LOGIN_BUTTON= "#root > div > div.container > div > div > div > div > div > a.btn.btn-lg.btn-secondary";
	private static final String LOGOUT_BUTTON= "#mobile-nav > ul > li:nth-child(4) > a";
	private static final String LOGIN_ERROR_MESSAGE_CLASS = "invalid-feedback";

	public FluentWebElement getLogInButton()
	{
		return el(By.cssSelector(LOGIN_BUTTON));
	}

	public FluentWebElement getLogOutButton()
	{
		return el(By.cssSelector(LOGOUT_BUTTON));
	}

	public FluentWebElement getLoginErrorMessage()
	{
		return getElementByClassName(LOGIN_ERROR_MESSAGE_CLASS);
	}

}
