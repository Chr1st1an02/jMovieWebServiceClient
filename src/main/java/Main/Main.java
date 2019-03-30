/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Media;
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

        while (!quit) {
            // Alle Songs vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Medien");
            System.out.println("================");
            System.out.println();

            Media[] medias = mediaResource.findAll();

            if (medias != null) {
                for (Media media : medias) {
                    System.out.println("Titel:       " + media.title);
                    System.out.println("Angelegt von:   " + media.owner.username);

                    System.out.println();
                }
            }
            
        }
    }
}

           
        
        
        
        
    
    

