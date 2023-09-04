<%-- 
    Document   : listarVideos
    Created on : 30/08/2023, 10:14:43 a. m.
    Author     : Sistemas
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ReproductorVideos</title>
         <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <header>
            <h1>  Listar videos</h1>
            <nav> 
            <a href="index.jsp" title="Mi enlace">Inicio</a>
            <a href="agregarVideo.jsp" title="Mi enlace1">Agregar Videos</a>
            <a href="listarVideos.jsp" title="Mi enlace2">Listar Videos</a>
            </nav>
        </header>
        <div class="b">
 <%
            
            ArrayList<Video> misVideos = null;
            
            String dataPath = application.getRealPath("/data/videos.ser");
            
            
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                misVideos  = (ArrayList<Video>) ois.readObject();
                ois.close();
                System.out.println("Datos de videos cargados exitosamente desde: " + dataPath);
            }
            
           
             if (misVideos != null) {
                System.out.println("Se cargaron " + misVideos.size() + " videos exitosamente.");
                for (Video v : misVideos) {
                    out.print("Id Video: " + v.getIdVideo() + "<br>");
                    out.print("Titulo: " + v.getTitulo() + "<br>");
                    out.print("Autor: " + v.getAutor() + "<br>");
                    out.print("Año: " + v.getAnio() + "<br>");
                    out.print("Categoria: " + v.getCategoria() + "<br>");
                    out.print("Url: " + v.getUrl() + "<br>");
                    out.print("Letra: " + v.getLetra() + "<br>");
                    out.print("------------------------------------------------------------"+"<br>");
                }
            } else {
                out.print("No hay videos disponibles.");
            }
        %>
        </div>
        <footer>
                <p>&copy; 2023 Blog de Dietas. Todos los derechos reservados.</p>
          </footer>
    </body>
</html>