package br.com.mourao.homeoffice.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonTimeSerializer extends JsonSerializer<Date> {
    SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    @Override
    public void serialize(final Date date, final JsonGenerator gen, final SerializerProvider provider) throws IOException, JsonProcessingException {

        String dateString = format.format(date);
        gen.writeString(dateString);
    }

}