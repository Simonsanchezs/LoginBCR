package co.org.buggy.calidad.pruebalogin.questions;

import co.org.buggy.calidad.pruebalogin.userinterfaces.LoginPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


/**
 * Pregunta que devuelve el texto del mensaje de credenciales inválidas de la aplicación.
 */
public class TheInvalidCredentialsMessage implements Question<String> {

    public static TheInvalidCredentialsMessage text() {
        return new TheInvalidCredentialsMessage();
    }

    @Override
    @Step("{0} pregunta por el texto del mensaje de credenciales inválidas")
    public String answeredBy(Actor actor) {
        return Text.of(LoginPageUI.INVALID_CREDENTIALS_MESSAGE).answeredBy(actor);
    }
}