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

                    String resultado = realizarOperacion(areaTexto.getText());

                    areaTexto.setText(resultado);

                    //Volvemos a habilitar las los operadores
                    for (int i = 10; i < 14; i++) {
                        this.botonera.grupoBotones[i].setEnabled(true);
                    }

                    break;
                case "C":
                    areaTexto.setText(" ");
                    break;
            }

            String ultimoCaracter = " ";
            String operador = " ";

            if (areaTexto.getText().length() == 1) {
                ultimoCaracter = areaTexto.getText();
            } else {
                ultimoCaracter = areaTexto.getText().substring(areaTexto.getText().length() - 1);
            }

            if (ultimoCaracter.equals("+") || ultimoCaracter.equals("-") || ultimoCaracter.equals("/")
                    || ultimoCaracter.equals("*")) {
                for (int i = 10; i < 14; i++) {
                    this.botonera.grupoBotones[i].setEnabled(false);
                    operador = ultimoCaracter;
                }
            }
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
        // Desabilitar botones setEnable (false)
    }

    private static String realizarOperacion(String operacion) {

        String operador = "";
        int posicion = 0;

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

        String resultadoFinal = Double.toString(resultadoFinalNumero);

        return resultadoFinal;

    }

    //Metodo para obtener la parte de la izquierda de la operacion hasta el +
    private static String primeraParte(String parteUno, int posicion) {

        String valor = "";

        if (posicion == 1) {
            valor = parteUno.substring(0,1);
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

    public static void main(String[] args) {
        String resultado = realizarOperacion("10+1");

        System.out.println(resultado);

        String string = "123-654321";
        String[] parts = string.split("-");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321

        System.out.println(part1);
    }
}
