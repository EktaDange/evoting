<%-- 
    Document   : verifyvote
    Created on : 28 Jun, 2021, 3:12:45 PM
    Author     : ekta dange
--%>

<%
  String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                session.invalidate();
                response.sendRedirect("accessdenied.html");
                return;
            }
             
        boolean result=(boolean)request.getAttribute("result");
        if(result==true)
        {
            out.println("success");
        }
        else{
        out.println("failed");
        }

%>