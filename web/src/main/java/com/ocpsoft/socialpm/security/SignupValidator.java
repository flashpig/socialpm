package com.ocpsoft.socialpm.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputElement;

@RequestScoped
@FacesValidator("signupValidator")
public class SignupValidator implements Validator
{
   @Inject
   private InputElement<String> password;
   @Inject
   private InputElement<String> passwordConfirm;

   @Override
   public void validate(final FacesContext context, final UIComponent comp, final Object values)
            throws ValidatorException
   {
      if (((passwordConfirm.getValue() == null)
               || ("".equals(passwordConfirm.getValue())))
               && !(password.getValue() == null || !"".equals(password.getValue())))
      {
         passwordConfirm.getComponent().setValid(false);
         passwordConfirm.getComponent().setValidatorMessage("Confirm your password");
         throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please confirm your password.",
                  null));
      }
   }
}