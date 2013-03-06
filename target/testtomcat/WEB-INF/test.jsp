<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import = "java.util.LinkedList"%>
<%@ page import = "java.util.List"%>

<!DOCTYPE HTML>
<html>
 <head>
  <meta charset="utf-8">
  <title>Гостевая книга</title>
 </head>
 <body bgcolor="#FFFFCC">

 <form method="post" action="/testtomcat/simple">
  <p><b>Введите текст сообщения</b></p>
  <p><input name="textfield" type="text" placeholder="Введите текст" size=60 autofocus /></p>
  <p><input type="submit"></p>
 </form>

 <table cellspacing="2" border="1" cellpadding="5" width="600">
	<tr>
		<td>Номер:</td>
		<td>Сообщение:</td>
	</tr>
		<%
            List listMessage = (List)request.getAttribute("ListRecords");
            int i = 1;
		    for (Object s: listMessage){
                out.println("<tr> <td>" + i + "</td> <td>" + s +"</td></tr>" );
                i++;
            }
        %>
 </table>

 </body>
</html>
