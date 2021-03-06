package xyz.vegaone.easytracking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "UserEntity{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
