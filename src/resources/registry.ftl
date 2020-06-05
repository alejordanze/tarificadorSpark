<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"", "registry": "active", "conf":"", "uploadClient": "", "clientRegistry":""} title="Registro de CDR's">
	<#list cdrs as key, cdr>
		<label>Fecha de guardado: ${key?number_to_datetime}</label>
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
	    	<#list cdr as item>
	    		<tbody>
	    			<#setting number_format="0" />
	    			<td>${item.getOriginPhoneNumber()}</td>
	    			<td>${item.getDestinationPhoneNumber()}</td>
	    			<#setting number_format="" />
	    			<td>${item.getStringDate()}</td>
	    			<td>${item.getStringHour()}</td>
	    			<td>${item.getStringDuration()}</td>
	    			<td>${item.getCost()}</td>
	    		</tbody>
			</#list>	
		</table>
		<br><br>
	</#list>
	
</@menu.menu>