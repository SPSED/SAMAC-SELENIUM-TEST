<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://richfaces.org/rich" prefix="rich" %>
<head><title>Tables des tests</title>
<link href="css/tableTests.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
	<br/>
	<span id="titre"> <h1 >Table des tests</h1></span>
	<div id="img" >     <h:commandLink action="#{testController.home}">
 					    <h:graphicImage  value="images/home.png" width="80px" />
 					  <span id="t" style="text-align:right;color:#FDC507;"> Accueil</span>
 						</h:commandLink> 
     </div> 
	<br/><br/>
	<div id="yo">
	<h:dataTable value="#{testController.listTests}" var="c" rules="all" styleClass="employeeTable"
         headerClass="cTableHeader"
         rowClasses="cTableOddRow,cTableEvenRow" cellpadding="8px" >
   
   <h:column>    				
      <f:facet name="header"><h:outputText>Ordre du test</h:outputText> </f:facet>    				
  <h:outputText value="#{c.idTest}"></h:outputText>   
   </h:column>

   <h:column>    				
      <f:facet name="header"><h:outputText>Nom</h:outputText> </f:facet>    				
  <h:outputText value="#{c.nomTest}"></h:outputText>   
   </h:column>
	
	 
     <h:column>    				
      <f:facet name="header">
      <h:outputText value="Date"/>
      </f:facet>    
      	<h:outputText value="#{c.date}"/>
    </h:column> 

    <h:column>    				
      <f:facet name="header">
      <h:outputText value="Descreption"/>
      </f:facet>    
      	<h:outputText value="#{c.description}"/>
   </h:column> 
   
     <h:column>			
      <f:facet name="header"><h:outputText> Modifier </h:outputText> </f:facet>
        <h:commandLink action="#{testController.edit(c)}">
      <h:graphicImage value="images/edit.png" width="20px" />  				
		</h:commandLink>
   </h:column>
   </h:dataTable>
 		<br/>										
</div>
</h:form>
</f:view></body>