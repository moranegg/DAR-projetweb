 $(document).ready(function(){
       $('#login').click(function()
       {   
          var nom=$('#nom').val();
          var prenom=$('#prenom').val();
	  var codep=$('#codep').val();
          var email=$('#email').val();
	  var password=$('#password').val();
          
          $.ajax({
               type: "POST",
               url:"InscriptionServlet",
               data:{"nom":nom, "prenom": prenom, "codep":codep,"email":email,"password":password},
               success: function (data) {
                  if(data=='True'){
                    alert('success');
                  }else{
                      alert('Fail....');
                  }
               }
             });                                
           });
         });
