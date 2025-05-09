package api.tamarin._root.comum.serializer.impl;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.serializer.CustomSerializer;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class IDSerializer extends CustomSerializer<EntidadePadrao> {

    @Override
    protected void serializeAttributes(JsonGenerator gen, EntidadePadrao entidade) throws IOException {

    }
}
