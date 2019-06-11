package com.danielrocha;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaViaServerConfig {

    public static void main(String[] args) {

        try {
            Connection conn = Util.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select nome, email from usuario where id = 1");

            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
