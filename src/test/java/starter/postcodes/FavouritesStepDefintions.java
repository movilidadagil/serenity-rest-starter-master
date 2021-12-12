package starter.postcodes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;

public class FavouritesStepDefintions {


    Actor actor;
    public String x_api_key="";
    @Steps
    FavouritesAPI favouritesAPI;

    @Given("x-api-key is already acquired.")
    public void x_api_key_is_already_acquired() {
        x_api_key ="8adf71fc-c27b-40ef-8662-19ab891129e3";
    }

    @When("Tester makes {string} request")
    public void tester_makes_request(String endpoint) {
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouritesAPI.invoke_my_webservice()));

        actor.attemptsTo(Get.resource("favourites").with(request ->
                request.header("x-api-key", x_api_key)));
        //actor.attemptsTo(Get.resource("favourites"));

    }

    @Then("Tester should see information about dog")
    public void tester_should_see_information_about_dog() {
        actor.should(
                seeThatResponse("all the favourites shoud be returned",
                        response -> response.statusCode(200)
                                .body("id",hasItem(14065)))
        );

        actor.should(
                seeThatResponse("all the favourites shoud be returned",
                        response -> response.statusCode(200)
                                .body("id",is(14065)))
        );
    }

    @When("I make favourite request with {string} parameter")
    public void i_make_favourite_request_with_parameter(String sub_id) {
        actor = Actor.named("Tester with "+sub_id)
                .whoCan(CallAnApi.at(favouritesAPI.invoke_my_webservice()));
        actor.attemptsTo(Get.resource("favourites?{sub_id}")
                .with(request ->
                request.header("x-api-key", x_api_key))
                .with( request ->
                request.pathParam("sub_id", sub_id)));

    }


    @Then("User should see its favourite including {string}")
    public void user_should_see_its_favourite_including(String user_id) {
        actor.should(
                seeThatResponse("all the votes shoud be returned",
                        response -> response.statusCode(200)
                                .body("user_id",hasItem(user_id)))
        );
    }

    @When("Tester makes favourites api {string} request")
    public void tester_makes_favourites_api_request(String sub_id) {

            /*given().headers("x-api-key",x_api_key)
                    .when().get("https://api.thedogapi.com/v1/favourites?sub_id=my-user-1234")
                    .then()
                    .statusCode(200)
                    .body("image_id", equalTo("Fq6sDY8Qv"));*/

        //https://api.thedogapi.com/v1/favourites?sub_id=my-user-1234
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouritesAPI.invoke_my_webservice()));
        actor.attemptsTo(Get.resource("favourites")
                .with(request ->
                request.header("x-api-key", x_api_key))
                .with(request ->
                request.pathParams("sub_id",sub_id)));

    }


    @Then("Tester should see all favourites dogs by {string}")
    public void tester_should_see_all_favourites_dogs_by(String string) {



    }


    @When("I make request with {string} parameter")
    public void i_make_request_with_parameter(String sub_id) {
        actor = Actor.named("Tester the automation tester")
                .whoCan(CallAnApi.at(favouritesAPI.invoke_my_webservice()));


        actor.attemptsTo(Get.resource("favourites?{sub_id}")
                .with(request ->
                        request.header("x-api-key", x_api_key))
                .with(request ->
                        request.pathParams("sub_id",sub_id)));

    }
    @Then("User should see its {string} favourite")
    public void user_should_see_its_favourite(String image_id) {
        actor.should(
                seeThatResponse("all the votes shoud be returned",
                        response -> response.statusCode(200)
                                .body("image_id",hasItem(image_id)))
        );
    }




}
