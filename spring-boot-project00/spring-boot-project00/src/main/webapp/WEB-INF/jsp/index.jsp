<!DOCTYPE html>
<html>
<head>
<title>spring boot form submit</title>

<link rel= "stylesheet" href="/WEB-INF/jsp/include-css.jsp"/>
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


