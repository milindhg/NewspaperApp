<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login</title>
  <link
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
  <div class="container">
    <section class="register">
      <h1>Add New Editor</h1>
      <form method="post" action="adduser">
      <div class="reg_section personal_info">
      <h3>Your Personal Information</h3>
      <input type="text" name="firstname" value="" placeholder="Your First Name">
      <input type="text" name="lastname" value="" placeholder="Your Last Name">
      <input type="text" name="contactnumber" value="" placeholder="Your Contact Number">
      <input type="text" name="email" value="" placeholder="Your E-mail Address">
      </div>
      <div class="reg_section password">
      <h3>Your Password</h3>
      <input type="password" name="password" value="" placeholder="Your Password">
      <input type="password" name="confirm" value="" placeholder="Confirm Password">
      </div>
      <div class="reg_section password">
      <h3>Your Address</h3>
      <select name="department">
        <option value="1">Business</option>
        <option value="2">Entertainment</option>
        <option value="3">Sports</option>
        <!-- <option value="">Italy</option> -->
      </select>
      </div>
      <p class="submit"><input type="submit" name="commit" value="Add Editor"></p>
      </form>
    </section>
    
  </div>

  <section class="about">
    <!-- Download it for free from <a href="http://www.imomen.com/">iMomen</a> -->
    <a href="logout"> Logout </a>
  </section>

</body>
</html>