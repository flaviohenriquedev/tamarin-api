package api.gommo._root.comum.serializer;

import api.gommo._root.comum.model.EntidadePadrao;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public abstract class CustomSerializer<E extends EntidadePadrao> extends JsonSerializer<E> {

    @Override
    public void serialize(E entidade, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(!Objects.isNull(entidade)){
            gen.writeStartObject();
            writeSerializableField(gen, "id", entidade.getId());
            serializeAttributes(gen, entidade);
            gen.writeEndObject();
        }
    }

    protected void writeNumberField(JsonGenerator gen, String field, Long value)throws IOException {
        if(!Objects.isNull(value)){
            gen.writeNumberField(field, value);
        }
    }

    protected void writeStringField(JsonGenerator gen, String field, String value)throws IOException{
        if(!Objects.isNull(value)){
            gen.writeStringField(field, value);
        }
    }

    protected void writeSerializableField(JsonGenerator gen, String field, Serializable value)throws IOException{
        if(!Objects.isNull(value)){
            gen.writeStringField(field, value.toString());
        }
    }

    protected void writeObjectField(JsonGenerator gen, String field, Object value)throws IOException{
        if(!Objects.isNull(value)){
            gen.writeObjectField(field, value);
        }
    }

    protected abstract void serializeAttributes(JsonGenerator gen, E entidade)throws  IOException;

}
