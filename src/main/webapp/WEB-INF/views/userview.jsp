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
  <title>Home</title>
  <link
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
  <div class="container">
    <section class="register">
			<h2>Hi ${sessionUser.firstName } ${sessionUser.lastName }</h2>
      <h1>User View</h1>
      <div class="reg_section personal_info">
				<table border="1">
					<tr>
						<th><h3>Internet Headlines</h3></th>
					</tr>
					<c:forEach items="${internetfeeds}" var="feed">
						<tr>
							<td>${feed.headline}</td>
						</tr>
					</c:forEach>
				</table>      
      </div>
      <div class="reg_section personal_info">
				<table border="1">
					<tr>
						<th><h3>Newspaper Headlines</h3></th>
					</tr>
					<c:forEach items="${newspaperfeeds}" var="feed">
						<tr>
							<td>${feed.headline}</td>
						</tr>
					</c:forEach>
				</table>      
      </div>
      <div class="reg_section personal_info">
				<table border="1">
					<tr>
						<th><h3>Twitter Headlines</h3></th>
					</tr>
					<c:forEach items="${twitterfeeds}" var="feed">
						<tr>
							<td>${feed.headline}</td>
						</tr>
					</c:forEach>
				</table>      
      </div>
      <p class="terms">
        <label>
          <!-- <input type="checkbox" name="remember_me" id="remember_me"> -->
           ${message}
        </label>
      </p>
      <p class="submit"></p>
    </section>
    <div class="reg_section password">
    	<a href="logout"> Logout </a>
    </div>
  </div>


</body>
</html>