<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>

<head><title>Ajouter un Champ</title>
<link href="css/champNew.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
			<div class="form-style-2-heading">Ajouter un champ</div>
		
		<h:outputLabel  value="Module  "  /> <span id="s1">
		<h:selectOneMenu   value="#{champController.idmodule}" >
				<f:selectItems   value="#{champController.selectItemsModule}" />
				<a4j:support event="onchange" reRender="listeEtapes" action="#{champController.chargerEtape}"/>
    	</h:selectOneMenu></span>
			   <br/><br/>
	
		   <h:outputLabel value="Etape  " />	
		 <span id="s2">
		<h:selectOneMenu   value="#{champController.numetape}" id="listeEtapes">
				<f:selectItems   value="#{champController.selectItemsEtape}" />		
	   <a4j:support event="onchange" reRender="listeMenus" action="#{champController.chargerMenu}"/>
		</h:selectOneMenu>	   </span>
		
	
		   <br/><br/>
		   <h:outputLabel value="Contexte  " /><span id="s3">   
		<h:selectOneMenu value="#{champController.contexte}">
		<f:selectItem itemLabel="pre-traitement" itemValue="pre-traitement" />
		<f:selectItem itemLabel="traitement" itemValue="traitement" />
		<f:selectItem itemLabel="validation" itemValue="validation" />
        <a4j:support event="onchange" reRender="listeMenus" action="#{champController.chargerMenu}"/>
		</h:selectOneMenu></span>
	
		   <br/><br/>
		   
	   	<h:outputLabel value="Menu  " /><span id="s4">
		<h:selectOneMenu  id="listeMenus" value="#{champController.idmenu}" >
				<f:selectItems   value="#{champController.selectItemsMenu}" />				
		</h:selectOneMenu></span>
	
		<br/><br/>
     	<h:outputLabel value="Type de champ" /><span id="s5">	    
		<h:selectOneMenu value="#{champController.idtype}">
			<f:selectItems   value="#{champController.selectItemsType}" />		
		    <a4j:support event="onchange" reRender="form"/> 
		</h:selectOneMenu></span>
		
		<br/><br/>
		
		<h:outputLabel value="Valeur du champ" /><span id="s6">
		<rich:calendar timeZone="#{champController.timeZone}"  id="date" rendered="#{champController.typeDate}" 
			 value="#{champController.texte}" datePattern="dd/MM/yyyy" >
         </rich:calendar>
		<h:inputText id="text" rendered="#{!champController.typeDate}" value="#{champController.texte}"/>
		</span>
        <br/><br/>
        
        <h:outputLabel value="Action" /><span id="s7">	    
		<h:selectOneMenu value="#{champController.idaction}">
			<f:selectItems   value="#{champController.selectItemsAction}" />		
		</h:selectOneMenu></span>	
	     
	             <br/><br/>
	     
	     
        <h:outputLabel value="Selecteur" /><span id="s8">	    
		<h:selectOneMenu value="#{champController.idselecteur}">
			<f:selectItems   value="#{champController.selectItemsSelecteur}" />		
		</h:selectOneMenu></span>
	
	                   <br/><br/>
	    <h:outputLabel value="Valeur du Selecteur" /><span id="s9">	    
		<h:inputText value="#{champController.valeurSelecteur}"/></span>
					<br/><br/><br/>
		<span id="submit">
	    <h:commandButton value="Valider" action="#{champController.add}"/>
	    </span>
	</h:form>
                    
	</f:view>
</body>
</html>
