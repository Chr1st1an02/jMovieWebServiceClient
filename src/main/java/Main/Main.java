/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Genre;
import Entities.RESTEpisode;
import Entities.RESTMedia;
import Entities.RESTMovie;
import Entities.RESTSeason;
import Entities.RESTSerie;
import Exception.WebAppException;
import Resource.MediaResource;
import Resource.MovieResource;
import Resource.Resource;
import Resource.SerieResource;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author D070429
 */
public class Main {
    
    
    static MediaResource mediaResource = new MediaResource();
    static SerieResource serieResource = new SerieResource();
    static MovieResource movieResource = new MovieResource();
    
    static BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    
    
    public static void main(String[] args) throws UnirestException, WebAppException, IOException{
        
        boolean quit = false;
        boolean logedIn = false;
        String id;
        String title;
        String genre;
        String status;
        
        while(!logedIn){
            try{
                System.out.println("================");
                System.out.println("Anmelden");
                System.out.println("================");
                System.out.println();
                System.out.println("Name: ");
                String name = fromKeyboard.readLine().trim();
                System.out.println();
                System.out.println("Passwort: ");
                String passwort = fromKeyboard.readLine().trim();
                System.out.println();
                Resource.setAuthData(name, passwort);
                logedIn=true;

                while(!quit){
                    System.out.println("[A] Alle Medien anzeigen");
                    System.out.println("[B] Alle Serien anzeigen");
                    System.out.println("[C] Alle Filme anzeigen");
                    System.out.println("[D] Media mit Id suchen");
                    System.out.println("[E] Serie mit Id suchen");
                    System.out.println("[F] Film mit Id suchen");
                    System.out.println("[G] Media nach Titel, Genre und Status suchen");
                    System.out.println("[H] Serie nach Titel, Genre und Status suchen");
                    System.out.println("[I] Film nach Titel, Genre und Status suchen");
                    System.out.println("[X] Ende");
                    System.out.println();

                    System.out.print("Deine Auswahl: ");
                    String command = fromKeyboard.readLine().trim();


                    switch (command.toUpperCase()) {
                        case "A":
                            mediaFindAll();
                            break;
                        case "B":
                            serieFindAll();
                            break;
                        case "C":
                            movieFindAll();
                            break;
                        case "D":
                            System.out.println();
                            System.out.print("Gebe die Id an:  ");
                            id = fromKeyboard.readLine().trim();
                            mediaFindById(Long.parseLong(id));
                            break;
                        case "E":
                            System.out.println();
                            System.out.print("Gebe die Id an:  ");
                            id = fromKeyboard.readLine().trim();
                            serieFindById(Long.parseLong(id));
                            break;
                        case "F":
                            System.out.println();
                            System.out.print("Gebe die Id an:  ");
                            id = fromKeyboard.readLine().trim();
                            movieFindById(Long.parseLong(id));
                            break;
                        case "G":
                            System.out.println();
                            System.out.print("Gebe den Titel an:  ");
                            title = fromKeyboard.readLine().trim();
                            title = title.isEmpty() ? null : title;
                            System.out.print("Gebe das Genre an:  ");
                            genre = fromKeyboard.readLine().trim();
                            genre = genre.isEmpty() ? null : genre;
                            System.out.print("Gebe den Status an:  ");
                            status = fromKeyboard.readLine().trim();
                            status = status.isEmpty() ? null : status;
                            mediaFind(title,genre,status);
                            break;
                        case "H":
                            System.out.println();
                            System.out.print("Gebe den Titel an:  ");
                            title = fromKeyboard.readLine().trim();
                            title = title.isEmpty() ? null : title;
                            System.out.print("Gebe das Genre an:  ");
                            genre = fromKeyboard.readLine().trim();
                            genre = genre.isEmpty() ? null : genre;
                            System.out.print("Gebe den Status an:  ");
                            status = fromKeyboard.readLine().trim();
                            status = status.isEmpty() ? null : status;
                            serieFind(title,genre,status);
                            break;
                        case "I":
                            System.out.println();
                            System.out.print("Gebe den Titel an:  ");
                            title = fromKeyboard.readLine().trim();
                            title = title.isEmpty() ? null : title;
                            System.out.print("Gebe das Genre an:  ");
                            genre = fromKeyboard.readLine().trim();
                            genre = genre.isEmpty() ? null : genre;
                            System.out.print("Gebe den Status an:  ");
                            status = fromKeyboard.readLine().trim();
                            status = status.isEmpty() ? null : status;
                            movieFind(title,genre,status);
                            break;
                        case "X":
                            System.out.println("Bye, bye!");
                            quit = true;
                            break;
                    }
                }
            }
            catch(JsonSyntaxException e){
                logedIn=false;
                System.out.println("Authentication Fehler: Bitte geben Sie richte Daten ein");
            }
                 
        }
        
    }
    
    public static void mediaFindAll() throws UnirestException, WebAppException{
        // Alle Medias vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Medien");
            System.out.println("================");
            System.out.println();

            
            try{
            RESTMedia[] medias = mediaResource.findAll();
            

            if (medias != null) {
                for (RESTMedia media : medias) {
                    System.out.println("Id:        "+ media.getId());
                    System.out.println("Type:        "+ media.getType());
                    System.out.println("Titel:       " + media.getTitle());
                    System.out.println("Angelegt von:   " + media.getOwner().getUsername());

                    System.out.println();
                }
            }
            }
             catch(NullPointerException nle){
                System.out.println("Nix gefunden!!!");  
                
                 System.out.println();
            }
            catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }

    private static void mediaFindById(long id) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Media mit ID: "+id);
            System.out.println("================");
            System.out.println();
            
            try{
            RESTMedia media = mediaResource.find(id);
            
            if (media != null) {
                System.out.println("Id:        "+ media.getId());
                System.out.println("Type:        "+ media.getType());
                System.out.println("Titel:       " + media.getTitle());
                System.out.println("Angelegt von:   " + media.getOwner().getUsername());
                System.out.println();
                
            }
            }
            catch(NullPointerException nle){
                System.out.println("Nix gefunden!!!");  
                
                 System.out.println();
            }
            catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
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

            
            
            try{
            RESTMedia[] medias = mediaResource.find(title, genre, status);

            if (medias != null) {
                for (RESTMedia media : medias) {
                    System.out.println("Id:        "+ media.getId());
                    System.out.println("Type:        "+ media.getType());
                    System.out.println("Titel:       " + media.getTitle());
                    System.out.println("Angelegt von:   " + media.getOwner().getUsername());

                    System.out.println();
                }
            }
            }
            catch(NullPointerException nle){
                System.out.print("Nix gefunden!!!");
                 System.out.println();
            }
            catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }
    
    public static void serieFindAll() throws UnirestException, WebAppException{
        // Alle Serien vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Serien");
            System.out.println("================");
            System.out.println();

            try{
            RESTSerie[] serien = serieResource.findAll();
            

            if (serien != null) {
                for (RESTSerie serie : serien) {
                    System.out.println("Id:        "+ serie.getId());
                    System.out.println("Type:        "+ serie.getType());
                    System.out.println("Titel:       " + serie.getTitle());
                    System.out.println("Angelegt von:   " + serie.getOwner().getUsername());
                    for(RESTSeason season : serie.getSeasons()){
                        System.out.println("  "+season.getNr()+". Staffel");
                        for(RESTEpisode episode : season.getEpisodes()){
                            System.out.println("    "+episode.getNr()+". "+ episode.getTitle());
                        }
                    }
                    System.out.println();

                    System.out.println();
                }
            }
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }

    private static void serieFindById(long id) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Serie mit ID: "+id);
            System.out.println("================");
            System.out.println();

            
            try{
            RESTSerie serie = serieResource.find(id);

            if (serie != null) {
                System.out.println("Id:        "+ serie.getId());
                System.out.println("Type:        "+ serie.getType());
                System.out.println("Titel:       " + serie.getTitle());
                System.out.println("Angelegt von:   " + serie.getOwner().getUsername());
                for(RESTSeason season : serie.getSeasons()){
                    System.out.println("  "+season.getNr()+". Staffel");
                    for(RESTEpisode episode : season.getEpisodes()){
                        System.out.println("    "+episode.getNr()+". "+ episode.getTitle());
                    }
                }
                System.out.println();
                
            }
            
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }
            catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }
    private static void serieFind(String title, String genre, String status) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.print("Serie mit ");
            System.out.print(" Title "+title);
            System.out.print(" Genre "+genre);
            System.out.println(" Status "+status);
            System.out.println("================");
            System.out.println();

            
            try{
            RESTSerie[] serien = serieResource.find(title, genre, status);

            if (serien != null) {
                for (RESTSerie serie : serien) {
                    System.out.println("Id:        "+ serie.getId());
                    System.out.println("Type:        "+ serie.getType());
                    System.out.println("Titel:       " + serie.getTitle());
                    System.out.println("Angelegt von:   " + serie.getOwner().getUsername());
                    for(RESTSeason season : serie.getSeasons()){
                        System.out.println("  "+season.getNr()+". Staffel");
                        for(RESTEpisode episode : season.getEpisodes()){
                            System.out.println("    "+episode.getNr()+". "+ episode.getTitle());
                        }
                    }
                    System.out.println();

                    System.out.println();
                }
            }
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }
            catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }
    
    
    public static void movieFindAll() throws UnirestException, WebAppException{
        // Alle Serien vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Alle Filme");
            System.out.println("================");
            System.out.println();

            
            try{
            RESTMovie[] movies = movieResource.findAll();
            

            if (movies != null) {
                for (RESTMovie movie : movies) {
                    System.out.println("Id:        "+ movie.getId());
                    System.out.println("Type:        "+ movie.getType());
                    System.out.println("Titel:       " + movie.getTitle());
                    System.out.println("Angelegt von:   " + movie.getOwner().getUsername());
                    System.out.println("Dauer:   " + movie.getMovieLength());
                    
                    System.out.println();

                    System.out.println();
                }
            }
            
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }

    private static void movieFindById(long id) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.println("Film mit ID: "+id);
            System.out.println("================");
            System.out.println();

            
            try{
            RESTMovie movie = movieResource.find(id);

            if (movie!= null) {
              System.out.println("Id:        "+ movie.getId());  
              System.out.println("Type:        "+ movie.getType());
                    System.out.println("Titel:       " + movie.getTitle());
                    System.out.println("Angelegt von:   " + movie.getOwner().getUsername());
                    System.out.println("Dauer:   " + movie.getMovieLength());
                    
                    System.out.println();

                    System.out.println();
                
            }
            
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }
    private static void movieFind(String title, String genre, String status) throws UnirestException, WebAppException{
        //Media vom Server abrufen und anzeigen
            System.out.println("================");
            System.out.print("Film mit ");
            System.out.print(" Title "+title);
            System.out.print(" Genre "+genre);
            System.out.println(" Status "+status);
            System.out.println("================");
            System.out.println();

            
            try{
            RESTMovie[] movies = movieResource.find(title, genre, status);

            if (movies != null) {
                for (RESTMovie movie : movies) {
                    System.out.println("Id:        "+ movie.getId());
                    System.out.println("Type:        "+ movie.getType());
                    System.out.println("Titel:       " + movie.getTitle());
                    System.out.println("Angelegt von:   " + movie.getOwner().getUsername());
                    System.out.println("Dauer:   " + movie.getMovieLength());
                    
                    System.out.println();

                    System.out.println();
                }
            }
            }
            catch(NullPointerException nle){
                
                System.out.print("Nix gefunden!!!");
                 System.out.println();
                
            }catch(WebAppException e){
                System.err.println("Es ist eine WebAppException "
                        + "\nvlt. dies könnte daran liegen, das etwas mit Ihrer Eingabe nicht stimmt"
                        + "\n\n");
            }
    }
    
    
}

           
        
        
        
        
    
    

