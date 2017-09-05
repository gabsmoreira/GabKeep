<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src = "js/index.js" type = "text/javascript"/></script>    
  </head>

  <body>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

   <nav >
    <div class="nav-wrapper cyan darken-2" style="height:115%">
    <div class="row cyan darken-2">
        <div class="col s4 m4 ">
      <a href="" class="brand-logo" style="margin-top:0.5%"><i class="material-icons">cloud</i>GabKeep</a>
        </div>
        <div class="col s4 m4 ">
            <nav class="cyan darken-2 hide-on-med-and-down" >
                <div class="nav-wrapper cyan darken-1 hide-on-med-and-down" style="margin-top:0.8%" >
                  <form  >
                    <div class="input-field">
                      <input id="search" type="search" required >
                      <label class="label-icon" for="search"><i class="large material-icons"  >search</i></label>
                      <i class="material-icons">close</i>
                    </div>
                  </form>
                </div>
              </nav>
        </div>
        <div class="col s4 m4">
      <ul class="right hide-on-small-only" style="margin-top:1%">
        <li><a href="#"><i class="material-icons">settings</i></a></li>
        <li><a href="#"><i class="material-icons">person</i></a></li>
      </ul>
        </div>
    </div>
  </nav>

     
        

      <div class="row">
          <div class="col s12"><p style="color:white">ola</p></div>
          <div class="col s12 m2 l2"></div>
          <div class="col s12 m8 l8"><nav>
              <div class="nav-wrapper cyan darken-1">
                <form id="textform" action="/GabKeep/create">
                  <div class="input-field">
                    <input id="textinput" type="search" required NAME="textinput" >
                    <label class="label-icon " for="search"><i class="material-icons align-wrapper">add</i></label>
                    <i class="material-icons">close</i>
                  </div>
                </form>
              </div>
            </nav></div>
          <div class="col s12 m2 l2"></div>
        </div>



        <div class="row container" id="cont_card">
        
        <%@ page import="java.util.*,br.keep.*" %>
        <% GabKeep gabkeep = new GabKeep();
		 List<Notes> notes = gabkeep.getLista();
		 for (Notes note : notes ) { %>
		 
		 	<div class="col s12 m6 l3 center-align"> 
			    <div class="card amber lighten-1 z-depth-3 hoverable">
			    <div class="card-content" id = "content" >
			    
			      <%=note.getContent()%>
			      
		
			    </div>
			    	<div class="s3 m3 l3  right-align" style="width=40%">
			    		<a role="button"  class=" material-icons" style="font-size:20px; padding-right:1%">brush</a>	
			    		<a class=" material-icons delete_button " style="font-size:20px; padding-right:1%" onclick="deletenote()" href="remove?id=<%=note.getId()%>">delete</a>
					<a id="change_button<%=note.getId() %>" class=" modal-trigger material-icons" style="font-size:20px; padding-right:2%" href="#modal<%=note.getId()%>" onclick="changeNote()">save</a>		 		 </div>
			    </div>                
		    </div>
		    
		   
		 
		<% } %>
		
  		<%@ page import="java.util.*,br.keep.*" %>
		 <%  for (Notes note : notes ) { %>
  
        
         <!-- Modal Structure -->
			  <div id="modal<%=note.getId() %>" class="modal bottom-sheet">
			    <div class="modal-content">
			      <h4>Edit Note</h4>
			      <form action="refresh" method="post">
			      <input type="hidden" name="id" value="<%=note.getId() %>"></input>
			      <input name="content"></input>
			      <button type="submit" class="modal-action modal-close waves-effect waves-green btn-flat cyan darken-1">Done</button>
			      </form>
			    </div>
			    
			  </div>
			  
			  <script>
			  $('.modal').modal();                        
	
		  </script>

        <%} %>
          

      



      
  </body>
</html>