<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Infuse Your Weapon</title>
</head>
<body>
	<h2>Infusions</h2>
	
	<h3>Choose Your Weapon</h3>
	<form action="Infusion.do" method="POST">
		<select name="menu">
			<c:forEach var="weapon" items="${weaponList}">
			<option value="${weapon.name}">${weapon.name}</option>
			</c:forEach>
		</select>
		<br>
		<h3>Choose Your Infusion</h3>
		<input type="text" placeholder="Infusion" name="damageType"/>
		<input type="submit" name="button" value="Infuse Weapon"/><br>
	</form>

</body>
</html>