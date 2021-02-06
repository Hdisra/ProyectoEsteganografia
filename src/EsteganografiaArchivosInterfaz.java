/**
 * Proyecto 03 del curso de ICC
 * 
 * @author Israel Hernández Dorantes - 318206604
 * @version 1.0 Enero 2021
 */
public interface EsteganografiaArchivosInterfaz {

    /**
     * Toma la n-ésima letra de cada palabra para obtener el mensaje
     * oculto.
     *
     * @param rutaArchivo El nombre del archivo que posee el mensaje
     * original con n espacios al final de la
     * última línea de texto.
     * @return El mensaje oculto, sin espacios.
    */
    public String descifraNulo(String rutaArchivo);

    /**
     * Busca un nombre oculto en un texto arbitrario ignorando
     * espacios, signos de puntuación y sin hacer distinciones
     * entre mayúculas y minúsulas .
     *
     * @param rutaArchivo El nombre del archivo que posee el mensaje
     * donde se hará la búsqueda .
     * @param nombre El nombre que se buscará en el texto .
     * @return true si el nombre está contenido , false en otro
     * caso.
    */
    public boolean contieneNombre(String rutaArchivo, String nombre);

    /**
     * Reconstruye el mensaje oculto a partir de las palabras
     * especiales que se obtienen al comparar dos textos .
     *
     * @param rutaM La ruta de un archivo con texto arbitrario .
     * @param rutaE La ruta de un archivo con un texto similar
     * al primero , pero con algunas palabras especiales .
     * @return El mensaje oculto .
    */
    public String descifraPalabrasMarcadas(String rutaM, String rutaE);
    
    /**
     * Reconstruye el mensaje oculto a partir de las letras
     * especiales que se obtienen al comparar dos textos .
     *
     * @param rutaM La ruta de un archivo con un texto arbitrario .
     * @param rutaE La ruta de un archivo con un texto similar al
     * primero , pero con algunas letras especiales .
     * @return El mensaje oculto .
    */
    public String descifraLetrasMarcadas(String rutaM, String rutaE);

    

}