package org.example.steps;

import org.example.pages.CommonPage;
import org.example.pages.CreateUseCasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateUseCaseSteps extends FluentCucumberTest implements En {
    @Page
    private final CreateUseCasePage _createusecasePage = new CreateUseCasePage();
    @Page
    private final CommonPage _commonPage = new CommonPage();


    @Then("I select Create Use Case")
    public void iSelectCreateUseCase() {
        _createusecasePage.awaitUntilClickableThenClick(_createusecasePage.getCreateCaseButton());
    }

    @And("I create new Case with {string} and {string} and {string} and {string}")
    public void iCreateNewCase(final String title, final String description, final String expected_result, final String steps) {
        el(By.name("title")).fill().with(title);
        el(By.name("description")).fill().with(description);
        el(By.name("expected_result")).fill().with(expected_result);
        _commonPage.getAutomatedSwitch().click();
        el(By.id("stepId")).fill().with(steps);
        _commonPage.awaitUntilClickableThenClick(_commonPage.getSubmitButton());

    }

    @And("Number of created use cases is {int}")
    public void thereAreNumberOfCompanyContacts(final int count)
    {
        assertThat(_createusecasePage.getUseCaseList().size()).isEqualTo(count);
    }

    @And("I can delete all cases")
    public void iCanDeleteAllCases() {
        _createusecasePage.getUseCaseList().click();
        await().explicitlyFor(5, TimeUnit.SECONDS);
        _commonPage.getDeleteButton().click();
        _commonPage.getPopupElementDeleteButton().click();

        //TO DO : Implement way to delete all cases

    }
}
