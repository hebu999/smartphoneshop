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
 * Diese Klasse validiert das Telefon Eingabefeld
 *
 *
 */

@FacesValidator(value="telValidator")
public class TelefonValidator implements Validator {


  Pattern pattern = Pattern.compile("^(\\+?"//Landesvorwahl kann mit + beginnen
      +"[0-9]{1,3})?"//Landesvorwahl besteht aus bis zu 3 Ziffern,die Vorwahl ist nicht zwingend notwendig
      +"[ -]?"//Landesvorwahl kann von Rest mit " " oder "-" getrennt werden
      +"([0]?[0-9]{3,4})?"//Orts- oder Mobilfunkvorwahlen können mit 0 begonnen werden, anschließend folgen 3-4 Ziffern, die Vorwahl ist nicht zwingend notwendig
      +"[ -]?"//Orts- oder Mobilfunkvorwahlen können von Rest mit " " oder "-" getrennt werden
      +"([0-9]{6,7})$");

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) {

    Matcher matcher = pattern.matcher(value.toString());

    if (!matcher.matches()) {


      FacesMessage fmsg = new FacesMessage("Telefonnummer entspricht nicht den Vorgaben!");
      fmsg.setSeverity(FacesMessage.SEVERITY_WARN);
      throw new ValidatorException(fmsg);

    }

  }
}
