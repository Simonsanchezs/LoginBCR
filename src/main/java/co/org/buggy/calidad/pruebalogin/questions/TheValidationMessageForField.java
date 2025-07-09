package co.org.buggy.calidad.pruebalogin.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.core.Serenity.getDriver;

/**
 * Pregunta que devuelve el mensaje de validación HTML5 (del navegador) para un campo específico.
 */
public class TheValidationMessageForField implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TheValidationMessageForField.class);

    private final Target field;

    public TheValidationMessageForField(Target field) {
        this.field = field;
    }

    public static TheValidationMessageForField called(Target field) {
        return new TheValidationMessageForField(field);
    }

    @Override
    @Step("{0} pregunta por el mensaje de validación del campo #field")
    public String answeredBy(Actor actor) {
        WebDriver driver = getDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElementFacade elementFacade;
        try {
            elementFacade = field.resolveFor(actor);
        } catch (NoSuchElementException e) {
            LOGGER.warn("El campo '{}' no fue encontrado en la página para verificar el mensaje de validación. Error: {}", field.getName(), e.getMessage());
            return "";
        } catch (Exception e) {
            LOGGER.error("Ocurrió un error inesperado al intentar resolver el campo '{}' para verificar el mensaje de validación. Error: {}", field.getName(), e.getMessage(), e);
            return "";
        }

        if (elementFacade != null && elementFacade.isPresent()) {
            return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", elementFacade.getWrappedElement());
        }

        return "";
    }
}