/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e2p1_diegocruz;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author dfcm9
 */
public class MenuE2 extends JFrame implements ActionListener{// Creacion del frame de menu
    
    JLabel titulo;
    JButton boton1 = new JButton();
    JButton boton2 = new JButton();
    JButton boton3 = new JButton();
    JPanel panel;
    ArrayList<Numero> numbers = new ArrayList<>();
    
    
    public MenuE2() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        
        titulo = new JLabel("Examen 2");
        titulo.setBounds(250, 30, 300, 50);
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 20));
        titulo.setForeground(Color.BLACK);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        boton1.setFocusable(false);// boton de numeros
        boton1.setText("Numeros");
        boton1.setBounds(200, 100, 200, 40);
        boton1.addActionListener(this);
        
        boton2.setFocusable(false);// boton de operaciones
        boton2.setText("Operaciones");        
        boton2.setBounds(200, 200, 200, 40);
        boton2.addActionListener(this);
        
        boton3.setFocusable(false);// boton para salir 
        boton3.setText("Salir");        
        boton3.setBounds(200, 300, 200, 40);
        boton3.addActionListener(this);
        
        // Se agrega todo a un panel que se agrega a un frame
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(titulo);
        add(panel);
        validate();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {// Caso 1: Numeros
            this.setVisible(false);
            boolean resp = true;
            while(resp){
                int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Numeros\n1. Agregar Numero\n2. Eliminar Numero\n3. Listar Numeros\n4. Menu Principal"));
                switch (op){
                    case 1:// Caso 1.1 Agregar Numero
                    {
                        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero:"));
                         while (num <2){
                            num = Integer.parseInt(JOptionPane.showInputDialog(null,"El numero que va a ingresar tiene que ser mayor que 1. Intente de nuevo."));
                        }
                        int base = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la base a la que quiere convertir este numero:"));
                        while (base <2 || base>35){
                            base = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese una base entre 2 y 35 (incluidos)."));
                        }
                        Numero nuevonum = new Numero(base,num);
                        numbers.add(nuevonum);
                        JOptionPane.showMessageDialog(null, "El numero ha sido agregado exitosamente!");
                        break;
                    }
                    case 2: // Caso 1.2 Eliminar Numero
                    {
                        if (numbers.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No tiene numeros agregados que pueda eliminar. Por favor agregue mas numeros.");
                        }
                        else{
                            String listab = listanums(numbers);
                            int opc = Integer.parseInt(JOptionPane.showInputDialog(null,listab+"\nIngrese el indice del numero que desea eliminar.\n Ingrese un cero para cancelar."));
                            while (opc < 0 || opc > numbers.size()){
                                opc = Integer.parseInt(JOptionPane.showInputDialog(null,listab+"\nIngrese un indice valido.\n Ingrese un cero para cancelar."));
                            }
                            if(opc==0){
                                break;
                            }
                            else{
                            numbers.remove(opc-1);
                            JOptionPane.showMessageDialog(null, "El numero ha sido elimnado exitosamente.");
                            }
                        }
                        break;

                    }
                    case 3://1.3 Listar numeros actuales
                    {
                        if (numbers.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No tiene numeros agregados para listar. Por favor agregue mas numeros.");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, listanums(numbers));
                        }
                        break;
                    }
                    case 4:// 1.4 Salir
                    {
                        resp = false;
                        this.setVisible(true);
                        break;
                    }
                    default:
                    {
                        JOptionPane.showMessageDialog(null, "Opcion invalida. Intente de nuevo.");
                        break;
                    }
                }
            }
                
            
        } 
        else if (e.getSource() == boton2) {// Caso 2: Operaciones
            this.setVisible(false);
            boolean resp2 = true;
            while (resp2){
                int Opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Operaciones\n1. Sumar Numeros\n2. Restar Numeros\n3. Multiplicar Numeros\n4.Menu Principal"));
                switch (Opcion){
                    case 1:
                    {
                        if (numbers.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No tiene numeros agregados que pueda sumar. Por favor agregue mas numeros.");
                        }
                        else{
                            int escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del primer numero:"));
                            while (escoge < 1 || escoge > numbers.size()){
                                escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del segundo numero:"));
                            while (escoge2 < 1 || escoge2 > numbers.size()){
                                escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int suma = numbers.get(escoge-1).baseToDec(numbers.get(escoge-1).getNumero()) + numbers.get(escoge2-1).baseToDec(numbers.get(escoge2-1).getNumero());
                            Numero num = new Numero(Math.max(numbers.get(escoge-1).getBase(), numbers.get(escoge2-1).getBase()),suma);
                            JOptionPane.showMessageDialog(null, "El resultado de la suma es: "+num.getNumero()+" en base "+num.getBase()+": "+suma);
                            
                        }
                        break;
                    }
                    case 2:
                    {
                        if (numbers.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No tiene numeros agregados que pueda restar. Por favor agregue mas numeros.");
                        }
                        else{
                            int escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del primer numero:"));
                            while (escoge < 1 || escoge > numbers.size()){
                                escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del segundo numero:"));
                            while (escoge2 < 1 || escoge2 > numbers.size()){
                                escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int resta = numbers.get(escoge-1).baseToDec(numbers.get(escoge-1).getNumero()) - numbers.get(escoge2-1).baseToDec(numbers.get(escoge2-1).getNumero());
                            if (resta < 0){
                                JOptionPane.showMessageDialog(null, "El resultado termino siendo negativo!");
                            }
                            else{
                                Numero num = new Numero(Math.max(numbers.get(escoge-1).getBase(), numbers.get(escoge2-1).getBase()),resta);
                                JOptionPane.showMessageDialog(null, "El resultado de la resta es: "+num.getNumero()+" en base "+num.getBase()+": "+resta);
                            }
                        }
                        break;
                    }
                    case 3:
                    {
                        if (numbers.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No tiene numeros agregados que pueda multiplicar. Por favor agregue mas numeros.");
                        }
                        else{
                            int escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del primer numero:"));
                            while (escoge < 1 || escoge > numbers.size()){
                                escoge = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese el indice del segundo numero:"));
                            while (escoge2 < 1 || escoge2 > numbers.size()){
                                escoge2 = Integer.parseInt(JOptionPane.showInputDialog(null,listanums(numbers)+"\nIngrese un indice valido."));
                            }
                            int multi = numbers.get(escoge-1).baseToDec(numbers.get(escoge-1).getNumero()) * numbers.get(escoge2-1).baseToDec(numbers.get(escoge2-1).getNumero());
                            Numero num = new Numero(Math.max(numbers.get(escoge-1).getBase(), numbers.get(escoge2-1).getBase()),multi);
                            JOptionPane.showMessageDialog(null, "El resultado de la multiplicacion es "+num.getNumero()+" en base "+num.getBase()+": "+multi);
                        }
                        break;
                    }
                    case 4:
                    {
                        resp2 = false;
                        this.setVisible(true);
                        break;
                    }
                    default:
                    {
                        JOptionPane.showMessageDialog(null, "Opcion invalida. Intente de nuevo.");
                        break;
                    }
                }
            }
        } 
        else if (e.getSource() == boton3) {// Caso 3 - Salir
            JOptionPane.showMessageDialog(null, "Gracias por todo instructores, son los mejores!!\nA continuacion saldra del programa.");
            System.exit(0);
        }
    }
    
    public String listanums(ArrayList<Numero> nums){// Metodo que lista numeros
        String listaA = "Lista de numeros:\n";
        for (int i = 0; i < numbers.size(); i++) {
            listaA+=(i+1)+". "+numbers.get(i).getNumero()+" en base "+numbers.get(i).getBase()+": "+numbers.get(i).baseToDec(numbers.get(i).getNumero());
            listaA+="\n";
        }
        
        return listaA;
        
    }
    

    
}
