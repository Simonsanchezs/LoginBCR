package co.org.buggy.calidad.pruebalogin.tasks;

import co.org.buggy.calidad.pruebalogin.interactions.EnterLoginCredentials;
import co.org.buggy.calidad.pruebalogin.userinterfaces.LoginPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Tarea para que un actor inicie sesión en la aplicación Buggy Cars Rating con credenciales dadas.
 */
public class LoginToBuggyCars implements Task {

    private final String username;
    private final String password;

    public LoginToBuggyCars(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginToBuggyCars withCredentials(String username, String password) {
        return instrumented(LoginToBuggyCars.class, username, password);
    }

    @Override
    @Step("{0} intenta iniciar sesión con el usuario '#username' y la contraseña '#password'")
    public <T extends Actor> void performAs(T actor) {
        // CAMBIO: Usa Open.url("/") para que Serenity use la URL base configurada en serenity.properties
        actor.attemptsTo(
                Open.url("https://buggy.justtestit.org/"),
                EnterLoginCredentials.with(username, password),
                Click.on(LoginPageUI.LOGIN_BUTTON)
        );
    }
}