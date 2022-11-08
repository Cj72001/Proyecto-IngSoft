<html>
<head>
<title>spring boot form submit</title>


<style type="text/css">
.form-style-3 {
	max-width: 450px;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}

.form-style-3 label {
	display: block;
	margin-bottom: 10px;
}

.form-style-3 label>span {
	float: left;
	width: 100px;
	color: #F072A9;
	font-weight: bold;
	font-size: 13px;
	text-shadow: 1px 1px 1px #fff;
}

.form-style-3 fieldset {
	border-radius: 10px;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	margin: 0px 0px 10px 0px;
	border: 1px solid #FFD2D2;
	padding: 20px;
	background: #FFF4F4;
	box-shadow: inset 0px 0px 15px #FFE5E5;
	-moz-box-shadow: inset 0px 0px 15px #FFE5E5;
	-webkit-box-shadow: inset 0px 0px 15px #FFE5E5;
}

.form-style-3 fieldset legend {
	color: #FFA0C9;
	border-top: 1px solid #FFD2D2;
	border-left: 1px solid #FFD2D2;
	border-right: 1px solid #FFD2D2;
	border-radius: 5px 5px 0px 0px;
	-webkit-border-radius: 5px 5px 0px 0px;
	-moz-border-radius: 5px 5px 0px 0px;
	background: #FFF4F4;
	padding: 0px 8px 3px 8px;
	box-shadow: -0px -1px 2px #F1F1F1;
	-moz-box-shadow: -0px -1px 2px #F1F1F1;
	-webkit-box-shadow: -0px -1px 2px #F1F1F1;
	font-weight: normal;
	font-size: 12px;
}

.form-style-3 textarea {
	width: 250px;
	height: 100px;
}

.form-style-3 input[type=text], .form-style-3 input[type=date],
	.form-style-3 input[type=datetime], .form-style-3 input[type=number],
	.form-style-3 input[type=search], .form-style-3 input[type=time],
	.form-style-3 input[type=url], .form-style-3 input[type=email],
	.form-style-3 select, .form-style-3 textarea {
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border: 1px solid #FFC2DC;
	outline: none;
	color: #F072A9;
	padding: 5px 8px 5px 8px;
	box-shadow: inset 1px 1px 4px #FFD5E7;
	-moz-box-shadow: inset 1px 1px 4px #FFD5E7;
	-webkit-box-shadow: inset 1px 1px 4px #FFD5E7;
	background: #FFEFF6;
	width: 50%;
}

.form-style-3  input[type=submit], .form-style-3  input[type=button] {
	background: #EB3B88;
	border: 1px solid #C94A81;
	padding: 5px 15px 5px 15px;
	color: #FFCBE2;
	box-shadow: inset -1px -1px 3px #FF62A7;
	-moz-box-shadow: inset -1px -1px 3px #FF62A7;
	-webkit-box-shadow: inset -1px -1px 3px #FF62A7;
	border-radius: 3px;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	font-weight: bold;
}

.required {
	color: red;
	font-weight: normal;
}

h4{
	color: red;
}

h3, h2{
	color: pink;
}
</style>
</head>

<body>

<h2>Vizualizar CINES:</h2>
	<div class="form-style-3">
	
		<form method="post" action="showCine">
			<fieldset>
				<legend>CINES</legend>
				
				<h4>${mostrar1}</h4>
				
			</fieldset>
			<br> <input type="submit" value="MOSTRAR CINES">
		</form>
	</div>



	<h2>AGREGAR CINE:</h2>
	<div class="form-style-3">
	
		<form method="post" action="addCine">
			<fieldset>
				<legend>AGREGAR CINE</legend>
				
				<h4>${error}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_CINE">
					<span>ID CINE</span>
					<input type="text" class="input-field"name="ID_CINE"/>
				</label>
				<label for="NOMBRE_CINE">
					<span>NOMBRE</span>
					<input type="text" class="input-field"name="NOMBRE_CINE"/>
				</label> 
				
				<label for="ASIENTOS_CINE">
					<span>CANTIDAD DE ASIENTOS DEL CINE</span>
					<input type="text" class="input-field"name="ASIENTOS_CINE"/>
				</label>
				
				<label for="SALAS_CINE">
					<span>CANTIDAD DE SALAS DEL CINE</span>
					<input type="text" class="input-field" name="SALAS_CINE"/>
				</label>
				<label for="TRABAJADORES_CINE">
					<span>CANTIDAD DE TRABAJADORES DEL CINE</span>
					<input type="text" class="input-field" name="TRABAJADORES_CINE"/>
				</label>
				
			</fieldset>
			<br> <input type="submit" value="Agregar CINE">
		</form>
	</div>
	
	
	<h2>ACTUALIZAR CINE:</h2>
	<div class="form-style-3">
	
		<form method="post" action="updateCine">
			<fieldset>
				<legend>ACTUALIZAR CINE</legend>
				
				<h4>${error2}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_CINE">
					<span>ID CINE</span>
					<input type="text" class="input-field"name="ID_CINE"/>
				</label> 
				<label for="NOMBRE_CINE">
					<span>NOMBRE</span>
					<input type="text" class="input-field"name="NOMBRE_CINE"/>
				</label> 
				
				<label for="ASIENTOS_CINE">
					<span>CANTIDAD DE ASIENTOS DEL CINE</span>
					<input type="text" class="input-field"name="ASIENTOS_CINE"/>
				</label>
				
				<label for="SALAS_CINE">
					<span>CANTIDAD DE SALAS DEL CINE</span>
					<input type="text" class="input-field" name="SALAS_CINE"/>
				</label>
				<label for="TRABAJADORES_CINE">
					<span>CANTIDAD DE TRABAJADORES DEL CINE</span>
					<input type="text" class="input-field" name="TRABAJADORES_CINE"/>
				</label>
				
			</fieldset>
			<br> <input type="submit" value="Actualizar CINE">
		</form>
	</div>
	
	
	<h2>Eliminar CINE:</h2>
	<div class="form-style-3">
	
		<form method="post" action="deleteCine">
			<fieldset>
				<legend>ELIMINAR CINE</legend>
				
				<h4>${error3}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_CINE">
					<span>ID CINE</span>
					<input type="text" class="input-field"name="ID_CINE"/>
				</label> 
				
			</fieldset>
			<br> <input type="submit" value="Eliminar CINE">
		</form>
	</div>
	
	
	
	
	
	
	
	<h2>Vizualizar PAISLOCALIDAD:</h2>
	<div class="form-style-3" >
	
		<form method="post" action="showPais">
			<fieldset style="background-color:blue">
				<legend>PAISLOCALIDAD</legend>
				
				<h4>${mostrar2}</h4>
				
			</fieldset>
			<br> <input type="submit" value="MOSTRAR PAISESLOCALIDAD">
		</form>
	</div>



	<h2>AGREGAR PAISLOCALIDAD:</h2>
	<div class="form-style-3">
	
		<form method="post" action="addPais">
			<fieldset style="background-color:blue">
				<legend>AGREGAR PAISLOCALIDAD</legend>
				
				<h4>${error4}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_PAISLOCALIDAD">
					<span>ID PAISLOCALIDAD</span>
					<input type="text" class="input-field"name="ID_PAISLOCALIDAD"/>
				</label>
				<label for="NOMBRE_PAIS">
					<span>PAIS</span>
					<input type="text" class="input-field"name="NOMBRE_PAIS"/>
				</label> 
				
				<label for="CIUDAD_PAIS">
					<span>CIUDAD</span>
					<input type="text" class="input-field"name="CIUDAD_PAIS"/>
				</label>
				
				<label for="CENTROCOMERCIAL_PAIS">
					<span>Centro comercial</span>
					<input type="text" class="input-field" name="CENTROCOMERCIAL_PAIS"/>
				</label>
				<label for="ID_CINEFK">
					<span>ID CINE (FK)</span>
					<input type="text" class="input-field" name="ID_CINEFK"/>
				</label>
				
			</fieldset>
			<br> <input type="submit" value="AGREGAR PAIS">
		</form>
	</div>
	
	
	<h2>ACTUALIZAR PAISLOCALIDAD:</h2>
	<div class="form-style-3">
	
		<form method="post" action=updatePais>
			<fieldset style="background-color:blue">
				<legend>ACTUALIZAR PAISLOCALIDAD</legend>
				
				<h4>${error5}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_PAISLOCALIDAD">
					<span>ID PAISLOCALIDAD</span>
					<input type="text" class="input-field"name="ID_PAISLOCALIDAD"/>
				</label>
				<label for="NOMBRE_PAIS">
					<span>PAIS</span>
					<input type="text" class="input-field"name="NOMBRE_PAIS"/>
				</label> 
				
				<label for="CIUDAD_PAIS">
					<span>CIUDAD</span>
					<input type="text" class="input-field"name="CIUDAD_PAIS"/>
				</label>
				
				<label for="CENTROCOMERCIAL_PAIS">
					<span>CENTRO COMERCIAL</span>
					<input type="text" class="input-field" name="CENTROCOMERCIAL_PAIS"/>
				</label>
				<label for="ID_CINE">
					<span>ID_CINE (FK)</span>
					<input type="text" class="input-field" name="ID_CINE"/>
				</label>
				
			</fieldset>
			<br> <input type="submit" value="ACTUALIZAR PAIS">
		</form>
	</div>
	
	
	<h2>Eliminar PAISLOCALIDAD:</h2>
	<div class="form-style-3">
	
		<form method="post" action="deleteCine">
			<fieldset style="background-color:blue">
				<legend>ELIMINAR PAISLOCALIDAD</legend>
				
				<h4>${error6}</h4>
				<h3>${emptySpaces}</h3>
				<label for="ID_Pais">
					<span>ID CINE</span>
					<input type="text" class="input-field"name="ID_Pais"/>
				</label> 
				
			</fieldset>
			<br> <input type="submit" value="Eliminar CINE">
		</form>
	</div>
	
	
				<h2>COMBOS:</h2>
	<div class="form-style-3">
	
		<form method="post" action="ComboCINES">
			<fieldset style="background-color:blue">
				<legend>COMBOS</legend>
				
				<label for="CINES">
					<span>CIUDAD:</span>
					<select name="CINES">
                    	<option value="CIUDAD1">${ciudad1}</option>
                    	<option value="CIUDAD2">${ciudad2}</option>
                    	<option value="CIUDAD3">${ciudad3}</option>
                    	<option value="CIUDAD4">${ciudad4}</option>
                    	<option value="CIUDAD5">${ciudad5}</option>
                	</select>
				</label>
				
				<label for="CINES">
					<span>CINES DISPONIBLES:</span>
					<select name="CINES">
                    	<option value="CINE1">${cine1}</option>
                    	<option value="CINE2">${cine2}</option>
                    	<option value="CINE3">${cine3}</option>
                    	<option value="CINE4">${cine4}</option>
                    	<option value="CINE5">${cine5}</option>
                	</select>
				</label>
				
			</fieldset>
			<br> <input type="submit" value="VER CINE">
		</form>
	</div>
	
	
</body>
</html>


