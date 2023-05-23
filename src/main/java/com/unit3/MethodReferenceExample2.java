package com.unit3;

import com.unit1.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {
    public static void main(String [] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );
        System.out.println("Printing all people");
        // printConditionally(people, p -> true, p -> System.out.println(p));

        // replace p -> method(p) with
        // Instance::method, the argument will automatically pass
        printConditionally(people, p -> true, System.out::println);
    };

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p: people) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}