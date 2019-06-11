package com.danielrocha.serverconfig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderConfigController {

    @GetMapping("/config")
    public ConfigurationProperties getConfigs() {

        String url              = "jdbc:mysql://localhost:3306/books?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user             = "root";
        String password         = "root";
        String jdbcClassName    = "com.mysql.cj.jdbc.Driver";

        return new ConfigurationProperties(user,password,url,jdbcClassName);

    }

}
