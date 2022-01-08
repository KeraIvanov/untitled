package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./cars.json");

    public static void main(String[] args) {
	// write your code here
        Car []cars = {
                Car.makeCar("Хонда Аккорд", 6000, Type.SEDAN),
                Car.makeCar("Хонда СРВ", 6000, Type.ALL_ROAD),
                Car.makeCar("Хонда Трак-вагон", 6000, Type.TRUCK),
        };


        /*String json = GSON.toJson(cars);
        write(json);
        System.out.println(readJson());*/

        Car[] cars1 = GSON.fromJson(readJson(), Car[].class);
        for (Car s: cars1) {
            System.out.println(s);
        }
    }
    private static void write(String obj){
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, obj,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String readJson(){
        String json = "";
        try {
            FileReader fr = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fr.read()) != -1){
                json+=(char)a;
            }
            return json;
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}
