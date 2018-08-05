package model;

import lombok.*;

/**
 * Created by Adwiti on 8/5/2018.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }
}
