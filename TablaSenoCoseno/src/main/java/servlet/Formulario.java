package servlet;
//Programador: Ismael Anrrango,  Stalin Ramirez
//Fecha: Jueves 11 del 2024
//Revision: Si
//Detalle: este es el constrolador

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ingresar")
public class Formulario extends HttpServlet {
// aqui definimos las variables para el uso del for y para imprimir los datos en la tabala
    //tambien usamos una variable para los  radianes por que las funciones Math.sin
// calcula el coseno con radianes
    protected double radianes;
    protected double seno;
    protected double coseno;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        //Codigo del html para cargar los datos de la tabla
        out.println("<html>");
        out.println("<head>" );
        out.print("<title>Tabla de Seno y Coseno</title>");
        //se importa los estilos css desde boostrap
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h1>Tabla de Seno y Coseno (0 - 360)</h1>");
        out.println("<h2>Intervalos entre 15</h2>");
        out.println("<table class=\"table table-dark table-striped\">");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th scope=\"col\">Angulo (°)</th>");
        out.println("<th scope=\"col\">Seno</th>");
        out.println("<th scope=\"col\">Coseno</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        // Se usa el bucle for para calcular los angulos
        for (int i = 0; i <= 360; i += 15) {
            radianes = Math.toRadians(i);
            seno = Math.sin(radianes);
            coseno = Math.cos(radianes);
            //Se imprime los valortes del bucle
            out.println("<tr>");
            out.println("<th scope=\"row\">" + i + "</th>");
            out.println("<td>" + seno + "</td>");
            out.println("<td>" + coseno + "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<p><a href=\"index.html\">Volver al inicio</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

}


