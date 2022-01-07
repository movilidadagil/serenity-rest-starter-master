package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "classpath:features"
       // tags = "@user-favs"
      //  tags = "@favs"
      //  tags ="@emrefavs"
      //  tags = "@emrefavsoutline"
      //  tags = "@favs-list"

)
public class CucumberTestSuite {}
