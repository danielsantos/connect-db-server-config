package com.danielrocha;

import com.danielrocha.ConexaoDB;
import com.danielrocha.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaViaServerConfig {

    private static ConexaoDB conexaoDB = new ConexaoDB();

    public static void main(String[] args) {

        try {
            Connection conn = Util.createConnection(conexaoDB);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select NM_RAZAO_SOCIAL from SCRCARDD.SCR_CC_COMPRD where NR_DOC_COMPRD = 13126802702");

            if (rs.next()) {
                System.out.println("Nome: " + rs.getString("NM_RAZAO_SOCIAL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}