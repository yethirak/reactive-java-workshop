package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().filter(number -> number < 5)
                .forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));
        /* or */
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));
        /* or */
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(u ->
                        StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
    }

}
