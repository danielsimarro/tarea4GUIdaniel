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
            //Creamos un boton donde almacenaremo el objeto o el cual le realizaremos un casting
            JButton boton = (JButton) o;

            //Comprobamos con switch que boton se ha pulsado
            switch (boton.getText()) {
                case "0":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "1":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "2":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "3":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "4":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "5":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "6":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "7":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "8":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "9":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case ".":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "+":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "-":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "/":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "*":
                    areaTexto.setText(areaTexto.getText() + boton.getText());
                    break;
                case "=":

                    //En resultado se almacena la operacion resuelta que nos devuelve el metodo realizarOperacion
                    String resultado = realizarOperacion(areaTexto.getText());

                    //Mostramos ese resultado de la operacion en elñ area de texto de la calculadora
                    areaTexto.setText(resultado);

                    //Volvemos a habilitar los operadores
                    for (int i = 10; i < 14; i++) {
                        this.botonera.grupoBotones[i].setEnabled(true);
                    }

                    break;
                case "C":
                    //Cuando pulse sobre C se borra lo que hay en el area de texto
                    areaTexto.setText(" ");
                    break;
            }

            
            String ultimoCaracter = " ";
            String operador = " ";

            //Con esto lo que hacemos es gusradar cual a sido el ultimo caracter que a pulsado
            if (areaTexto.getText().length() == 1) {
                ultimoCaracter = areaTexto.getText();
            } else {
                ultimoCaracter = areaTexto.getText().substring(areaTexto.getText().length() - 1);
            }

            //Aqui comprobamos si el ultimo caracter es un operador y lo desabilitamos en tal caso
            if (ultimoCaracter.equals("+") || ultimoCaracter.equals("-") || ultimoCaracter.equals("/")
                    || ultimoCaracter.equals("*")) {
                for (int i = 10; i < 14; i++) {
                    this.botonera.grupoBotones[i].setEnabled(false);
                    operador = ultimoCaracter;
                }
            }
        }

    }

    //Metodo que realiza las operaciones que le pasamos como string
    private static String realizarOperacion(String operacion) {

        String operador = "";
        int posicion = 0;

        //Comprobamos si contiene un operador y lo almacenamos
        if (operacion.contains("+")) {
            operador = "+";
            posicion = operacion.indexOf("+");
        } else if (operacion.contains("-")) {
            operador = "-";
        } else if (operacion.contains("*")) {
            operador = "*";
            posicion = operacion.indexOf("*");
        } else if (operacion.contains("/")) {
            operador = "/";
        }

        String[] parts = new String[2];

        double resultadoFinalNumero = 0;

        double resultadoUno = 0;
        double resultadoDos = 0;

        //Se pude utilizar spliot en '/' y '-' en los demas se utilizan metodos aparte
        switch (operador) {
            case "+":

                resultadoUno = Double.parseDouble(primeraParte(operacion, posicion));
                resultadoDos = Double.parseDouble(segundaParte(operacion, posicion));

                resultadoFinalNumero = resultadoUno + resultadoDos;

                break;
            case "-":
                parts = operacion.split("-");

                resultadoUno = Double.parseDouble(parts[0]);
                resultadoDos = Double.parseDouble(parts[1]);

                resultadoFinalNumero = resultadoUno - resultadoDos;
                break;
            case "*":
                resultadoUno = Double.parseDouble(primeraParte(operacion, posicion));
                resultadoDos = Double.parseDouble(segundaParte(operacion, posicion));

                resultadoFinalNumero = resultadoUno * resultadoDos;
                break;
            case "/":
                parts = operacion.split("/");

                resultadoUno = Double.parseDouble(parts[0]);
                resultadoDos = Double.parseDouble(parts[1]);

                resultadoFinalNumero = resultadoUno / resultadoDos;
                break;
        }

        String resultadoFinal = operacion;

        //Con esto controlamos que si no se ha pulsado ningun operador devuelva el mismo String que hemos recibido
        if(operador!=""){
            resultadoFinal = Double.toString(resultadoFinalNumero);
        }
        
        return resultadoFinal;

    }

    //Estos metodos solo se utilizan en el '+' y '*' ta que el split nos los reconoce 
    //Metodo para obtener la parte de la izquierda de la operacion hasta el +
    private static String primeraParte(String parteUno, int posicion) {

        String valor = "";

        if (posicion == 1) {
            valor = parteUno.substring(0, 1);
        } else {
            valor = parteUno.substring(0, posicion);
        }
        return valor;
    }

    //Metodo para obtener la parte de la derecha de la operacion hasta el +
    private static String segundaParte(String parteDos, int posicion) {

        String valor = "";

        valor = parteDos.substring(posicion + 1, parteDos.length());

        return valor;
    }

}
