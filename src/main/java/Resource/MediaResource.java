/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Entities.Media;
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
public class MediaResource {
    
    public static final String URL = "https://localhost:8443/jMovie/api/Medias/";

    public String url = URL;
    public String username = "";
    public String password = "";
    
    Gson gson = new GsonBuilder().create();

    //
    // Konstruktoren
    //

    public MediaResource() {
    }

    public MediaResource(String url) {
        this.url = url;
    }

    //
    // Benutzername und Passwort setzen
    //

    public void setAuthData(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     *  Alle Medien anfragen.
     */
    public Media[] findAll() throws UnirestException, WebAppException {
        // HTTP-Anfrage senden
        HttpResponse<String> httpResponse = Unirest.get(this.url)
                .header("accept", "application/json")
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
        return this.gson.fromJson(httpResponse.getBody(), Media[].class);
    }

    
}
