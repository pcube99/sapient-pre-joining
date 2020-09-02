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
	<form action = "Calculator">
		<input type="number" name = "number1"><br>
		<input type="number" name = "number2"><br>
		<br>
		<input type="submit" value="calculate" placeholder="calculate">
		<br>
	</form>

    <h3>Choose below option :</h3>
    <a href='add'>Add numbers</a>
    <br>
    <a href='multiplication'>Multiplication numbers</a>
    <br>
    <a href='subtraction'>Subtraction numbers</a>
    <br>
    <a href='division'>Division numbers</a>
    <br>
    <a href='history'>History numbers</a>
    <br>
</body>
</html>