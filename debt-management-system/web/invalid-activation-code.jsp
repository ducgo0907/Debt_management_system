<%-- 
    Document   : invalid-activation-code.jsp
    Created on : Feb 25, 2023, 8:24:26 PM
    Author     : bang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Debt Management System</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
        <style>
            /* Global styles */
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                box-sizing: border-box;
            }

            /* Header styles */
            .header {
                text-align: center;
                margin-top: 50px;
                margin-bottom: 50px;
            }

            .header h1 {
                font-size: 2em;
                margin: 0;
            }

            /* Content styles */
            .content {
                text-align: center;
            }

            .content p {
                font-size: 1.2em;
                margin: 20px 0;
            }

            /* Button styles */
            .button {
                display: inline-block;
                font-size: 1.2em;
                text-decoration: none;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            .button:hover {
                background-color: #3e8e41;
            }

            /* Responsive styles */
            @media only screen and (max-width: 600px) {
                .container {
                    padding: 10px;
                }

                .header h1 {
                    font-size: 1.5em;
                }

                .content p {
                    font-size: 1em;
                }

                .button {
                    font-size: 1em;
                    padding: 8px 16px;
                }
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1 style="color: red">Có gì đó không ổn!!!</h1>
            </div>
            <div class="content">
                <p><b>Kích hoạt tài khoản thất bại!</b></p>
                <p>Báo cáo vấn đề của bạn bằng cách gửi email đến cho chúng tôi tại địa chỉ nguyenht65.temp@gmail.com</p>
                <a href="register.jsp" class="button">Quay lại trang đăng ký</a>
            </div>
        </div>
    </body>
</html>
