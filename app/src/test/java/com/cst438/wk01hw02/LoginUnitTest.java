package com.cst438.wk01hw02;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * <h1><b>LoginUnitTest</b></h1>
 * These are the unit tests to check the login page. It validates whether the functions
 * are properly populating users, as well as checking cases when username or passwords are
 * invalid or valid.
 *
 * @author Eric Chavez Velez
 */

public class LoginUnitTest {

    @Test
    public void populateUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("test", "123",1));
        users.add(new User("test2", "234",2));
        assertEquals(users.size() != 0, MainActivity.populateUsers().size() != 0);
    }

    @Test
    public void usernameIncorrect() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("test", "123",1));
        users.add(new User("test2", "234",2));
        String username = "not found";
        String password = "no password";
        assertEquals(-1, MainActivity.userFound(users, username, password));
    }

    @Test
    public void userFound() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("test", "123",1));
        users.add(new User("test2", "234",2));
        String username = "test2";
        String password = "234";
        assertEquals(2, MainActivity.userFound(users, username, password));
    }

    @Test
    public void invalidPassword() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("test", "123",1));
        users.add(new User("test2", "234",2));
        String username = "test2";
        String password = "321";
        assertEquals(-2, MainActivity.userFound(users, username, password));
    }

}
