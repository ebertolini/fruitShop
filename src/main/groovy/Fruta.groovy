import java.util.ArrayList;

/**
 * Created by estefaniabertolini on 8/22/16.
 */
public class Fruta {

    String nombre;
    String color;
    ArrayList<String> vitaminas;


    Fruta(String nombre, String color, ArrayList<String> vitaminas){
        this.nombre = nombre
        this.color = color
        this.vitaminas = vitaminas
    }
    String toString(){
        String body = """
            {
            nombre : ${nombre},
            color: ${color},
            vitamina: ${vitaminas}
            }
        """

    }


}
