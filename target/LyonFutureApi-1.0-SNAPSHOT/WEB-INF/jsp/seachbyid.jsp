<%-- 
    Document   : SearchById
    Created on : Feb 6, 2020, 11:10:01 AM
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
                Enter ICD #:&nbsp;<input type="text" name="icd"/><br/><br/>
                Enter Business #:&nbsp;<input type="text" name="bnumber"/>

                <div style="width:500px;display: block;padding-top: 15px">
                    <a href="/home"><input type="button" value="&#8592; Home"></input></a>
                    <a href=""><input type="button" id="tabledisp" value="View in table format"></input></a>
                    <a href=""><input type="button" id="jsondisp" value="View in json format"></input></a>
                </div>

            </fieldset>
        </form>   
    </body>

    <script>
        $(document).ready(function () {
            $("#dtBasicExample_next").before("&nbsp;")     
            var icd = $("input[name=icd]").val("");
            var enp = $("input[name=bnumber]").val("");
            $("#jsondisp").click(function () {
                icd = $("input[name=icd]").val();
                enp = $("input[name=bnumber]").val();
                if (icd != "" || enp != "") {
                    var url = "/searchById/" + icd + "/" + enp + "/";
                    $('a').eq(2).attr('href', url)
                } else {
                    alert("Please review your input, currently empty.");
                    
                }

            });

            $("#tabledisp").click(function () {
                icd = $("input[name=icd]").val();
                enp = $("input[name=bnumber]").val();
              if (icd != "" || enp != "") {
                 var url = "/searchById/" + icd + "/" + enp + "/table";
                 $('a').eq(1).attr('href', url)   
              }else{
                  alert("Please review your input, currently empty.");
              }

            });

        });

    </script>
</html>
