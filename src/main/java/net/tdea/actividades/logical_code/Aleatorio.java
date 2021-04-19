/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tdea.actividades.logical_code;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eduer
 */
public class Aleatorio extends HttpServlet {

    protected ArrayList<Double> numerosA = new ArrayList<>();
    protected double suma = 0.0;
    protected String salida = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Aleatorio</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Aleatorio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        double numero = 0.0;

        for (int i = 0; i < 10; i++) {
            numero = Math.round(((Math.random() * (9 - 1) + 1)) * Math.pow(10, 2)) / Math.pow(10, 2);
            numerosA.add(numero);
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
        //processRequest(request, response);
        salida = "";
        suma = 0;
        for (int i = 0; i < numerosA.size(); i++) {
            suma += numerosA.get(i);
            salida += "[" + numerosA.get(i) + " ] ";
        }
        
        suma = Math.round((suma) * Math.pow(10, 2)) / Math.pow(10, 2);
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
            out.println("<h1>Suma: " + suma + "</h1>");
            out.println("<p>Numeros: " + salida + "</p>");
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
