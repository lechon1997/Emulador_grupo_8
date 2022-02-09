package Logica;

import java.util.*;

//Controlador CPU - Controlador de tipo Fachada
public class CPU implements ICPU{
    private static CPU instance;

    //Map<String, Subrutina> subruitinas;
    private List<Subrutina> subrutinas;
    //private String[][]subruitinas;
    private int registros[] = new int[43];
    private int[] subrutina;

    private CPU(){
        subrutinas = new ArrayList<>();
    }

    public static CPU getInstance() {
        if (instance == null) {
            instance = new CPU();
        }
        return instance;
    }

    @Override
    public void agregarSubrutina(String[] subrutinas) {

        for(String subrutina: subrutinas){
            String[] partes = subrutina.split(" ");
            Subrutina subr = new Subrutina(partes);
            this.subrutinas.add(subr);

        }
    }

    @Override
    public void ejecutarSubrutinas() {
        for(int i = 0; i < this.subrutinas.size(); i++){
            Subrutina subr = (Subrutina)this.subrutinas.get(i);
            switch(subr.getComando()){
                case "MOV":
                    break;
                case "ADD":
                    break;
                case "DEC":
                    break;
                case "INC":
                    break;
                case "INV":
                    break;
                case "JMP":
                    break;
                case "JS":
                    break;
                case "NOP":
                    break;
            }
        }
    }


    private void MOV(int Rxx, int Ryy) {
        Ryy = Rxx;

    }

    private void MOV(float d, int Rxx) {

    }

    private int getIndex(String registro){
        String s = registro.substring(1);
        if(s.charAt(0) == '0') return Integer.parseInt(s.substring(1));
        return Integer.parseInt(s);
    }
    private int JZ (int d){
        if (registros[0]==0){
            return d-1;
        }
    }
}
