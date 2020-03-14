package com.officeHours.day_031120;

import java.util.ArrayDeque;
import java.util.Deque;


public class JavaMapsOH {

    public static void main(String[] args) {


        /*

        dequeue - double sided
        we can add and retrieve elements from dequeue from
        both sides (head, end)

        */

        Deque<Integer> numbers = new ArrayDeque<>();

        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);
        System.out.println(numbers);

        numbers.addLast(90);
        System.out.println(numbers);

        numbers.add(33);
        System.out.println(numbers);

        Integer num = numbers.pollFirst(); // return and delete first element
        System.out.println(num);

        System.out.println(numbers);

        System.out.println(numbers.getLast() + " peek: " + numbers.peekLast());
        // peek -> return the value ( similar to get())
        // poll -> returns the value and remove it from the Queue
        System.out.println("dequeue after peek: " + numbers);

        /*

            What collections you are using in your project?
            describe all different collections (List, Queue, Set)
            explain the difference between them

            List --> ArrayList most of the times, because I would usually
            just need to store some values

            I would use LinkedList if I know I will need to manipulate my data
            (consistently add, remove, etc.)

            Set --> HashSet - for unique values
                    TreeSet - for unique sorted values

            Queue -> if I need to check First In First Out in my project
         */


    }
}
