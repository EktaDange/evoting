<%-- 
    Document   : votingresponse
    Created on : 28 Jun, 2021, 3:16:00 PM
    Author     : ekta dange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="evoting.dto.CandidateInfoDTO"%>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link href="stylesheet/backgroundimage.css" rel="stylesheet">
        <link href="stylesheet/pageheader.css" rel="stylesheet">
        <link href="stylesheet/showcandidate.css" rel="stylesheet">
        <title>Voting Details </title>
    </head>
    
    <body>
        <%
           String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                session.invalidate();
                response.sendRedirect("accessdenied.html");
                return;
            }
            
        CandidateInfoDTO c=(CandidateInfoDTO)session.getAttribute("candidate");
        StringBuffer displayBlock =new StringBuffer();
        displayBlock.append("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div><br>");
        if(c==null)
        {
              displayBlock.append("<div class='subcandidate'>Sorry Your Vote Could not be casted</div><br><br>");
              displayBlock.append("<div><h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4></div>");
              out.println(displayBlock);
        }
        else
        {
                displayBlock.append("<div class='subcandidate'>Thank YOu for voting !!</div><br><br>");
                displayBlock.append("<div class='candidateprofile'><p>CandidiateID:"+c.getCandidateId()+"<br>");
                displayBlock.append("<strong>YOu Voted For </strong><br><img src='data:image/jpg;base64,"+c.getSymbol()+"' style='width:300px;height=200px;'></label>");
                displayBlock.append("<br><div class='candidateprofile'><p>CandidiateID:"+c.getCandidateId()+"<br>");
                displayBlock.append("CandidiateName:"+c.getCandidatename()+"<br>");
                displayBlock.append("Party:"+c.getParty()+"<br></div>");
                
                out.println(displayBlock);
        }
        %>
    </body>
    
    
</html>