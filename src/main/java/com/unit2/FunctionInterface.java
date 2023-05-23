package com.unit2;
import com.unit1.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionInterface {
    public static void main(String[] args){
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Step1: sort list by last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        // Step2: Create a method that prints all elements in the list
        System.out.println("Printing all people");
        printConditionally(people, p -> true, p -> System.out.println(p));
        // Step3: Create a method that print all the people with last name beginning with C
        System.out.println("Printing people with last name start with 'C'");
        printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        System.out.println("Printing people with first name start with 'C'");
        printConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));

    };

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p: people) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}