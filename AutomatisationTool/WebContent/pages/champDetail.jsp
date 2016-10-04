<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails du champ</title>
<link href="css/champNew.css" rel="stylesheet" type="text/css"  /> 
</head>
<body>
	<f:view> 
	<h:form id="form">
		<br/>
			<div id="img">
				<h:commandLink action="#{champController.home}">
					<h:graphicImage value="images/home.png" width="50px" />
					<span id="t" style="text-align: right; color: #FDC507;">
						Accueil</span>
				</h:commandLink>
			</div> 
     
	
			<div class="form-style-2-heading">Détails du champ</div>
		
		<h:outputLabel  value="Module  "  /> <span id="s1">
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.etape.module.nomModule}" />
    	</h:selectOneMenu></span>
			   <br/><br/>
	    
		   <h:outputLabel value="Etape  " />	
		 <span id="s2">
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.etape.nomEtape}" />
    	</h:selectOneMenu></span>
		
	
		   <br/><br/>
		   <h:outputLabel value="Contexte  " /><span id="s3">   
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.contexte}" />
    	</h:selectOneMenu></span>
	
		   <br/><br/>
		   
	   	<h:outputLabel value="Menu  " /><span id="s4">
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.menu.nomMenu}" />
    	</h:selectOneMenu></span>
	
		<br/><br/>
     	<h:outputLabel value="Type de champ" /><span id="s5">	    
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.typeChamp.nomType}" />
    	</h:selectOneMenu></span>
		
		<br/><br/>
		<h:outputLabel value="Valeur du champ" /><span id="s6">
		<h:inputText id="text" value="#{champController.champ.texte}" disabled="true" />
		</span>
        <br/><br/>
        
        <h:outputLabel value="Action" /><span id="s7">	    
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.action.action}" />
    	</h:selectOneMenu></span>
			
	     
	             <br/><br/>
	     
	     
        <h:outputLabel value="Selecteur"  /><span id="s8">	    
		<h:selectOneMenu  disabled="true" >
		<f:selectItem itemLabel="#{champController.champ.selecteur.typeSelecteur}" />
    	</h:selectOneMenu></span>
	
	                   <br/><br/>
	    <h:outputLabel value="Valeur du Selecteur" /><span id="s9">	    
		<h:inputText value="#{champController.champ.valeurSelecteur}" disabled="true" /></span>
					<br/><br/><br/>
	</h:form>
                    
	</f:view>
</body>
</html>
