package com.danielrocha;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class Injector {

    private static String URL_SERVER_CONFIG = "http://localhost:8081/config";

    public static void inject(Object instance) {

        HashMap<String,Object> map;

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(URL_SERVER_CONFIG).openConnection();

            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            map = new ObjectMapper().readValue(response.toString(), HashMap.class);

            Field[] fields = instance.getClass().getDeclaredFields();

            for (Field field : fields) {

                if (field.isAnnotationPresent(ByServerConfig.class)) {

                    ByServerConfig byServerConfig = field.getAnnotation(ByServerConfig.class);

                    field.setAccessible(true);
                    field.set(instance, map.get(byServerConfig.key()));

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
