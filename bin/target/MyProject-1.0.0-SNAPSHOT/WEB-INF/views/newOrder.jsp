<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new order</title>
</head>
<body>
		<div>
			<h2>Create a new order</h2>
			<sf:form method="POST" modelAttribute="orderForm">
				<fieldset>
				<table cellspacing="0">
					<tr>
						<th><label for="orderId">Enter order id:</label></th>
						<td><sf:input path="id" size="35" id="orderId"/>
					</tr>
					<tr>
						<th><label for="orderCreatedDate">Order created:</label></th>
						<td><sf:input path="created" size="35" id="orderCreatedDate"/>
					</tr>
					<tr>
						<td>
							<input type="submit" value="create">
						</td>
					</tr>
				</table>	
				</fieldset>
			</sf:form>
		</div>
</body>
</html>