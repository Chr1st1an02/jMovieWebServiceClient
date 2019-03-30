/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D070429
 */
public class User {
    
     public String username = "";
     
     public String vorname = "";
     
     public String nachname = "";
     
     public class Password {
        
        public String password = "";
    }
    
    public final Password password = new Password();

    
    public String passwordHash;

    
    public List<String> groups = new ArrayList<>();

    
    public List<Media> medias = new ArrayList<>();
    
}
