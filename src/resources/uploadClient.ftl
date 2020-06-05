<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"", "registry": "", "conf":"", "uploadClient": "active", "clientRegistry":""} title="Cargar archivo de Clientes">
	<div>
	    <form action="/uploadClient" method="post" enctype="multipart/form-data">
	        <label for="myfile">Selecciona un archivo: </label>
	        <br><br>
	        <input class="file" type="file" id="file" name="myfile"/>
	        <label class="input-file" for="file">Choose a file...</label>
	        <label class="input-label" id="label"></label>
	        <br><br>
	        <input class="submit" type="submit" id="buttonUpload" value="Upload"/>
	        <br>
	    </form>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
	 	var fileName = '';
	 	function getFileName(){
	 		$('#label').text(fileName);
	 	}
		$(document).ready(function(){
	        $('input[type="file"]').change(function(e){
	        	if(e.target.files.length > 0){
		            fileName = e.target.files[0].name;
		            console.log(fileName);
	            }
	            else {
	            	fileName = '';
	            }
	            getFileName();
        	});
       	});
	</script>
</@menu.menu>