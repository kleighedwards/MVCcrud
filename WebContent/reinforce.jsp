<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Reinforce Weapon</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
</head>
<body id="reinforcePage">

	<ul>
		<li><a href="Inventory.do">List All Weapons</a></li>
	</ul>

	<div class="infusionDiv">
	
	<h2>Reinforce Weapon</h2>
	<br>
	
	<div class="container">
	<div class="row">
	<div class="verticalcenter text-center">
	
	<h3>Choose Your Weapon</h3>

	<div class="form-group">
		<form action="Reinforce.do" method="POST">
			<select name="menu" class="form-control">
				<c:forEach var="weapon" items="${weaponList}">
				<option value="${weapon.name}">${weapon.name}</option>
				</c:forEach>
			</select>
			<br>
			<br>
			<input class="removeButton" type="submit" name="button" value="Reinforce Weapon"/><br>
		</form>
	</div>
	
	</div>
	</div>
	</div>
	</div>
	
</body>
</html>