/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evotingcontroller;

import evoting.dao.CandidateDAO;
import evoting.dto.CandidateDetailsDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
public class DeleteCandidateControllerServlet extends HttpServlet {

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
       RequestDispatcher rd=null;
       
       HttpSession sess=request.getSession();
       String userid= (String)sess.getAttribute("userid");
       
       if(userid==null)
       {
           sess.invalidate();
           response.sendRedirect("accessdenied.jsp");
           return;
       }
       
       
       
       String data=request.getParameter("data");
       try{
           
       if(data !=null &&data.equalsIgnoreCase("cid"))
       {
           ArrayList <String> candidateList=CandidateDAO.getCandidateId();
                request.setAttribute("candidateid",candidateList);
                request.setAttribute("result", "candidatelist"); 
                //rd=request.getRequestDispatcher("deletecandidate.jsp");
       }
       
       else 
       {
          CandidateDetailsDTO cd=CandidateDAO.getDetailsById(data);
                request.setAttribute("candidate", cd);
                request.setAttribute("result","details");
                
          /*boolean result=CandidateDAO.deleteCandidate(data) ;
          if(result==true)
          rd=request.getRequestDispatcher("success.jsp");
          else
            rd=request.getRequestDispatcher("failure.jsp");*/
       }
       
       }
       catch(Exception ex)
       {
            ex.printStackTrace();
            rd=request.getRequestDispatcher("ShowException.jsp");
            request.setAttribute("exception",ex); 
       }
       
       finally
               {
                rd=request.getRequestDispatcher("deletecandidate.jsp");
                rd.forward(request,response);
               }
    }  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
