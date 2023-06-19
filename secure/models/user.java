package Vlad.IT.by.posts.models;

import javax.persistence.*;

@Entity
@Table( name="User")
public class user {


    @Id
    private long id;
    private String login;

    private String password;

    private String name;

    private String surname;
    private String patronymic;


    @Enumerated(value = EnumType.STRING)
    private Role role;




    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public Role getUserrole() {
        return role;
    }

    public void setUserrole(Role userrole) {
        this.role = userrole;
    }

    @Override
    public String toString() {
        return "user{" +
                "login='" + login + '\'' +
                ", userrole='" + role + '\'' +
                '}';
    }
    public user() {}


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public user(String login, String password, String name, String surname, String patronymic, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.role = role;
    }
    public user(Long id,String login, String password, String name, String surname, String patronymic, Role role) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.role = role;
    }
}
