package net.tdea.actividades.logical_code;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ContadorVisitas", urlPatterns = {"/contarVisitas"})
public class ContadorVisitas extends HttpServlet {

    protected int valor = 0;
    protected String mensaje = "";

    //protected int contador = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorVisitas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /*public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
    }*/
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

            String user = request.getParameter("idUser");
            HttpSession session = request.getSession();

            String cuenta = (String) (session.getAttribute("idUser"));

            if (cuenta == null) {
                session.setAttribute("idUser", user);
                session.setAttribute("cuenta", 1);
                System.out.println("Ingreso a nueva cuenta");
                mensaje = "Se registro la cuenta a nombre de: " + user;
            } else if (cuenta.equals(user)) {
                System.out.println("Ingreso a equals");
                valor = Integer.parseInt(session.getAttribute("cuenta").toString());
                valor += 1;
                session.setAttribute("cuenta", valor);
                mensaje = "";
            }

            valor = Integer.parseInt(session.getAttribute("cuenta").toString());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hipotenusa: resultado</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='showH'>");
            out.println("<h1>GET</h1>");
            out.println("<h2 class='formula'>" + mensaje + "</h2>");
            out.println("Contador: " + valor);
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception exception) {
            System.out.println(exception);
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
        try {
            String user = request.getParameter("idUser");
            HttpSession session = request.getSession();

            String cuenta = (String) (session.getAttribute("idUser"));

            if (cuenta == null) {
                session.setAttribute("idUser", user);
                session.setAttribute("cuenta", 1);
                System.out.println("Ingreso a nueva cuenta");
                mensaje = "Se registro la cuenta a nombre de: " + user;
            } else if (cuenta.equals(user)) {
                System.out.println("Ingreso a equals");
                valor = Integer.parseInt(session.getAttribute("cuenta").toString());
                valor += 1;
                session.setAttribute("cuenta", valor);
                mensaje = "";
            }

            valor = Integer.parseInt(session.getAttribute("cuenta").toString());
        } catch (Exception e) {
            System.out.println("Algo salio mal: " + e);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hipotenusa: resultado</title>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='showH'>");
            out.println("<h1>POST</h1>");
            out.println("Contador: " + valor);
            out.println("" + mensaje + "");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
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
