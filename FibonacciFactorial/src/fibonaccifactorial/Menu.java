/*
  * Código creado para calcular Fibonacci Y Factorial
  * Creado el 22/08/2017
  * http://coatl.cecyt9.ipn.mx/eoropezaWEB/home.html
*/
// Encontramos la carpeta en donde se localiza fibonaccifactorial

package fibonaccifactorial;
 
// Importamos todos los elementos necesarios
import java.awt.Font;
import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.*;

// Creamos la clase Menú implementando los importes.

public class Menu extends JFrame implements ActionListener {

    // Creamos Botones y Cajas de Texto
    private JRadioButton fibonacci;
    private JRadioButton factorial;
    private JLabel titulo;
    private JLabel instruccion;
    private JTextField numero;
    private JTextField resultado;

    //Configuramso la ventana
    public Menu() {
        configurarVentana();
        iniciarComponentes();
    }

    // Aquí comienza la configuración de la ventana
    private void configurarVentana() {
        setTitle("CALCULADORA: DECIMALES Y BINARIOS");
        setSize(650, 510);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(getClass().getResource("PICS/rascacielos.jpg")).getImage());
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon IMG = new ImageIcon(this.getClass().getResource("PICS/rascacielos.jpg"));
        JLabel PIC = new JLabel();
        PIC.setIcon(IMG);
        getLayeredPane().add(PIC, JLayeredPane.FRAME_CONTENT_LAYER);
        PIC.setBounds(0, 0, 800, 600);
    }

    // Inicializamos los botones y cajas de textos, ademas de darles propiedades.
    private void iniciarComponentes() {
        titulo = new JLabel(" ¡ HOLA BIENVENIDO !");
        titulo.setBounds(230, 40, 200, 40);
        titulo.setFont(new Font("TimesRoman", Font.BOLD, 18));
        add(titulo);

        instruccion = new JLabel("SELECCIONA LA OPCION QUE QUIERAS REALIZAR");
        instruccion.setBounds(180, 90, 450, 40);
        instruccion.setFont(new Font("TimesRoman", Font.BOLD, 12));
        add(instruccion);

        numero = new JTextField();
        numero.setBounds(250, 150, 150, 30);
        numero.setFont(new Font("TimesRoman", Font.BOLD, 12));
        numero.addKeyListener(new KeyAdapter() {
           
       // Validamos para que no se puedan escribir letras o signos.
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume(); // ignorar el evento de teclado
                }
            }
        });
        add(numero);
        
        instruccion = new JLabel("RESULTADO");
        instruccion.setBounds(290, 250, 150, 30);
        instruccion.setFont(new Font("TimesRoman", Font.BOLD, 12));
        add(instruccion);
        
        resultado = new JTextField();
        resultado.setBounds(250, 280, 150, 30);
        resultado.setFont(new Font("TimesRoman", Font.BOLD, 12));
        add(resultado);
        
        fibonacci = new JRadioButton("FIBONACCI");
        fibonacci.setBounds(100, 350, 200, 50);
        add(fibonacci);
        fibonacci.addActionListener(this);
        
        factorial = new JRadioButton("FACTORIAL");
        factorial.setBounds(350, 350, 200, 50);
        add(factorial);
        factorial.addActionListener(this);
    }
    // Cierre de la creación de botones y cajas de texto
    // Comenzamos a calcular el fibonacci
    // Opcion uno fibonacci
    // Opcion dos factorial
    @Override
    public void actionPerformed(ActionEvent e) {
        int num;
        int fibo1=1;
        int fibo2=1; 
        int i;
        String total;
        long factor =1L;
        if(fibonacci.isSelected()==true)
        {
            num = Integer.parseInt(numero.getText());
            for(i=2;i<=num;i++){
             fibo2 = fibo1 + fibo2;
             fibo1 = fibo2 - fibo1;
             }
            total = String.valueOf(fibo1);
            resultado.setText(total);
        } else if(factorial.isSelected()==true)
        {
           num = Integer.parseInt(numero.getText());
           for(i=num;i>0;i--) {
	   factor=factor*i;
	   }
           total = String.valueOf(factor);
           resultado.setText(total);
        }
    }
    // Cierre del actionPerformed

}
//Cierre de la clase
