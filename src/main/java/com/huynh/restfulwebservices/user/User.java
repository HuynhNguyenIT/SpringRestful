package com.huynh.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "name must not null")
    @Size(min = 2,message = "name must be at least 2 character")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "birthDate must in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2023,9,14);
        System.out.printf(ld.minusYears(1).toString());
    }
}
