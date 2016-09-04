/**
 * Created by estefaniabertolini on 8/30/16.
 */
class Assertion {

    def variableAssertion

    Assertion(jsonParseado){
        this.variableAssertion = jsonParseado
    }

    Assertion listaDeNombres(String buildToVerify){
        assert variableAssertion.nombre == buildToVerify

    }
}
