package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 * @author Heiner, Steffen
 * @version 1.0
 *
 * Diese Klasse validiert das Passwort eingabefeld
 *
 *
 */
@FacesValidator(value = "pwdValidator")
public class PwdValidator implements Validator {


  @Override
  public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
    // TODO Auto-generated method stub


    String pattern = (String) obj;
    String matcher = "^([\\w ä ö ü Ä Ö Ü]{5,45})$";
    String fm = "Passwort entspricht nicht den Vorgaben (1 Grobbuchstabe gefolgt von Kleinbuchstaben) ";

    if (!Pattern.matches(matcher, pattern)) {

      throw new ValidatorException(new FacesMessage(fm));
    }
  }
}
