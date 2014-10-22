/*
 CD o DVD 
  - codigo(s) fuente(s)
  - PDF de manual explicando el
    desarrollo, pantallas, curiosidad y 
    sobre todo el modelo matematico generado
 
 - Compilador en el que lo desarrollaron
   (para instalarse) 64 y 32 bits
 
 */

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.math.*;
import java.text.DecimalFormat;

public class Main extends JFrame implements ActionListener, ItemListener{
    
    
    /*Se declaran publicos los elementos que se van a utilizar en la interfaz*/
    JLabel FondoMenu = new JLabel( new ImageIcon( "imagenes/fondo.png" ) );
    JLabel FondoAcerca = new JLabel( new ImageIcon( "imagenes/fondoabout.png" ) );
    JLabel FondoConsumo = new JLabel( new ImageIcon( "imagenes/fondoCuestionario.png" ) );
    JButton principal, salir, about, regresar, regresarM, calcularM, limpiarM ;
    JTextField campoWc, campoLavadora, campoDucha, campoDuchaVeces,campoCubeta, campoPlanta;
    JTextField campoTrapear, campoManos,campoManosVeces, campoDientes, campoDientesVeces;
    JTextField campoTinaco, campoTinacoCapacidad, campoAljibe, campoAljibeCapacidad;
    JComboBox combo, contratoTipo, cobroTipo,capLavadora;
    String failDigitos="",failValores="";boolean tocadoDigitos=false, tocadoValores=false;
    
  
  /*Variables para hacer operaciones con los datos de los textfields*/  
    boolean toogle; double total=0; double totalDiario=0;
    double wc, lavadora, ducha, duchaVeces,cubeta,planta=0;
    double trapear,manos,manosVeces,dientes,dientesVeces,capacidadWc=6;
    double tinaco,tinacoCapacidad, aljibe,aljibeCapacidad,capacidadLavadora=20;
    double tarifaMedidor=0, tarifaContrato, totalCubicos=0;
    
    
    
    
    /*Metodo contructor para declarar los componentes*/
    public Main()
    {
        initComponents();
        
        FondoMenu.reshape( 0, 0, 600, 600 );
        add( FondoMenu );
        
        FondoAcerca.reshape( 0, 0, 600, 700 );
        FondoAcerca.setVisible(false);
        add( FondoAcerca );
        
        FondoConsumo.reshape( 0, 0, 1400, 690 );
        FondoConsumo.setVisible(false);
        add( FondoConsumo );
        
        setLayout(null);
        setSize(500,500);
        setVisible( true );
        setResizable(true);
        setLocationRelativeTo( null );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        
    }
    
    
    /*Metodo para declarar los elemntos de interfaces*/
    public void initComponents(){
        
        /*Agregamos los botones del menu principal*/
        
        principal= new JButton("");
      principal.setIcon(new ImageIcon( "imagenes/consumo.png" ) );
      principal.setVisible(true);
      principal.reshape(110,160,250,45);
        principal.addActionListener(this);
      add(principal);
        
        about= new JButton("");
      about.setIcon(new ImageIcon( "imagenes/about.png" ) );
      about.setVisible(true);
      about.reshape(110,260,250,45);
        about.addActionListener(this);
      add(about);
        
        regresar= new JButton("");
      regresar.setIcon(new ImageIcon( "imagenes/getback.png" ) );
      regresar.setVisible(false);
      regresar.reshape(110,590,250,45);
        regresar.addActionListener(this);
      add(regresar);
        
        salir= new JButton("");
      salir.setIcon(new ImageIcon( "imagenes/salir.png" ) );
      salir.setVisible(true);
      salir.reshape(110,360,250,45);
        salir.addActionListener(this);
      add(salir);
        
        
        
        /*Agregamos los campos para indtroducir las variables*/
        
        campoWc = new JTextField();
      campoWc.reshape(289,128,115,20);
        campoWc.setVisible(false);
      add(campoWc);
        
        campoLavadora = new JTextField();
      campoLavadora.reshape(285,203,115,20);
        campoLavadora.setVisible(false);
      add(campoLavadora);     
        
        campoDucha = new JTextField();
      campoDucha.reshape(285,273,115,20);
        campoDucha.setVisible(false);
      add(campoDucha);  
        
        campoDuchaVeces = new JTextField();
      campoDuchaVeces.reshape(560,273,130,20);
        campoDuchaVeces.setVisible(false);
      add(campoDuchaVeces);   
        
        
        campoTrapear = new JTextField();
      campoTrapear.reshape(285,344,115,20);
        campoTrapear.setVisible(false);
      add(campoTrapear);      
        
        campoCubeta = new JTextField();
      campoCubeta.reshape(620,344,115,20);
        campoCubeta.setVisible(true);
      add(campoCubeta); 
        
        campoManos = new JTextField();
      campoManos.reshape(285,409,115,20);
        campoManos.setVisible(false);
      add(campoManos);
        
        campoManosVeces = new JTextField();
      campoManosVeces.reshape(560,409,115,20);
        campoManosVeces.setVisible(false);
      add(campoManosVeces);
        
        campoDientes = new JTextField();
      campoDientes.reshape(285,482,115,20);
        campoDientes.setVisible(false);
      add(campoDientes);
        
        campoDientesVeces = new JTextField();
      campoDientesVeces.reshape(560,482,115,20);
        campoDientesVeces.setVisible(false);
      add(campoDientesVeces);
        
        campoTinaco = new JTextField();
      campoTinaco.reshape(285,560,115,20);
        campoTinaco.setVisible(false);
      add(campoTinaco);
        
        campoTinacoCapacidad = new JTextField();
      campoTinacoCapacidad.reshape(550,560,115,20);
        campoTinacoCapacidad.setVisible(false);
      add(campoTinacoCapacidad);
        
        campoAljibe = new JTextField();
      campoAljibe.reshape(285,630,115,20);
        campoAljibe.setVisible(false);
      add(campoAljibe);
        
        
        campoPlanta = new JTextField();
      campoPlanta.reshape(1100,430,115,20);
        campoPlanta.setVisible(true);
      add(campoPlanta); 
        
        
        campoAljibeCapacidad = new JTextField();
      campoAljibeCapacidad.reshape(550,630,115,20);
        campoAljibeCapacidad.setVisible(false);
      add(campoAljibeCapacidad);
        
        
        
        /*Botones de la parte de calcular el consumo de agua*/
        regresarM= new JButton("");
      regresarM.setIcon(new ImageIcon( "imagenes/regresarM.png" ) );
      regresarM.setVisible(true);
      regresarM.reshape(1000,125,250,45);
        regresarM.addActionListener(this);
      add(regresarM);
        
        calcularM= new JButton("");
      calcularM.setIcon(new ImageIcon( "imagenes/calcularM.png" ) );
      calcularM.setVisible(true);
      calcularM.reshape(1000,195,250,45);
        calcularM.addActionListener(this);
      add(calcularM);
        
        limpiarM= new JButton("");
      limpiarM.setIcon(new ImageIcon( "imagenes/limpiarM.png" ) );
      limpiarM.setVisible(true);
      limpiarM.reshape(1000,265,250,45);
        limpiarM.addActionListener(this);
      add(limpiarM);
        
        
        
        
        /*Combo box para el baño*/
        
        combo=new JComboBox();
        combo.setBounds(580,130,80,20);
        combo.setVisible(false);
        add(combo);
        
        combo.addItem("6 Litros");
        combo.addItem("7 Litros");
        combo.addItem("8 Litros");
        combo.addItem("9 Litros");
        combo.addItem("10 Litros");
        combo.addItem("11 Litros");
        combo.addItem("12 Litros");
        combo.addItem("13 Litros");
        
        combo.addItemListener(this);
        
        
        cobroTipo=new JComboBox();
        cobroTipo.setBounds(1115,540,80,20);
        cobroTipo.setVisible(true);
        add(cobroTipo);
        
        cobroTipo.addItem("Contrato");
        cobroTipo.addItem("Medidor");
        cobroTipo.addItemListener(this);
        
        contratoTipo=new JComboBox();
        contratoTipo.setBounds(1115,615,170,20);
        contratoTipo.setVisible(true);
        add(contratoTipo);
        
        contratoTipo.addItem("Domestico popular 1");
        contratoTipo.addItem("Domestico popular 2");
        contratoTipo.addItem("Domestico media");
        contratoTipo.addItem("Domestico residencial");
        contratoTipo.addItemListener(this);
        
        
        capLavadora=new JComboBox();
        capLavadora.setBounds(630,200,80,20);
        capLavadora.setVisible(true);
        add(capLavadora);
        
        capLavadora.addItem("20 Litros");
        capLavadora.addItem("25 Litros");
        capLavadora.addItem("30 Litros");
        capLavadora.addItem("35 Litros");
        capLavadora.addItemListener(this);
        
  
}
    
    /*Meodo utilizado para limpiar todos los text fields de la interfaz*/
    public void limpiar()
    {
        
        campoWc.setText("");
        campoLavadora.setText("");  
        campoDucha.setText("");      
        campoDuchaVeces.setText(""); 
        campoTrapear.setText("");     
        campoManos.setText("");     
        campoManosVeces.setText("");     
        campoDientes.setText(""); 
        campoDientesVeces.setText(""); 
        campoTinaco.setText("");   
        campoTinacoCapacidad.setText("");     
        campoAljibe.setText("");     
        campoAljibeCapacidad.setText("");
        campoPlanta.setText("");
        campoCubeta.setText("");
        
    }
    
    
    /*Metodo utilizado para hacer aparecer y desaparecer elmentos de la parte de calcular el consumo de agua*/
    public void toogleCampos()
    {
        if(campoWc.isVisible()==true)
        {
            toogle=false;
        }
        if(campoWc.isVisible()==false)
        {
            toogle=true; 
        }
        campoWc.setVisible(toogle); 
        campoLavadora.setVisible(toogle);   
        campoDucha.setVisible(toogle);       
        campoDuchaVeces.setVisible(toogle);    
        campoTrapear.setVisible(toogle);     
        campoManos.setVisible(toogle);       
        campoManosVeces.setVisible(toogle);     
        campoDientes.setVisible(toogle);       
        campoDientesVeces.setVisible(toogle);  
        campoTinaco.setVisible(toogle);       
        campoTinacoCapacidad.setVisible(toogle);   
        campoPlanta.setVisible(toogle);
        campoCubeta.setVisible(toogle);
        campoAljibe.setVisible(toogle);     
        campoAljibeCapacidad.setVisible(toogle);
        combo.setVisible(toogle);
        cobroTipo.setVisible(toogle);
        contratoTipo.setVisible(toogle);
        
        
        limpiarM.setVisible(toogle);
        regresarM.setVisible(toogle);
        calcularM.setVisible(toogle);
    }
    
    
    /*Metodo para hacer visible el fondo de la parte de consumo de agua*/
    public void medotoConsumo()
    {
        FondoConsumo.setVisible(true);
        setSize(1350,700);
        
    }
    
    
    /*Metodo para hacer visible los elementos del menu principal*/
    public void acercaDe()
    {
        FondoAcerca.setVisible(true);
        regresar.setVisible(true);
        setSize(480,750);
    }
    
    
    /*Metodo para esconder los elementos del menu principal*/
    public void hideAll()
    {
        principal.setVisible(false);
        about.setVisible(false);
        salir.setVisible(false);
        FondoMenu.setVisible(false);
    }
    
    
    /*Metodo para regresar al menu principal desde la parte de informacion*/
    public void getBack()
    {
        FondoAcerca.setVisible(false);
        regresar.setVisible(false);
        setSize(500,500);
        
        principal.setVisible(true);
        about.setVisible(true);
        salir.setVisible(true);
        FondoMenu.setVisible(true);
    }
    
    /*Metodo escucha para los elementos del teclado*/
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==salir)
        {
            System.exit(0);
        }
        
        if(ae.getSource()==about)
        {
            hideAll();
            acercaDe();
        }
        
        if(ae.getSource()==regresar)
        {
            getBack();
        }
        
        if(ae.getSource()==principal)
        {
            hideAll();
            medotoConsumo();
            toogleCampos();
            
        }
        
        if(ae.getSource()==regresarM)
        {
            getBack();
            toogleCampos();
        }
        
        if(ae.getSource()==limpiarM)
        {
            limpiar();
        }
        
        if(ae.getSource()==calcularM)
        {
            evaluar();
        }
        
      
    }
    
    /*Metodo escucha de los comboboxes*/
    
    public void itemStateChanged(ItemEvent ie) {
        
        /*metodo escucha para el combobox de el WC*/
        if(ie.getSource()==combo)
        {
            String seleccionado=(String)combo.getSelectedItem();
            
            if(seleccionado.equals("6 Litros"))
            {
                capacidadWc = 6;
            }
            if(seleccionado.equals("7 Litros"))
            {
                capacidadWc = 7;
            }
            if(seleccionado.equals("8 Litros"))
            {
                capacidadWc = 8;
            }
            if(seleccionado.equals("9 Litros"))
            {
                capacidadWc = 9;
            }
            if(seleccionado.equals("10 Litros"))
            {
                capacidadWc = 10;
            }
            if(seleccionado.equals("11 Litros"))
            {
                capacidadWc = 11;
            }
            if(seleccionado.equals("12 Litros"))
            {
                capacidadWc = 12;
                
            }
             if(seleccionado.equals("13 Litros"))
            {
                capacidadWc = 13;
                
            }
        }
        
        
        /*Metodo escucha para el combobox de tipo de contrato */
        if(ie.getSource()==contratoTipo)
        {
             String seleccionContrato=(String)contratoTipo.getSelectedItem();
            
            if(seleccionContrato.equals("Domestico popular 1"))
            {
                if(total>30000)
                {
                    tarifaMedidor=4.48;
                }
                if(total<=30000)
                {
                    tarifaMedidor=3.53;
                }
                tarifaContrato=48.84;
            }
            if(seleccionContrato.equals("Domestico popular 2"))
            {
                 if(total>30000)
                {
                    tarifaMedidor=3.70;
                }
                if(total<=30000)
                {
                    tarifaMedidor=2.75;
                }
                tarifaContrato=34.15;
            }
            if(seleccionContrato.equals("Domestico media"))
            {
                if(total>30000)
                {
                    tarifaMedidor=4.48;
                }
                if(total<=30000)
                {
                    tarifaMedidor=3.53;
                }
                tarifaContrato=75.13;
            }
            if(seleccionContrato.equals("Domestico residencial"))
            {
                if(total>30000)
                {
                    tarifaMedidor=5.27;
                }
                if(total<=30000)
                {
                    tarifaMedidor=4.32;
                }
                
                tarifaContrato=101.43;
            }

        }
        
        if(ie.getSource()==capLavadora)
        {
            String seleccionLavadora=(String)capLavadora.getSelectedItem();
            
            if(seleccionLavadora.equals("20 Litros"))
            {
                capacidadLavadora = 20;
            }
            if(seleccionLavadora.equals("25 Litros"))
            {
                capacidadLavadora = 25;
            }
            if(seleccionLavadora.equals("30 Litros"))
            {
                capacidadLavadora = 30;
            }
            if(seleccionLavadora.equals("35 Litros"))
            {
                capacidadLavadora = 35;
            }
        }
    
    }
    

    /*Metodo  para comprobar si un valor es un numero*/
   public static boolean isNumeric(String a)
   {
        try{
            Integer.parseInt(a);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }

   }

   
   /*Metodo para comprobar si un numero es flotante*/
    public static boolean isFloat(String x)     
    {
        try{
            Float.parseFloat(x);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    
    public void evaluar()
    {
        failDigitos = "\nErrores de entrada\n";
        tocadoDigitos = false;
        
        failValores = "\nErrores de entrada\n";
        tocadoValores = false;
        
        /*Seccion utilizada para evaluar */
       if(isNumeric(campoPlanta.getText())==false)
       {
           failDigitos = "Minutos con la llave abierta al regar las plantas: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoCubeta.getText())==false)
       {
           failDigitos += "Capacidad de la cubeta: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       
       if(isNumeric(campoWc.getText())==false)
       {
           failDigitos +="Veces que utilizas el WC: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoLavadora.getText())==false)
       {
           failDigitos += "Cargas de lavadora semanales: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoDucha.getText())==false)
       {
           failDigitos += "Minutos que tardas en la ducha: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoDuchaVeces.getText())==false)
       {
           failDigitos += "Minutos que tardas en la ducha, veces: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoTrapear.getText())==false)
       {
           failDigitos += "Veces que trapeas tu casa: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoManos.getText())==false)
       {
           failDigitos += "Segundos que tardas lavandote las manos: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoManosVeces.getText())==false)
       {
           failDigitos += "Segundos que tardas lavandote las manos, veces: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoDientes.getText())==false)
       {
           failDigitos += "Segundos que tardas lavandote los dientes: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoDientesVeces.getText())==false)
       {
           failDigitos += "Segundos que tardas lavandote los dientes, veces: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoTinaco.getText())==false)
       {
           failDigitos += "Cuantos tinacos tienes: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoTinacoCapacidad.getText())==false)
       {
           failDigitos += "Cuantos tinacos tienes, capacidad: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoAljibe.getText())==false)
       {
           failDigitos += "Cuantos aljibes tienes: El caracter no es numerico\n";
           tocadoDigitos = true;
       }
       if(isNumeric(campoAljibeCapacidad.getText())==false)
       {
           failDigitos += "Cuantos aljibes tienes, capacidad: El caracter no es numerico\n";
           tocadoDigitos = true;
       }

       
       
       if(tocadoDigitos==true)
       {
           JOptionPane.showMessageDialog(null,failDigitos,"Error- Revise sus datos",JOptionPane.ERROR_MESSAGE);
       }
       else{
           wc = Double.parseDouble(campoWc.getText());
           lavadora = Double.parseDouble(campoLavadora.getText());
           ducha = Double.parseDouble(campoDucha.getText());
           duchaVeces = Double.parseDouble(campoDuchaVeces.getText());
           trapear = Double.parseDouble(campoTrapear.getText());
           cubeta = Double.parseDouble(campoCubeta.getText());
           manos = Double.parseDouble(campoManos.getText());
           manosVeces = Double.parseDouble(campoManosVeces.getText());
           dientes = Double.parseDouble(campoDientes.getText());
           dientesVeces = Double.parseDouble(campoDientesVeces.getText());
           tinaco = Double.parseDouble(campoTinaco.getText());
           tinacoCapacidad = Double.parseDouble(campoTinacoCapacidad.getText());
           aljibe = Double.parseDouble(campoAljibe.getText());
           aljibeCapacidad = Double.parseDouble(campoAljibeCapacidad.getText());
           planta = Double.parseDouble(campoPlanta.getText());
           
           /*Seccion utilizada para saber valores fuera de rangos*/
       
        if((dientes * dientesVeces)>86400)
        {
                failValores += "Los segundos que tardas lavandote los dientes es mayor a los de un dia\n";
                tocadoValores = true;
        }
        if((manos * manosVeces)>86400)
        {
               failValores += "Los segundos que tardas lavandote las manos es mayor a los de un dia\n";
               tocadoValores = true;
        }
        if((ducha * duchaVeces)>1440)
        {
                failValores += "Los minutos bañandote superan a los de un dia\n";
                tocadoValores = true;
        }
            
        if(planta<0)
        {
               failValores += "Minutos con la llave encendida al regar plantas: Numero negativo\n";
               tocadoValores = true;
        }
        if(planta>1440)
        {
                failValores += "Los minutos regando plantas superan a los de un dia\n";
                tocadoValores = true;
                
        }
        if(cubeta<0)
        {
                 failValores += "Capacidad de la cubeta: Numero negativo\n";
                 tocadoValores = true;
        }
        if(duchaVeces<0)
        {
                failValores += "Minutos que tardas en la ducha, veces al dia: Numero negativo\n";
                tocadoValores = true;
        }
        if(ducha<0)
        {
                failValores += "Minutos que tardas en la ducha: Numero negativo\n";
                tocadoValores = true;
        }
            
        if(lavadora<0)
        {
               failValores += "Cargas de lavadora semanales: Numero negativo\n";
               tocadoValores = true;
        }
        if(wc<0)
        {
              failValores += "Veces que utilizas el WC: Numero negativo\n";
              tocadoValores = true;
        }
        if(dientesVeces<0)
        {
               failValores += "Segundos que tardas lavandote los dientes, veces al dia: Numero negativo\n";
               tocadoValores = true;
        }
        if(dientes<0)
        {
               failValores += "Segundos que tardas lavandote los dientes: Numero negativo\n";
               tocadoValores = true;

        }
        if(manosVeces<0)
        {
                failValores += "Segundos que tardas lavandote las manos, veces: Numero negativo\n";
                tocadoValores = true;
        }
        if(manos<0)
        {
                  failValores += "Segundos que tardas lavandote las manos: Numero negativo\n";
                  tocadoValores = true;
        }
        if(trapear<0)
        {
              failValores += "Veces que trapeas tu casa: Numero negativo\n";
              tocadoValores = true;
        }
        if(tinaco<0)
        {
               failValores += "Cuantos tinacos tienes: Numero negativo\n";
               tocadoValores = true;
        }
        if(tinacoCapacidad<0)
        {
              failValores += "Cuantos tinacos tienes, capacidad: Numero negativo\n";
              tocadoValores = true;
        }
        if(aljibe<0)
        {   
              failValores += "Cuantos aljibes tienes: Numero negativo\n";
              tocadoValores = true;
        }
        if(aljibeCapacidad<0)
        {
               failValores += "Cuantos aljibes tienes, capacidad: Numero negativo\n";
               tocadoValores = true;
               
        }
        
        
        if(tocadoValores == true)
        {
            JOptionPane.showMessageDialog(null,failValores,"Error- Revise sus datos",JOptionPane.ERROR_MESSAGE);
        }
        if(tocadoValores == false)
        {
            calcular();
        }
        
       }
       
       

           
       
       
       
       
       
       
       
        
    }
    
    public void calcular()
    {
        
        total += (wc * capacidadWc) * 30; /*Veces que utilizaes el WC en litros*/
        total += (lavadora * capacidadLavadora) * 4;/*cargas de lavadora a la semana*/
        total += ((ducha * 15) * duchaVeces) * 30;/*Litros en minutos que tardas en la ducha*/
        total += (trapear* cubeta) * 30;/*Litros gastados al trapear casa vecesXlitros*/
        total += ((manos * 0.25) * manosVeces) * 30;
        total += ((dientes * 0.25) * dientesVeces) * 30; 
        total += planta * 15 * 30;
        
        total += tinaco * tinacoCapacidad *30;
        total += aljibeCapacidad * aljibe *30;
        
        tarifacion();
        
        String seleccionCobro=(String)cobroTipo.getSelectedItem();
        String seleccionContrato=(String)contratoTipo.getSelectedItem();
        
        totalCubicos = total * 0.0010000;
        DecimalFormat df=new DecimalFormat("0.00");
        String formate = df.format((totalCubicos * tarifaMedidor));
        JOptionPane.showMessageDialog(null,"Litros mensualmente: "+total+"\n"+
                "Tipo de cobro: "+seleccionCobro+"\n"+
                "Tipo de contrato: "+seleccionContrato+"\n"+
                "Tarifa con contrato: $"+tarifaContrato+"\n"+
                "Tarifa con medidor: $"+tarifaMedidor+"\n"+
                "-------------------------------------\n"+
                "Total con contrato: $"+tarifaContrato+"\n"+
                "Total con medidor: $"+formate,"Total - Consumo de agua mensual",JOptionPane.PLAIN_MESSAGE);
      
    }
    
    public void tarifacion()
    {
          String seleccionContrato=(String)contratoTipo.getSelectedItem();
            
            if(seleccionContrato.equals("Domestico popular 1"))
            {
                if(total>30000)
                {
                    tarifaMedidor=4.48;
                }
                if(total<=30000)
                {
                    tarifaMedidor=3.53;
                }
                tarifaContrato=48.84;
            }
            if(seleccionContrato.equals("Domestico popular 2"))
            {
                 if(total>30000)
                {
                    tarifaMedidor=3.70;
                }
                if(total<=30000)
                {
                    tarifaMedidor=2.75;
                }
                tarifaContrato=34.15;
            }
            if(seleccionContrato.equals("Domestico media"))
            {
                if(total>30000)
                {
                    tarifaMedidor=4.48;
                }
                if(total<=30000)
                {
                    tarifaMedidor=3.53;
                }
                tarifaContrato=75.13;
            }
            if(seleccionContrato.equals("Domestico residencial"))
            {
                if(total>30000)
                {
                    tarifaMedidor=5.27;
                }
                if(total<=30000)
                {
                    tarifaMedidor=4.32;
                }
                
                tarifaContrato=101.43;
            }
    }
    
    
     /*Metodo main para inicializar el programa*/
    public static void main(String [] args)
    {
        Main inicializar = new Main();
    }
    
      
}
