package edu.preschool.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String role_name;
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username",nullable = false)

    private User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    public Role(String role_name, User user) {
        this.role_name = role_name;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * Sets role name.
     *
     * @param role_name the role name
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public User getUsername() {
        return user;
    }

    public void setUsername(User user) {
        this.user = user;
    }
/*

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(role_name, role.role_name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,  role_name);
    }

}
