<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Information</h2>
      <form:form>
       <h1>  ${name}</h1>
         <h1>  ${age}</h1>
         <h1>  ${id}   </h1>
      </form:form>
   </body>
   
</html>