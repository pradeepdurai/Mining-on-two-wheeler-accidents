/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.project;
import project.projectFacadeLocal;

/**
 *
 * @author 18mx263
 */
public class servlet extends HttpServlet {

    @EJB
    private projectFacadeLocal projectFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int br = 0;
            String s1 = request.getParameter("v1");
            String s2 = request.getParameter("v2");
            String s3 = request.getParameter("v3");
            String s4 = request.getParameter("v4");
            String s5 = request.getParameter("v5");
            project obj = new project();
            List list = projectFacade.findAll();
            for (int i = 0; i < list.size(); i++) {
                obj = (project) list.get(i);
                if (s4.equals(s5)) {
                    if (obj.getUname().equals(s3)) {
                        out.println("Username Already Exist");
                        br = 0;
                        break;
                    } else {
                        br = 1;
                    }       
                } 
                else {
                    out.println("<h1>" + "Password is Mismatch" + "<h1>");
                    break;
                }
            }
            if (br == 1)
            {
             project ob=new project();
            ob.setFname(s1);
            ob.setLname(s2);
            ob.setUname(s3);
            ob.setPassword(s5);
            projectFacade.create(ob);
            out.println("<h1>" + "Successfully Register" + "<h1>");
                out.println("<a href='testlogin.html'>" + "Click Here To Login" + "</a>");
            }

            /*if(br==1)
            {
                out.println("Enter Correct Password");
                    out.println("<a href='Signup.html'>"+"GoBack"+"</a>");
            }*/
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
        processRequest(request, response);
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
