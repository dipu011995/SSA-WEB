<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<meta charset="ISO-8859-1">
<title>person_details</title>
</head>
<body>
	<h1 style="color: lime;text-align: center;">PASSPORT REGISTRATION</h1>
	<form:form action="savePerson" method="POST"
		modelAttribute="personDetails">
		<h3 style="color: navy">Person Details</h1>
		<form:hidden path="pid"/>
		
		<table border="5" align="center">
			<tr>
				<td>FIRST NAME :</td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td>LAST NAME :</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td>EMAIL ID :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" id="datepicker" /></td>
				<%-- <td><form:input path="dob"  id = "datepicker"/></td> --%>
				<!-- <td><input type="date" name="dob"  pattern="dd-MM-yyyy"/></td> -->
			</tr>
			<tr>
				<td>GENDER : </td>
				<td>
						<form:radiobutton path="gender" value="M" />Male 
						<form:radiobutton	path="gender" value="F" />Female
				</td>
			</tr>
			<tr>
				<td>ADHAR NO : </td>
				<td><form:input path="adharNo"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="RESET" /></td>
				<td><input type="submit" value="NEXT" /></td>
			</tr>
		</table>
	</form:form>
</body>

<script>
  $(function() {
    $("#datepicker").datepicker();
  });
</script>
</html>