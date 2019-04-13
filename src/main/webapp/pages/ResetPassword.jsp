<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
    * {
      box-sizing: border-box;
    }

    /* Style the body */
    body {
      font-family: Arial, Helvetica, sans-serif;
      margin: 0;
    }

    /* Header/logo Title */
    .header {
      padding: 80px;
      text-align: center;
      background: #1abc9c;
      color: white;
    }

    /* Increase the font size of the heading */
    .header h1 {
      font-size: 40px;
    }

    /* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
    .navbar {
      overflow: hidden;
      background-color: #333;
      position: sticky;
      position: -webkit-sticky;
      top: 0;
    }

    /* Style the navigation bar links */
    .navbar a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 14px 20px;
      text-decoration: none;
    }


    /* Right-aligned link */
    .navbar a.right {
      float: right;
    }

    /* Change color on hover */
    .navbar a:hover {
      background-color: #ddd;
      color: black;
    }

    /* Active/current link */
    .navbar a.active {
      background-color: #666;
      color: white;
    }

    /* Column container */
    .row {
      display: -ms-flexbox; /* IE10 */
      display: flex;
      -ms-flex-wrap: wrap; /* IE10 */
      flex-wrap: wrap;
    }

    /* Create two unequal columns that sits next to each other */
    /* Sidebar/left column */
    .side {
      -ms-flex: 30%; /* IE10 */
      flex: 30%;
      background-color: #f1f1f1;
      padding: 20px;
    }

    /* Main column */
    .main {
      -ms-flex: 70%; /* IE10 */
      flex: 70%;
      background-color: white;
      padding: 20px;
    }

    /* Fake image, just for this example */
    .fakeimg {
      background-color: #aaa;
      width: 100%;
      padding: 20px;
    }

    /* Footer */
    .footer {
      padding: 20px;
      text-align: center;
      background: #ddd;
    }

    /* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 700px) {
      .row {
        flex-direction: column;
      }
    }

    /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
    @media screen and (max-width: 400px) {
      .navbar a {
        float: none;
        width: 100%;
      }
    }
</style>
<script>
function validate()
{
 var email = document.form.email.value;
 var password = document.form.password.value;
 var conpassword= document.form.conpassword.value;


  if (email==null || email=="")
 {
 alert("Email can't be blank");
 return false;
 }
 else if(password.length<6)
 {
 alert("Password must be at least 6 characters long.");
 return false;
 }
 else if (password!=conpassword)
 {
 alert("Confirm Password should match with the Password");
 return false;
 }
 }
</script>
</head>
<body>

<div class="header">
    <h1>CINEMA PLAZА</h1>
    <p><b>Welcome</b> to our website.</p>
</div>

<div class="navbar">
    <a href="MainController" class="active">Home</a>
    <a href="#">Link</a>
    <a href="LoginServlet" class="right">Sign in</a>
    <a href="RegisterServlet" class="right">Sign up</a>
</div>

<form name="form" action="ResetPasswordServlet" method="post" onsubmit="return validate()">
<table align="center">

 <td>Email</td>
 <td><input type="text" name="email" /></td>
 </tr>

 <tr>
 <td>New Password</td>
 <td><input type="password" name="password" /></td>
 </tr>
 <tr>
 <td>Confirm Password</td>
 <td><input type="password" name="conpassword" /></td>
 </tr>
 <tr>
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Change password"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>

<div class="footer">
    <h2>Footer</h2>
</div>

</body>
</html>