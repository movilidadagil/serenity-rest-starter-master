package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

public class FavouritesStepDefintions {


    Actor actor;
    public String x_api_key="";
    @Steps
    FavouiresAPI favouiresAPI;

    @Given("x-api-key is already acquired.")
    public void x_api_key_is_already_acquired() {
        x_api_key ="8adf71fc-c27b-40ef-8662-19ab891129e3";
    }

    @When("Tester makes {string} request")
    public void tester_makes_request(String endpoint) {
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouiresAPI.invoke_my_webservice()));

        actor.attemptsTo(Get.resource("favourites").with(request ->
                request.header("x-api-key", x_api_key)));
    }

    @Then("Tester should see information about dog")
    public void tester_should_see_information_about_dog() {
        actor.should(
                seeThatResponse("all the votes shoud be returned",
                        response -> response.statusCode(200)
                                .body("id",hasItem(14065)))
        );
    }


}
