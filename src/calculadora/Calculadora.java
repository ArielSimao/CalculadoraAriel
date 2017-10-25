package calculadora;

/**
 *
 * @author Ariel Simao
 */
public class Calculadora {
    private double conta=0;
    private double valor1;
    private double valor2;
    private String operador=" ";
    private boolean estadoOperador = false;
    private boolean estadoIgual = false;

    public boolean getEstadoIgual() {
        return estadoIgual;
    }

    public void setEstadoIgual(boolean estadoIgual) {
        this.estadoIgual = estadoIgual;
    }
    
    public String getOperador(){
        return operador;
    }
    
    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    public void porcentagem(double valor2) throws DivisaoImpossivelException{
        //if("*".equals(operador)){
           conta = (valor1 * valor2)/100;
           operador = " ";
           estadoOperador = false;    
        //}
    }
    
    public void somar(double valor1) throws DivisaoImpossivelException{
        atribuirValor(valor1);
        operador = "+";
    }
    
    public void subtrair(double valor1) throws DivisaoImpossivelException{
        atribuirValor(valor1);
        operador = "-"; 
    }
    
    public void multiplicar(double valor1) throws DivisaoImpossivelException{
        atribuirValor(valor1);
        operador = "*";
    }
    
    public void dividir(double valor1) throws DivisaoImpossivelException{
        atribuirValor(valor1);
        operador = "/";
    }
    
    public void resultar(double valor2) throws DivisaoImpossivelException{
        if(estadoOperador == true){
          this.valor2 = valor2;  
          this.estadoOperador = false;
        }else{
            this.valor1 = conta;
        } 
        switch(operador){
            case "+":
                conta = this.valor1 + this.valor2;
            break;
            case "-":
                conta = this.valor1 - this.valor2;
            break; 
            case "*":
                conta = this.valor1 * this.valor2;
            break;
            case "/":
                try {
                    if(this.valor2 != 0){
                        conta = this.valor1 / this.valor2;
                    }else{
                        throw new DivisaoImpossivelException();
                    } 
                } catch (DivisaoImpossivelException e) {
                    throw e;
                } catch (Exception e) {
                    throw e;
                }
            break;
            case "%":
                conta = (this.valor1 * this.valor2)/100;
            break;
            case " ":
                
            break;
            default:

            break;
           
        }
        this.valor1 = conta;  
    }
    
    public void atribuirValor(double valor) throws DivisaoImpossivelException{
        if(" ".equals(operador)||(estadoIgual == true && estadoOperador==true)){
            this.valor1 = valor;
            this.conta = this.valor1;
            this.estadoOperador = false;
        }else if(estadoOperador == true){ 
            this.resultar(valor);
            //this.valor1 = conta;
            //this.valor2 = valor;
            this.estadoOperador = false;
        }
    }
    
    public double getResultado(){   
        return conta;
    }
    
    public Boolean getEstadoOperador(){
        return this.estadoOperador;
    }
    
    public void setEstadoOperador(Boolean estado){
        this.estadoOperador = estado;
    }
    
    public String getValor1(){
        String valor = String.valueOf(this.valor1);
        if(valor.endsWith(".0")){
             valor = valor.substring(0, valor.length()-2);
        }
        return valor;
    }
    
    public String getValor2(){
        String valor = String.valueOf(this.valor2);
        if(valor.endsWith(".0")){
             valor = valor.substring(0, valor.length()-2);
        }
        return valor;
    }
    
    public void zerarC(){
        conta = 0;
        valor1= 0;
        valor2= 0;
        operador = " ";
    }
    
    public void zerarCE(){
        conta = 0;
        valor2= 0;
    }
}
