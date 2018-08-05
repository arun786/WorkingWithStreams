# WorkingWithStreams

## Streams

Stream interface in java defines 2 operations, 

    1. Intermediate operations
    2. Terminal Operations
    
### Intermediate Operations are
    
    1. filter
    2. map
    3. limit
    
### Terminal Operation
    
    collect
    
### Example 
    
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