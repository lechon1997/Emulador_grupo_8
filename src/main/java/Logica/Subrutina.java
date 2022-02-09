package Logica;
import java.util.List;

public class Subrutina {
    private String comando;
    private List<Integer> parametros;
    
    public Subrutina(String comando, List parametros) {
        this.comando = comando;
        this.parametros = parametros;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public List getParametros() {
        return parametros;
    }

    public void setParametros(List parametros) {
        this.parametros = parametros;
    }
    
    public String[] toArray(){
        String instruccion[] = new String[1+parametros.size()];
        instruccion[0] = this.comando;
        instruccion[1] = "R"+this.parametros.get(0);
        if(instruccion.length == 3) instruccion[2] = "R"+this.parametros.get(1); 
        return instruccion;
        //cuchau
      }
}
