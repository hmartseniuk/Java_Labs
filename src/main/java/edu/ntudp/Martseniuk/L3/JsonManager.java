package edu.ntudp.Martseniuk.L3;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import edu.ntudp.Martseniuk.L2.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    Gson gson;

    public JsonManager(Gson gson) {
        this.gson = gson;
    }

    public void writeUniversityToJson(University university, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(university, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public University readUniversityFromJson(String filePath) {
        try {
            JsonReader fileReader = new JsonReader(new FileReader(filePath));
            return gson.fromJson(fileReader, University.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}