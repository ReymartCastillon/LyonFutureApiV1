<%-- 
    Document   : firstpage
    Created on : Feb 4, 2020, 5:21:12 AM
    Author     : randmc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
         
<body>
	<form>
 <fieldset> 

<legend><h2>Please choose a service below:</h2></legend>
<br/>
<a href="${pageContext.request.contextPath}/searchById">Search by ID</a><br>
<a href="${pageContext.request.contextPath}/wildsearch">Wild   search by name</a><br>
<a href="${pageContext.request.contextPath}/exactSearch">Search by exact name</a>

 </fieldset>
</form>
</body>


<script type="text/javascript">
	        
	    </script>
</html>
