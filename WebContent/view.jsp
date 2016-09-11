<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Andre's Smithy</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
</head>
<body id="listWeapons">
		<ul>
			<li><a href="goToAdd.do">Add Weapon To Inventory</a></li>
		
			<li><a href="goToInfusion.do">Infuse Weapon</a></li>
		
			<li><a href="goToReinforce.do">Reinforce Weapon</a></li>
		
			<li><a href="sortByClass.jsp">Sort By Weapon Class</a><li>
		</ul>

	<br>

	<div class="tableDiv">

	<h2>Your Inventory</h2>
	
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Base Damage</td>
				<td>Damage Type</td>
				<td>Weapon Class</td>
				<td>Remove from Inventory</td>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="weapon" items="${weaponList}">
			
			<tr>
				<td>${weapon.name}</td>
				<td>${weapon.attackRating}</td>
				<%-- <c:forEach var="infusion" items="${weapon.infusions}">
					${infusions}
				</td>
				</c:forEach> --%>
				<td>${weapon.damageType}</td>
				<td>${weapon.weaponClass}</td>
				<td>
					<form class="removeButton" action="removeInventory.do" method="POST">
						<input type="hidden" value="${weapon.name}" name="weapon"/>
						<input type="submit" value="Remove"/>
					</form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	</div>
	<br>
	
</body>
</html>