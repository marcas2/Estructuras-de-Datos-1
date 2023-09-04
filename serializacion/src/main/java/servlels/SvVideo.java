package servlels;

import com.umariana.mundo.Video;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    
    ArrayList<Video> misVideos= new ArrayList<>();
    
    // Método init() se llama al iniciar el servlet
    @Override
    public void init() throws ServletException {
        super.init();

        ServletContext servletContext = getServletContext();

        // Cargar videos desde archivo al iniciar el servlet
        cargarVideosDesdeArchivo(servletContext);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //manda las variables por abajo
        //Aqui vienen los datos por POST
        
        String idVideo = request.getParameter("idvideo");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anio = request.getParameter("anio");
        String categoria = request.getParameter("categoria");
        String url = request.getParameter("url");
        String letra = request.getParameter("letra");
        
        /**System.out.println("idVideo: "+idVideo);
        System.out.println("titulo: "+titulo);
        System.out.println("autor: "+autor);
        System.out.println("anio: "+anio);
        System.out.println("categoria: "+categoria);
        System.out.println("url: "+url);
        System.out.println("letra: "+letra);**/
        
        //ingresar datos al objeto
       // Video miVideo = new Video(Integer.parseInt(idVideo), titulo, autor, anio, categoria, url, letra);
        //misVideos.add(miVideo);
        
        //agregar el arraylist al objeto de solicitud como atributo
        //request.setAttribute("misVideos",misVideos);
        
        
        //request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
        /*System.out.println("----------------------------");
        for(Video v:misVideos){
            System.out.println("idVideo: "+v.getIdVideo());
            System.out.println("titulo: "+v.getTitulo());
            System.out.println("autor: "+v.getAutor());
            System.out.println("anio: "+v.getAnio());
            System.out.println("categoria: "+ v.getCategoria());
            System.out.println("url: "+v.getUrl());
            System.out.println("letra: "+v.getLetra());
            System.out.println("----------------------------");
        }*/
        try {
            int idVideoInt = Integer.parseInt(idVideo);

            // Crear un objeto Video y agregarlo a la lista misVideos
            Video miVideo = new Video(idVideoInt, titulo, autor, anio, categoria, url, letra);
            misVideos.add(miVideo);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Error al convertir idVideo a entero: " + e.getMessage());
        }

        // Guardar los videos en un archivo
        guardarVideosEnArchivo();

        // Establecer la lista de misVideos como un atributo de la solicitud
        request.setAttribute("misVideos", misVideos);

        // Redirigir a la página listarVideos.jsp
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void guardarVideosEnArchivo() {
        try {
            // Obtener la ruta real del directorio "data" en el contexto del servlet
            String dataPath = getServletContext().getRealPath("/data");

            // Crear la carpeta "data" si no existe
            File dataFolder = new File(dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }

            // Crear el archivo de datos de videos
            String filePath = dataPath + File.separator + "videos.ser";
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream obj = new ObjectOutputStream(fos);
            obj.writeObject(misVideos);
            obj.close();
            System.out.println("Datos de videos guardados exitosamente en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de videos: " + e.getMessage());
        }
    }

    // Método para cargar la lista de videos desde un archivo
    public void cargarVideosDesdeArchivo(ServletContext servletContext) {
        try {
            // Obtener la ruta real del archivo de datos de videos
            String dataPath = servletContext.getRealPath("/data/videos.ser");

            // Verificar si el archivo existe
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);

                // Leer la lista de videos desde el archivo
                misVideos = (ArrayList<Video>) ois.readObject();
                ois.close();
                System.out.println("Datos de videos cargados exitosamente desde: " + dataPath);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos de videos: " + e.getMessage());
        }
    }
    
}