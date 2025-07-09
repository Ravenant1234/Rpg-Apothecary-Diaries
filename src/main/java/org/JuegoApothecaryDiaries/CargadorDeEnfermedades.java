package org.JuegoApothecaryDiaries;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;


public class CargadorDeEnfermedades {
    public static List<Enfermedad> cargar(String ruta) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Enfermedad>>() {});
    }
}