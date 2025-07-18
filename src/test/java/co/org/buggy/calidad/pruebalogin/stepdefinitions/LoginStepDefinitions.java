package co.org.buggy.calidad.pruebalogin.stepdefinitions;

import co.org.buggy.calidad.pruebalogin.questions.TheInvalidCredentialsMessage;
import co.org.buggy.calidad.pruebalogin.questions.TheValidationMessageForField;
import co.org.buggy.calidad.pruebalogin.userinterfaces.LoginPageUI;
import co.org.buggy.calidad.pruebalogin.tasks.LoginToBuggyCars;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    private Actor usuario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

        usuario = OnStage.theActorCalled("Usuario");
    }

    @Given("que un usuario esta en la pagina de inicio de Buggy Cars Rating")
    public void queUnUsuarioEstaEnLaPaginaDeInicioDeBuggyCarsRating() {

    }

    @When("el usuario se loguea con {string} y {string}")
    public void elUsuarioSeLogueaConUsuarioYContrasenia(String username, String password) {

        usuario.attemptsTo(
                LoginToBuggyCars.withCredentials(username, password)
        );
    }

    @Then("el usuario deberia ver la pagina de inicio")
    public void elUsuarioDeberiaVerLaPaginaDeInicio() {
        WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.WELCOME_MESSAGE_BY));


        usuario.should(
                seeThat(Text.of(LoginPageUI.WELCOME_MESSAGE_SPAN), containsString("Hi, simon"))
        );
    }

    @When("el usuario intenta loguearse con {string} y {string}")
    public void elUsuarioIntentaLoguearseConUsuarioYContrasenia(String username, String password) {

        usuario.attemptsTo(
                LoginToBuggyCars.withCredentials(username, password)
        );
    }

    @Then("el usuario deberia ver el mensaje de validacion del navegador {string} para el campo de {string}")
    public void elUsuarioDeberiaVerElMensajeDeValidacionDelNavegadorParaElCampoDe(String expectedMessage, String fieldName) {
        Target fieldToValidate;
        switch (fieldName.toLowerCase()) {
            case "usuario":
                fieldToValidate = LoginPageUI.USERNAME_FIELD;
                break;
            case "contrasena":
                fieldToValidate = LoginPageUI.PASSWORD_FIELD;
                break;
            default:
                throw new IllegalArgumentException("Campo de validación no reconocido: " + fieldName);
        }


        usuario.should(
                seeThat(TheValidationMessageForField.called(fieldToValidate), containsString(expectedMessage))
        );
    }

    @Then("el usuario deberia ver el mensaje de error {string}")
    public void elUsuarioDeberiaVerElMensajeDeError(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.INVALID_CREDENTIALS_MESSAGE_BY));


        usuario.should(seeThat(TheInvalidCredentialsMessage.text(), containsString(expectedErrorMessage)));
    }
}