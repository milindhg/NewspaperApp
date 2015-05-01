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
  <title>Add Business Feed</title>
  <link
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
  <div class="container">
    <section class="register">
			<h2>Hi ${sessionUser.firstName } ${sessionUser.lastName }</h2>
      <h1>Edit Feed</h1>
      <form method="post" action="editfeed">
      <div class="reg_section personal_info">
      <input type="hidden" name="id" value="${feed.id}">
      <input type="text" name="headline" value="${feed.headline}" placeholder="Your Headline Name">
      </div>
      <p class="submit"><input type="submit" name="commit" value="Save Feed"></p>
      </form>
    </section>
    <div class="reg_section password">
    	<a href="logout"> Logout </a>
    </div>
  </div>


</body>
</html>