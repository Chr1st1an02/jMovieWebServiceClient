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
 * @author bpall
 */
public class RESTSeason implements Serializable {
    private long id;
    private int nr;
    private String releaseDate;
    private List<RESTEpisode> episodes;
    private WatchStatus status;
   
    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public RESTSeason(){
        super();
        this.status = WatchStatus.NOT_WATCHED;
    }

    public RESTSeason(long id, int nr, Date releaseDate, List<RESTEpisode> episodes, WatchStatus status) {
        this.id = id;
        this.nr = nr;
        this.releaseDate = releaseDate.toString();
        this.episodes = episodes;
        this.status = status;
        if(status==null){
            this.status = WatchStatus.NOT_WATCHED;
        }
    }
    
   
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">

   
    
    
    //</editor-fold>

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<RESTEpisode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<RESTEpisode> episodes) {
        this.episodes = episodes;
    }

    public WatchStatus getStatus() {
        return status;
    }

    public void setStatus(WatchStatus status) {
        this.status = status;
    }

    
}
