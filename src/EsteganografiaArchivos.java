import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 * Proyecto 03 del curso de ICC
 * @author Israel Hernández Dorantes - 318206604
 * @version 1.0 Enero 2021
 */
public class EsteganografiaArchivos extends Esteganografia implements EsteganografiaArchivosInterfaz {

    //Para crear la interfaz gráfica
    InterfazGrafica graficos;
    
    /* Cifrado nulo */
    @Override
    public String descifraNulo(String rutaArchivo){

        //Almacena el mensaje
        String mensaje = "";

        //Almacena una línea del archivo
        String line;

        //Almacena los espacios al final del archivo
        int espacios;
        try {
            
            //Para leer se necesitan dos objetos
            FileReader l = new FileReader(rutaArchivo);
            BufferedReader lectura = new BufferedReader(l);

            //Para leer una línea
            line = lectura.readLine();
            espacios = this.cuentaEspaciosArchivo(rutaArchivo);

            while(line != null){
                mensaje += super.descifraNulo(line, espacios);

                //Para volver a leer 
                line = lectura.readLine();


            }

        } catch (FileNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "No se enconctró el archivo");
        } catch (IOException e) {
            //Proviene de hacer readLine()
            System.out.println("Oucrrió un error al leer el archivo");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un problema al leer el archivo");
        }

        return mensaje;
        
    }

    /**
     * Cuenta los espacios al final de la última línea de un archivo
     * @param ruta la ruta del archivo
     * @return el número de espacios al final del archivo
     */
    public int cuentaEspaciosArchivo(String ruta){

        //Almacena los espacios
        int espacios = 0;

        //Almacena lo que está en la línea
        String linea = "", linea2 = "";

        
        try {
            
            //Para leer 
            FileReader l = new FileReader(ruta);
            BufferedReader lectura = new BufferedReader(l);

            //Para leer dos veces el archivo
            BufferedReader aux = new BufferedReader(new FileReader(ruta));
            
            while(true){

                linea2 = aux.readLine();

                if(linea2 == null)
                    break;

                //Para volver a leer 
                linea = lectura.readLine();


            }
            espacios = this.cuentaEspacios(linea);

        } catch (FileNotFoundException e) {
            
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            //Proviene de hacer readLine()
            System.out.println("Oucrrió un error al leer el archivo");
        }catch(Exception e){
            System.out.println("Ocurió un error");
        }

        return espacios;
    }


    /* Nombre Oculto */
    @Override
    public boolean contieneNombre(String rutaArchivo, String nombre){

        //Almacena si se encontró el nombre
        boolean encontrado = false;

        //Almacena las lineas del archivo
        String linea1 = "";

        //Almacena todo el texto
        String texto = "";

        try {
            
            //Para poder leer el archivo
            FileReader l = new FileReader(rutaArchivo);
            BufferedReader lectura = new BufferedReader(l);
            
            //Para leer una línea
            linea1 = lectura.readLine();

            while(linea1 != null){
                
                texto += linea1;

                //Para volver a leer 
                linea1 = lectura.readLine();

            }

            encontrado = super.contieneNombre(texto, nombre);

        } catch (FileNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "No se enconctró el archivo");
        } catch (IOException e) {
            //Proviene de hacer readLine()
            System.out.println("Oucrrió un error al leer el archivo");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un problema al leer el archivo");
        }
        return encontrado;
    }
    

    /* Marcando palabras */
    @Override
    public String descifraPalabrasMarcadas(String rutaM, String rutaE){

        //Almacena el mensaje oculto
        String message = "";

        //Almacena las lineas del archivo
        String lineaArchivo1 = "", lineaArchivo2 = "";

        try{

            //Para poder leer el primer archivo
            FileReader l = new FileReader(rutaM);
            BufferedReader lectura = new BufferedReader(l);

            //Para leer segundo archivo
            BufferedReader lectura2 = new BufferedReader(new FileReader(rutaE));

            //Para leer la primera línea de cada archivo
            lineaArchivo1 = lectura.readLine();
            lineaArchivo2 = lectura2.readLine();

            while(lineaArchivo1 != null){

                message += super.descifraPalabrasMarcadas(lineaArchivo1, lineaArchivo2);

                //Para leer las otras líneas
                lineaArchivo1 = lectura.readLine();
                lineaArchivo2 = lectura2.readLine();
            }

            if(message.equals(""))
                JOptionPane.showMessageDialog(null, "Los archivos tienen el mismo contenido o algún archivo no tiene texto");

        }catch (FileNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "No se enconctró algún archivo");
        } catch (IOException e) {
            //Proviene de hacer readLine()
            System.out.println("Oucrrió un error al leer algún archivo");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un problema al leer algún archivo");
        }

        return message;
    }


    /* Marcando letras */
    @Override
    public String descifraLetrasMarcadas(String rutaM, String rutaE){

        //Almacena el mensaje oculto
        String message = "";

        //Almacena las lineas del archivo
        String lineaArchivo1 = "", lineaArchivo2 = "";

        try{

            //Para poder leer el primer archivo
            FileReader l = new FileReader(rutaM);
            BufferedReader lectura = new BufferedReader(l);

            //Para leer segundo archivo
            BufferedReader lectura2 = new BufferedReader(new FileReader(rutaE));

            //Para leer la primera línea de cada archivo
            lineaArchivo1 = lectura.readLine();
            lineaArchivo2 = lectura2.readLine();

            while(lineaArchivo1 != null){

                message += super.descifraLetrasMarcadas(lineaArchivo1, lineaArchivo2);

                //Para leer las otras líneas
                lineaArchivo1 = lectura.readLine();
                lineaArchivo2 = lectura2.readLine();
            }

            if(message.equals(""))
                JOptionPane.showMessageDialog(null, "Los archivos tienen el mismo contenido o algún archivo no tiene texto");

        }catch (FileNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "No se enconctró algún archivo");
        } catch (IOException e) {
            //Proviene de hacer readLine()
            System.out.println("Oucrrió un error al leer algún archivo");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un problema al leer algún archivo");
        }

        return message;
    }

     


    //Ejecución del programa
    public static void main(String[] args) {
        
        //Para poder llamar a los métodos
        EsteganografiaArchivos eArchivos = new EsteganografiaArchivos();

        //Crea la interfaz gráfica
        eArchivos.graficos = new InterfazGrafica();
        eArchivos.graficos.creaVentana();
        eArchivos.graficos.setVisible(true);
        
    }


}