package Presentacion;

import     Logica.Fabrica;
import Logica.ICPU;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Fabrica fabrica = Fabrica.getInstance();
        ICPU Cpu = fabrica.getICPU();

        String[] linea = {"MOV 5,R01"};
        Cpu.agregarSubrutina(linea);
        Cpu.ejecutarSubrutinas();

    }
}
