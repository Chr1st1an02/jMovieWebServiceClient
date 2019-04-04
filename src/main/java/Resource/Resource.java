/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Entities.RESTMedia;
import Entities.RESTSerie;
import Exception.WebAppException;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author bpall
 */
public abstract class Resource {
    
    
    public static String username = "";
    public static String password = "";
    
    //
    // Benutzername und Passwort setzen
    //
    public static void setAuthData(String username, String password) {
        Resource.username = username;
        Resource.password = password;
    }
    
    public abstract RESTMedia[] findAll() throws UnirestException, WebAppException;
    public abstract RESTMedia find(long id) throws WebAppException, UnirestException;
    public abstract RESTMedia[] find(String title, String genre, String status) throws UnirestException, WebAppException;
}
