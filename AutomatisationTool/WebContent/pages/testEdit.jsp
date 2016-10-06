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
            <h:commandLink action="#{testController.home}">
               <h:graphicImage value="images/home.png" width="50px" />
               <span id="t" style="text-align: right; color: #FDC507;">
                  Accueil</span>
            </h:commandLink>
         </div>
         <div class="form-style-2-heading">Modification du test</div>
      
               <h:outputLabel value="Nom du test  " /><span id="s4">
      <h:inputText value="#{testController.testEtape.test.nomTest}"/></span>
                  <br/><br/>
      
          <h:outputLabel value="Description" /><span id="s9">      
      <h:inputText value="#{testController.testEtape.test.description}"/></span>
               <br/><br/>
               
      <h:outputLabel  value="Module  "   /> <span id="s1">
      <h:selectOneMenu   value="#{testController.testEtape.etape.module.idModule}" >
            <f:selectItems   value="#{testController.selectItemsModule}" />
            <a4j:support event="onchange" reRender="listeEtapes" action="#{testController.chargerEtape2}"/>
      </h:selectOneMenu></span>
            <br/><br/>
   
         <h:outputLabel value="Etape  " /><span id="s2">
      <h:selectOneMenu   value="#{testController.testEtape.etape.numEtape}" id="listeEtapes">      
            <f:selectItems   value="#{testController.selectItemsEtape}" />      
      </h:selectOneMenu>      </span>
      <br/> <br/> <br/> 
      <span id="submit">
       <h:commandButton value="Modifier" action="#{testController.edit}"/>
       </span><br/><br/>
       <h:messages  globalOnly="true" style="color:yellow" />
   </h:form>
                    
   </f:view>
</body>
</html>
