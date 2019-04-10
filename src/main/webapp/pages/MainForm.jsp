<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cinema Plaza</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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

<div class="row">
    <div class="side">
        <h2>About Us</h2>
        <p>Maybe there will be some buttons</p>
        <h3>Maybe some additional info</h3>
        <p>Some info</p>
        <div class="fakeimg" style="height:60px;">Image or sth like that</div><br>
        <div class="fakeimg" style="height:60px;">the same</div><br>
        <div class="fakeimg" style="height:60px;">the same</div>
    </div>
    <div class="main">
        <h2>STILL IN THE CINEMA</h2>
        <h5>Ferdinand, May 7, 2019</h5>
        <div> <img src="ferdinand.jpg" alt="Ferdinand picture" width="200" height="300">
        </div>
        <p>After Ferdinand, a bull with a big heart, is mistaken for a dangerous beast, he is captured and torn from his home. Determined to return to his family, he rallies a misfit team on the ultimate adventure.</p>
        <p>Director: Carlos Saldanha
            <br>
            Writers: Robert L. Baird (screenplay by), Tim Federle (screenplay by)
            <br>
            Stars: John Cena, Kate McKinnon, Bobby Cannavale
        </p>
        <h5>The Great Gatsby, May 13, 2019</h5>
        <div> <img src="gatsby.jpg" alt="The Great Gatsby picture" width="200" height="300"/></div>
        <p>A writer and wall street trader, Nick, finds himself drawn to the past and lifestyle of his millionaire neighbor, Jay Gatsby.</p>
        <p>Director: Baz Luhrmann
            <br>
            Writers: Baz Luhrmann (screenplay), Craig Pearce (screenplay)
            <br>
            Stars: Leonardo DiCaprio, Carey Mulligan, Joel Edgerton </p>
    </div>
</div>

<div class="footer">
    <h2>Footer</h2>
</div>

</body>
</html>