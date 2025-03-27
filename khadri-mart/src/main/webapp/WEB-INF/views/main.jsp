<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style>
.container {
	display: flex;
	flex-direction: column;
	height: 100vh;
}

.top {
	height: 10%;
}

.main-content {
	display: flex;
	flex-grow: 1;
}

.left-pane {
	width: 20%;
	display: flex;
	flex-direction: column;
}

.bottom-left-frame {
	flex: 1; 
	border: none;
}

.right-pane {
	width: 80%;
}
</style>
</head> 
<body>
	<div class="container">
		<div class="top">
			<iframe name="top" src="top"
				style="width: 100%; height: 100%; border: none;"></iframe>
		</div>
		<div class="main-content">
			<div class="left-pane">
				<iframe name="bottom-left-gro" src="bottom-left-gro"
					class="bottom-left-frame"></iframe>
				<iframe name="bottom-left-clo" src="bottom-left-clo"
					class="bottom-left-frame"></iframe>
				<iframe name="bottom-left-fru" src="bottom-left-fruits"
					class="bottom-left-frame"></iframe>
				<iframe name="bottom-left-cos" src="bottom-left-veg"
					class="bottom-left-frame"></iframe>
			</div>
			<div class="right-pane">
				<iframe name="bottom-right" src="bottom-right"
					style="width: 100%; height: 100%; border: none;"></iframe>
			</div>
		</div>
	</div>
</body>
</html>
