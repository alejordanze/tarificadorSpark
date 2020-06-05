<#macro menu options={"home": "active", "uploadCdr":"","fare":"", "registry": "", "conf":"", "uploadClient": "", "clientRegistry":""} title="Inicio">
	<html>
		<head>
			<link rel="stylesheet" type="text/css" href="./style.css">
			<script src="//cdnjs.cloudflare.com/ajax/libs/sass.js/0.6.3/sass.min.js"></script>
		</head>
		<body>
			<ul class="menu">
				<li class="item ${options.home}"><a class="item-text" href="/">Inicio</a></li>
				<li class="item ${options.uploadCdr}"><a class="item-text" href="/upload">Cargar CDR's</a></li>
				<li class="item ${options.uploadClient}"><a class="item-text" href="/uploadClient">Cargar Clientes</a></li>
				<li class="item ${options.fare}"><a class="item-text" href="/fare">Tarificar</a></li>
				<li class="item ${options.registry}"><a class="item-text" href="/registry">Registro de CDR's</a></li>
				<li class="item ${options.clientRegistry}"><a class="item-text" href="/clientRegistry">Registro de Clientes</a></li>
				<li class="item ${options.conf}"><a class="item-text" href="/configuration">Configuración</a></li>
			</ul>
			<div class="body">
				<h3 class="title">${title}</h3>
				<#nested />
			</div>
		</body>
	</html>
</#macro>