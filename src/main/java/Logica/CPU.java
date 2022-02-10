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

    /**
     * Este metodo agrega las subrutinas entrantes a un objetosu subrutina
     * @param subrutinas
     */
    @Override
    public void agregarSubrutina(String[] subrutinas) {
        for(String subrutina: subrutinas){
            String[] partes = subrutina.split(" ");
            Subrutina subr = new Subrutina(partes);
            this.subrutinas.add(subr);

        }
    }

    private int getIndex(String registro){
        if(registro.charAt(0) == 'R'){
            String s = registro.substring(1);

            if(s.charAt(0) == '0')
                return Integer.parseInt(s.substring(1));

            return Integer.parseInt(s);
        }
        /*
        if(registro.contains(".")){
            return Integer.(registro.charAt(0));
        }
        */
        return Integer.parseInt(registro);
    }

    @Override
    public void ejecutarSubrutinas() { // :O
        int i = 0;
        do {
            Subrutina subr = (Subrutina)this.subrutinas.get(i);

            switch(subr.getComando()){
                case "MOV":
                    String param = (String)subr.getParametros().get(0);
                    if(param.charAt(0) == 'R'){
                        MOV(getIndex((String)subr.getParametros().get(0)),getIndex((String)subr
                                .getParametros().get(1)));
                    }else{
                        MOV((String)subr.getParametros().get(0), getIndex((String)subr
                                .getParametros().get(1)));
                    }
                    i++;
                    break;
                case "ADD":
                    ADD(getIndex((String)subr.getParametros().get(0)), getIndex((String)subr.getParametros().get(1)));
                    i++;
                    break;
                case "DEC":
                    DEC(getIndex((String)subr.getParametros().get(0)));
                    i++;
                    break;
                case "INC":
                    INC(getIndex((String)subr.getParametros().get(0)));
                    i++;
                    break;
                case "INV":
                    INV(getIndex((String)subr.getParametros().get(0)));
                    i++;
                    break;
                case "JMP":
                    i = JMP(getIndex((String)subr.getParametros().get(0)));
                    break;
                case "JZ":
                    if(JZ(getIndex((String)subr.getParametros().get(0))) != -1){
                        i = JZ(getIndex((String)subr.getParametros().get(0)));
                    }else{
                        i++;
                    }
                    break;
                case "NOP":
                    NOP();
                    i++;
                    break;
            }
        }while(i < this.subrutinas.size());

        System.out.println(String.valueOf(registros[42]));

    }

    private void MOV(int Rxx, int Ryy) {
        registros[Ryy] = registros[Rxx];
    }

    private void MOV(String d, int Rxx) {
        registros[Rxx] = getIndex(d);
    }
    private void ADD(int Rxx, int Ryy) {
            registros[Rxx] = (int) ((registros[Rxx] + registros[Ryy])); /* % Math.pow(2, 32)) */;
        }
    private void DEC(int Rxx) {
            if(registros[Rxx]==0){
                registros[Rxx] = (int)Math.pow(2,32) -1;
            }
            registros[Rxx] = registros[Rxx]-1;
        }
    private void INC(int Rxx) {
            if(registros[Rxx] >= Math.pow(2, 32)-1) registros[Rxx] = 0;
            registros[Rxx] = registros[Rxx]+1;
        }

    private void INV(int Rxx){
        int dato = registros[Rxx];
        String Binario = Integer.toBinaryString(dato);
        String NewBinario = "" ;
        int[] arr = Arrays.stream(Binario.substring(0, Binario.length()).split(""))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i< arr.length; i++){
            if (arr[i]==0){
                arr[i]=1;
            }
            else
                arr[i]=0;

            NewBinario= arr[i] + NewBinario;

        }

        NewBinario = new StringBuilder(NewBinario).reverse().toString();
        int NewRxx = Integer.parseInt(NewBinario);
        NewRxx= Integer.parseInt(NewBinario,2);
        registros[Rxx] = NewRxx;
    }

    private int JMP(int d){
        return d-1;
    }
    
    private int JZ(int d){
        if(registros[0] == 0){

            return d-1;
        }
        return -1;

    }
    private void NOP(){}
}
