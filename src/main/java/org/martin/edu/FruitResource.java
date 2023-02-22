package org.martin.edu;

import io.netty.handler.codec.http.HttpContentEncoder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@Path("fruits")
public class FruitResource {

    List<Fruit> fruits = new ArrayList<>();


    @GET
    public List<Fruit> getFruits(){
        return fruits;
    }


    @GET
    @Path("{index}")
    public Fruit getFruitByIndex(Integer index){
        return fruits.get(index);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fruit addFruit(Fruit fruit){
        fruits.add(fruit);
        return fruit;
    }

    @POST
    @Path("batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> addFruits(List<Fruit> lotAddFruit){
        for (Fruit fruit : lotAddFruit){
            fruits.add(fruit);
        }
        return lotAddFruit;
    }

    @PUT
    @Path("{index}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit editFruit(Integer index, Fruit newFruit){
        fruits.set(index, newFruit);
        return newFruit;
    }

    @DELETE
    @Path("{index}")
    public Response deleteFruit(Integer index){
        fruits.remove(index.intValue());
        return Response.ok("data berhasil di hapus").build();
    }
}
