package ru.kpfu.itis.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok - библиотека, которая позволяет заменять getters, setters, constructors аннотациями
@Data //- заменяет написание гетеров и сетеров для каждого поля класса
@NoArgsConstructor //- заменяет написание конструктора без параметров
@AllArgsConstructor //- заменяет написание конструктора со всеми параметрами
@Builder //- аннотация, реализующий патерн Builder, позволяющий создание объекта с n количеством параметрами
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String username;
    private String password;
    private String email;
}
