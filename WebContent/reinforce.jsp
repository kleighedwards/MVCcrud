<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Reinforce Weapon</title>
</head>
<body>

	<h2>Reinforce Weapon</h2>
	
	<h3>Choose Your Weapon</h3>

	<div class="weaponSelect">
		<form action="Reinforce.do" method="POST">
			<select name="menu">
				<c:forEach var="weapon" items="${weaponList}">
				<option value="${weapon.name}">${weapon.name}</option>
				</c:forEach>
			</select>
			<input type="submit" name="button" value="Reinforce Weapon"/><br>
		</form>
	</div>
</body>
</html>