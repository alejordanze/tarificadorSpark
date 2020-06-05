<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"", "registry": "", "conf":"", "uploadClient": "", "clientRegistry":"active"} title="Registro de CDR's">
		<table class="table">
	    	<thead>
	    		<tr>
		    		<th>Número</th>
		    		<th>Nombre completo</th>
		    		<th>Plan</th>
		    		<th>Números amigos</th>
	    		</tr>
	    	</thead>
	    	<#list clients as item>
	    		<tbody>
	    			<#setting number_format="0" />
	    			<td>${item.getPhoneNumber()}</td>
	    			<#setting number_format="" />
	    			<td>${item.getFullName()}</td>
	    			<td>${item.getPlan().getStringPlan()?capitalize}</td>
	    			<td>${item.getPlan().getStringFriends()}</td>
	    		</tbody>
			</#list>	
		</table>
		<br><br>
	
</@menu.menu>