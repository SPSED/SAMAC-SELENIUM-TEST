<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://richfaces.org/rich" prefix="rich" %>
<head><title>Tables des tests</title>
<link href="css/table.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
	<br/>
	<span id="titre"> <h1 >Table des champs</h1></span>
	<div id="img" >     <h:commandLink action="#{champController.home}">
 					    <h:graphicImage  value="images/home.png" width="80px" />
 					  <span id="t" style="text-align:right;color:#FDC507;"> Accueil</span>
 						</h:commandLink> 
     </div> 
	
	<h:dataTable value="#{champController.listChamps}" var="c" rules="all" styleClass="employeeTable"
         headerClass="cTableHeader"
         rowClasses="cTableOddRow,cTableEvenRow" cellpadding="8px" >
   
   <h:column>    				
      <f:facet name="header"><h:outputText>Ordre du champ</h:outputText> </f:facet>    				
  <h:outputText value="#{c.idChamp}"></h:outputText>   
   </h:column>
	
	 <h:column>    				
      <f:facet name="header">
      <h:outputText value="Module"/>
      </f:facet>    
      	<h:outputText value="#{c.etape.module.nomModule}"/>
     </h:column> 
    
     <h:column>    				
      <f:facet name="header">
      <h:outputText value="Etape"/>
      </f:facet>    
      	<h:outputText value="#{c.etape.nomEtape}"/>
     </h:column> 
   
     <h:column>    				
      <f:facet name="header">
      <h:outputText value="Menu"/>
      </f:facet>    
      	<h:outputText value="#{c.menu.nomMenu}"/>
   </h:column> 
   <h:column>			
      <f:facet name="header"><h:outputText>Valeur du champ</h:outputText> </f:facet>    				
      <h:outputText value="#{c.texte}"></h:outputText>    
   </h:column>
   
      <h:column>			
      <f:facet name="header"><h:outputText>Details</h:outputText> </f:facet>
        <h:commandLink action="#{champController.details(c)}">
      <h:graphicImage value="images/detail.png" width="20px" />  				
		</h:commandLink>
   </h:column>
   
     <h:column>			
      <f:facet name="header"><h:outputText> Modifier </h:outputText> </f:facet>
        <h:commandLink action="#{champController.edit(c)}">
      <h:graphicImage value="images/edit.png" width="20px" />  				
		</h:commandLink>
   </h:column>
   
    <h:column>			
      <f:facet name="header"><h:outputText>Supprimer</h:outputText> </f:facet>
        <h:commandLink action="#{champController.delete(c)}">
      <h:graphicImage value="images/delete.png" width="20px" />  				
		</h:commandLink>
   </h:column>
   
   </h:dataTable>
 		<br/>										
<h:outputText value="Table is empty" rendered="#{empty champController.listChamps}"/>
</h:form>
</f:view></body>