<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "upload":"active","fare":"", "registry": "", "conf":""} title="Archivo cargado satisfactoriamente">
	<label class="confirmation">Fueron cargados ${quantity} CDR's</label><br>
	<button class="submit">Aceptar</button> 
</@menu.menu>