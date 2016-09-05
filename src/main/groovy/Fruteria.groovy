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

        System.out.println( "Bienvenido a la Fruteria de Estefania, el lugar ideal para mandar fruta");
        Scanner scanner = new Scanner(System.in);
        System.out.println('''Presione la opción 1 para LISTAR.
                            opción 2 AGREGAR un Item.
                            opción 3 BUSCAR un item.
                            opcion 4 ELIMINAR un item.
                            para ABANDONAR presione 5.''');

        boolean salir = true;
        while (salir) {
            int valorIngresado = scanner.nextInt();
            switch (valorIngresado) {
                case 1:
                    listarLasFrutas();
                    break;
                case 2:
                    agregarUnItem();
                    break;
                case 3:
                    buscarUnItem();
                    break;
                case 4:
                    eliminarUnItem();
                case 5:
                    salir = false;
                    break;
                default:
                    System.out.println("No hay mas opciones!");
            }
        }
    }

    public static void listarLasFrutas() {

        //El usuario recibe el listado de la frutas
        frutas.ListadoFrutas.each{
            it.nombre
            println(it.nombre)
            nombre = nombre + it.nombre
        }
    }



    public static void agregarUnItem() {

        System.out.println("Agregar");
        Scanner scanner = new Scanner(System.in)
        String nombre = "";
        String color = "";
        String vitamina = "";
        String[] vitaminaSplit = [];

        System.out.println("Ingrese el nombre de la fruta")
        nombre = scanner.next()
        System.out.println("Ingrese el color de la fruta")
        color = scanner.next()
        System.out.println("Ingrese la vitamina de la fruta")
        vitamina = scanner.next()
        vitaminaSplit = vitamina.split(",")
        ArrayList<String> vitaminaArray;
        vitaminaArray = new ArrayList<String>()
        vitaminaSplit.each{
            vitaminaArray.add(it)
        }
        frutas.ListadoFrutas.add(new Fruta(nombre,color,vitaminaArray))

        listarLasFrutas()

        println(frutas.ListadoFrutas.last().toString())

        // POST con el valor de mi string a info/frutas.json
        def http = new HTTPBuilder( 'https://fefa-workshop.firebaseio.com/' )
        def postBody = http.post(  path : '/info/frutas.json',
                                    body : frutas.ListadoFrutas.last(),
                                    requestContentType : ContentType.JSON
        )



        /*public void noAceptaNumeros(){
            if (nombre.isNumber() ) {
            }
        }*/
    }




    public static void buscarUnItem(String frutaABuscar){
        System.out.println("Buscar");

        // El usuario ingresa la fruta de la que desea recibir la información.
        Scanner scanner = new Scanner(System.in)
        System.out.println("Ingresa la fruta")
        String sentence;
        if(frutaABuscar == null) {
            sentence = scanner.next()
        }
        else {
        sentence = frutaABuscar

    }   //reemplazar por .find
        boolean found = false
        frutas.ListadoFrutas.each{
          if (it.nombre == sentence) {
              found = true
              println("Fruta Encontrada!")
              println("  - Nombre: "+it.nombre)
              println("  - Color: "+it.color)
              println("  - Vitaminas: "+it.vitaminas)

              loQueEncontro = it.nombre
          }
        }
        if (found == false){
            println("Fruta No encontrada :(")
        }
    }


    public static void eliminarUnItem(){
        Scanner scanner = new Scanner(System.in)
        println("Ingresa el nombre de la fruta a borrar")
        String frutaAEliminar = scanner.next()

        Fruta encontrarFrutaAEliminar = frutas.ListadoFrutas.find {
            it.nombre == frutaAEliminar
        }

        def http = new RESTClient('https://fefa-workshop.firebaseio.com/' )
        http.delete(path : "/info/frutas/${encontrarFrutaAEliminar.id}.json"
        )
        println("La fruta ha sido borrada!")



    }
}

