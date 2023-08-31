package it.gbale.apisports.apifootball.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.OffsetDateTime;

public class OffsetDayTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {
    @Override
    public void write(JsonWriter jsonWriter, OffsetDateTime offsetDateTime) throws IOException {
        if (offsetDateTime == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.value(offsetDateTime.toEpochSecond());
    }

    @Override
    public OffsetDateTime read(JsonReader jsonReader) throws IOException {
        String date;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }else{
            date = jsonReader.nextString();
        }
        return OffsetDateTime.parse(date);
    }
}
