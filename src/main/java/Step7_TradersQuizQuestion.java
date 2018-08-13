import factory.TradeFactory;
import model.Trader;
import model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Adwiti on 8/12/2018.
 */
public class Step7_TradersQuizQuestion {
    public static void main(String[] args) {

        List<Transaction> transactions = TradeFactory.tradeFactory();
        /**
         * Find all transactions in 2011 and sort them by value (ascending)
         */

        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect);
        /*
        o/p will be
        [Transaction(trader=Trader(name=Brian, city=Cambridge), year=2011, value=30), Transaction(trader=Trader(name=Raoul, city=Cambridge), year=2011, value=400)]
         */
        System.out.println("-----------------");

        /**
         * unique cities where traders work
         */
        List<String> collect1 = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect1);
        /*
        [Cambridge, Milan]
         */

        /**
         * we can also use sets for the above code
         */

        Set<String> cities = transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(cities);

        /**
         * Find all traders from Cambridge and sort them by name
         */

        List<Trader> collect2 = transactions.stream().map(transaction -> transaction.getTrader()).filter(trader -> trader.getCity() == "Cambridge").distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(collect2);
        /*
        o/p will be
        [Trader(name=Alan, city=Cambridge), Trader(name=Brian, city=Cambridge), Trader(name=Raoul, city=Cambridge)]
         */

        /**
         * Return a string of all traders name sorted alphabatically
         */
        String reduce = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> (n1 + " " + n2));
        System.out.println(reduce);

        /**
         * Are any traders based from Milan
         */
        boolean isMilan = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity() == "Milan");
        System.out.println(isMilan);

        /**
         * print all transactions values of traders who are living in Cambridge
         */
        List<Integer> valueOfTradersLivingInCambrdige = transactions.stream().filter(transaction -> transaction.getTrader().getCity() == "Cambridge").map(transaction -> transaction.getValue()).collect(Collectors.toList());
        System.out.println(valueOfTradersLivingInCambrdige);

        /*
        [30, 1000, 400, 950]
         */

        /**
         * What is the highest value of all transactions
         */

        Integer maxTransaction = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println(maxTransaction);
        /*
        o/p will be 1000
         */

        /**
         * Find the transaction with smallest value
         */
        Optional<Integer> minTransaction = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(minTransaction.get());
        /*
        o/p will be 30
         */

        /**
         * The above code can be written in below format too
         */
        Optional<Integer> min = transactions.stream().min(Comparator.comparing(Transaction::getValue)).map(transaction -> transaction.getValue());
        System.out.println(min.get());




    }
}
