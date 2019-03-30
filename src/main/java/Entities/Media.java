/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author D070429
 */
public class Media {
    
    public final long id = 0L;
    
    public User owner = new User();
    
    public List<Genre> genres;
    
    public String title = "";
    
    public String description = "";
    
    public Date releaseDate = new Date(0);
    
    public WatchStatus status = WatchStatus.NOT_WATCHED;
    
    
    
}
