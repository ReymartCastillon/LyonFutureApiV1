<%-- 
    Document   : wiildsearch
    Created on : Feb 5, 2020, 1:50:10 PM
    Author     : randmc
--%>

<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.js" type="text/javascript"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>      
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <div id="error">${error}</div>
    <body>
        <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>ICD</th>
                    <th>Business Number</th>
                    <th>Name</th>
                    <th>Country code</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="card" items="${cards}">  
                    <tr>    
                        <td> ${card.ICD}</td>
                        <td> ${card.businessNum}</td>
                        <td> ${card.entity.name}</td>
                        <td> ${card.entity.countryCode}</td>
        
                </tr>
</c:forEach>
          
            
            </tbody>
        </table>
        <script>
$(document).ready(function () {
  $('#dtBasicExample').DataTable({
    "pagingType": "simple" // "simple" option for 'Previous' and 'Next' buttons only
  });
  $('.dataTables_length').addClass('bs-select');
});
</script>
    </body>
</html>
