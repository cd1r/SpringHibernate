<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/player.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="resources/js/player.js"></script>
<title>Soccer Player</title>
</head>
<body>
	<h1 id="header">Player List</h1>
	<form action="searchPlayer" class="navbar-form navbar-left" role="search" method="post">
        <input name="keyword" type="text" class="form-control" placeholder="Search" id="searchText">
        <button type="submit" class="btn btn-default" id="searchBtn">Search</button>
    </form>
	<table class="table table-striped table-hover">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>nation</th>
			<th>height</th>
			<th>birth</th>
		</tr>
		<#list players as player>
		<tr>
			<td>${player.id}</td>
			<td>${player.name}</td>
			<td>${player.nation}</td>
			<td>${player.height}</td>
			<td>${player.birth}</td>
		</tr>
		</#list>
	</table>
	<form action="insertPlayer" id="insertForm" class="form-horizontal" method="post">
	  <fieldset>
	    <legend>Insert Player</legend>
	    <div class="form-group">
	      <label for="inputName" class="col-lg-2 control-label">Name</label>
	      <div class="col-lg-10">
	        <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="inputName" class="col-lg-2 control-label">Nation</label>
	      <div class="col-lg-10">
	        <input type="text" name="nation" class="form-control" id="inputNation" placeholder="Nation">
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="inputName" class="col-lg-2 control-label">Height</label>
	      <div class="col-lg-10">
	        <input type="text" name="height" class="form-control" id="inputHeight" placeholder="Height">
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="select" class="col-lg-2 control-label">Birth</label>
	      <div class="col-lg-10">
	        <input type="text" name="birth" class="form-control" id="inputBirth" placeholder="Year-Month-Day">
	      </div>
	    </div>
	    <div class="form-group">
	      <div class="col-lg-10 col-lg-offset-2">
	        <button type="submit" class="btn btn-primary">Register</button>
	      </div>
	    </div>
	  </fieldset>
</form>
	
</body>
</html>