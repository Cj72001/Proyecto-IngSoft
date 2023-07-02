package com.uca.spring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.uca.spring.model.Materia;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class Util2 {

	// Materias recomendadas
	static List<Materia> materiasR = new ArrayList<Materia>();

	// Lista de materias que son prerrequisitos de las posibles
	static String[] idsMateriasPosiblesPrerrequisitos = new String[0];
	static int materiasPosiblesPrerrequisitosSize = 0;

	// Bandera para cocnluir si una materia es agregada a las recomendadas
	static boolean esRecomendada = false;

	// Nota minima
	static double notaMinima = 7.0;

	// Referente a
	// ML:____________________________________________________________________________________________________
	// Crear las instancias con los datos de entrenamiento
	static Attribute atributoNota = new Attribute("nota");

	// Crear los valores discretos para el atributo recomendacion
	static String valorRecomendado = "Recomendado";
	static String valorNoRecomendado = "No Recomendado";
	static Attribute atributoRecomendacion = new Attribute("recomendacion",
			Arrays.asList(valorRecomendado, valorNoRecomendado));

	// Crear el arreglo de atributos
	static Attribute[] atributos = { atributoNota, atributoRecomendacion };

	// Crear el conjunto de datos vacío con los atributos
	static Instances dataset = new Instances("RecomendacionMaterias", new ArrayList<>(Arrays.asList(atributos)), 0);

	// Declarar instancias de ejemplo
	static Instance instancia1 = new DenseInstance(2);
	static Instance instancia2 = new DenseInstance(2);
	static Instance instancia3 = new DenseInstance(2);
	static Instance instancia4 = new DenseInstance(2);
	static Instance instancia5 = new DenseInstance(2);
	static Instance instancia6 = new DenseInstance(2);

	// Construir el clasificador Naive Bayes
	static NaiveBayes clasificador = new NaiveBayes();

	// ____________________________________________________________________________________________________________________

	// metodo de aprendizaje
	public static List<Materia> materiasRecomendadas(List<Materia> materiasPosibles, List<Materia> materiasAprobadas,
			List<Double> notaAprobada) {

		// Definir el atributo recomendacion como nominal con los valores discretos
		atributoRecomendacion.addStringValue(valorRecomendado);
		atributoRecomendacion.addStringValue(valorNoRecomendado);

		// Una vez con la lista de materias recomendadas, se reinician las variables de
		// la clase:
		materiasR = new ArrayList<Materia>();
		idsMateriasPosiblesPrerrequisitos = new String[0];
		materiasPosiblesPrerrequisitosSize = 0;
		esRecomendada = false;
		notaMinima = 7.0;

		// Agregar instancias de ejemplo
		instancia1.setValue(atributos[0], 8.5);
		instancia1.setValue(atributos[1], "Recomendado");
		dataset.add(instancia1);

		instancia2.setValue(atributos[0], 9.0);
		instancia2.setValue(atributos[1], "Recomendado");
		dataset.add(instancia2);
		
		instancia3.setValue(atributos[0], 7.0);
		instancia3.setValue(atributos[1], "Recomendado");
		dataset.add(instancia3);
		
		instancia4.setValue(atributos[0], 6.9);
		instancia4.setValue(atributos[1], "No Recomendado");
		dataset.add(instancia4);
		
		instancia5.setValue(atributos[0], 6.8);
		instancia5.setValue(atributos[1], "No Recomendado");
		dataset.add(instancia5);
		
		instancia5.setValue(atributos[0], 5.0);
		instancia5.setValue(atributos[1], "No Recomendado");
		dataset.add(instancia5);

		// Entrenar el clasificador Naive Bayes
		dataset.setClass(atributoRecomendacion);

		try {
			clasificador.buildClassifier(dataset);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// por cada materia posible iremos obteniendo sus materias prerrequisito para
		// evaluar la nota
		// y si las notas son aceptadas por el dataset, entonces esa materia posible se
		// agregara a
		// las recomendadas
		materiasPosibles.forEach(m -> {

			// guardando las materias prerrequisito de cada materia posible
			idsMateriasPosiblesPrerrequisitos = m.getPreRequisito().split(",");
			// size
			materiasPosiblesPrerrequisitosSize = idsMateriasPosiblesPrerrequisitos.length;

			// recorremos la lista de materias aprobadas y si el id es igual al de la
			// materia aprobada, entonces
			// tomaremos ese indice en materias aprobadas para evaluar la nota
			for (int i = 0; i < materiasPosiblesPrerrequisitosSize; i++) {

				for (int j = 0; j < materiasAprobadas.size(); j++) {

					// si los ids son iguales, entonces tomaremos el indice j, para evaluar la nota
					if (idsMateriasPosiblesPrerrequisitos[i]
							.equals(materiasAprobadas.get(j).getIdMateria().toString())) {

						// Crear una nueva instancia para hacer una recomendación
						Instance instanciaRecomendacion = new DenseInstance(2);
						instanciaRecomendacion.setValue(atributoNota, Double.valueOf(notaAprobada.get(j).toString()));
						instanciaRecomendacion.setDataset(dataset);

						// Realizar la clasificación/recomendación
						double resultado = 0.0;
						try {
							resultado = clasificador.classifyInstance(instanciaRecomendacion);
						} catch (Exception e) {
							e.printStackTrace();
						}

						// Obtener el valor de recomendación predicho
						String recomendacionPredicha = dataset.attribute("recomendacion").value((int) resultado);

						if (recomendacionPredicha.equals("Recomendado")) {
							esRecomendada = true;
						} else {
							esRecomendada = false;
						}

					}
				}

			}

			// Si la materia m cumplio con que todas las materias aprobadas que son
			// prerrequisito se aprobaron con
			// al menos la nota minima, entonces esta materia sera recomendada
			if (esRecomendada) {
				materiasR.add(m);

			}

		});

		return materiasR;
	}

}
