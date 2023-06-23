/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_diegocruz;

/**
 *
 * @author dfcm9
 */
public class Numero {
    
    int base;
    String numero;
    
    
    public Numero(){
        
    }
    
    public Numero(int baseN, int numeroN){
        
        this.base = baseN;
        this.numero = decToBase(numeroN);
    
    }
    
    public char numToChar(int numero){
        char x;
        if (numero >=0 && numero <= 9){
            x = (char) (numero+48);
        }
        else{
            x = (char) (numero+87);          
        }
        return x;
    }
    
    public int charToNum(char x){
        int num;
        if (Character.isDigit(x)){
            num = Character.getNumericValue(x);
        }
        else{
            num = x -87;
        }
        return num;
    }
    
    public String decToBase(int entero){
        String num = "", baseorg ="";
        while (entero / base > 0 ){
            if(entero % base <10){
                num+= Integer.toString(entero % base);
            }
            else{
                num+= numToChar(entero%base);
            }
            entero = entero/base;
        }
        num+= numToChar(entero);
        
        for (int i = 0; i < num.length(); i++) {
            char s = num.charAt(num.length()-i-1);
            baseorg+=s;
        }
        
        return baseorg;
    }
    
    public int baseToDec(String numenbase){
        int valordec = 0;
        
        for (int i = 0; i < numenbase.length(); i++) {
            char d = numenbase.charAt(i);
            valordec+= charToNum(d) * Math.pow(base, numenbase.length()-i-1); 
        }
        
        return valordec;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
    
    
    
    
}
