package it.gbale.apisports.apifootball.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Year;

public class YearTypeAdapter extends TypeAdapter<Year> {

    @Override
    public void write(JsonWriter jsonWriter, Year year) throws IOException {
        if (year == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(year.getValue());
    }

    @Override
    public Year read(JsonReader jsonReader) throws IOException {
        int date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }else{
            date = jsonReader.nextInt();
        }
        return Year.of(date);
    }
}
