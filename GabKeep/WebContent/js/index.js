
var data = []
var $cardContainer = Object()

function card(text){

    return` <div class="col s12 m6 l3 center-align"> 
    <div class="card amber lighten-1 z-depth-3 hoverable">
    <div class="card-content" contenteditable="true">
      <p card="true">${text}</p>
    </div>
    <div class="s3 m3 l3  right-align" style="width=40%">
    <a class=" material-icons delete_button " style="font-size:15px; " onclick="deletenote()" href="#">delete</a>
    <a class=" material-icons" style="font-size:15px; padding-right:3%">brush</a>
  </div>
    </div>                
    </div>`

}





 function createNewBoard(){
    $cardContainer = $('#cont_card')
    
         $textinput = $("#textinput").val()
         $cardContainer.append(card($textinput))
         
         $("#textinput").val("")

 }

 
 function changeNote(){
	    
	    $('#change_button').click(function(e){
	    	$('#modal1').modal();
	    });
	    
	} 
 
function deletenote(){
    
    $('.delete_button').click(function(e){
        $(e.target).parent().parent().parent().fadeOut(300);
    });
    Materialize.toast('Deleted note', 1500)
    
} 

