package co.org.buggy.calidad.pruebalogin.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageUI {

    // Elemento para ingresar usuario
    public static final By USERNAME_BY = By.name("login");
    public static final Target USERNAME_FIELD =
            Target.the("campo de usuario").located(USERNAME_BY);

    // Elemento para ingresar contraseña
    public static final By PASSWORD_BY = By.name("password"); 
    public static final Target PASSWORD_FIELD =
            Target.the("campo de contraseña").located(PASSWORD_BY);

    // Botón de login
    public static final By LOGIN_BUTTON_BY = By.cssSelector("button.btn.btn-success[type='submit']");
    public static final Target LOGIN_BUTTON =
            Target.the("botón de login").located(LOGIN_BUTTON_BY);

    // Elemento que dice que la contraseña o usuario son incorrectos
    public static final By INVALID_CREDENTIALS_MESSAGE_BY = By.cssSelector("span.label.label-warning");
    public static final Target INVALID_CREDENTIALS_MESSAGE =
            Target.the("mensaje de credenciales invalidas").located(INVALID_CREDENTIALS_MESSAGE_BY);

    // Elemento que indica inicio de sesión correcto
    public static final By WELCOME_MESSAGE_BY = By.cssSelector("li.nav-item span.nav-link.disabled");
    public static final Target WELCOME_MESSAGE_SPAN =
            Target.the("mensaje de bienvenida de usuario")
                    .located(WELCOME_MESSAGE_BY);
}