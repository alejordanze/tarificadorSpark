<#macro menu options={"home": "active", "upload":"","fare":"", "registry": "", "conf":""} title="Inicio">
	<html>
		<head>
			<link rel="stylesheet" type="text/css" href="./style.css">
			<script src="//cdnjs.cloudflare.com/ajax/libs/sass.js/0.6.3/sass.min.js"></script>
		</head>
		<body>
			<ul class="menu">
				<li class="item ${options.home}"><a class="item-text" href="/">Inicio</a></li>
				<li class="item ${options.upload}"><a class="item-text" href="/upload">Cargar Archivo</a></li>
				<li class="item ${options.fare}"><a class="item-text" href="/fare">Tarificar</a></li>
				<li class="item ${options.registry}"><a class="item-text" href="/registry">Registro</a></li>
				<li class="item ${options.conf}"><a class="item-text" href="/configuration">Configuración</a></li>
			</ul>
			<div class="body">
				<h3 class="title">${title}</h3>
				<#nested />
			</div>
		</body>
	</html>
</#macro>