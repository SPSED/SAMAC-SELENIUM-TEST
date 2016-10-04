<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<head><title>Gestion champ</title>
<link href="css/champNew.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
	
			<div class="form-style-2-heading">Gestion champ</div>

	<div id="img" >     <h:commandLink action="#{champController.neww}">
 					    <h:graphicImage  value="images/add.png" width="40px" />
 						</h:commandLink>  </div> 	

<br/><br/>
		<h:outputLabel  value="Module  "  /> <span id="s1">
		<h:inputText value="#{champController.nommodule}"/></span>
			   <br/><br/>
	
		   <h:outputLabel value="Etape  " />	
		 <span id="s2">
		<h:inputText value="#{champController.nometape}"/> </span>
		
	
		   <br/><br/>
		   
	   	<h:outputLabel value="Menu  " /><span id="s4">
		<h:inputText value="#{champController.nommenu}"/></span>
	
		<br/><br/>
		
		<h:outputLabel value="Valeur du champ" /><span id="s6">
		<h:inputText value="#{champController.texte}"/>
		</span>
					<br/><br/><br/>
		<span id="submit">
	    <h:commandButton value="Valider" action="#{champController.find}"/>
	    </span>
	</h:form>
                    
	</f:view>
</body>
</html>
