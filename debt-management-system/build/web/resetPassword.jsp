<!DOCTYPE html>
<html>
<head>
	<title>Forgot password</title>
	<style>
		body {
			margin: 0;
			padding: 0;
			font-family: Arial, sans-serif;
		}

		.container {
			max-width: 500px;
			margin: 50px auto;
			padding: 20px;
			background-color: #f2f2f2;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
		}

		h2 {
			margin-top: 0;
		}

		form label {
			display: block;
			margin-bottom: 10px;
		}

		input[type="email"],
		select,
		input[type="text"] {
			width: 100%;
			padding: 8px;
			margin-bottom: 15px;
			border-radius: 4px;
			border: 1px solid #ccc;
			box-sizing: border-box;
		}

		button[type="submit"] {
			background-color: #4CAF50;
			color: white;
			padding: 10px 16px;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}

		button[type="submit"]:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
	<div class="container">
		<h2>Reset password</h2>
                <form action="forgot" method="POST">
			<label for="email">Password</label>
			<input type="password" id="email" name="password" >
			<label for="security-answer">Re-Password</label>
			<input type="password" id="security-answer" name="repassword" >

			<button type="submit">Save</button>
		</form>
	</div>
</body>
</html>
