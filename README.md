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