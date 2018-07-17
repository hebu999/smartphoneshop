package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Heiner, Steffen
 * @version 1.0
 *
 * Diese Klasse validiert das Email eingabefeld
 *
 *
 */
@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {

  Pattern pattern = Pattern.compile(
      "^([a-z,A-Z,ä,ö,ü,Ä,Ö,Ü,ß,0-9,\\.,\\-,_]{1,30}[@][A-Z,a-z,0-9,-]{1,15}[.][a-z]{2,4})$");

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) {

    Matcher matcher = pattern.matcher(value.toString());

    if (!matcher.matches()) {


      FacesMessage fmsg = new FacesMessage("Email entspricht nicht den Vorgaben!");
      fmsg.setSeverity(FacesMessage.SEVERITY_WARN);
      throw new ValidatorException(fmsg);

    }

  }
}
