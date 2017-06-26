
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="controller?action=home">RoadTex</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="controller?action=home">Home</a></li>
						<li><a href="controller?action=userman">User Management</a></li>
						<li><a href="controller?action=role">Create Role</a></li>
						<li><a href="controller?action=roleperm">Role Permissions</a></li>
						<li><a href="controller?action=addcus">Client</a></li>
						<li><a href="#"><%=session.getAttribute("user")%></a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						
						<li><a href="controller?action=logout">Log Out</a></li>
					</ul>

				</div>
			</div>
		</nav>
	</div>
	<!--  blah -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>