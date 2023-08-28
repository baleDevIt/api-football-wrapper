package it.gbale.apisports.apifootball.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.ZoneId;

public class ZoneIdTypeAdapter extends TypeAdapter<ZoneId> {
    @Override
    public void write(JsonWriter out, ZoneId value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.getId());
    }

    @Override
    public ZoneId read(JsonReader jsonReader) throws IOException {
        String id;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }

        id = jsonReader.nextString();
        try {
            return ZoneId.of(id);
        }catch (Exception e){
            return null;
        }
    }
}
