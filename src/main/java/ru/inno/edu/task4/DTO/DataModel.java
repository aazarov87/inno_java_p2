package ru.inno.edu.task4.DTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class DataModel {

    private String login, fam, lastName, firstName, typeApp;
    private LocalDateTime dateLogin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTypeApp() {
        return typeApp;
    }

    public void setTypeApp(String typeApp) {
        this.typeApp = typeApp;
    }

    public LocalDateTime getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(LocalDateTime dateLogin) {
        this.dateLogin = dateLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return Objects.equals(login, dataModel.login) && Objects.equals(fam, dataModel.fam) && Objects.equals(lastName, dataModel.lastName) && Objects.equals(firstName, dataModel.firstName) && Objects.equals(typeApp, dataModel.typeApp) && Objects.equals(dateLogin, dataModel.dateLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, fam, lastName, firstName, typeApp, dateLogin);
    }

    public DataModel() {
    }

    public DataModel(String login, String fam, String lastName, String firstName, String typeApp, LocalDateTime dateLogin) {
        this.login = login;
        this.fam = fam;
        this.lastName = lastName;
        this.firstName = firstName;
        this.typeApp = typeApp;
        this.dateLogin = dateLogin;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "login='" + login + '\'' +
                ", fam='" + fam + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", typeApp='" + typeApp + '\'' +
                ", dateLogin=" + dateLogin +
                '}';
    }
}
