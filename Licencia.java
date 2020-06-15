import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{
  
  private JLabel label1, label2;
  private JCheckBox check1;
  private JButton boton1, boton2;
  private JScrollPane scrollpane1;
  private JTextArea textarea1;
  String nombre = "";//crear nueva variable desde bienvenida

  public Licencia(){
 	setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//los programas no queden en segundo plano
	setTitle("licencia de uso");
	setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
 	Bienvenida ventanaBienvenida = new Bienvenida();//recuperar valor de una variable que esta en otra clase creando  un objeto
	nombre = ventanaBienvenida.texto;//ya tenemos en valor en la clase bienvenida utilizandola en la clase licencia


  label1 = new JLabel("TERMINOS Y CONDICIONES");//titulo
  label1.setBounds(215,5,200,30);
  label1.setFont(new Font("Andale Mono", 1, 14));
  label1.setForeground(new Color(0,0,0));
  add(label1);

  textarea1 = new JTextArea();//contener texto trabajando en conjunto el scrollpane adapatandose a el mismo
  textarea1.setEditable(false);//valor boleano
  textarea1.setFont(new Font("Andale Mono", 0, 9));
  textarea1.setText("\n\n          TERMINOS Y CONDICIONES" + 
  "\n\n          A.  PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE LA GEEKIPEDIA DE HERNESTO." + 
  "\n\n          B. PROHIBIDA LA ALTERACION DEL CODIGO." + 
  "\n\n          C. LA GEEKIPEDIA DE HERNESTO NO SE HACE RESPONSABLE DEL MAL USO QUE SE LE DE A US CODIGO" + 
  "\n\n          HAGA CON ESTE SOFWARE Y SUS SERVIVCIOS. PARA ACEPTAR LOS TERMINOS Y CONDICIONES" + 
  "\n\n          PARA MAYOR INFORMACION COMUNIQUESE CON NUESTRO OPERADOR LA GEEKIPEDIA DE HERNESTO" + 
  "\n\n          http://www.youtube.com/ernestoperezm");
  scrollpane1 = new JScrollPane(textarea1);
  scrollpane1.setBounds(10,40,575,200);
  add(scrollpane1);

  check1 = new JCheckBox("Yo " + nombre + " Acepto");
  check1.setBounds(10,250,300,30);
  check1.addChangeListener(this);//agrego evento este
  add(check1);

  boton1 = new JButton("Continuar");
  boton1.setBounds(10,290,100,30);
  boton1.addActionListener(this);//evento
  boton1.setEnabled(false);//no va a estar activo el boton1
  add(boton1);
  

  boton2 = new JButton("No acepto");
  boton2.setBounds(120,290,100,30);
  boton2.addActionListener(this);//evento
  boton1.setEnabled(true);//si esta activo
  add(boton2);

  ImageIcon imagen = new ImageIcon("images/coca-cola.png");//agregar imagen
  label2 = new JLabel(imagen);//agrege como un objeto la imagen
  label2.setBounds(315,135,300,300);
  add(label2);
 }

  public void stateChanged(ChangeEvent e){//agregar evento ayuda a controlar eventos JCKECKBOX
	if(check1.isSelected() == true){
		boton1.setEnabled(true);
		boton2.setEnabled(false);
       }else{
		boton1.setEnabled(false);
		boton2.setEnabled(true);		
 }
}

  public void actionPerformed(ActionEvent e){//agregar evento
       if(e.getSource() == boton1){//enlazar interfaz principal
	Principal ventanaPrincipal = new Principal();
 	ventanaPrincipal.setBounds(0,0,640,535);
	ventanaPrincipal.setVisible(true);
	ventanaPrincipal.setResizable(false);
 	ventanaPrincipal.setLocationRelativeTo(null);
  	this.setVisible(false);
       }else if(e.getSource() == boton2){
	    Bienvenida ventanabienvenda = new Bienvenida();
            ventanabienvenda.setBounds(0,0,350,450);
            ventanabienvenda.setVisible(true);
            ventanabienvenda.setResizable(false);
            ventanabienvenda.setLocationRelativeTo(null);
	    this.setVisible(false);//boleano
 }
}

  public static void main(String args[]){
	Licencia ventanalicencia = new Licencia();
 	ventanalicencia.setBounds(0,0,600,360);
 	ventanalicencia.setVisible(true);
	ventanalicencia.setResizable(false);
	ventanalicencia.setLocationRelativeTo(null);
 }
}