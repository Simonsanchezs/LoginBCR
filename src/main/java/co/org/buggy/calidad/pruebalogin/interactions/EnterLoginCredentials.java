package co.org.buggy.calidad.pruebalogin.interactions;


import co.org.buggy.calidad.pruebalogin.userinterfaces.LoginPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Interacción para que un actor ingrese credenciales en los campos de usuario y contraseña.
 */
public class EnterLoginCredentials implements Interaction {

    private final String username;
    private final String password;

    public EnterLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public static EnterLoginCredentials with(String username, String password) {
        return instrumented(EnterLoginCredentials.class, username, password);
    }

    @Override
    @Step("{0} ingresa el usuario '#username' y la contraseña '#password'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPageUI.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPageUI.PASSWORD_FIELD)
        );
    }
}