package net.tdea.actividades.logical_code;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hipotenusa", urlPatterns = {"/hiponusar"})
public class Hipotenusa extends HttpServlet {

    private Double c1, c2, e1, e2, h;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hipotenusa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Hipotenusa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            // Obtener los numeros por parametros
            c1 = Double.parseDouble(request.getParameter("c1"));
            c2 = Double.parseDouble(request.getParameter("c2"));

            // Elevar ambos numeros
            e1 = Math.pow(c1, 2);
            e2 = Math.pow(c2, 2);

            // Sacar raiz cuadrada y resultado
            h = Math.sqrt((e1 + e2));
            h = Math.round((h) * Math.pow(10, 2)) / Math.pow(10, 2);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hipotenusa: resultado</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='showH'>");
            out.println("<p>h = raiz(" + c1 + ")^2 + raiz(" + c2 + ")^2</p>");
            out.println("<p>h = raiz(" + e1 + ") + raiz(" + e1 + ")</p>");
            out.println("<p>h = " + h + "</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
