package calculadora;

/**
 *
 * @author Ariel Simao
 */
public class DivisaoImpossivelException extends Exception{
    @Override
    public String getMessage(){
        return "Não é possivel dividir por zero!";
    }    
}
