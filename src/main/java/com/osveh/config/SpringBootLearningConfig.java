package com.osveh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spbootlrn")
public class SpringBootLearningConfig {
    /**
     * This is our welcome message
     */
    private String welcomeMsg = "Hello, world!";

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
