<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"active", "registry": "", "conf":"", "uploadClient": "", "clientRegistry":""} title="Tarificación">
	<#if saved == true >
		<label class="saved">Registro guardado correctamente</label>
		<br><br>
	</#if>
	
	<#if 0 < cdrs.getRegistry()?size >
		<table class="table">
	    	<thead>
	    		<tr>
		    		<th>Número origen</th>
		    		<th>Número destino</th>
		    		<th>Fecha</th>
		    		<th>Hora</th>
		    		<th>Duración</th>
		    		<th>Costo</th>
	    		</tr>
	    	</thead>
	    	<#assign list = cdrs.getRegistry()/>
	    	<#list list as cdr>
	    		<tbody>
	    			<#setting number_format="0" />
	    			<td>${cdr.getOriginPhoneNumber()}</td>
	    			<td>${cdr.getDestinationPhoneNumber()}</td>
	    			<#setting number_format="" />
	    			<td>${cdr.getStringDate()}</td>
	    			<td>${cdr.getStringHour()}</td>
	    			<td>${cdr.getStringDuration()}</td>
	    			<td>${cdr.getCost()}</td>
	    		</tbody>
			</#list>	
		</table>
		<form method="post" action="/fare">
			<input class="submit" type="submit" value="Guardar"/>
			<label class="save-type">La opcion de guardado actual es: "${option}"</label>
		</form>
	<#else>
		<label class="save-type">Aún no se ha cargado ningún Archivo CDR</label><br><br>
		<label class="save-type">Para cargar presione en Cargar Archivo</label>
	</#if>
	
	    	
	
</@menu.menu>