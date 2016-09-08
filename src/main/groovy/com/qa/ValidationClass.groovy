package com.qa
/**
 * Created by estefaniabertolini on 9/5/16.
 */
public class ValidationClass {

    public static String validateName (){
        String fruitName = pedirNombre()
        while (!fruitName.matches( "[a-zA-Z]*" )){
            System.out.println("The name is invalid.")
            fruitName = pedirNombre()
        }
        return fruitName

    }


    public static String pedirNombre(){
        System.out.println("Enter a fruit name:")
        Scanner scanner = new Scanner(System.in)
        scanner.next()

    }

    public static String validateColour (){
        String fruitColour = pedirColor()
        while (!fruitColour.matches( "[a-zA-Z]*" )){
            println("The fruit colour is invalid.")
            fruitColour = pedirColor()
        }
        return fruitColour

    }

    public static String pedirColor(){
        System.out.println("Enter a colour name:")
        Scanner scanner = new Scanner(System.in)
        scanner.next()

    }

    public static String validateVitamins() {
        String fruitVitamin = askVitaminFruit()
        while (!fruitVitamin.matches("[a-z,A-Z]*")) {
            println("The vitamin/s is/are invalid.:")
            fruitVitamin = askVitaminFruit()
        }
        return fruitVitamin
    }

    public static String askVitaminFruit() {
        System.out.println("Enter a fruit vitamins:")
        Scanner scanner = new Scanner(System.in)
        scanner.next()
    }

}
