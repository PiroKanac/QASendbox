package org.example.pages;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.Optional;

import org.example.components.AttributesComponent;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.action.KeyboardActions;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.wait.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java8.En;

public class BasePage extends FluentCucumberTest implements En
{
	public FluentWebElement getElementById(final String elementId)
	{
		return el("#" + elementId);
	}

	public FluentWebElement getElementByClassName(final String className)
	{
		return el("." + className);
	}

	public FluentList<FluentWebElement> getElementsByClassName(final String className)
	{
		return $("." + className);
	}

	public FluentWebElement getElementByDataTest(final AttributesComponent attribute, final String dataTestValue)
	{
		return el(attribute.getComponent() + "[data-testid='" + dataTestValue + "']");
	}

	public FluentList<FluentWebElement> getElementsByDataTest(final AttributesComponent attribute, final String dataTestValue)
	{
		return $(attribute.getComponent() + "[data-test='" + dataTestValue + "']");
	}

	public FluentList<FluentWebElement> getChainElementsByDataTest(
		final AttributesComponent attribute0,
		final String dataTestValue0,
		final AttributesComponent attribute1,
		final String dataTestValue1)
	{
		return $(attribute0.getComponent()
			+ "[data-test='"
			+ dataTestValue0
			+ "'] "
			+ attribute1.getComponent()
			+ "[data-test='"
			+ dataTestValue1
			+ "']");
	}

	public FluentWebElement getSubElementByDataTest(
		final FluentWebElement parent,
		final AttributesComponent attribute,
		final String dataTestValue)
	{
		return parent.el(By.cssSelector(attribute.getComponent() + "[data-test='" + dataTestValue + "']"));
	}

	public FluentList<FluentWebElement> getSubElementsByTestData(
		final FluentWebElement parent,
		final AttributesComponent attribute,
		final String dataTestValue)
	{
		return parent.$(By.cssSelector(attribute.getComponent() + "[data-test='" + dataTestValue + "']"));
	}



	public FluentWait waitExplicitly(final int amount)
	{
		return await().explicitlyFor(amount, SECONDS);
	}

	public FluentWait waitAtMost(final int amount)
	{
		return await().atMost(amount, SECONDS);
	}

	public void waitForElementToBeDisplayed(final FluentWebElement pageElement)
	{
		waitAtMost(300).untilElement(() -> pageElement).displayed();
	}

	public void waitForElementToBePresent(final FluentWebElement pageElement)
	{
		waitAtMost(300).untilElement(() -> pageElement).present();
	}

	public void waitForElementToDisappear(final FluentWebElement pageElement)
	{
		waitAtMost(300).untilElement(() -> pageElement).not().present();
	}

	public void waitUntilElementTextContains(final FluentWebElement pageElement, final String expectedTextContain)
	{
		final ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> pageElement.text().contains(expectedTextContain);
		waiter().until(elementTextEqualsString);
	}

	public void waitUntilElementValueContains(final FluentWebElement pageElement, final String expectedTextContain)
	{
		final ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> pageElement.value().contains(expectedTextContain);
		waiter().until(elementTextEqualsString);
	}

	public void waitForElementToBeClickable(final FluentWebElement pageElement)
	{
		await().until(pageElement).clickable();
	}

	public void pressKeys(final CharSequence charSequence)
	{
		final KeyboardActions keyboardActions = new KeyboardActions(getDriver());
		keyboardActions.sendKeys(charSequence);
	}

	protected WebDriverWait waiter()
	{
		return new WebDriverWait(getDriver(), 300);
	}

	public void waitImplicit(final int time)
	{
		//TODO : Find solution to wait for network request to be loaded
		try
		{
			Thread.sleep(time * 1000);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	public void waitUntilPageLoaded()
	{
		final ExpectedCondition<Boolean> expectation =
			driver -> jsExecutor().executeScript("return document.readyState").toString().equals("complete");

		try
		{
			waiter().until(expectation);
			Thread.sleep(2000);
		}
		catch (final Exception e)
		{
			getDriver().navigate().refresh();
			waiter().until(expectation);
		}
	}

	public void awaitUntilClickableThenClick(final FluentWebElement element)
	{
		waitForElementToBePresent(element);
		await().until(element::clickable);
		element.scrollToCenter();
		element.getElement().click();
		waitUntilPageLoaded();
	}

	protected JavascriptExecutor jsExecutor()
	{
		return (JavascriptExecutor)getDriver();
	}

	public void waitElementEnabled(final FluentWebElement element)
	{
		waitAtMost(300).until(element).enabled();
	}

	public void closeWindowByContainUrl(final String desiredUrl)
	{
		String desiredWindow = getDriver().getWindowHandle();
		for (String handle : getDriver().getWindowHandles())
		{
			getDriver().switchTo().window(handle);
			if (getDriver().getCurrentUrl().contains(desiredUrl))
			{
				desiredWindow = handle;
			}
			else
			{
				getDriver().switchTo().window(handle);
				getDriver().close();
			}
		}
		getDriver().switchTo().window(desiredWindow);
		waitUntilPageLoaded();
	}

	public FluentWebElement getPaginationLinkItem(final FluentWebElement parent, final int pageNumber) throws Exception
	{
		final Optional<FluentWebElement> pageItem = parent.$(".page-link").stream()
			.filter(webElement -> webElement.text().trim().equals(String.valueOf(pageNumber))).findFirst();

		if (!pageItem.isPresent())
		{
			throw new Exception("No page found with requested number");
		}

		return pageItem.get();
	}
}
