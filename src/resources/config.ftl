<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"", "registry": "", "conf":"active", "uploadClient": "", "clientRegistry":""} title="Configuración">
	
	<button class="option ${config.file}" id="file" onclick="select('file')">Archivo</button>
	<button class="option ${config.sql}" id="sql" onclick="select('sql')">Base de datos SQL</button>
	<br><br>
	<form method="post" action="/configuration">
		<input type="text" id="option" name="option" hidden/>
		<input type="submit" value="Guardar" class="submit-config"/>
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
	 	function select(value){
	 		$('#file').removeClass('active');
 			$('#sql').removeClass('active');
 			console.log(value)
	 		if(value == 'file'){
	 			$('#file').addClass('active');
	 			$('#option').val('Archivo');
	 		}
	 		else{
	 			$('#sql').addClass('active');
	 			$('#option').val('Sql');
	 		}
	 	}
	</script>
</@menu.menu>