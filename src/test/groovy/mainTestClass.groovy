import com.qa.Fruta
import com.qa.Frutas
import com.qa.Fruteria
import org.testng.annotations.Test

/**
 * Created by estefaniabertolini on 8/30/16.
 */
class mainTestClass {

    //@Test
    void firstValidation() {

        Fruteria.listadoDeFrutas()
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
        Fruteria.frutas.ListadoFrutas.add(new Fruta("durazno", "amarillo", [], ""))
        Fruteria.searchAnItem("durazno")
        assert Fruteria.loQueEncontro == "durazno"
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


