package com.qa
/**
 * Created by estefaniabertolini on 9/5/16.
 */
public class ValidationClass {
    static String nombre = "";
    static String dataByUser;
    static Scanner scanner = new Scanner(System.in)


    public static String pedirNombre() {
        System.out.println("Enter a fruit name:")
    }

    public static String enterData() {
        dataByUser = scanner.next()
    }

    public static String validateName() {

        Fruta existe = Fruteria.frutas.ListadoFrutas.find {
            it.nombre == dataByUser
        }
        if (existe) {
            println("The fruit you are trying to enter already exist.")
            nameValidated()
        }
        //String fruitName = dataByUser
        while (!dataByUser.matches("[a-zA-Z]*")) {
            println("The name is invalid.")
            pedirNombre()
            enterData()
            validateName()
            //fruitName = dataByUser
        }
        return dataByUser
    }

    public static String nameValidated() {
        pedirNombre()
        enterData()
        validateName()
    }

    public static String validateColour() {
        String fruitColour = pedirColor()
        while (!fruitColour.matches("[a-zA-Z]*")) {
            println("The fruit colour is invalid.")
            fruitColour = pedirColor()
        }
        return fruitColour

    }

    public static String pedirColor() {
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
