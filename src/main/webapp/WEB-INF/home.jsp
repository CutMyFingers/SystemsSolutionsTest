<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing</title>
</head>
<body>

	<form action="/calculate" method="GET">
		<h2>The simple calculator for equation ax<sup>2</sup> + bx + c = 0</h2>
		<table>
			<tr>
				<th>Enter coefficients:</th>
			</tr>
			<tr>
				<th align="left">first coeff (a):</th>
				<th><input type="text" name="first_coeff" /></th>

			</tr>
			<tr>
				<th align="left">second coeff (b):</th>
				<th><input type="text" name="second_coeff" /></th>
			</tr>
			<tr>
				<th align="left">third coeff (c):</th>
				<th><input type="text" name="third_coeff" /></th>
			</tr>
			<tr>
				<th colspan="2" align="center"><input type="submit"
					value="Calculate" /></th>
			</tr>
		</table>
	</form>

</body>
</html>