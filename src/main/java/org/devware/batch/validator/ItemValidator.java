/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.devware.batch.validator;

import java.util.Date;
import org.devware.batch.model.Item;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Cette classe effectue la validation des donnee relative a une persone. 
 * Elle crree un contexte qui sera utilisée par le processeur de validation
 * afin de filtré ou d ' apporté le traitement approprié aux données
 * erronnées de la classe Perssone lue par le reader et transmis au processeur
 * @see Item
 */
public class ItemValidator implements Validator {

        @Override
	public boolean supports(Class<?> arg0) {
            return arg0.isAssignableFrom(Item.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
            Item item = null;
            try {
                    item = (Item) arg0;
            } catch (ClassCastException cce) {
                    errors.reject("Type de de donne incorrecte");
            }

            if(item != null) {
			validateName(item.getName(), errors);
			validateSurname(item.getSurname(), errors);
                        validateDate(item.getDate(), errors);
            }
	}
        
        /**
        * Effecture le controle sur le date  d une personne. 
        * Le model ici etant constitué de la classe personne
        * L objet errors en parametre comporte des erreurs
        * Ces erreurs seront utilisé par le processeur: les ligne errone sont 
        * pas traitées par ce dernier
        *
        * @param  date   Le nom  à valider de la personne
        * @param  errors L' objet erreur comportant les erreurs 
        * @see          ValidatingItemProcessor
        */
	protected void validateDate(Date date, Errors errors) {
		
            // on verifie si la date est null
            if(date == null) {
		errors.rejectValue("Personne.date", "error.null.date");
            }
            // on verifie le format de la date
            if(date != null && !date.toString().matches("[a-zA-Z]+")) {
		errors.rejectValue("Personne.date", "error.format.date");
            }
	}
        
        /**
        * Effectue le controle sur le prenom  d une personne. 
        * Le model ici etant constitué de la classe personne
        * L objet errors en parametre comporte des erreurs
        * Ces erreurs seront utilisé par le processeur: les ligne errone sont 
        * pas traitées par ce dernier
        *
        * @param  surname  Le nom  à valider de la personne
        * @param  errors   Le objet errur comportant les erreurs
        * @see             ValidatingItemProcessor
        */
	protected void validateSurname(String surname, Errors errors) {
                
            // on verifie si le format est null
            if(surname == null) {
                errors.rejectValue("Personne.surname", "error.null.surname");
            }
                
            // on verifie le format du prenom
            if(surname != null && !surname.matches("[a-z][A-Z]+")) {
                errors.rejectValue("Personne.surname", "error.format.surname");
            }
	}
        
       /**
        * Effecture le controle sur le nom  d une personne. 
        * Le model ici etant constitué de la classe personne
        * L objet errors en parametre comporte des erreurs
        * Ces erreurs seront utilisé par le processeur: les ligne errone sont 
        * pas traitées par ce dernier
        *
        * @param  name   Le nom  à valider de la personne
        * @param  errors L objet errur comportant les erreur lors de la validation
        * @see           ValidatingItemProcessor
        */
        protected void validateName(String name, Errors errors) {
                
            // on verifie si le nom est null
            if(name == null) {
		errors.rejectValue("Personne.name", "error.null.name");
            }
                
            // on verifie si le nom est alphabetique
            if(name != null && !name.matches("[a-z][A-Z]+")) {
		errors.rejectValue("Personne.name", "error.format.name");
            }
	}

    
}
