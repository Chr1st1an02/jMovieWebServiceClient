/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package Entities;

import java.io.Serializable;
import java.util.List;

/**
 * Datenbankklasse für einen Benutzer.
 */
public class RESTUser implements Serializable {

    private String username;
    private String vorname;
    private String nachname;

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public RESTUser() {
    }

    public RESTUser(String username, String vorname, String nachname) {
        this.username = username;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
   

   

    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


    //</editor-fold>
}
