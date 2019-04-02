/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.RESTMedia;
import Exception.WebAppException;
import Resource.MediaResource;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author D070429
 */
public class Main {
    
    
    static MediaResource mediaResource = new MediaResource();
    
    
    public static void main(String[] args) throws UnirestException, WebAppException{
        boolean quit = false;

        //while (!quit) {
            // Alle Songs vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Medien");
            System.out.println("================");
            System.out.println();

            RESTMedia[] medias = mediaResource.findAll();

            if (medias != null) {
                for (RESTMedia media : medias) {
                    System.out.println("Type:        "+ media.getType());
                    System.out.println("Titel:       " + media.getTitle());
                    System.out.println("Angelegt von:   " + media.getOwner().getUsername());

                    System.out.println();
                }
            }
            
        //}
    }
}

           
        
        
        
        
    
    

