package starter.postcodes;

import lombok.var;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FavouritesAPI {
    private EnvironmentVariables environmentVariables;

    @Step
    public String invoke_my_webservice() {
        String webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("api.base.endpoint");
        return webserviceEndpoint;
    }

    @Step
    public List<String> invoke_all_webservices(){
        List<String> envList= new ArrayList<>();
        var Environments= EnvironmentSpecificConfiguration.from(environmentVariables);
        EnvironmentVariables objEnvVar = SystemEnvironmentVariables.createEnvironmentVariables();
        Properties items=objEnvVar.getProperties();
        var v3=items.propertyNames();
        items.forEach((k, v) -> {
            if (k.toString().contains("environments")) {
                System.out.println(k + ", : " + v);
                envList.add((String) v);
            }
        });
        return envList;
    }

    @Step
    public String invoke_xapikey(){

        return "";
    }

}
