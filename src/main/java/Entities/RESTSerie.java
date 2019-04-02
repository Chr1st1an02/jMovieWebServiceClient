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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mediarg0n
 */
public class RESTSerie extends RESTMedia implements Serializable {

    private List<RESTSeason> seasons;
    
    
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public RESTSerie() {
        super();
    }

    public RESTSerie(List<RESTSeason> seasons, RESTUser owner, List<Genre> genres, String title, String description, Date releaseDate, String type) {
        super(owner, genres, title, description, releaseDate, type);
        this.seasons = seasons;
    }

    
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public List<RESTSeason> getSeasons(){
        return seasons;
    }
 
    public void setSeasons(List<RESTSeason> seasons){
        this.seasons= seasons;
    }
    //</editor-fold>
    
}

