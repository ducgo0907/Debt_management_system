<%-- 
    Document   : check-email
    Created on : Feb 23, 2023, 10:35:42 PM
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
        <!-- Custom Stylesheet -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: Arial, sans-serif;
                font-size: 16px;
                line-height: 1.6;
                color: #444;
                background-color: #f4f4f4;
                padding: 0;
                margin: 0;
            }
            .container {
                max-width: 500px;
                margin: 0 auto;
                padding: 30px;
                background-color: #fff;
                border: 5px;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            h1 {
                font-size: 36px;
                font-weight: bold;
                margin-top: 0;
            }
            p {
                margin-bottom: 1.5em;
            }
            button {
                display: inline-block;
                background-color: #1a73e8;
                color: #fff;
                font-size: 16px;
                font-weight: bold;
                text-transform: uppercase;
                border: none;
                border-radius: 4px;
                padding: 10px 20px;
                cursor: pointer;
                border: 5px;
                border-radius: 10px;
            }
            button:hover {
                background-color: #0c5aa7;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Kiểm Tra Email Của Bạn</h1>
            <p>Một email kích hoạt đã được gửi đến email của bạn. Hãy kiểm tra hòm thư trong email của bạn và làm theo hướng dẫn. </p>
            <button onclick="window.location.href = 'login.jsp';">Quay trở lại trang đăng nhập</button>
        </div>
    </body>
</html>
