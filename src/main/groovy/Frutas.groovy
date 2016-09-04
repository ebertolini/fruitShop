/**
 * Created by estefaniabertolini on 8/22/16.
 */
public class Frutas {

    ArrayList<Fruta> ListadoFrutas = new ArrayList<Fruta>()

    Frutas(){

    }

    Frutas(def json){
        json.frutas.each{
            def fruta = new Fruta(it.nombre, it.color, it.vitaminas)
            ListadoFrutas.add(fruta)
        }



    }



}
