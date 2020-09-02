package org.example.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;
import org.example.components.UserProfile;
import org.example.pages.CommonPage;
import org.example.pages.LoginPage;
import org.example.web.QASandboxPortal;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps extends FluentCucumberTest implements En {

	private final Map<String, UserProfile> _candidateProfiles = createCandidateProfiles();
	@Page
	private final LoginPage _loginPage = new LoginPage();
	@Page
	private final CommonPage _commonPage = new CommonPage();
	@Page
	private QASandboxPortal _qasandboxPortal;

	@Before
	public void before(Scenario scenario)
	{
	}

	@After
	public void after(Scenario scenario)
	{
		final WebDriver driver = getDriver();
		if (driver != null)
		{
			driver.quit();
		}
	}

	@Override
	public WebDriver newWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/VladimirN/Desktop/Sendboxqa/Driver/chromedriver.exe");
		return new ChromeDriver();
	}

	@Given("I open QA SandBox")
	public void iOpenTheQASandBox() {
		this.initFluent(newWebDriver());
		goTo(_qasandboxPortal).verifyIfIsLoaded();
		await().explicitlyFor(2, TimeUnit.SECONDS);
	}

	@And("I click on the Login button")
	public void iClickOnTheLoginButton() {

		_loginPage.getLogInButton().click();
		await().explicitlyFor(5, TimeUnit.SECONDS);
	}

	@And("^I login into QASandbox portal as \"([^\"]*)\"$")
	public void iLoginToCandidatePortal(final String user)
	{
		final UserProfile userProfile;
		userProfile = _candidateProfiles.get(user);
		iLoginAsWithPassword(userProfile.getAccount(), userProfile.getPassword());
	}

	@And("I login as {string} with password {string}")
	public void iLoginAsWithPassword(final String email, final String password) {
		el(By.name("email")).fill().with(email);
		el(By.name("password")).fill().with(password);
		_commonPage.awaitUntilClickableThenClick(_commonPage.getSubmitButton());
	}

	@Then("I got error {string}")
	public void iGotErrorMessages(final String messages)
	{
		final FluentWebElement feedbackText = _loginPage.getLoginErrorMessage();
		assertThat(feedbackText.text()).isEqualTo(messages);
	}

	@And("I log out")
	public void iLogOut()
	{
		_loginPage.awaitUntilClickableThenClick(_loginPage.getLogOutButton());
	}

	private Map<String, UserProfile> createCandidateProfiles() {
		final Map<String, UserProfile> candidateProfiles = new HashMap<>();

		candidateProfiles.put("Vladimir Nikolic", new UserProfile("nikolic_vla@yahoo.com", "gzNfVHHPYUhh3Xx", "Vladimir Nikolic"));

		return candidateProfiles;
	}
}