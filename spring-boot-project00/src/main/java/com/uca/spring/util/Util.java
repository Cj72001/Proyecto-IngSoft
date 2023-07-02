package com.uca.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.uca.spring.model.Materia;

public class Util {


	// Materias recomendadas
	static List<Materia> materiasR = new ArrayList<Materia>();

	// Lista de materias que son prerrequisitos de las posibles
	static String[] idsMateriasPosiblesPrerrequisitos = new String[0];
	static int materiasPosiblesPrerrequisitosSize = 0;
	
	//Bandera para cocnluir si una materia es agregada a las recomendadas
	static boolean esRecomendada = false;
	
	//Nota minima
	static double notaMinima = 7.0;

	public static List<Materia> materiasRecomendadas(List<Materia> materiasPosibles, List<Materia> materiasAprobadas,
			List<Double> notaAprobada) {
		
		//Una vez con la lista de materias recomendadas, se reinician las variables de la clase:
		materiasR = new ArrayList<Materia>();
		idsMateriasPosiblesPrerrequisitos = new String[0];
		materiasPosiblesPrerrequisitosSize = 0;
		esRecomendada = false;
		notaMinima = 7.0;

		// por cada materia posible iremos obteniendo sus materias prerrequisito para
		// evaluar la nota
		// y si las notas son mayor a 7.0, entonces esa materia posible se agregara a
		// las recomendadas
		materiasPosibles.forEach(m -> {

			// guardando las materias prerrequisito de cada materia posible
			idsMateriasPosiblesPrerrequisitos = m.getPreRequisito().split(",");
			// size
			materiasPosiblesPrerrequisitosSize = idsMateriasPosiblesPrerrequisitos.length;
			
			//recorremos la lista de materias aprobadas y si el id es igual al de la materia aprobada, entonces 
			//tomaremos ese indice en materias aprobadas para evaluar la nota
			for(int i=0; i<materiasPosiblesPrerrequisitosSize; i++) {
				
				for(int j=0; j<materiasAprobadas.size(); j++) {
					
					//si los ids son iguales, entonces tomaremos el indice j, para evaluar la nota
					if(idsMateriasPosiblesPrerrequisitos[i].equals(materiasAprobadas.get(j).getIdMateria().toString())) {
						
						//Si la nota de la materia prerrequisito aprobada es mayor a la nota minima, entonces la bandera se volvera 
						//true si no false
						if(Double.valueOf(notaAprobada.get(j).toString()) > notaMinima) {
							esRecomendada = true;
						}
						else {
							esRecomendada = false;
						}
						
					}
				}
				
			}
			
			//Si la materia m cumplio con que todas las materias aprobadas que son prerrequisito se aprobaron con 
			//al menos la nota minima, entonces esta materia sera recomendada
			if(esRecomendada) {
				materiasR.add(m);
				
			}
			
		});
		
		

		return materiasR;
		
	}
	

}
