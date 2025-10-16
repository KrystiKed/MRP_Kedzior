package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.List;

public final class Json {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public static byte[] writeBytes(Object payload) throws Exception {
        return MAPPER.writeValueAsBytes(payload);
    }

    public static <T> T read(String body, Class<T> type) throws Exception {
        return MAPPER.readValue(body, type);
    }

    public static <T> List<T> readListFromFile(String path, Class<T> elemType) throws Exception {
        File f = new File(path);
        if (!f.exists()) return List.of();
        return MAPPER.readValue(
                f, MAPPER.getTypeFactory().constructCollectionType(List.class, elemType));
    }

    public static void writeListToFile(List<?> list, String path) throws Exception {
        MAPPER.writeValue(new File(path), list);
    }
}
