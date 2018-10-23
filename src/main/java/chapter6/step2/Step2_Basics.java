package chapter6.step2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Step2_Basics {

    private static final Logger logger = LoggerFactory.getLogger(Step2_Basics.class);

    public static void main(String[] args) {

        List<Transaction> transactions = buildTransaction();
        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getAmount() > 50).collect(Collectors.toList());
        logger.info("Transactions where currency is more than 50, {}",collect);

    }

    public static List<Transaction> buildTransaction() {

        Transaction transaction1 = new Transaction(Currency.DOLLAR, 10, "1", LocalDate.now());
        Transaction transaction2 = new Transaction(Currency.YEN, 100, "2", LocalDate.now());
        Transaction transaction3 = new Transaction(Currency.DOLLAR, 50, "3", LocalDate.now());
        Transaction transaction4 = new Transaction(Currency.RUPEE, 60, "4", LocalDate.now());
        Transaction transaction5 = new Transaction(Currency.DOLLAR, 70, "5", LocalDate.now());
        Transaction transaction6 = new Transaction(Currency.DOLLAR, 80, "6", LocalDate.now());
        Transaction transaction7 = new Transaction(Currency.TAKA, 90, "7", LocalDate.now());

        return Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7);
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Transaction {
    private Currency currency;
    private int amount;
    private String transactionId;
    private LocalDate localDate;
}

enum Currency {
    DOLLAR, RUPEE, YEN, TAKA
}

