import java.util.Scanner;
/**
 * Proyecto 03/04 del curso de ICC
 * @author Israel Hernández Dorantes - 318206604
 * @version 2.0 Enero 2021
 */
public class Esteganografia implements EsteganografiaInterfaz {

    @Override
    public String descifraNulo(String original, int n) {

        //Almacena la nueva cadena que se generará
        String mensaje = "";

        //Para almacenar cada palabra
        String aux;
        
        for(int i = 0; i<original.length(); i++){

            aux = "";
            
            for( ; i<original.length(); i++){
                
                if(original.charAt(i) != ' '){

                    aux += original.charAt(i);
                }else{
                    break;
                }

            }
            
            if((aux.length()-1)<n){
                //Para que no tome en cuenta las palabras que son más pequeñas que el índice
                continue;
            }

            mensaje += aux.charAt(n);
            
        }

        return mensaje;
    }
    
    
    @Override
    public String descifraNulo(String original) {
        //Almacena la nueva cadena que se generará
        String mensaje = "";

        //Guarda el número de espacios al final del texto
        int n = this.cuentaEspacios(original);

        //Para quitarle los espacios al final del texto original
        mensaje = original.trim();

        //Para que el otro método decifraNulo descifre el mensaje con el n ya dado
        mensaje = this.descifraNulo(mensaje, n);

        return mensaje;
    }


    /**
     * Cuenta los espacios al final del texto dado
     * @param texto El texto con n espacios al final .
     * @return el número de espacios que tiene al final el texto
     */
    public int cuentaEspacios(String texto){

        //Cuenta el número de espacios al final del texto original
        int espacios = 0;

        for(int i = (texto.length()-1); ; i--){

            if(i == -1 || texto.charAt(i) != ' ')
                break;

            espacios++;
                
        }

        return espacios;
    }


    @Override
    public boolean contieneNombre(String mensaje, String nombre) {
        
        //Almacena el mensaje modificado
        String newMessage = "";

        //Guarda si se encontró o no el nombre
        boolean encontrado = false;

        //Para que el texto y el nombre esté todo en minúsculas
        mensaje = mensaje.toLowerCase();
        nombre = nombre.toLowerCase();

        //Para quitarle los acentos al nombre y los espacios al final 
        nombre = quitarAcento(nombre);
        nombre = nombre.trim();

        //Almacena las palabras
        String palabra;

        //Almacena el tamaño del nombre para poderlo modificar
        int t = (nombre.length() - 1);

        if(nombre.length() > mensaje.length()){

            return false;
        }

        //Almacena la cadena sin espacios
        for(int i = 0; i<mensaje.length(); i++){

            if(mensaje.charAt(i) == ' ')
                continue;

            if(!esLetra(mensaje.charAt(i)))
                continue;

            newMessage += mensaje.charAt(i);

        }

        for(int i = 0; i<newMessage.length(); i++){

            if(t >= newMessage.length()){
                return false;
            }

            palabra = newMessage.substring(i, (t+1));

            //Para quitar los acentos a las palabras generadas
            palabra = quitarAcento(palabra);

            if(nombre.equals(palabra))
                return true;

            t++;
        }
        
        return encontrado;
    }

    /**
     * Método que verifica si un caracter es una letra
     * @param c el caracter al cual se le verificará si es una letra
     * @return true si es una letra, de otro modo false
     */
    public boolean esLetra(char c){

        //Almacena el caracter
        char letra;

        //Almacena si sí es letra
        boolean l = true;

        switch(c){

            case 'a':
            case 'A':
            case 'á':
            case 'Á':
            case 'e':
            case 'é':
            case 'É':
            case 'E':
            case 'í':
            case 'i':
            case 'Í':
            case 'I':
            case 'o':
            case 'ó':
            case 'O':
            case 'Ó':
            case 'u':
            case 'ú':
            case 'U':
            case 'Ú':
            case 'ü':
            case 'b':
            case 'B':
            case 'c':
            case 'C':
            case 'd':
            case 'D':
            case 'f':
            case 'F':
            case 'g':
            case 'G':
            case 'h':
            case 'H':
            case 'j':
            case 'J':
            case 'k':
            case 'K':
            case 'l':
            case 'L':
            case 'm':
            case 'M':
            case 'n':
            case 'N':
            case 'ñ':
            case 'Ñ':
            case 'p':
            case 'P':
            case 'q':
            case 'Q':
            case 'r':
            case 'R':
            case 's':
            case 'S':
            case 't':
            case 'T':
            case 'v':
            case 'V':
            case 'w':
            case 'W':
            case 'x':
            case 'X':
            case 'y':
            case 'Y':
            case 'z':
            case 'Z':
            l = true;

            break;

            default:
            l = false;

            break;
        }

        return l;
    }

    /**
     * Método que le quita los acentos a una palabra
     * @param palabra la palabra a quitar los acentos
     * @return la palabra sin acentos
     */
    public String quitarAcento(String palabra){

        for(int i = 0; i<palabra.length(); i++){

            switch(palabra.charAt(i)){

                case 'a':
                case 'á':
                palabra = palabra.replace(palabra.charAt(i), 'a');
                break;

                case 'e':
                case 'é':
                palabra = palabra.replace(palabra.charAt(i), 'e');
                break;

                case 'i':
                case 'í':
                palabra = palabra.replace(palabra.charAt(i), 'i');
                break;

                case 'o':
                case 'ó':
                palabra = palabra.replace(palabra.charAt(i), 'o');
                break;

                case 'u':
                case 'ú':
                palabra = palabra.replace(palabra.charAt(i), 'u');
                break;

                default:
                break;
            }

        }

        return palabra;
    }


    @Override
    public String descifraPalabrasMarcadas(String m, String e) {
        
        //Guarda el mensaje obtenido
        String mensaje = "";

        //Guarda las palabras del texto m y el e
        String palabraM, palabraE;
        
        if(m != null && e != null){
            for(int i = 0, j = 0; i<m.length(); i++, j++){

                palabraM = "";
                palabraE = "";
                
                for( ; i<m.length(); i++){
                    
                    if(m.charAt(i) != ' '){
                        if(esLetra(m.charAt(i)))
                            palabraM += m.charAt(i);
                    }else{
                        break;
                    }

                }

                for( ; j<e.length(); j++){
                    
                    if(e.charAt(j) != ' '){
                        if(esLetra(e.charAt(j)))
                            palabraE += e.charAt(j);
                    }else{
                        break;
                    }

                }
                
                if(!palabraM.equals(palabraE)){
                    mensaje += palabraM + " ";
                }

            }
        }
        
        return mensaje;
    }


    @Override
    public String descifraLetrasMarcadas(String m, String e) {
        
        //Guarda el mensaje obtenido
        String mensaje = "";

        //Guarda las palabras del texto m y el e
        String palabraM, palabraE;

        if(m != null && e != null){
            for(int i = 0, j = 0; i<m.length(); i++, j++){

                palabraM = "";
                palabraE = "";
                
                for( ; i<m.length(); i++){
                    
                    if(m.charAt(i) != ' '){
                        if(esLetra(m.charAt(i)))
                            palabraM += m.charAt(i);
                    }else{
                        break;
                    }

                }

                for( ; j<e.length(); j++){
                    
                    if(e.charAt(j) != ' '){
                        if(esLetra(e.charAt(j)))
                            palabraE += e.charAt(j);
                    }else{
                        break;
                    }

                }

                for(int k = 0; k<palabraM.length(); k++){

                    if(palabraM.charAt(k) != palabraE.charAt(k)){
                        mensaje += palabraM.charAt(k) + "";
                    }
                }
            
            }
        }

        return mensaje;
    }


    
    /*
        PRUEBAS DEL PROYECTO PASADO

    public static void main(String[] args) {
        
        //Para leer desde la consola
        Scanner entrada = new Scanner(System.in);

        //Almacena la opción que se vaya a ingresar
        int opcion;

        //Para poder realizar los métodos
        EsteganografiaInterfaz descifrado = new Esteganografia();

        //Para leer el texto de los métodos de Cifrado Nulo, Nombre Oculto, Marcando Palabras y Marcando Letras
        String texto;

        //Para leer el otro texto del método de Marcando Palabras y Marcando Letras
        String texto2;

        //Para leer el nombre del método Nombre Oculto
        String nombre;

        //Para el índice del método de Cifrafo Nulo
        int indice;

        //Menú
        do{

            System.out.println("--- Menú ---");
            System.out.println("1. Decifra un mensaje oculto en un texto");
            System.out.println("2. Decifra un mensaje oculto de acuerdo al número de espacios proporcionados"+
            "al final del texto");
            System.out.println("3. Busca una nombre oculto en un texto");
            System.out.println("4. Decifra un mensaje oculto con dos textos, basado en sus palabras");
            System.out.println("5. Decifra un mensaje oculto con dos textos, basado en sus letras");
            System.out.println("6. Salir");
            System.out.print("Opción:  ");

            opcion = entrada.nextInt();

            //Para vaciar lo que está en el buffer
            entrada.nextLine();
            
            switch(opcion){

                case 1:
                System.out.println("\nEscribe el texto:");
                texto = entrada.nextLine();
                System.out.println("Escribe el índice que se tomará para cada palabra:");
                indice = entrada.nextInt();
                System.out.println("El mensaje oculto es:  "+descifrado.descifraNulo(texto, indice)+"\n");
                break;

                case 2:
                System.out.println("\nEscribe el texto con los espacios al final de él:");
                texto = entrada.nextLine();
                System.out.println("El mensaje oculto es:  "+descifrado.descifraNulo(texto)+"\n");
                break;

                case 3:
                System.out.println("\nEscribe el texto:");
                texto = entrada.nextLine();
                System.out.print("Escribe el nombre a buscar:  ");
                nombre = entrada.nextLine();
                System.out.println("Se encontró el nombre: "+descifrado.contieneNombre(texto, nombre)+"\n");
                break;

                case 4:
                System.out.println("\nEscribe el primer texto:");
                texto = entrada.nextLine();
                System.out.println("Escribe el segundo texto:");
                texto2 = entrada.nextLine();
                System.out.println("El mensaje oculto es:  "+descifrado.descifraPalabrasMarcadas(texto, texto2)+"\n");
                break;
                
                case 5:
                System.out.println("\nEscribe el primer texto:");
                texto = entrada.nextLine();
                System.out.println("Escribe el segundo texto:");
                texto2 = entrada.nextLine();
                System.out.println("El mensaje oculto es:  "+descifrado.descifraLetrasMarcadas(texto, texto2)+"\n");
                break;

                case 6:
                System.out.println("Hasta pronto!");
                break;

                default:
                System.out.println("Índice inválido");
                break;

            }

        }while(opcion != 6);

        
    }
     */   
    
}
