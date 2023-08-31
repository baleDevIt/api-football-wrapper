package it.gbale.apisports.apifootball.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.Instant;
public class InstantTypeAdapter extends TypeAdapter<Instant> {
    @Override
    public void write(JsonWriter jsonWriter, Instant instant) throws IOException {
        if (instant == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(instant.getEpochSecond());
    }

    @Override
    public Instant read(JsonReader jsonReader) throws IOException {
        String instant;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }else{
            instant = jsonReader.nextString();
        }
        return Instant.ofEpochSecond(Long.parseLong(instant));
    }
}
