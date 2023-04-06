package com.driver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "serviceProviders")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn
    private Admin admin;
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>();
    @ManyToMany(mappedBy = "serviceProviderList",cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();

    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, Admin admin, List<Connection> connectionList, List<User> userList, List<Country> countryList) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.connectionList = connectionList;
        this.users = userList;
        this.countryList = countryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}