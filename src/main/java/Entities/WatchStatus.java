/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author D070429
 */

public enum WatchStatus {
    
    
    NOT_WATCHED,NOT_COMPLETLY_WATCHED, WATCHED,STOPPED_WATCHING;

    /**
     * Bezeichnung ermitteln
     *
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case NOT_WATCHED:
                return "Noch nicht angeschaut";
            case NOT_COMPLETLY_WATCHED:
                return "Nocht nicht ganz angeschaut";
            case WATCHED:
                return "Vollständig angeschaut";
            case STOPPED_WATCHING:
                return "Aufgehört zu schauen";
            default:
                return this.toString();
        }
    }
    
}
    

