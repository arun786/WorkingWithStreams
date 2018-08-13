package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Adwiti on 8/12/2018.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
