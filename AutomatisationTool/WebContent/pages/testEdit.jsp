<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<head><title>Modifier un Test</title>
 <link href="css/champNew.css" rel="stylesheet" type="text/css"  />
</head>
<body>
	<f:view> 
	<h:form id="form"><br/>
	<div id="img">
				<h:commandLink action="#{champController.home}">
					<h:graphicImage value="images/home.png" width="50px" />
					<span id="t" style="text-align: right; color: #FDC507;">
						Accueil</span>
				</h:commandLink>
			</div>
			<div class="form-style-2-heading">Modification du test</div>
		
			   	<h:outputLabel value="Nom du test  " /><span id="s4">
		<h:inputText value="#{testController.test.nomTest}"/></span>
					   <br/><br/>
		
		    <h:outputLabel value="Description" /><span id="s9">	    
		<h:inputText value="#{testController.test.description}"/></span>
					<br/><br/>

		<br/><span id="submit">
	    <h:commandButton value="Modifier" action="#{testController.edit}"/>
	    </span><br/><br/>
	    <h:messages  globalOnly="true" style="color:yellow" />
	</h:form>
                    
	</f:view>
</body>
</html>
