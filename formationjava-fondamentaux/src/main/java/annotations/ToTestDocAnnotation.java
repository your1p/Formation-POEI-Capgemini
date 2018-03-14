/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package annotations;

import formationjavaannotation.DOC;

/**
 *
 * @author Olivier Andrade - Aplose
 */
public class ToTestDocAnnotation {
    @DOC(value = "Méthode permettant l'obtention d'un nom sur un utilisateur.")
    public String getUserName(){
        return "Name";
    }

}
