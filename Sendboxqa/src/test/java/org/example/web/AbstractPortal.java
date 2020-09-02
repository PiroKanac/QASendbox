package org.example.web;

import static java.util.concurrent.TimeUnit.SECONDS;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.Capabilities;

public abstract class AbstractPortal extends FluentPage
{
	@Override
	public String getWebDriver()
	{
		return getConfiguration().getWebDriver();
	}

	@Override
	public String getRemoteUrl()
	{
		return getConfiguration().getRemoteUrl();
	}

	@Override
	public Capabilities getCapabilities()
	{
		return getConfiguration().getCapabilities();
	}

	public void verifyIfIsLoaded()
	{
		await().atMost(60, SECONDS).untilPage().isLoaded();
	}

}
