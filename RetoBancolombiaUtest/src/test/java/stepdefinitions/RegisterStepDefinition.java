package stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import models.ThirdField;
import models.UserFirstFields;
import models.UserSecond;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.OpenHome;
import tasks.RegisterTaskFirts;
import tasks.RegisterTaskSecond;
import tasks.RegisterTaskThrid;

import java.util.List;

public class RegisterStepDefinition {



    @Managed(driver = "Chrome")
    private WebDriver driver;

    @Before
    public void DoSomethingBefore(){//actor
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^I am on the website$")
    public void iAmOnTheWebsite() {
        theActorCalled(".DoSomethingBefore");
        theActorInTheSpotlight().wasAbleTo(OpenHome.browser());
    }

    @When("^the user fills in the data of the first form$")
    public void theUserFillsInTheDataOfTheFirstForm(List<UserFirstFields> data) {
        theActorInTheSpotlight().attemptsTo(RegisterTaskFirts.fields(data));

    }

    @When("^the user fills in the data of the second form$")
    public void theUserFillsInTheDataOfTheSecondForm(List<UserSecond> data) {
        theActorInTheSpotlight().attemptsTo(RegisterTaskSecond.fields(data));
    }


    @When("^the user fills in the data of the third form$")
    public void theUserFillsInTheDataOfTheThirdForm(List<ThirdField> data) {

        theActorInTheSpotlight().attemptsTo(RegisterTaskThrid.fields(data));

        System.out.println();
    }

}


