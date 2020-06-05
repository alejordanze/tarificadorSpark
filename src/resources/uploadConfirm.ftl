<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "uploadCdr":"","fare":"", "registry": "", "conf":"", "uploadClient": "", "clientRegistry":""} title="Archivo cargado satisfactoriamente">
	<#if quantity == 0>
		<label>Hubo un error en la carga, los numeros ya existen</label>
	<#else>
		<label class="confirmation">Fueron cargados ${quantity} ${type}</label><br>	
	</#if>
	<form method="get" action="${redirect}">
    	<input class="submit" type="submit" value="Aceptar" />
	</form>
</@menu.menu>