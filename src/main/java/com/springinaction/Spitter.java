package com.springinaction;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;


/**
 * Created by 1 on 27.03.2017.
 */
public class Spitter {
    private Long id;

    @NotNull
    @Size(min=5, max=16, message = "{username.error.msg}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message = "{password.error.msg}")
    private String password;

    @NotNull
    @Size(min=2, max=30, message = "{firstName.error.msg}")
    private String firstName;

    @NotNull
    @Size(min=2, max=30, message = "{lastName.error.msg}")
    private String lastName;

    @NotNull
    @Email(message = "{email.error.msg}")
    private String email;

    public Spitter() {}

    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, new String[] {"firstName", "lastName", "username", "password", "email"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[] {"firstName", "lastName", "username", "password", "email"});
    }
}
