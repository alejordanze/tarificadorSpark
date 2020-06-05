<#import "menu.ftl" as menu />

<@menu.menu options={"home": "active", "uploadCdr":"","fare":"", "registry": "", "conf":"", "uploadClient": "", "clientRegistry":""} title="Bienvenido a Tarificador">
	<ul class="home-options">
		<li class="li-option"><label class="item-home">Cargar archivo -> </label> Te permite cargar un archivo de CDR con el formato: 
		<br> Origen, Destino, Fecha(dd—mm-aaaa), hora(hh:mm), duracion(mm:ss)</li>
		<li class="li-option"><label class="item-home">Tarificar -> </label> Muestra el archivo cargado y tarifica los CDR's. Tambien puedes guardarlos.</li>
		<li class="li-option"><label class="item-home">Registro -> </label> Muestra los CDR's almacenados en la base de datos.</li>
		<li class="li-option"><label class="item-home">Configuracion -> </label> Puedes configurar el metodo de guardado, Archivo o Base de Datos.</li>
	</ul>
</@menu.menu>