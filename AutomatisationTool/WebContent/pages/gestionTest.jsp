<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<head><title>Gestion test</title>
<link href="css/champNew.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
	
			<div class="form-style-2-heading">Gestion de tests</div>

	<div id="img" >     <h:commandLink action="#{testController.neww}">
 					    <h:graphicImage  value="images/add.png" width="40px" />
 						</h:commandLink>  </div> 	

		<br/><br/>
		<h:outputLabel  value="Module  "  /> <span id="s1">
			<h:selectOneMenu   value="#{testController.idmodule}" >
				<f:selectItems   value="#{testController.selectItemsModule}" />
				<a4j:support event="onchange" reRender="listeEtapes" action="#{testController.chargerEtape}"/>
    	</h:selectOneMenu></span>
			   <br/><br/>
	
		   <h:outputLabel value="Etape  " /><span id="s2">
			<h:selectOneMenu   value="#{testController.numetape}" id="listeEtapes">
				<f:selectItems   value="#{testController.selectItemsEtape}" />		
		</h:selectOneMenu></span>
		
			
		<br/><br/>
		
		<h:outputLabel value="Nom du test" /><span id="s6">
		<h:inputText value="#{testController.nomtest}"/>
		</span>
					<br/><br/><br/>
		<span id="submit">
	    <h:commandButton value="Rechercher" action="#{testController.find}"/>
	    <span id="l"> </span>
	    <h:commandButton value="Afficher tout" action="#{testController.display}"/>
		
	    </span>
	</h:form>
                    
	</f:view>
</body>
</html>
