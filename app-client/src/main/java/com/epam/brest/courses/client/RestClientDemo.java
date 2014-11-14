package com.epam.brest.courses.client;

import com.epam.brest.courses.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by sberdachuk on 11/12/14.
 */
public class RestClientDemo {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {

        RestClient restClient = new RestClient("http://localhost:8080");

        String version = restClient.getRestVesrsion();
        LOGGER.debug("Rest version is {}", version);

        UUID uuid = UUID.randomUUID();

        User user = new User();
        user.setLogin("login-" + uuid);
        user.setName("name-" + uuid);
        long id = restClient.addUser(user);
        LOGGER.debug("User id is {}", id);

        user = restClient.getUserById(id);
        LOGGER.debug("User: {}", user);

        user = restClient.getUserByLogin("login-" + uuid);
        LOGGER.debug("User: {}", user);

        User[] users = restClient.getUsers();
        LOGGER.debug("Users: {}", users);

        user.setLogin("login-new-" + uuid);
        user.setName("name-new-" + uuid);
        restClient.updateUser(user);

        users = restClient.getUsers();
        LOGGER.debug("Users: {}", users);

        restClient.removeUser(id);

        users = restClient.getUsers();
        LOGGER.debug("Users: {}", users);
    }
}
