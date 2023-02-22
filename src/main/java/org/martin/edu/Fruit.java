package org.martin.edu;

import javax.validation.constraints.NotBlank;

public class Fruit {

    public String name;
    public String colour;


    public Integer jumlah;

    public Fruit() {
    }

    public Fruit(String name, String colour, int jumlah) {

        this.name = name;
        this.colour = colour;
        this.jumlah = jumlah;
    }

}
