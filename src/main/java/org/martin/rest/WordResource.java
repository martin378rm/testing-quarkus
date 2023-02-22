package org.martin.rest;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("words")
public class WordResource {

    List<String> words = new ArrayList<>();

    @GET
    public List<String> getWords(){
        return words;
    }

    @GET
    @Path("{index}")
    public String getWordsByIndex(Integer index){
        return words.get(index);
    }


    @POST
    public List<String> addWords(String word){
        words.add(word);
        return words;
    }


    @PUT
    @Path("{index}")
    public List<String> changeWords(Integer index, String word){
        words.set(index, word);
        return words;
    }


    @DELETE
    @Path("{index}")
    public List<String> deleteWords(Integer index){
        words.remove(index.intValue());
        return words;
    }
}