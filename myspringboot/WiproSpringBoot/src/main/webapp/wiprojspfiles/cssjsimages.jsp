
<!-- JSTL is a combination of JSP.. -->
<%@taglib prefix="wiprotag" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<!-- wiprotag:url(url encoding happens) ONLY FOR ASSIGING SRC/MAIN/RESOURCES PATH -->
    <link href="<wiprotag:url value="/mycss/wiprostyle.css" />" rel="stylesheet">
    <script src="<wiprotag:url value="/myjavascripts/firstscript.js" />"></script>
</head>

    <h2>Hi This style is defined in EXTERNAL CSS file</h2>
   <input type="button" onclick="disp()" value="Call Javascript(static)" />

    <img height = 500 width=500 src="<wiprotag:url value="/myimages/Lighthouse.jpg">
 </wiprotag:url>"/>	

<body>
