<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "upload":"","fare":"", "registry": "active", "conf":""} title="Registro de CDR's">
	<#if 0 < cdrs?size >
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
	    	<#list cdrs as cdr>
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
	</#if>
</@menu.menu>