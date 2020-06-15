import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida extends JFrame implements ActionListener{
 
  private JTextField textfield1; // creamos los componentes requeridos 
  private JLabel label1, label2, label3, label4; 
  private JButton boton1;
  public static String texto = "";//modificadores de acceso quien tiene acceso y quien no para que venga una clase y siendo publica acceda a ella
  
  public Bienvenida(){
   setLayout(null);
   setDefaultCloseOperation(EXIT_ON_CLOSE);//los programas no queden en segundo plano
   setTitle("Bienvenido");
   getContentPane().setBackground(new Color(255,0,0));//ROJO VERDE AZUL metodos
   setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage()); //insertar la imagen
 
   ImageIcon imagen = new ImageIcon("images/logo-coca.png");
   label1 = new JLabel(imagen);
   label1.setBounds(25,15,300,150);
   add(label1);
 
   label2 = new JLabel("Sistema de Control Vacacional");
   label2.setBounds(35,135,300,30);
   label2.setFont(new Font("Andale Mono", 3, 18));//tipografia texto numero 1 2 3 para el color de las letras o cursiva
   label2.setForeground(new Color(255,255,255));//RGB letras de color blanco
   add(label2);   

   label3 = new JLabel("Ingrese su nombre");
   label3.setBounds(45,212,200,30);
   label3.setFont(new Font("Andale Mono", 1, 12));//tipografia texto numero 1 2 3 para el color de las letras o cursiva
   label3.setForeground(new Color(255,255,255));//RGB letras de color blanco
   add(label3); 

   label4 = new JLabel(" © 2017 The Coca-Cola Company");
   label4.setBounds(85,375,300,30);
   label4.setFont(new Font("Andale Mono", 1, 12));
   label4.setForeground(new Color(255,255,255));
   add(label4); 

   textfield1 = new JTextField();
   textfield1.setBounds(45,240,255,25);
   textfield1.setBackground(new Color(224,224,224));//tonalidad grisasio para jugar con el rgb
   textfield1.setFont(new Font("Andale Mono", 3, 14));//diseño tamaño color
   textfield1.setForeground(new Color(255,0,0));  
   add(textfield1);

   boton1 = new JButton("Ingresar");//diseño del boton
   boton1.setBounds(125,280,100,30);
   boton1.setBackground(new Color(255,255,255));
   boton1.setFont(new Font("Andale Mono", 1, 14));
   boton1.setForeground(new Color(255,0,0));
   boton1.addActionListener(this);//agregar evento
   add(boton1);  
 }
   public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
	texto = textfield1.getText().trim();//escribir instrucciones funcionalidad .trim nos permite cuando da espacios borra los espacios y los guarda dentro de nuestra variable texto
  	if(texto.equals("")){//verifica con el metodo lo que ahi en la variable vacia o llena
   	JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
   } else{
	Licencia ventanalicencia = new Licencia();
 	ventanalicencia.setBounds(0,0,600,360);
 	ventanalicencia.setVisible(true);
	ventanalicencia.setResizable(false);
	ventanalicencia.setLocationRelativeTo(null);
        this.setVisible(false);//se esconde la interfaz de bienvenida
   }
  }
 }
   public static void main(String args[]){
    Bienvenida ventanabienvenda = new Bienvenida();
    ventanabienvenda.setBounds(0,0,350,450);
    ventanabienvenda.setVisible(true);
    ventanabienvenda.setResizable(false);
    ventanabienvenda.setLocationRelativeTo(null);
 }
}

