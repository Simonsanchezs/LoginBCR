package co.org.buggy.calidad.pruebalogin.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/LoginDeUsuario.feature",
        glue = "co.org.buggy.calidad.pruebalogin.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class loginrunner {
}