<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>Change Password</title>
 <!-- <link rel="stylesheet" href="style.css"> -->
 <link href="https://fonts.googleapis.com/css?family=Roboto"; rel="stylesheet">

 <style>
 /* General styles */
* {
 box-sizing: border-box;
 margin: 0;
 padding: 0;
 }

 body {
 font-family: 'Roboto', sans-serif;
 background-color: #baa3a0;
 }

 .container {
 display: flex;
 }

 /* Header styles */
 header {
 display: flex;
 justify-content: space-between;
 align-items: center;
 background-color: #999190;
 padding: 10px 20px;
 box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
 }

 .logo img {
 height: 50px;
 }

 .logout button {
 background-color: #FF4136;
 color: #fff;
 border: none;
 padding: 10px 20px;
 border-radius: 4px;
 font-size: 14px;
 cursor: pointer;
 }

 .logout button:hover {
 background-color: #d40000;
 }

 /* Sidebar styles */
 .sidebar {
 background-color: #999190;
 height: calc(100vh - 70px);
 width: 200px;
 padding: 20px;
 box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
 }

 .sidebar ul {
 list-style-type: none;
 }

 .sidebar ul li {
 margin-bottom: 10px;
 }

 .sidebar ul li a {
 display: flex;
 align-items: center;
 color: #333;
 text-decoration: none;
 font-size: 16px;
 }

 .sidebar ul li a img {
 height: 20px;
 margin-right: 10px;
 }

 .sidebar ul li a:hover {
 color: #FF4136;
 }

 /* Content styles */
 .content {
 padding: 20px;
 flex: 1;
 }

 h1 {
 font-size: 28px;
 margin-bottom: 20px;
 }

 form {
 max-width: 400px;
 margin: 0 auto;
 }

 .form-group {
 margin-bottom: 20px;
 }

 label {
 display: block;
 margin-bottom: 5px;
 }

 input[type="password"] {
 width: 100%;
 border: none;
 border-bottom: 2px solid #333;
 padding: 5px;
 font-size: 16px;
 margin-bottom: 10px;
 }

 button[type="submit"] {
 background-color: #FF4136;
 color: #fff;
 border: none;
 padding: 10px 20px;
 border-radius: 4px;
 font-size: 14px;
 cursor: pointer;
 }

 button[type="submit"]:hover {
 background-color: #d40000;
 }

 </style>
</head>
<body>
 <header>
 <div class="logo">
 <img src="logo.png" alt="Logo">
 </div>
 <div class="logout">
 <button>Log out</button>
 </div>
 </header>
 <div class="container">
 <div class="sidebar">
 <ul>
 <li>Dept Management</a></li>
 <li>Service</li></a></li>
 </ul>
 </div>
 <div class="content">
 <h1>Change Password</h1>
 <form>
 <div class="form-group">
 <label for="old-password">Old Pass Word:</label>
 <input type="password" id="old-password" name="oldPassword" required>
 </div>
 <div class="form-group">
 <label for="new-password">New Pass Word:</label>
 <input type="password" id="new-password" name="newPassword" required>
 </div>
 <div class="form-group">
 <label for="confirm-password">Confirm New Pass Word:</label>
 <input type="password" id="confirm-password" name="confirmPassword" required>
 </div>
 <button type="submit">Save</button>
 </form>
 </div>
 </div>
</body>
</html>