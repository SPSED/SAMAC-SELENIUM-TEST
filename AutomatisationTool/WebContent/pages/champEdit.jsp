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
<title>Modification du champ</title>
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
			
				
			<div class="form-style-2-heading">Modification du champ</div>
								<br/><br/>
			
		<h:outputLabel value="libelle" /><span id="s10">	    
		<h:inputText value="#{champController.champ.libelle}"/></span>
					<br/><br/>
		
		<h:outputLabel  value="Module  "   /> <span id="s1">
		<h:selectOneMenu   value="#{champController.champ.etape.module.idModule}" >
				<f:selectItems   value="#{champController.selectItemsModule}" />
				<a4j:support event="onchange" reRender="listeEtapes" action="#{champController.chargerEtape2}"/>
    	</h:selectOneMenu></span>
			   <br/><br/>
	
		   <h:outputLabel value="Etape  " /><span id="s2">
		<h:selectOneMenu   value="#{champController.champ.etape.numEtape}" id="listeEtapes">		
				<f:selectItems   value="#{champController.selectItemsEtape}" />		
	   <a4j:support event="onchange" reRender="listeMenus" action="#{champController.chargerMenu2}"/>
		</h:selectOneMenu>	   </span>
		
	
		   <br/><br/>
		   <h:outputLabel value="Contexte  " /><span id="s3">   
		<h:selectOneMenu value="#{champController.champ.contexte}">
		<f:selectItem itemLabel="pre-traitement" itemValue="pre-traitement" />
		<f:selectItem itemLabel="traitement" itemValue="traitement" />
		<f:selectItem itemLabel="validation" itemValue="validation" />
        <a4j:support event="onchange" reRender="listeMenus" action="#{champController.chargerMenu2}"/>
		</h:selectOneMenu></span>
	
		   <br/><br/>
		   
	   	<h:outputLabel value="Menu  " /><span id="s4">
		<h:selectOneMenu  id="listeMenus" value="#{champController.champ.menu.idMenu}" >
				<f:selectItems   value="#{champController.selectItemsMenu}" />				
		</h:selectOneMenu></span>
	
		<br/><br/>
     	<h:outputLabel value="Type de champ" /><span id="s5">	    
		<h:selectOneMenu value="#{champController.champ.typeChamp.idType}">
			<f:selectItems   value="#{champController.selectItemsType}" />		
		    <a4j:support event="onchange" reRender="form"/> 
		</h:selectOneMenu></span>
		
		<br/><br/>
		<h:outputLabel value="Valeur du champ" /><span id="s6">
		<rich:calendar timeZone="#{champController.timeZone}"  id="date" rendered="#{champController.typeDate2}" 
			 value="#{champController.champ.texteDate}" datePattern="dd/MM/yyyy" >
         </rich:calendar>
		<h:inputText id="text" rendered="#{!champController.typeDate2}" value="#{champController.champ.texte}"/>
		</span>
        <br/><br/>
        
        <h:outputLabel value="Action" /><span id="s7">	    
		<h:selectOneMenu value="#{champController.champ.action.idAction}">
			<f:selectItems   value="#{champController.selectItemsAction}" />		
		</h:selectOneMenu></span>	
	     
	             <br/><br/>
	     
	     
        <h:outputLabel value="Selecteur"  /><span id="s8">	    
		<h:selectOneMenu value="#{champController.champ.selecteur.idSelecteur}" readonly="true">
			<f:selectItems   value="#{champController.selectItemsSelecteur}" />		
		</h:selectOneMenu></span>
	
	                   <br/><br/>
	    <h:outputLabel value="Valeur du Selecteur" /><span id="s9">	    
		<h:inputText value="#{champController.champ.valeurSelecteur}" readonly="true" /></span>
					<br/><br/><br/>
		<span id="submit">
	    <h:commandButton value="Valider" action="#{champController.edit}" style="background:#FDC507"   />
	    </span>
	</h:form>
                    
	</f:view>
</body>
</html>
