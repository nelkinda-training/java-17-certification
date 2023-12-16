package com.nelkinda.training.access;

class User {
    private String id;
    private String username;
    private String password; // bcrypt-encoded
    private String firstname;
    private String lastname;

    private String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    private String getId() {
        return id;
    }

    public String getName() {
        return firstname + " " + lastname;
    }
}
