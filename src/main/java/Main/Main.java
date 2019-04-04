/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Genre;
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
        
        mediaResource.setAuthData("Mediargon", "123456");
        mediaFindAll();
        mediaFindById(50);
        mediaFind("HIMYM","Thriller",null);
            
         
    }
    
    public static void mediaFindAll() throws UnirestException, WebAppException{
        // Alle Medias vom Server abrufen und anzeigen
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
    }

    private static void mediaFindById(long id) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Media mit ID: "+id);
            System.out.println("================");
            System.out.println();

            RESTMedia media = mediaResource.findMedia(id);

            if (media != null) {
                
                System.out.println("Type:        "+ media.getType());
                System.out.println("Titel:       " + media.getTitle());
                System.out.println("Angelegt von:   " + media.getOwner().getUsername());
                System.out.println();
                
            }
    }
    private static void mediaFind(String title, String genre, String status) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.print("Media mit ");
            System.out.print(" Title "+title);
            System.out.print(" Genre "+genre);
            System.out.println(" Status "+status);
            System.out.println("================");
            System.out.println();

            RESTMedia[] medias = mediaResource.find(title, genre, status);

            if (medias != null) {
                for (RESTMedia media : medias) {
                    System.out.println("Type:        "+ media.getType());
                    System.out.println("Titel:       " + media.getTitle());
                    System.out.println("Angelegt von:   " + media.getOwner().getUsername());

                    System.out.println();
                }
            }
    }
}

           
        
        
        
        
    
    

