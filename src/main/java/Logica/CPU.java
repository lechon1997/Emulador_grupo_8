package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controlador CPU - Controlador de tipo Fachada
public class CPU implements ICPU{
    private static CPU instance;

    //Map<String, Subrutina> subruitinas;
    private List<String> subrutinas;
    //private String[][]subruitinas;
    private int registros[] = new int[43];

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
    public void hola() {

    }

    @Override
    public void agregarSubrutina(String subrutinas) {
        for(int i = 0; i < subrutinas.length(); i++){

        }
    }


    @Override
    public void MOV(int Rxx, int Ryy) {
        Ryy = Rxx;

    }

    @Override
    public void MOV(float d, int Rxx) {

    }
}
