<#import "menu.ftl" as menu />

<@menu.menu options={"home": "active", "upload":"","fare":"", "registry": "", "conf":""}>
	<div class="box">
		<h1>Bienvenido a tarificador</h1>
	</div>
	</br>
	<div class="box">
		<form method='post' action='/welcome'>
			<h3>Ingrese su nombre</h3>
			<label>Nombre:</label>
			<input type='text' name='name'>
			<input type='submit' value='Entrar' class="buttom">
		</form>
	</div>
</@menu.menu>