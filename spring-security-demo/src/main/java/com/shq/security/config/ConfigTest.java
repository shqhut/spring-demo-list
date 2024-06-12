package com.shq.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 1、测试@ConfigurationProperties注解的使用
 * 2、使用yaml配置bean属性
 */
@ConfigurationProperties(prefix = "shq.security")
public class ConfigTest {

    private User user = new User();

    public User getUser() {
        return this.user;
    }

    public static class User {

        /**
         * Default user name.
         */
        private String name = "user";

        /**
         * Password for the default user name.
         */
        private String password = UUID.randomUUID().toString();

        /**
         * Granted roles for the default user name.
         */
        private List<String> roles = new ArrayList<>();

        private boolean passwordGenerated = true;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            if (!StringUtils.hasLength(password)) {
                return;
            }
            this.passwordGenerated = false;
            this.password = password;
        }

        public List<String> getRoles() {
            return this.roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = new ArrayList<>(roles);
        }

        public boolean isPasswordGenerated() {
            return this.passwordGenerated;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", roles=" + roles +
                    ", passwordGenerated=" + passwordGenerated +
                    '}';
        }
    }

}
