# WorkingWithStreams

## Streams

Streams are a sequence of elements from a source that supports data processing operations.

important points of streams

    1. Generating a stream from an ordered collection will preserve the order.
    2. elements of a stream from a list will maintain the order.
    3. many stream operation return a stream. 
    4. Streams can be tranversed only once.
    5. Streams are internal iterator.

Stream interface in java defines 2 operations, 

    1. Intermediate operations
    2. Terminal Operations
    
### Examples of Intermediate Operations are
    
    1. filter
    2. map
    3. limit
    
    Intermediate operations return a stream.
    
### Examples of Terminal Operation
    
    1. collect
    2. count
    3. forEach
    
    * filter takes a lambda, to exclude certian elements from a list based on the condition
    * map takes a lambda to transform an element to another
    * limit truncates the stream to no more than the number specified.
    * collect - converts a stream to another form.
    
### Example 
    List of Dish
    
    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("Season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 800, Dish.Type.OTHER),
                    new Dish("prawns", false, 300, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH)
                    
    /**
     * to get the name of the dishes where calories is less than 400
     */
    Stream<Dish> stream = menu.stream(); //this will create a stream
    Stream<Dish> dishStream = stream.filter(d -> d.getCalories() > 400); //this will filter the stream based on the calorie
    Stream<String> stringStream = dishStream.map(Dish::getName); //this will include names only in list
    List<String> collect = stringStream.collect(Collectors.toList());

    /**
     * To collect only first three element where calorie is less than 400
     */
    List<String> first2WhereMenuHavingCaloriesLessThan400 = menu.stream().filter(dish -> dish.getCalories() > 400).limit(2).map(Dish::getName).collect(Collectors.toList());
    System.out.println(first2WhereMenuHavingCaloriesLessThan400);
    
    /**
     * to get the details of dishes where calorie is less than 4000
     */
    List<Dish> collect1 = menu.stream().filter(dish -> dish.getCalories() > 400).collect(Collectors.toList());
    System.out.println(collect1);
    
### Filtering elements in a stream

            List<Dish> menus = DishFactory.dishFactory();
    
            /**
             * Filtering a stream with predicate, this will filter all the vegetarian dish
             */
            List<Dish> vegDish = menus.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
            System.out.println(vegDish);
    
    
            /**
             * Filtering unique elements from a list of integer, use of distinct
             */
            List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 5, 3, 4, 6, 8, 9, 11, 20, 10, 11, 12, 14, 13);
            List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
            System.out.println(distinctNumber);
    
            /**
             * filtering even numbers from a stream
             */
            List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
            System.out.println(evenNumbers);
    
            /**
             * filtering even distinct numbers from a stream
             */
            List<Integer> evenDistinctNumbers = numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
            System.out.println(evenDistinctNumbers);
    
            /**
             * filtering first 3 even distinct numbers from a stream
             */
            List<Integer> first3EvenDistinctNumbers = numbers.stream().filter(i -> i % 2 == 0).distinct().limit(3).collect(Collectors.toList());
            System.out.println(first3EvenDistinctNumbers);
    
            /**
             * filtering even distinct numbers skipping the first 2 numbers
             */
            List<Integer> evenDistinctNumbersSkippingFirst2 = numbers.stream().filter(i -> i % 2 == 0).distinct().skip(2).collect(Collectors.toList());
            System.out.println(evenDistinctNumbersSkippingFirst2);
    
            /**
             * Filter first 2 meat dishes
             */
            List<Dish> first2MeatDish = menus.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
            System.out.println(first2MeatDish);
            
            
### Use Of Map

Map takes a function as an argument, function is applied to each element, maaping it to a new element.
    
    
            List<Dish> dishes = DishFactory.dishFactory();
    
            /**
             * The below map will display only the name of all dishes
             */
            List<String> dishNames = dishes.stream().map(Dish::getName).collect(Collectors.toList());
            System.out.println(dishNames);
    
            /**
             * To get the length of each word in a list
             */
            List<String> names = Arrays.asList("Never", "Give", "Up", "Arun");
            List<Integer> lengthOfNames = names.stream().map(s -> s.length()).collect(Collectors.toList());
            System.out.println(lengthOfNames);
    
            /**
             * The above code can also be written as below
             */
            List<Integer> lngthOfNames = names.stream().map(String::length).collect(Collectors.toList());
            System.out.println(lngthOfNames);
    
            /**
             * Length of the name of each dish
             */
            List<Integer> lengthOfEachDishes = dishes.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
            System.out.println(lengthOfEachDishes);

### Flat Map

            List<Dish> dishes = DishFactory.dishFactory();
    
            /**
             * To get individual characters, the below code wont work as the map returns string array
             */
            List<String> words = Arrays.asList("Hello", "World");
            List<String[]> collect = words.stream().map(word -> word.split("")).collect(Collectors.toList());
            System.out.println(collect);
    
            /**
             * The below code will print the individual letters
             */
            List<String> individualLetters = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
            System.out.println(individualLetters);
    
            /**
             * To get distinct individual letters
             */
            List<String> distinctIndividualLetters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
            System.out.println(distinctIndividualLetters);
    
            /**
             * Given a list of numbers, print the square of the numbers
             */
    
            List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 9);
            List<Integer> squareOfNumber = numbers.stream().map(i -> i * i).collect(Collectors.toList());
            System.out.println(squareOfNumber);
            
            /**
            * to print words
            */
            List<String> seperatedWords = Arrays.asList("w e", "t h e", "pe op le");
            List<String> collect1 = seperatedWords.stream().map(w -> w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
            System.out.println(collect1);
            /*
            o/p will be as below
            [w, e, t, h, e, pe, op, le]
            */
            
### anyMatch(),noneMatch(), allMatch()
 
        List<Dish> dishes = DishFactory.dishFactory();
        
#### anyMatch()     
        boolean b = dishes.stream().anyMatch(Dish::isVegetarian);
        if (b) {
            System.out.println("There are few dishes which are vegetarian");
        }
        
#### allMatch()

        List<Dish> vegDishes = dishes.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        
        boolean b1 = vegDishes.stream().allMatch(Dish::isVegetarian);
        if (b1) {
            System.out.println("All dishes are vegetarian");
        }

#### noneMatch()

        List<Dish> lowCalorie = dishes.stream().filter(d -> d.getCalories() < 500).collect(Collectors.toList());
        
        boolean b2 = lowCalorie.stream().noneMatch(d -> d.getCalories() >= 500);
        if (b2) {
            System.out.println("All dishes are low calorie");
        }

#### findAny() ifPresent()

        dishes.stream().filter(Dish::isVegetarian).findAny().ifPresent( d -> System.out.print(d));
        /*
        o/p will be
        Dish(name=french fries, vegetarian=true, calories=530, type=OTHER)
         */

#### findFirst()

        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7);
        Optional<Integer> first = numbers.stream().map(d -> d * d).filter(x -> x % 5 == 0).findFirst();
        System.out.println(first);
        /*
        Optional[25]
         */
      
### Reduce

        /**
         * To add sequence of numbers to get a single result, use Reduce
         */
        
        List<Integer> numbers = Arrays.asList(1, 4, 6, 7, 9, 10);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        
        /*
        o/p will be 37
         */
         
        /**
        * the above code can also be written as below
        */
        Integer sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum1);
        
        Optional<Integer> sum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum2);
        
        
        /**
         * To get the max value
         */
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);
        
        Integer maximun = numbers.stream().reduce(0, Integer::max);
        System.out.println(maximun);
        
        /**
         * to get the minimum value
         */
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);
        
        /**
         * To count the number of dishes
         */
        Integer numberOfDishes = dishes.stream().map(dish -> 1).reduce(0, Integer::sum);
        System.out.println(numberOfDishes);
        /*
        o/p will be 8
         */
        
        /**
         * to get the maximum of calories
         */
        Integer maxCalorie = dishes.stream().map(dish -> dish.getCalories()).reduce(0, Integer::max);
        System.out.println(maxCalorie);
        
        /**
         * to get the minimum of calories
         */
        Optional<Integer> minCalorie = dishes.stream().map(dish -> dish.getCalories()).reduce(Integer::min);
        System.out.println(minCalorie);
        
        
### Transaction

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        
        return Arrays.asList(new Transaction(brian, 2011, 30),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
                
                
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
                
### Issue of Boxing and Unboxing

                List<Dish> dishes = DishFactory.dishFactory();
        
                /**
                 * To get the sum of calories in the dishes, the below code has issue with boxing and unboxing
                 */
        
                Integer sumOfCalories = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
                System.out.println(sumOfCalories);
        
                /**
                 * here the issue of boxing and unboxing is resolved
                 */
                int sumOfCaloriesWithMapToInt = dishes.stream().mapToInt(Dish::getCalories).sum();
                System.out.println(sumOfCaloriesWithMapToInt);
        
                /**
                 * to get the max
                 */
                Optional<Integer> maxCalorie = dishes.stream().map(Dish::getCalories).reduce(Integer::max);
                System.out.println(maxCalorie);
        
                OptionalInt maxCaloie = dishes.stream().mapToInt(Dish::getCalories).max();
                System.out.println(maxCaloie);
        
                /**
                 * to get the min
                 */
                Optional<Integer> minV = dishes.stream().map(Dish::getCalories).reduce(Integer::min);
                System.out.println(minV);
        
                /**
                 * here when you get the value of OptionalInt, you can specify the default value also using orElse
                 */
                OptionalInt min = dishes.stream().mapToInt(Dish::getCalories).min();
                System.out.println(min.orElse(1));
        
                /**
                 * to get the average
                 */
                Integer sumOfCaloriesOfAllDishes = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
                long count = dishes.stream().count();
                double avg = (double) sumOfCaloriesOfAllDishes / count;
                System.out.println(avg);
        
                OptionalDouble average = dishes.stream().mapToInt(Dish::getCalories).average();
                System.out.println(average.getAsDouble());
                
### IntStream

            /**
             * to generate even numbers from 1 to 20. 20 inclusive
             */
            IntStream intStream = IntStream.rangeClosed(1, 20).filter(i -> i % 2 == 0);
            List<Integer> evenNumbers = intStream.boxed().collect(Collectors.toList());
            System.out.println(evenNumbers);
            /*
            o/p will be
            [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
             */
    
            /**
             * to generate even numbers from 1 to 20, 20 exclusive
             */
            List<Integer> collect = IntStream.range(1, 20).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
            System.out.println(collect);
            /*
            o/p will be
            [2, 4, 6, 8, 10, 12, 14, 16, 18]
             */
    
            /**
             * to get the sum of first 100 even numbers, 100 included
             */
            int sum = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).sum();
            System.out.println(sum);
    
            /**
             * To get the sum of first 100 numbers, 100 not included
             */
            int sum1 = IntStream.range(1, 100).filter(i -> i % 2 == 0).sum();
            System.out.println(sum1);
    
    
            double sqrt = Math.sqrt(5 * 5 + 6 * 6);
            System.out.println(sqrt);
            System.out.println(sqrt % 1);
    
            /**
             * pythagorean triples, a*a + b*b = c*c
             */
    
            Stream<int[]> stream = IntStream.range(1, 100).boxed().flatMap(a -> IntStream.range(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
    
            stream.limit(5).forEach(t -> {
                System.out.println(t[0] + "," + t[1] + "," + t[2]);
            });
            
### Stream.of , Arrays.stream, Stream.iterate

    /**
             * use of Stream.of
             */
            Stream<String> hello = Stream.of("Hello", " Arun", " How are you");
            List<String> collect = hello.map(String::toUpperCase).collect(Collectors.toList());
            System.out.println(collect);
    
            /**
             * Streams from Arrays
             */
            int [] numbers = {2,3,4,5,6,7};
            int sum = Arrays.stream(numbers).sum();
            System.out.println(sum);
    
            /**
             * Creating an infinite stream, using Stream.iterate
             */
            List<Integer> infiniteStream = Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList());
            System.out.println(infiniteStream);
    
            /**
             * fibonacci series
             */
            List<Integer> fibonnaci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).map(t -> t[0]).collect(Collectors.toList());
            System.out.println(fibonnaci);