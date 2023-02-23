package org.martin.edu;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Fruit {

    @NotBlank(message = "fields name harus diisi")
    public String name;
    @NotBlank(message = "fields colour harus disi")
    public String colour;

    @NotNull(message = "fields jumlah tidak boleh null")
    @Max(value = 100, message = "tidak boleh lebih dari 100")
    public Integer jumlah;

    public Fruit() {
    }

    public Fruit(String name, String colour, int jumlah) {

        this.name = name;
        this.colour = colour;
        this.jumlah = jumlah;
    }

}
