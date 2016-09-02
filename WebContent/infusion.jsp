<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Infuse Your Weapon</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
</head>
<body id="infusionPage">
	<ul>
		<li><a href="Inventory.do">List All Weapons</a></li>
	</ul>

	<div class="infusionDiv">
	<h2>Infusions</h2>
	
	<h3>Choose Your Weapon</h3>
	<form action="Infusion.do" method="POST" class="form-horizontal">
		<select name="menu">
			<c:forEach var="weapon" items="${weaponList}">
			<option value="${weapon.name}">${weapon.name}</option>
			</c:forEach>
		</select>
		<br>
		<h3>Choose Your Infusion</h3>
		<!-- <input type="text" placeholder="Infusion" name="damageType"/> -->
		<br>
		<input type="checkbox" name="damageType" value="Physical"/>
		Physical<br>
		<input type="checkbox" name="damageType" value="Bleed"/>
		Bleed<br>
  		<input type="checkbox" name="damageType" value="Fire" />
		Fire<br>
  		<input type="checkbox" name="damageType" value="Chaos" />
  		Chaos<br>
  		<input type="checkbox" name="damageType" value="Lightning" />
  		Lightning<br>
  		<input type="checkbox" name="damageType" value="Magic" />
  		Magic<br>
  		<input type="checkbox" name="damageType" value="Dark" />
  		Dark<br>
  		<br>
		<input class="removeButton" type="submit" name="button" value="Infuse Weapon"/><br>
	
	</form>
	</div>

</body>
</html>