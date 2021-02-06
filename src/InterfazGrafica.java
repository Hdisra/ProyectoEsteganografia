import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Proyecto 03 del curso de ICC
 * Clase que crea la interfaz gráfica 
 * @author Israel Hernández Dorantes - 318206604
 * @version 1.0 Enero 2021
 */
public class InterfazGrafica extends JFrame {

    /** El panel a agregar los componentes */
    private JPanel panel;

    /** Para poder acceder a lo que escribe el usuario */
    JTextField areaTexto, areaTexto2, nombreTexto;

    /** Los botones de las opciones */
    JRadioButton cifradoNulo, nombreOculto, marcadoParabras, marcadoLetras;

    /** El botón de activación */
    JButton boton;

    /** La etiqueta que muestra el resultado de las opciones */
    JLabel resultado;

    /** Almacena el mensaje generado */
    String message;


    /**
     * Crea una ventana
     */
    public void creaVentana(){

        //Propiedades de la ventana
        this.setSize(650, 650);
        this.setTitle("Esteganografía de Archivos");
        this.setMinimumSize(new Dimension(400 , 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setBackground(Color.lightGray);
        this.initComponents();

    }

    /**
     * Inicializa los componentes 
     */
    public void initComponents(){

        //Manda a llamar a los métodos que crean los componentes
        this.creaPanel();
        this.crearEtiqueta1();
        this.crearEtiqueta2();
        this.crearEtiqueta3();
        this.crearEtiquetaNombre();
        this.crearEtiquetaResultado();
        this.crearZonaDeTexto();
        this.crearZonaDeTexto2();
        this.crearZonaDeTextoNombre();
        this.crearRadioBotones();
        this.crearBoton();
    }

    /**
     * Crea un panel donde poner los elementos
     */
    public void creaPanel(){

        panel = new JPanel();

        //Para mover los componentes dentro del panel
        panel.setLayout(null);
        panel.setForeground(Color.DARK_GRAY);
        //Agregar el panel a la ventana
        this.getContentPane().add(panel);
    }

    /**
     * Crea la etiqueta de "Escoga una opción"
     */
    public void crearEtiqueta1(){

        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(30, 30, 400, 40);
        etiqueta.setText("Escoga una opción");
        etiqueta.setForeground(Color.darkGray);
        etiqueta.setFont(new Font("courier new", 3, 23));
        panel.add(etiqueta);
        
    }

    /**
     * Crea la etiqueta de escribir la ruta
     */
    public void crearEtiqueta2(){

        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(30, 70, 450, 40);
        etiqueta.setText("Escribe la ruta del archivo:");
        etiqueta.setFont(new Font("courier new", 3, 16));
        panel.add(etiqueta);
        
    }

    /**
     * Crea la etiqueta para señalar al usuario que escriba otra ruta
     */
    public void crearEtiqueta3(){

        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(30, 130, 450, 40);
        etiqueta.setText("Escribe la otra ruta del otro archivo:");
        etiqueta.setFont(new Font("courier new", 3, 16));
        panel.add(etiqueta);
        
    }

    /**
     * Crea la etiqueta para señalar al usuario que escriba un nombre a buscar
     */
    public void crearEtiquetaNombre(){

        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(30, 200, 500, 40);
        etiqueta.setText("Escribe un nombre a buscar en el archivo:");
        etiqueta.setFont(new Font("courier new", 3, 16));
        panel.add(etiqueta);
        
    }

    /**
     * Crea la etiqueta que le muestra el resultado de la búsqueda
     * de las opciones
     */
    public void crearEtiquetaResultado(){

        resultado = new JLabel();
        resultado.setBounds(30, 450, 550, 40);
        resultado.setFont(new Font("courier new", 3, 16));
        panel.add(resultado);
        
    }

    /**
     * Crea una zona de texto para la primer ruta
     */
    public void crearZonaDeTexto(){

        areaTexto = new JTextField();
        areaTexto.setBounds(35, 100, 350, 30);
        areaTexto.setFont(new Font("arial", 0, 14));
        panel.add(areaTexto);

    }

    /**
     * Crea una zona de texto para la segunda ruta
     */
    public void crearZonaDeTexto2(){

        areaTexto2 = new JTextField();

        areaTexto2.setBounds(35, 170, 350, 30);
        areaTexto2.setFont(new Font("arial", 0, 14));
        panel.add(areaTexto2);

    }

    /**
     * Crea una zona de texto para el nombre
     */
    public void crearZonaDeTextoNombre(){

        nombreTexto= new JTextField();

        nombreTexto.setBounds(35, 230, 350, 30);
        nombreTexto.setFont(new Font("arial", 0, 14));
        panel.add(nombreTexto);

    }

    /**
     * Crea los radio botones para las opciones
     */
    public void crearRadioBotones(){

        cifradoNulo = new JRadioButton("Obtener el mensaje oculto de un archivo", false);
        nombreOculto = new JRadioButton("Obtener el nombre oculto de un archivo", false);
        marcadoParabras = new JRadioButton("Recostruye el mensaje oculto a partir de las palabras", false);
        marcadoLetras = new JRadioButton("Recostruye el mensaje oculto a partir de las letras", false);

        //Botón 1
        cifradoNulo.setBounds(30, 270, 400, 30);
        cifradoNulo.setFont(new Font("arial", 1, 15));
        panel.add(cifradoNulo);
        //Botón 2
        nombreOculto.setBounds(30, 300, 400, 30);
        nombreOculto.setFont(new Font("arial", 1, 15));
        panel.add(nombreOculto);
        //Botón 3
        marcadoParabras.setBounds(30, 330, 450, 30);
        marcadoParabras.setFont(new Font("arial", 1, 15));
        panel.add(marcadoParabras);
        //Botón 4
        marcadoLetras.setBounds(30, 360, 450, 30);
        marcadoLetras.setFont(new Font("arial", 1, 15));
        panel.add(marcadoLetras);

        //Las añado a un grupo para que no se seleccionen todas
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(cifradoNulo);
        grupo.add(nombreOculto);
        grupo.add(marcadoParabras);
        grupo.add(marcadoLetras);

        //Llamada al método de sus acciones
        presionadoBoton();
    }


    /**
     * Se activa al presionar un botón de una opción
     */
    public void presionadoBoton(){

        /* Acción del primer botón y como es una interfaz, aqui la implemento*/
        ActionListener oyenteBoton1 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /* Para borrar lo que dice la etiqueta del resultado de la búsqueda 
                al seleccionar otra opción */
                resultado.setText("");

            }

        };

        //Asignación de la acción al correspondiente botón
        cifradoNulo.addActionListener(oyenteBoton1);

        /* Acción del segundo botón y como es una interfaz, aqui la implemento*/
        ActionListener oyenteBoton2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                resultado.setText("");
            }

        };

        //Asignación de la acción al correspondiente botón
        nombreOculto.addActionListener(oyenteBoton2);

        /* Acción del tercer botón y como es una interfaz, aqui la implemento*/
        ActionListener oyenteBoton3 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
            }

        };

        //Asignación de la acción al correspondiente botón
        marcadoParabras.addActionListener(oyenteBoton3);

        /* Acción del cuarto botón y como es una interfaz, aqui la implemento*/
        ActionListener oyenteBoton4 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                resultado.setText("");
            }

        };

        //Asignación de la acción al correspondiente botón
        marcadoLetras.addActionListener(oyenteBoton4);

    }

    /**
     * Crea el botón de activación
     */
    public void crearBoton(){

        boton = new JButton();

        boton.setText("Buscar!");
        boton.setBounds(30, 400, 200, 35);
        boton.setForeground(Color.BLUE);
        boton.setFont(new Font("arial", 3, 20));

        panel.add(boton);

        //Manda a llamar a la acción que realizará el botón
        accionBoton();
    }

    /**
     * La acción del botón al ser presionado
     */
    public void accionBoton(){
        
        //Para llamar a los métodos de EsteganografiaArchivos
        EsteganografiaArchivos esteArch = new EsteganografiaArchivos();
        
        message = "";
        
        ActionListener accionBoton = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                //La opción de cifrado nulo
                if(cifradoNulo.isSelected()){

                    message = esteArch.descifraNulo(areaTexto.getText());
                    
                    if(message != ""){
                        resultado.setText("El mensaje es: \""+message+"\"");
                    }
                }

                //La opción de nombre oculto
                if(nombreOculto.isSelected()){
    
                    boolean encontrado = esteArch.contieneNombre(areaTexto.getText(), nombreTexto.getText());

                    if(encontrado){
                        if(nombreTexto.getText().length() == 0){
                            resultado.setText("No ingresaste el nombre");
                        }else{
                            resultado.setText("Se encontró el nombre "+nombreTexto.getText()+" en el archivo");                        
                        }
                    }else{
                        resultado.setText("El nombre no se encontró en el archivo");
                    }
                }


                //La opción de marcando palabras
                if(marcadoParabras.isSelected()){

                    message = esteArch.descifraPalabrasMarcadas(areaTexto.getText(), areaTexto2.getText());

                    if(message != ""){
                        resultado.setText("El mensaje es: "+message);
                    }
                }

                //La opción de marcando letras
                if(marcadoLetras.isSelected()){
                    message = esteArch.descifraLetrasMarcadas(areaTexto.getText(), areaTexto2.getText());

                    if (message != ""){
                        resultado.setText("El mensaje es: "+message);
                    }
                }
            }
            
        };

        //Se agrega la acción al botón
        boton.addActionListener(accionBoton);

    }


}