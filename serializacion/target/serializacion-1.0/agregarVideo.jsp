<%-- 
    Document   : agregarVideo
    Created on : 29/08/2023, 10:45:43 a. m.
    Author     : Sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ReproductorVideos</title>
         <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        
        <header>
            <h1>Agregar Videos</h1>
            <nav> 
            <a href="index.jsp" title="Mi enlace">Inicio</a>
            <a href="agregarVideo.jsp" title="Mi enlace1">Agregar Videos</a>
            <a href="listarVideos.jsp" title="Mi enlace2">Listar Videos</a>
            </nav>
        </header>
        <table>
        <form action="SvVideo" method="POST">
            <tr>
        <td>Id Video:</td>
        <td><input type="type" name="idvideo"></td>
        </tr><tr>
        <td>Titulo:</td>
        <td><input type="type" name="titulo"></td>
        </tr><tr>
        <td>Autor:</td>
        <td><input type="type" name="autor"></td>
        </tr><tr>
        <td>Año:</td>
        <td><input type="type" name="anio"></td>
        </tr><tr>
        <td>Categoria:</td>
        <td><input type="type" name="categoria"></td>
        </tr><tr>
        <td>Url:</td>
        <td><textarea id="id" name="url" rows="5" cols="20"></textarea></td>
        </tr><tr>
        <td>Letra:</td>
        <td><textarea id="id" name="letra" rows="5" cols="20"> </textarea></td>
        </tr>
        </table>
        <div class="left"> 
            <input id="boton" type="submit" value="Agregar video">
            <input type="reset" value="Eliminar"/>
        </div>
        </form>
        
        <div class="center"> 
            <button> <a href="index.jsp" title="Regresar">Regresar</a></button >
        </div>
        
          <footer>
                <p>&copy; 2023 Reproductor de musica. Todos los derechos reservados.</p>
          </footer>
    </body>
</html>
