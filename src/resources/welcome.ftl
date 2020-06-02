<#import "menu.ftl" as menu />

<@menu.menu options={"home": "", "upload":"","fare":"", "registry": "", "conf":""}>
		<div class="box">
		    <h1>Tarificador</h1>
        </div>
		</br>
        <div class="box">
            <h1>Bienvenido ${name}</h1>
            <h3>Presione el boton si desea realizar la tarificacion de CDRS</h3>
            <form method='post' action='/export'> 
                <button type='submit' class="buttom">Realizar</button>
            </form>
        </div>
</@menu.menu>