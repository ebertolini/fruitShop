package com.qa

import com.qa.Fruta

/**
 * Created by estefaniabertolini on 8/22/16.
 */
public class Frutas {

    ArrayList<Fruta> ListadoFrutas = new ArrayList<Fruta>()

    Frutas(){

    }

    Frutas(def json){
        json.frutas.each{
            def fruta = new Fruta(it.value.nombre, it.value.color, it.value.vitaminas, it.key)
            ListadoFrutas.add(fruta)
        }



    }



}
