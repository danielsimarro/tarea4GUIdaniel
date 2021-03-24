/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author NitroPc
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Juan Carlos Fernández Vico
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón 
        if (o instanceof JButton) {
//            System.out.println(((JButton) o).getText());
            JButton boton = (JButton) o;
            areaTexto.setText(((JButton) o).getText());

            String resultado = "";

            switch (boton.getText()) {
                case "0":
                    resultado+="0";
                    break;
                case "1":
                    resultado+="1";
                    break;
                case "2":
                    resultado+="2";
                    break;
                case "3":
                    resultado+="3";
                    break;
                case "4":
                    resultado+="4";
                    break;
                case "5":
                    resultado+="5";
                    break;
                case "6":
                    resultado+="6";
                    break;
                case "7":
                    resultado+="7";
                    break;
                case "8":
                    resultado+="8";
                    break;
                case "9":
                    resultado+="9";
                    break;
                case "+":
                    resultado+="+";
                    break;
                case "-":
                    resultado+="-";
                    break;
                case "/":
                    resultado+="/";
                    break;
                case "*":
                    resultado+="*";
                    break;
                case "=":
                    
                areaTexto.setText(resultado);
                    
                    break;
                case "C":
                    resultado+="C";
                    resultado = "0";
                    break;
            }
            
            String ultimoCaracter = "";
            String operador = "";
            
            if(resultado.length()== 1){
                ultimoCaracter = resultado;
            }else{
                ultimoCaracter=resultado.substring(resultado.length()-1);
            }
            
            if(ultimoCaracter.equals("+")|| ultimoCaracter.equals("-")||ultimoCaracter.equals("/")||
                    ultimoCaracter.equals("*")){
                for(int i =10; i<14;i++){
                    this.botonera.grupoBotones[i].setEnabled(false);
                    operador = ultimoCaracter;
                }
            }
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
        // Desabilitar botones setEnable (false)
    }

}
