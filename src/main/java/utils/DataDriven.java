package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;

public class DataDriven {

    @org.jetbrains.annotations.Nullable
    public static JsonObject jsonReader(String relativePath) {
        try {

            Reader reader = new FileReader(Paths.get(relativePath).toFile());
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
