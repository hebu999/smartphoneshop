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
 * Diese Klasse validiert das Namen Eingabefeld
 *
 *
 */
@FacesValidator(value="nameValidator")
public class NameValidator implements Validator {

  
  Pattern pattern = Pattern.compile("^[A-Z Ä Ö Ü ß][a-z ä ö ü ß]*$");

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) {

    Matcher matcher = pattern.matcher(value.toString());

    if (!matcher.matches()) {


      FacesMessage fmsg = new FacesMessage("Name entspricht nicht den Vorgaben!");
      fmsg.setSeverity(FacesMessage.SEVERITY_WARN);
      throw new ValidatorException(fmsg);

    }

  }
  
}

