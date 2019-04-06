/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Entities.RESTMedia;
import Exception.ExceptionResponse;
import Exception.WebAppException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;




/**
 *
 * @author D070429
 */
public class MediaResource extends Resource{
    
    public static final String URL = "http://localhost:8080/jMovie/api/Medias";

    public String url = URL;
    
    Gson gson = new GsonBuilder().create();

    //
    // Konstruktoren
    //

    public MediaResource() {
        
    }

    public MediaResource(String url) {
        this.url = url;
    }

    
    /**
     *  Alle Medien anfragen.
     */
    public RESTMedia[] findAll() throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url)
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();

        // Exception werfen, wenn der Server einen Fehler meldet
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Fehlerdaten empfangen
        }

        // Antwortdaten zurückgeben
        return this.gson.fromJson(httpResponse.getBody(), RESTMedia[].class);
    }
    
    
    //Medium mit Id finden
    
    public RESTMedia find(long id) throws WebAppException, UnirestException{
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url + "/"+ id + "/")
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();

        // Exception werfen, wenn der Server einen Fehler meldet
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Fehlerdaten empfangen
        }

        // Antwortdaten zurückgeben
        return this.gson.fromJson(httpResponse.getBody(), RESTMedia.class);
        
              
    }
    
    public RESTMedia[] find(String title, String genre, String status) throws UnirestException, WebAppException {
        StringBuilder requestUrl = new StringBuilder(this.url+"/search/?");
        if(title!= null){
            requestUrl.append("title="+title.replace(" ", "+")+"&");
        }
        if(genre!= null){
            requestUrl.append("genre="+genre.replace(" ", "+")+"&");
        }
        if(status!= null){
            requestUrl.append("status="+status+"&");
        }
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(requestUrl.toString())
                .header("accept", "application/json")
                .basicAuth(username, password)
                .asString();

        // Exception werfen, wenn der Server einen Fehler meldet
        try {
            ExceptionResponse er = this.gson.fromJson(httpResponse.getBody(), ExceptionResponse.class);

            if (er.exception != null) {
                throw new WebAppException(er);
            }
        } catch (JsonSyntaxException ex) {
            // Okay, keine Fehlerdaten empfangen
        }

        // Antwortdaten zurückgeben
        return this.gson.fromJson(httpResponse.getBody(), RESTMedia[].class);
    }
    
}
