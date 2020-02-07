<%-- 
    Document   : exactNameSearch
    Created on : Feb 6, 2020, 12:04:05 PM
    Author     : randmc
--%>

<%@page import="com.mycompany.lyonfutureapi.controller.pojoClass.XmlParserClass"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="jquery-3.4.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form>
 <fieldset>

<legend><h2>***Lyon Future***</h2></legend>
Enter the exact name to search:&nbsp;<input style="width:200px" type="text" name="name" id="name"/><br/><br/>

<div style="width:500px;display: block;padding-top: 15px">
<a href="/home"><input type="button" value="&#8592; Home"></input></a>	
<a href=""><input name="tabledisp" id="tabledisp" type="button" value="View in table format"></input></a>
<a href=""><input id="jsondisp" name=jsondisptype" type="button" value="View in json format"></input></a>
</div>

 </fieldset>
</form>
    </body>
  
 <script>
        $(document).ready(function() { 
            var name = $("input[name=name]").val("");
         $("#jsondisp").click(function(){
             name = $("input[name=name]").val();
             if(name !=""){
              var url="/exactSearch/"+name+"/";
             $('a').eq(2).attr('href',url)         
             }else{
                 alert("Please review your input, currently empty.");
               
             }
             
             
         });
            
           $("#tabledisp").click(function(){
             name = $("input[name=name]").val();
             if(name != ""){
                 var url="/exactSearch/"+name+"/table";
               $('a').eq(1).attr('href',url)     
             }else{
                 alert("Please review your input, currently empty.");
                  
             }
           
             
         });
         
        });
      </script>
</html>
