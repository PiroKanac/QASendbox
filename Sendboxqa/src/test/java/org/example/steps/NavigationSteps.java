package org.example.steps;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

import org.example.components.NavigationTab;
import org.example.pages.CommonPage;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import io.cucumber.java.en.*;
import io.cucumber.java8.En;


public class NavigationSteps extends FluentCucumberTest implements En
{
	@Page private final CommonPage _commonPage = new CommonPage();

	@Then("^I can see the '(Sandbox|Exam|Intro|Use Cases|Playground|Reporting issues)' navigation tab$")
	public void iCanSeeTheTab(final String name) throws Exception
	{
		final Optional<NavigationTab> navigationTab =
				EnumSet.allOf(NavigationTab.class).stream().filter(tab -> tab.getName().equals(name)).findAny();

		if (!navigationTab.isPresent())
		{
			throw new Exception("Unknown navigation tab item");
		}

		final FluentWebElement navigationTabElement = _commonPage.getNavigationTab(navigationTab.get());
		if (!navigationTabElement.present())
		{
			_commonPage.waitForElementToBePresent(navigationTabElement);
		}

		if (!navigationTabElement.displayed())
		{
			_commonPage.waitForElementToBeDisplayed(navigationTabElement);
		}

		assertThat(navigationTabElement.text()).isEqualTo(name);
	}

	@And("I open '(Sandbox|Exam|Intro|Use Cases|Playground|Reporting issues)' navigation tab$")
	public void iOpenProfileTab(final String name) throws Exception
	{
		_commonPage.awaitUntilClickableThenClick(_commonPage.getNavigationTab(findNavigationTab(name)));
	}


	private NavigationTab findNavigationTab(final String name) throws Exception
	{
		return Arrays.stream(NavigationTab.values())
			.filter(navigationTab -> navigationTab.getName().equals(name))
			.findFirst()
			.orElseThrow(() -> new Exception("Unknown navigation tab item"));
	}


}
