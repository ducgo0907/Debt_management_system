<%-- 
    Document   : account-activated
    Created on : Feb 25, 2023, 7:45:35 PM
    Author     : bang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Debt Management System</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
        <style>
            /* center the body content */
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            /* add border to content */
            div {
                border: 2px solid black;
                padding: 20px;
                border-radius: 10px;
            }

            /* style heading */
            h2 {
                color: green;
                text-align: center;
                margin-bottom: 20px;
            }

            /* style paragraph */
            p {
                text-align: center;
            }

            /* style button */
            button {
                display: block;
                margin: 0 auto;
                border: 2px solid black;
                border-radius: 10px;
                background-color: white;
                color: black;
                padding: 10px 20px;
                font-size: 16px;
                text-decoration: none;
                cursor: pointer;
            }

            button:hover {
                background-color: #ccc;
            }

        </style>
    </head>
    <body>
        <div>
            <h2>Tài khoản đã được kích hoạt</h2>
            <p>Tài khoản của bạn đã được kích hoạt thành công.</p>
            <p>Bây giờ bạn có thể đăng nhập vào hệ thống Debt Management System.</p>
            <button onclick="window.location.href = 'login.jsp'">Đăng nhập ngay</button>
        </div>
    </body>
</html>

