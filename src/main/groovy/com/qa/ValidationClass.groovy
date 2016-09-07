package com.qa
/**
 * Created by estefaniabertolini on 9/5/16.
 */
public class ValidationClass {

    public static String validateName (){
        String fruitName = pedirNombre()
        while (!fruitName.matches( "[a-zA-Z]*" )){
            fruitName = pedirNombre()

        }
        return fruitName

    }


    public static String pedirNombre(){
        System.out.println("Enter the fruit name:")
        Scanner scanner = new Scanner(System.in)
        scanner.next()

    }

}
