package com.qa

import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.RESTClient


/**
 * Created by estefaniabertolini on 8/22/16.
 */
public class Fruteria {

    static def json = new JsonSlurper().parseText(new URL('https://fefa-workshop.firebaseio.com/info.json').text)
    static Frutas frutas = new Frutas(json)
    static String nombre = "";
    static String loQueEncontro = "";

    public static void main (String[] args){

        System.out.println( "Welcome to the FruitSHop, This is the best place to drop fruit!!! Enjoy it!");
        Scanner scanner = new Scanner(System.in);
        mainMenu()

        boolean exit = true;
        while (exit) {
            int valorIngresado = scanner.nextInt();
            switch (valorIngresado) {
                case 1:
                    listAllFruits();
                    break;
                case 2:
                    addAnItem();
                    break;
                case 3:
                    searchAnItem();
                    break;
                case 4:
                    deleteAnItem();
                    break;
                case 5:
                    exit = false;
                    break;
                default:
                    System.out.println("No more options!");
            }
        }
    }

    public static void listAllFruits() {

        //El usuario recibe el listado de la frutas
        println('''
        OPTION 1 - LIST ALL FRUITS.
        The fruits list is the following:
        ''')
        listadoDeFrutas()
        mainMenu()
    }

    public static void addAnItem() {

        println("OPTION 2 - ADD A NEW FRUIT.");
        Scanner scanner = new Scanner(System.in)
        String nombre = "";
        String color = "";
        String vitamina = "";
        String[] vitaminaSplit = [];

        nombre = ValidationClass.nameValidated()
        color = ValidationClass.validateColour()
        vitamina = ValidationClass.validateVitamins()
        vitaminaSplit = vitamina.split(",")
        ArrayList<String> vitaminaArray;
        vitaminaArray = new ArrayList<String>()
        vitaminaSplit.each {
            vitaminaArray.add(it)
        }
        frutas.ListadoFrutas.add(new Fruta(nombre,color,vitaminaArray))
        println("The fruit was successfully added : "+frutas.ListadoFrutas.last().toString())
        // POST con el valor de mi string a info/frutas.json
        def http = new HTTPBuilder( 'https://fefa-workshop.firebaseio.com/' )
        http.post(  path : '/info/frutas.json',
                                    body : frutas.ListadoFrutas.last(),
                                    requestContentType : ContentType.JSON
        )
        mainMenu()
    }

    public static void searchAnItem(String frutaABuscar){
        println("OPTION 3 - SEARCH AN EXISTING FRUIT.");

        // El usuario ingresa la fruta que desea recibir la información.
        Scanner scanner = new Scanner(System.in)
        System.out.println("Enter the fruit you are looking for:")
        String sentence;
        if(frutaABuscar == null) {
            sentence = scanner.next()

        }
        else {
        sentence = frutaABuscar
        }
        //Compara com.qa.Fruta a buscar con la lista de frutas
        Fruta frutaEncontrada = frutas.ListadoFrutas.find {
            it.nombre.toLowerCase() == sentence.toLowerCase()
        }
        if (frutaEncontrada) {
            println("The fruit was found.")
        } else {
            println("The fruit does not exist.")
        }
        mainMenu()
    }

    public static void deleteAnItem(){
        println("OPTION 4 - DELETE AN ITEM.")
        Scanner scanner = new Scanner(System.in)
        listadoDeFrutas()
        println("Enter the fruit you want to delete")
        String frutaAEliminar = scanner.next()

        Fruta encontrarFrutaAEliminar = frutas.ListadoFrutas.find {
            it.nombre == frutaAEliminar
        }
        if (encontrarFrutaAEliminar) {
            def http = new RESTClient('https://fefa-workshop.firebaseio.com/' )
            http.delete(path : "/info/frutas/${encontrarFrutaAEliminar.id}.json")
            println("The fruit has been deleted!")

        }
        else {
            println("The fruit has not been deleted or could not be deleted.")
        }
        mainMenu()
    }


    public static void mainMenu(){
        System.out.println ('''
                            OPTION 1 - LIST ALL FRUITS.
                            OPTION 2 - ADD A NEW FRUIT.
                            OPTION 3 - SEARCH AN EXISTING FRUIT.
                            OPTION 4 - DELETE AN ITEM.
                            OPTION 5 - EXIT.
                            ''');
    }

    public static void listadoDeFrutas(){
        frutas.ListadoFrutas.each{
            it.nombre
            println(it.nombre)
            nombre = nombre + it.nombre
        }
    }


}

