package Presentacion;

import Logica.Fabrica;
import Logica.ICPU;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fabrica fabrica = Fabrica.getInstance();
        ICPU Cpu = fabrica.getICPU();

        String[] linea = {"MOV 5,R00","MOV 10,R01","JZ 7","ADD R02,R01","DEC R00","JMP 3","MOV R02,R42"};
        //String[] linea = {"MOV 5,R00","INV R00"};
        Cpu.agregarSubrutina(linea);
        Cpu.ejecutarSubrutinas();

    }
}
