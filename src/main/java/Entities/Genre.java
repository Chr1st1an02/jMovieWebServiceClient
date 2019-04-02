/*
 * Copyright © 2019 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author bpal
 */
public class Genre implements Serializable {

    private long id;
    private String name;

    
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Genre() {
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //</editor-fold>
    
    
}
