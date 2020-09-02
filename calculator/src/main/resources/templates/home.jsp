<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Calculator Application</title>
</head>
<body>
	<h1>Please Enter 2 Numbers</h1>
	<form action  = "Calculator">
		<input type="number" name = "number1"><br>
		<input type="number" name = "number2"><br>
		<br>
		<input type="submit" placeholder="calculate">
		<br>
	</form>

	<h2>Now goto /add for Addition</h2>
	<h2>Now goto /sub for Subtraction</h2>
	<h2>Now goto /mul for Multiplication</h2>
	<h2>Now goto /div for Division</h2>
	<h2>Now goto /history for History</h2>
</body>
</html>