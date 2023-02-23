package org.martin.edu;

import io.netty.handler.codec.http.HttpContentEncoder;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/fruits")
public class FruitResource {

    // untuk menampung data fruits
    List<Fruit> fruits = new ArrayList<>();


    // Json mapping and validator ( cara (1))
    @Inject
    Validator validator;


    // untuk mengambil data keseluruhan dari fruits
    @GET
    public List<Fruit> getFruits(){
        return fruits;
    }


    // untuk mengambil data berdasarkan index dari fruits
    @GET
    @Path("{index}")
    public Fruit getFruitByIndex(Integer index){
        return fruits.get(index);
    }


    // untuk menambahkan data
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result addFruit(Fruit fruit){
        Set<ConstraintViolation<Fruit>> violations = validator.validate(fruit); // violations digunakan untuk menampung kesalahan

        // pengecekan jika tidak ada kesalahan / fields nama tidak kosong
        if (violations.isEmpty()){
            fruits.add(fruit);
            return new Result("buah " + fruit.name + " berhasil ditambahkan");
        } else {
            return new Result(violations);
        }
    }

    // untuk menambahkan beberapa data sekaligus
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

    // untuk meng-edit data berdasarkan index
    @PUT
    @Path("{index}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit editFruit(Integer index, Fruit newFruit){
        fruits.set(index, newFruit);
        return newFruit;
    }


    // untuk menghapus data berdasarkan index
    @DELETE
    @Path("{index}")
    public Response deleteFruit(Integer index){
        fruits.remove(index.intValue());
        return Response.ok("data berhasil di hapus").build();
    }
}
