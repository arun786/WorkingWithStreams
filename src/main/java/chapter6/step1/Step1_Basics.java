package chapter6.step1;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Step1_Basics {
    private static final Logger logger = LoggerFactory.getLogger(Step1_Basics.class);

    public static void main(String[] args) {

        /**
         * Group by Currency
         */

        List<Transaction> transactions = transactionBuilder();
        Map<Currency, List<Transaction>> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        logger.info("Collection of transactions based on currency {}", collect);
    }


    private static List<Transaction> transactionBuilder() {

        Transaction transaction1 = new Transaction(Currency.DOLLAR, "1", LocalDate.now(), 107);
        Transaction transaction2 = new Transaction(Currency.DOLLAR, "2", LocalDate.now(), 106);
        Transaction transaction3 = new Transaction(Currency.YEN, "3", LocalDate.now(), 105);
        Transaction transaction4 = new Transaction(Currency.RUPEES, "4", LocalDate.now(), 104);

        return Arrays.asList(transaction1, transaction2, transaction3, transaction4);
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Transaction {
    private Currency currency;
    private String id;
    private LocalDate year;
    private Integer amount;
}

enum Currency {
    DOLLAR, RUPEES, YEN
}