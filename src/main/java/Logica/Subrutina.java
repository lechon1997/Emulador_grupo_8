package Logica;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subrutina {
    private String comando;
    private List<String> parametros;
    
    public Subrutina(String[] subrutina) { //Aquí entra UNA instrucción con sus parametros
        this.comando = subrutina[0];
        this.parametros = new ArrayList<>();
        String[] parametro = subrutina[1].split(",");

        for(int i =0; i < parametro.length; i++){
            this.parametros.add(parametro[i]);
        }
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
