<%-- 
    Document   : hello
    Created on : Feb 4, 2020, 5:50:43 AM
    Author     : randmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <table class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
    <thead>
      <tr>
        <th>ICD</th>
        <th>Business Number</th>
        <th>Name</th>
        <th>Country code</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${icd}</td>
        <td>${enterprise}</td>
        <td>${name}</td>
        <td>${code}</td>
      </tr>
    </tbody>
  </table>
        
        
    </body>
</html>
