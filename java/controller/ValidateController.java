package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("validateController")
@RequestScoped
public class ValidateController {

  public ValidateController() {

  }

  public void checkName(FacesContext fc, Object obj) throws ValidatorException {

    String pattern = (String) obj;
    String matcher = "^[A-Za-z]{1}" + "[A-Za-z0-9]{7,15}$";
    String fm = "Benutzername ist nicht lang genug";

    if (!Pattern.matches(matcher, pattern)) {

      throw new ValidatorException(new FacesMessage(fm));
    }
  }

  public void CheckPwd(FacesContext fc, Object obj) {

    String pattern = (String) obj;
    String matcher = "^(?=.*\\d)" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + ".{8,}$";
    String fm = "Passwort entspricht nicht den Vorgaben";

    if (!Pattern.matches(matcher, pattern)) {

      throw new ValidatorException(new FacesMessage(fm));
    }
  }
}