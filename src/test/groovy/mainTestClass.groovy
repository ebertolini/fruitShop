
import org.testng.annotations.Test
import org.testng.annotations.TestInstance

/**
 * Created by estefaniabertolini on 8/30/16.
 */
class mainTestClass {

    //@Test
    void firstValidation() {

        Fruteria.listarLasFrutas()
        assert Fruteria.nombre == "bananamanzananaranja"
    }

    @Test
    void testDomain() {

        Frutas frutaNueva = new Frutas()
        frutaNueva.ListadoFrutas.add(new Fruta("durazno", "amarillo", [], ""))

        assert frutaNueva.ListadoFrutas[0].nombre == "durazno"

    }

    @Test
    void secondValidation() {
        Fruteria.buscarUnItem("naranja")

        assert Fruteria.loQueEncontro == "naranja"
    }

    @Test
    void thirdValidation() {
        Frutas frutaNueva2 = new Frutas()
        frutaNueva2.ListadoFrutas.add(new Fruta("pera", "amarilla", ["E", "D"]))

        assert frutaNueva2.ListadoFrutas.nombre[0] == "pera"
        assert frutaNueva2.ListadoFrutas.color[0] == "amarilla"
        assert frutaNueva2.ListadoFrutas.vitaminas[0] == ["E","D"]



    }
}
//ESCRIBIR EL PROCESO LOGICO PARA PROBAR LA FUNCION DE AGREGAR
/*
- Agregar un item con el metodo ADD de Fruta pasandole los nuevos parametros
Frutas frutaNueva = new Fruta()
1- frutas.listadodeFrutas.add(new Fruta(pera,amarilla,[E,D]))
2- Assert del Fruta con los datos del parametro.
Fruta[0].nombre == "pera"
Fruta[0].color == "amarillo"
Fruta[0].vitaminas == "E,D"
- print del ListadoFrutas y aparecen todas las frutas del json y esta hardcodeada

 */

