package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        System.out.println("Print all numbers in the ReactiveSources.intNumbersFlux stream");
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);
        //underneath it behaes like below
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
        stream.subscribe(e -> System.out.println(e));
        //multiple subscribes
        stream.subscribe(e -> System.out.println("Another Stream" + e));

        // Print all users in the ReactiveSources.userFlux stream
        System.out.println("Print all users in the ReactiveSources.userFlux stream");
        ReactiveSources.userFlux().subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
