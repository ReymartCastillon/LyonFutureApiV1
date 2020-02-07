<%-- 
    Document   : wildsearch
    Created on : Feb 6, 2020, 12:13:16 PM
    Author     : randmc
--%>

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
                Enter the keyword to search:&nbsp;<input name="name" type="text"/><br/><br/>

                <div style="width:500px;display: block;padding-top: 15px">
                    <a href="/home"><input type="button"  value="<- Home"></input></a>
                    <a href=""><input type="button" id="tabledisp" value="View in table format"></input></a>
                    <a href=""><input type="button" id="jsondisp" value="View in json format"></input></a>
                </div>



            </fieldset>
        </form>


    </body>

    <script>
        $(document).ready(function () {
            var name = $("input[name=name]").val("");
            $("#jsondisp").click(function () { 
                name = $("input[name=name]").val();
                if(name != ""){
                  var url = "/wildSearch/" + name + "/";
                 $('a').eq(2).attr('href', url)      
                }else{
                    alert("Please review your input, currently empty.");
                    
                }
                

            }); 
            $("#tabledisp").click(function () {
                name = $("input[name=name]").val();
                if(name != ""){
                 var url = "/wildSearch/" + name + "/table";
                $('a').eq(1).attr('href', url)       
                }else{
                  alert("Please review your input, currently empty.");
                         
                }
              

            });

        });
    </script>
</html>
