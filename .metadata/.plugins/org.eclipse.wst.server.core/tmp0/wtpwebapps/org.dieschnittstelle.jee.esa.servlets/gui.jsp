<%@page
	import="org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint,org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Touchpoints</title>
</head>
<body>
	<!--  print out the class hierarchy -->
	<%=this%>
	<br />
	<%
		Class klass = this.getClass();
		String tabs = "";
		do {
	%><%=tabs + klass%><br />
	<%
		klass = klass.getSuperclass();
			tabs += "\t";
		} while (klass != null);
	%>

	<!--  access session attributes and their constituents -->
	<h3>Touchpoints</h3>

	<!-- create a table -->
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Strasse</th>
			<th>Postleitzahl</th>
			<th>Ort</th>
			<td></td>
		</tr>
		<!--  iterate over the touchpoints -->
		<%
			List<AbstractTouchpoint> touchpoints = (List<AbstractTouchpoint>) request
					.getAttribute("touchpoints");
			for (AbstractTouchpoint touchpoint : touchpoints) {
				if (touchpoint instanceof StationaryTouchpoint) {
		%>
		<tr>
			<td><%=touchpoint.getId()%></td>
			<td><%=touchpoint.getName()%></td>
			<td><%=((StationaryTouchpoint) touchpoint).getLocation()
							.getStreet()%>
				<%=((StationaryTouchpoint) touchpoint).getLocation()
							.getHouseNr()%></td>
			<td><%=((StationaryTouchpoint) touchpoint).getLocation()
							.getZipCode()%></td>
			<td><%=((StationaryTouchpoint) touchpoint).getLocation()
							.getCity()%></td>
			<td>
				<!--  we add a delete button -->
				<form method="POST"
					action="/org.dieschnittstelle.jee.esa.servlets/gui/touchpoints/delete/<%=touchpoint.getId()%>">
					<input type="submit" value="delete">
				</form>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<!--  create a new touchpoint -->
	<h3>New Touchpoint</h3>
	<form method="POST" action="/org.dieschnittstelle.jee.esa.servlets/gui/touchpoints/create/">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Street and HouseNr:</td>
				<td><input type="text" name="street"><input
					type="text" size="4" name="houseNr"></td>
			</tr>
			<tr>
			<td>Zip Code and City:</td>
			<td><input type="number" name="zipCode" size="5" ><input
				type="text" name="city"></td>
			</tr>
		</table>
		<input type="submit" value="create" />
	</form>
</body>
</html>