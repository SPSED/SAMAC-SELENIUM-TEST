
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<head><title>Acueil</title>
 <link href="css/accueil.css" rel="stylesheet" type="text/css"  />
</head>
<body>
	<f:view> 
	<h:form id="form"><br/>
			<div class="form-style-2-heading">Accueil</div>
 		<span id="submit2">	    	
 		<h2 id="m2" >Gestion Champ</h2>
	    <h:commandButton value="valider " action="#{testController.champ}"/>
	    </span><br/><br/><br/><br/>
	    
		 <span id="submit2">	    	
 		<h2 id="m2" >Gestion Test</h2>
	    <h:commandButton  value="valider" action="#{testController.test}"/>
	    </span><br/><br/><br/>
	    
	</h:form>
                    
	</f:view>
</body>
</html>
