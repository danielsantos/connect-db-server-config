package com.danielrocha;

public class ConnectionProperties {

    @ByServerConfig(key = "user")
    private String user;

    @ByServerConfig(key = "password")
    private String password;

    @ByServerConfig(key = "url")
    private String url;

    @ByServerConfig(key = "jdbcClassName")
    private String jdbcClassName;

    public ConnectionProperties() {
        Injector.inject(this);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getJdbcClassName() {
        return jdbcClassName;
    }

}
