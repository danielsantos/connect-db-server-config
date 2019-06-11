package com.danielrocha;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class ConexaoDB {

    @GetConnection
    public static Connection getConnection() {

        Connection conn = null;
        try {
            String urlWS = "http://localhost:8081/ws-rcbe-producao/migracao-plus/teste";

            URL obj = new URL(urlWS);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json_result = response.toString();
            HashMap<String,Object> map = new ObjectMapper().readValue(json_result, HashMap.class);

            String user            = map.get("user").toString();
            String password        = map.get("password").toString();
            String url             = map.get("url").toString();
            String jdbcClassName   = map.get("jdbcClassName").toString();

            Class.forName(jdbcClassName);
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }

}
