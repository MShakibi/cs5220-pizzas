<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Your Order</title>
</head>
<body>

<c:if test="${fn:length(order.pizzas) == 0}">
<p>You haven't ordered anything yet. <a href="CustomizePizza">Create Your Own Pizza</a></p>
</c:if>

<c:if test="${fn:length(order.pizzas) > 0}">
<form action="UpdateOrder" method="post">
<table border="1">
<tr>
  <th>Pizza</th><th>Quantity</th><th>Price</th>
</tr>
<c:forEach items="${order.pizzas}" var="pizza" varStatus="status">
<tr>
  <td>${pizza}</td>
  <td><input type="text" name="quantity-${status.index}" value="${pizza.quantity}" /></td>
  <td>${pizza.price}</td>
</tr>
</c:forEach>
<tr>
  <td colspan="2"><b>Total:</b></td>
  <td>${order.total}</td>
</tr>
</table>

<p>
  <a href="CustomizePizza">Add Another Pizza</a>
  <input type="submit" name="update" value="Update Order" />
  <a href="PlaceOrder">Place Order</a>
</p>
</form>
</c:if>

</body>
</html>