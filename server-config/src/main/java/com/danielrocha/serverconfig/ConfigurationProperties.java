package com.danielrocha.serverconfig;

public class ConfigurationProperties {

    private String user;

    private String password;

    private String url;

    private String jdbcClassName;

    public ConfigurationProperties(String user, String password, String url, String jdbcClassName) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.jdbcClassName = jdbcClassName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJdbcClassName() {
        return jdbcClassName;
    }

    public void setJdbcClassName(String jdbcClassName) {
        this.jdbcClassName = jdbcClassName;
    }

}
