<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create Your Own Pizza</title>
</head>
<body>

<form action="CustomizePizza" method="post">
<table border="1">
 <tr>
   <td>Crust</td>
   <td>
     <select name="crust">
     <c:forEach items="${crusts}" var="crust" varStatus="status">
       <option value="${status.index}">${crust.name}, $${crust.price}</option>
     </c:forEach>
     </select>
   </td>
 </tr>
 
 <tr>
   <td>Cheese</td>  
   <td>
     Normal Cheese <input type="radio" name="cheese" checked="checked" value="1" />
     No Cheese <input type="radio" name="cheese" value="0" />
   </td>
 </tr>

 <tr>
   <td>Toppings</td>
   <td>
     <c:forEach items="${toppings}" var="topping">
       <input type="checkbox" name="topping" value="${topping}" /> ${topping}<br />
     </c:forEach>
   </td>
 </tr>
 
 <tr>
   <td colspan="2"><input type="submit" name="Add" value="Add to Order" /></td>
 </tr>
</table>
</form>

</body>
</html>