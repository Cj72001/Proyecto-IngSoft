package com.uca.spring.controller;

import java.io.IOException;

import java.time.LocalDate; 
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.spring.model.ActividadesExtra;
import com.uca.spring.model.Carrera;
import com.uca.spring.model.Estudiante;
import com.uca.spring.model.Materia;
import com.uca.spring.service.ActividadesExtraService;
import com.uca.spring.service.CarreraService;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.service.MateriaService;
import com.uca.spring.util.Util;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	ActividadesExtraService actividadesExtraService;
	@Autowired
	CarreraService carreraService;
	
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	MateriaService materiaService;
	
	
	//temporales
	ActividadesExtra actividadExtra1 = new ActividadesExtra();
	ActividadesExtra actividadExtra2 = new ActividadesExtra();
	Estudiante estudianteEjemplo = new Estudiante();
	Carrera carreraEstudianteEjemplo = new Carrera();
	
	//Creando estudiantes:
	Estudiante estudiante1 =  new Estudiante();
	boolean estudianteExiste = false;
	Estudiante estudianteLogeado = new Estudiante();
	
	//Creando carrera para Estudiante1:
	Carrera carreraEstudiante1 = new Carrera();
	Carrera carreraEstudianteLogeado = new Carrera(); //carrera que se inicializara respecto al estudiante que se loguea
	
	
	//objetos de la dabla de ActividadesExtra del estudiante1:
	ActividadesExtra actividadExtraEstudianteEjemplo1 = new ActividadesExtra();
	ActividadesExtra actividadExtraEstudianteEjemplo2 = new ActividadesExtra();
	ActividadesExtra actividadExtraEstudianteEjemplo3 = new ActividadesExtra();
	ActividadesExtra actividadExtraEstudianteEjemplo4 = new ActividadesExtra();

	
	//Crear todos los objetos de la malla curricular:
	Materia materiaEstudianteEjemplo1= new Materia();
	Materia materiaEstudianteEjemplo2= new Materia();
	Materia materiaEstudianteEjemplo3= new Materia();
	Materia materiaEstudianteEjemplo4= new Materia();
	Materia materiaEstudianteEjemplo5= new Materia();
	Materia materiaEstudianteEjemplo6= new Materia();
	Materia materiaEstudianteEjemplo7= new Materia();
	Materia materiaEstudianteEjemplo8= new Materia();
	Materia materiaEstudianteEjemplo9= new Materia();
	Materia materiaEstudianteEjemplo10= new Materia();
	Materia materiaEstudianteEjemplo11= new Materia();
	Materia materiaEstudianteEjemplo12= new Materia();
	Materia materiaEstudianteEjemplo13= new Materia();
	Materia materiaEstudianteEjemplo14= new Materia();
	Materia materiaEstudianteEjemplo15= new Materia();
	Materia materiaEstudianteEjemplo16= new Materia();
	Materia materiaEstudianteEjemplo17= new Materia();
	Materia materiaEstudianteEjemplo18= new Materia();
	Materia materiaEstudianteEjemplo19= new Materia();
	Materia materiaEstudianteEjemplo20= new Materia();
	Materia materiaEstudianteEjemplo21= new Materia();
	Materia materiaEstudianteEjemplo22= new Materia();
	Materia materiaEstudianteEjemplo23= new Materia();
	Materia materiaEstudianteEjemplo24= new Materia();
	Materia materiaEstudianteEjemplo25= new Materia();
	Materia materiaEstudianteEjemplo26= new Materia();
	Materia materiaEstudianteEjemplo27= new Materia();
	Materia materiaEstudianteEjemplo28= new Materia();
	Materia materiaEstudianteEjemplo29= new Materia();
	Materia materiaEstudianteEjemplo30= new Materia();
	Materia materiaEstudianteEjemplo31= new Materia();
	Materia materiaEstudianteEjemplo32= new Materia();
	Materia materiaEstudianteEjemplo33= new Materia();
	Materia materiaEstudianteEjemplo34= new Materia();
	Materia materiaEstudianteEjemplo35= new Materia();
	Materia materiaEstudianteEjemplo36= new Materia();
	Materia materiaEstudianteEjemplo37= new Materia();
	Materia materiaEstudianteEjemplo38= new Materia();
	Materia materiaEstudianteEjemplo39= new Materia();
	Materia materiaEstudianteEjemplo40= new Materia();
	Materia materiaEstudianteEjemplo41= new Materia();
	Materia materiaEstudianteEjemplo42= new Materia();
	Materia materiaEstudianteEjemplo43= new Materia();
	Materia materiaEstudianteEjemplo44= new Materia();
	
	//vars que se ocupan a nivel global para cada action (metodo)
	boolean contraActualizada = false;
	boolean usuarioActualizado = false;
	boolean miMateriaEncontrada = false;
	boolean materiaPosible = false;
	String nuevasMateriasPosibles;
	
	List<String> nombreActividades = new ArrayList<String>();
	List<String> ponderacionActividades = new ArrayList<String>();
	List<String> fechaActividades = new ArrayList<String>();
	List<String> notaActividades = new ArrayList<String>();
	List<Integer> idMateriaActividades = new ArrayList<Integer>();
	int listEvaluacionesSize = 0;
	
	

	//Action que se invoca al iniciar la app en la ruta del login (/)
  @GetMapping("/")
  public String getForm() {
	  
	  actividadExtra1.setIdActividadesExtra(2);
	  actividadExtra1.setIdEstudiante(1);
	  actividadExtra1.setNombreActividadesExtra("Ir a devolver libros");
	  
	  actividadExtra2.setIdActividadesExtra(3);
	  actividadExtra2.setIdEstudiante(1);
	  actividadExtra2.setNombreActividadesExtra("Renovar CARNET");
	  
	  actividadesExtraService.createActividadExtra(actividadExtra1);
	  actividadesExtraService.createActividadExtra(actividadExtra2);
	  
	  //Creando objeto tipo Estudiante para ejemplo:
	  estudiante1.setCarnetEstudiante(38619);
	  estudiante1.setIdEstudiante(1);
	  estudiante1.setNombreEstudiante("Omar Flores Alas");
	  estudiante1.setContrasenaEstudiante("123");
	  estudiante1.setCarreraEstudiante(1);
	  estudianteService.createEstudiante(estudiante1);
	  
	  
	//Creando objeto tipo Carrera para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	  carreraEstudiante1.setIdCarrera(1);
	  carreraEstudiante1.setUvAprobadas(102);
	  carreraEstudiante1.setCantidadMateriasAprobadas(4);
	  carreraEstudiante1.setMateriasAprobadas("1,2,3,4");
	  carreraEstudiante1.setCantidadMateriasPosibles(4);
	  carreraEstudiante1.setMateriasPosibles("5,6,7,8");
	  carreraService.createCarrera(carreraEstudiante1);
	  
//Creando objetos tipo ActividadExtra (seran las actividades relacionadas al estudiante) para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	  
	  actividadExtraEstudianteEjemplo1.setNombreActividadesExtra("Reunirse con el grupo de Simu");
	  actividadExtraEstudianteEjemplo2.setNombreActividadesExtra("Entregar proyecto Arqui");
	  actividadExtraEstudianteEjemplo3.setNombreActividadesExtra("Meet BI 6:30pm");
	  actividadExtraEstudianteEjemplo4.setNombreActividadesExtra("Ver videos en youtube sobre CSR");
	  
	  
	//Creando objetos tipo materia (seran las materias aprobadas relacionadas al estudiante) para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	//OBJETOD DE MALLA (prerequisito =0 cuando sea bachillerato)
	  materiaEstudianteEjemplo1.setNombreMateria("Precálculo");
	  materiaEstudianteEjemplo1.setIdMateria(1);
	  materiaEstudianteEjemplo1.setUv(4);
	  materiaEstudianteEjemplo1.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo1);
	  
	  materiaEstudianteEjemplo2.setNombreMateria("Optativa Técnica I");
	  materiaEstudianteEjemplo2.setIdMateria(2);
	  materiaEstudianteEjemplo2.setUv(3);
	  materiaEstudianteEjemplo2.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo2);

	  materiaEstudianteEjemplo3.setNombreMateria("Matemática Discreta I");
	  materiaEstudianteEjemplo3.setIdMateria(3);
	  materiaEstudianteEjemplo3.setUv(3);
	  materiaEstudianteEjemplo3.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo3);

	  materiaEstudianteEjemplo4.setNombreMateria("Fundamentos de Programación");
	  materiaEstudianteEjemplo4.setIdMateria(4);
	  materiaEstudianteEjemplo4.setUv(4);
	  materiaEstudianteEjemplo4.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo4);

	  materiaEstudianteEjemplo5.setNombreMateria("Álgebra Vectorial y Matrices");
	  materiaEstudianteEjemplo5.setIdMateria(5);
	  materiaEstudianteEjemplo5.setUv(4);
	  materiaEstudianteEjemplo5.setPreRequisito("1");	 
	  materiaService.createMateria(materiaEstudianteEjemplo5);
	  

	  materiaEstudianteEjemplo6.setNombreMateria("Cálculo I");
	  materiaEstudianteEjemplo6.setIdMateria(6);
	  materiaEstudianteEjemplo6.setUv(4);
	  materiaEstudianteEjemplo6.setPreRequisito("1");	
	  materiaService.createMateria(materiaEstudianteEjemplo6);
	  

	  materiaEstudianteEjemplo7.setNombreMateria("Programación de Estructuras Dinámicas");
	  materiaEstudianteEjemplo7.setIdMateria(7);
	  materiaEstudianteEjemplo7.setUv(4);
	  materiaEstudianteEjemplo7.setPreRequisito("3,4");
	  materiaService.createMateria(materiaEstudianteEjemplo7);
	  

	  materiaEstudianteEjemplo8.setNombreMateria("Matemática Discreta II");
	  materiaEstudianteEjemplo8.setIdMateria(8);
	  materiaEstudianteEjemplo8.setUv(3);
	  materiaEstudianteEjemplo8.setPreRequisito("3");
	  materiaService.createMateria(materiaEstudianteEjemplo8);

	  materiaEstudianteEjemplo9.setNombreMateria("Física I");
	  materiaEstudianteEjemplo9.setIdMateria(9);
	  materiaEstudianteEjemplo9.setUv(5);
	  materiaEstudianteEjemplo9.setPreRequisito("5,6");
	  materiaService.createMateria(materiaEstudianteEjemplo9);

	  materiaEstudianteEjemplo10.setNombreMateria("Cálculo II");
	  materiaEstudianteEjemplo10.setIdMateria(10);
	  materiaEstudianteEjemplo10.setUv(4);
	  materiaEstudianteEjemplo10.setPreRequisito("5,6");
	  materiaService.createMateria(materiaEstudianteEjemplo10);

	  materiaEstudianteEjemplo11.setNombreMateria("Programación Orientada a Objetos");
	  materiaEstudianteEjemplo11.setIdMateria(11);
	  materiaEstudianteEjemplo11.setUv(4);
	  materiaEstudianteEjemplo11.setPreRequisito("7");
	  materiaService.createMateria(materiaEstudianteEjemplo11);
	  

	  materiaEstudianteEjemplo12.setNombreMateria("Bases de Datos");
	  materiaEstudianteEjemplo12.setIdMateria(12);
	  materiaEstudianteEjemplo12.setUv(4);
	  materiaEstudianteEjemplo12.setPreRequisito("7");
	  materiaService.createMateria(materiaEstudianteEjemplo12);
	  

	  materiaEstudianteEjemplo13.setNombreMateria("Electricidad y Magnetismo");
	  materiaEstudianteEjemplo13.setIdMateria(13);
	  materiaEstudianteEjemplo13.setUv(5);
	  materiaEstudianteEjemplo13.setPreRequisito("9,10");
	  materiaService.createMateria(materiaEstudianteEjemplo13);
	  

	  materiaEstudianteEjemplo14.setNombreMateria("Cálculo III");
	  materiaEstudianteEjemplo14.setIdMateria(14);
	  materiaEstudianteEjemplo14.setUv(4);
	  materiaEstudianteEjemplo14.setPreRequisito("10");
	  materiaService.createMateria(materiaEstudianteEjemplo14);
	  

	  materiaEstudianteEjemplo15.setNombreMateria("Programación WEB");
	  materiaEstudianteEjemplo15.setIdMateria(15);
	  materiaEstudianteEjemplo15.setUv(4);
	  materiaEstudianteEjemplo15.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo15);
	  

	  materiaEstudianteEjemplo16.setNombreMateria("Administración de Bases de Datos");
	  materiaEstudianteEjemplo16.setIdMateria(16);
	  materiaEstudianteEjemplo16.setUv(4);
	  materiaEstudianteEjemplo16.setPreRequisito("12");
	  materiaService.createMateria(materiaEstudianteEjemplo16);
	  

	  materiaEstudianteEjemplo17.setNombreMateria("Optativa Humanístico Social I");
	  materiaEstudianteEjemplo17.setIdMateria(17);
	  materiaEstudianteEjemplo17.setUv(3);
	  materiaEstudianteEjemplo17.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo17);
	  

	  materiaEstudianteEjemplo18.setNombreMateria("Análisis Numérico");
	  materiaEstudianteEjemplo18.setIdMateria(18);
	  materiaEstudianteEjemplo18.setUv(4);
	  materiaEstudianteEjemplo18.setPreRequisito("14");
	  materiaService.createMateria(materiaEstudianteEjemplo18);
	  

	  materiaEstudianteEjemplo19.setNombreMateria("Redes de Computadoras");
	  materiaEstudianteEjemplo19.setIdMateria(19);
	  materiaEstudianteEjemplo19.setUv(4);
	  materiaEstudianteEjemplo19.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo19);

	  
	  materiaEstudianteEjemplo20.setNombreMateria("Programación de Dispositivos Móviles");
	  materiaEstudianteEjemplo20.setIdMateria(20);
	  materiaEstudianteEjemplo20.setUv(4);
	  materiaEstudianteEjemplo20.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo20);
	  

	  materiaEstudianteEjemplo21.setNombreMateria("Análisis de Sistemas");
	  materiaEstudianteEjemplo21.setIdMateria(21);
	  materiaEstudianteEjemplo21.setUv(3);
	  materiaEstudianteEjemplo21.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo21);
	  

	  materiaEstudianteEjemplo22.setNombreMateria("Física II");
	  materiaEstudianteEjemplo22.setIdMateria(22);
	  materiaEstudianteEjemplo22.setUv(5);
	  materiaEstudianteEjemplo22.setPreRequisito("9,10");
	  materiaService.createMateria(materiaEstudianteEjemplo22);
	  

	  materiaEstudianteEjemplo23.setNombreMateria("Optativa Humanístico Social II");
	  materiaEstudianteEjemplo23.setIdMateria(23);
	  materiaEstudianteEjemplo23.setUv(3);
	  materiaEstudianteEjemplo23.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo23);
	  

	  materiaEstudianteEjemplo24.setNombreMateria("Análisis de Algoritmos");
	  materiaEstudianteEjemplo24.setIdMateria(24);
	  materiaEstudianteEjemplo24.setUv(4);
	  materiaEstudianteEjemplo24.setPreRequisito("8");
	  materiaService.createMateria(materiaEstudianteEjemplo24);
	  

	  materiaEstudianteEjemplo25.setNombreMateria("Programación de Artefactos");
	  materiaEstudianteEjemplo25.setIdMateria(25);
	  materiaEstudianteEjemplo25.setUv(4);
	  materiaEstudianteEjemplo25.setPreRequisito("13,15");
	  materiaService.createMateria(materiaEstudianteEjemplo25);
	  

	  materiaEstudianteEjemplo26.setNombreMateria("Probabilidad y Estadística");
	  materiaEstudianteEjemplo26.setIdMateria(26);
	  materiaEstudianteEjemplo26.setUv(4);
	  materiaEstudianteEjemplo26.setPreRequisito("14");
	  materiaService.createMateria(materiaEstudianteEjemplo26);

	  
	  materiaEstudianteEjemplo27.setNombreMateria("Seguridad en Entornos de Desarrollo");
	  materiaEstudianteEjemplo27.setIdMateria(27);
	  materiaEstudianteEjemplo27.setUv(4);
	  materiaEstudianteEjemplo27.setPreRequisito("8,16");
	  materiaService.createMateria(materiaEstudianteEjemplo27);
	  

	  materiaEstudianteEjemplo28.setNombreMateria("Arquitectura de Computadoras");
	  materiaEstudianteEjemplo28.setIdMateria(28);
	  materiaEstudianteEjemplo28.setUv(4);
	  materiaEstudianteEjemplo28.setPreRequisito("13");
	  materiaService.createMateria(materiaEstudianteEjemplo28);
	  

	  materiaEstudianteEjemplo29.setNombreMateria("Técnicas de Simulación en Computadoras");
	  materiaEstudianteEjemplo29.setIdMateria(29);
	  materiaEstudianteEjemplo29.setUv(4);
	  materiaEstudianteEjemplo29.setPreRequisito("26");
	  materiaService.createMateria(materiaEstudianteEjemplo29);
	  

	  materiaEstudianteEjemplo30.setNombreMateria("Programación N-Capas");
	  materiaEstudianteEjemplo30.setIdMateria(30);
	  materiaEstudianteEjemplo30.setUv(4);
	  materiaEstudianteEjemplo30.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo30);
	  

	  materiaEstudianteEjemplo31.setNombreMateria("Fundamentos de Inteligencia de Negocios");
	  materiaEstudianteEjemplo31.setIdMateria(31);
	  materiaEstudianteEjemplo31.setUv(4);
	  materiaEstudianteEjemplo31.setPreRequisito("16");
	  materiaService.createMateria(materiaEstudianteEjemplo31);
	  

	  materiaEstudianteEjemplo32.setNombreMateria("Optativa Humanístico Social III");
	  materiaEstudianteEjemplo32.setIdMateria(32);
	  materiaEstudianteEjemplo32.setUv(3);
	  materiaEstudianteEjemplo32.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo32);

	  
	  materiaEstudianteEjemplo33.setNombreMateria("Sistemas Operativos");
	  materiaEstudianteEjemplo33.setIdMateria(33);
	  materiaEstudianteEjemplo33.setUv(4);
	  materiaEstudianteEjemplo33.setPreRequisito("28");
	  materiaService.createMateria(materiaEstudianteEjemplo33);

	  materiaEstudianteEjemplo34.setNombreMateria("Programación Declarativa");
	  materiaEstudianteEjemplo34.setIdMateria(34);
	  materiaEstudianteEjemplo34.setUv(4);
	  materiaEstudianteEjemplo34.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo34);

	  materiaEstudianteEjemplo35.setNombreMateria("Ingeniería de Software");
	  materiaEstudianteEjemplo35.setIdMateria(35);
	  materiaEstudianteEjemplo35.setUv(4);
	  materiaEstudianteEjemplo35.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo35);

	  materiaEstudianteEjemplo36.setNombreMateria("Formulación y Evaluación de Proyectos");
	  materiaEstudianteEjemplo36.setIdMateria(36);
	  materiaEstudianteEjemplo36.setUv(4);
	  materiaEstudianteEjemplo36.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo36);
	  

	  materiaEstudianteEjemplo37.setNombreMateria("Optativa Humanístico Social IV");
	  materiaEstudianteEjemplo37.setIdMateria(37);
	  materiaEstudianteEjemplo37.setUv(3);
	  materiaEstudianteEjemplo37.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo37);

	  materiaEstudianteEjemplo38.setNombreMateria("Optativa Técnica II");
	  materiaEstudianteEjemplo38.setIdMateria(38);
	  materiaEstudianteEjemplo38.setUv(4);
	  materiaEstudianteEjemplo38.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo38);

	  materiaEstudianteEjemplo39.setNombreMateria("Aplicaciones de Código Abierto");
	  materiaEstudianteEjemplo39.setIdMateria(39);
	  materiaEstudianteEjemplo39.setUv(4);
	  materiaEstudianteEjemplo39.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo39);

	  materiaEstudianteEjemplo40.setNombreMateria("Práctica Profesional I");
	  materiaEstudianteEjemplo40.setIdMateria(40);
	  materiaEstudianteEjemplo40.setUv(4);
	  materiaEstudianteEjemplo40.setPreRequisito("36");
	  materiaService.createMateria(materiaEstudianteEjemplo40);

	  materiaEstudianteEjemplo41.setNombreMateria("Optativa Técnica III");
	  materiaEstudianteEjemplo41.setIdMateria(41);
	  materiaEstudianteEjemplo41.setUv(4);
	  materiaEstudianteEjemplo41.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo41);

	  materiaEstudianteEjemplo42.setNombreMateria("Teorías de Lenguaje de Programación");
	  materiaEstudianteEjemplo42.setIdMateria(42);
	  materiaEstudianteEjemplo42.setUv(4);
	  materiaEstudianteEjemplo42.setPreRequisito("24");
	  materiaService.createMateria(materiaEstudianteEjemplo42);

	  materiaEstudianteEjemplo43.setNombreMateria("Optativa Humanístico Social V");
	  materiaEstudianteEjemplo43.setIdMateria(43);
	  materiaEstudianteEjemplo43.setUv(3);
	  materiaEstudianteEjemplo43.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo43);

	  materiaEstudianteEjemplo44.setNombreMateria("Práctica Profesional II");
	  materiaEstudianteEjemplo44.setIdMateria(44);
	  materiaEstudianteEjemplo44.setUv(4);
	  materiaEstudianteEjemplo44.setPreRequisito("40");
	  materiaService.createMateria(materiaEstudianteEjemplo44);
	   
	  
    return "login.jsp";
  }
  
  //Actions para rutas (para botones):
  @GetMapping("/login")
  public String login() {
	  
	  //Al volver al login o al deslogearse para que reinicie el estudiante logeado
	  carreraEstudianteLogeado = null;
	  estudianteLogeado = null;
	  estudianteExiste = false;
	  
	  //Limpiando las listas de las evaluaciones
	  nombreActividades.clear();
	  ponderacionActividades.clear();
	  fechaActividades.clear();
	  notaActividades.clear();
	  listEvaluacionesSize = 0;
	  
    return "login.jsp";
  } 
 
  
  @GetMapping("/dataUpdate")
  public String dataUpdate() {
    return "dataUpdate.jsp";
  } 
  
  
  @GetMapping("/userUpdate")
  public String userUpdate() {
    return "userUpdate.jsp";
  } 
  
  @GetMapping("/recoveryPasword")
  public String recoveryPasword() {
    return "passwordRecover.jsp"; 
  } 
  
  @GetMapping("/register")
  public String register() {
    return "register.jsp";      
  }  
  
  @GetMapping("/closeSemester")
  public String closeSemester(ModelMap modelMap) {
	modelMap.put("nombreEstudianteCS", estudianteEjemplo.getNombreEstudiante());
    return "closeSemester.jsp"; 
  } 
  
  
  @GetMapping("/socialUpdate")
  public String socialUpdate() {
    return "socialUpdate.jsp";
  } 
  
  
  @GetMapping("/semester")
  public String semester(ModelMap modelmap) {
	  
	
    return "semester.jsp";
  } 
 
  
  Double suma = 0.0;
  
  @GetMapping("/calculateScore")
  public String calculateScore(ModelMap modelmap) {
	  
	  
	  //Posiciones de las evaluaciones que tienen 0.0
	  List<Integer> posiciones = new ArrayList<Integer>();
	  List<Double> multiplicados = new ArrayList<Double>();
	  List<Double> sumados = new ArrayList<Double>();
	   
	  
    return "calculateScore.jsp";
  } 
  
  
  
  @GetMapping("/mainPage")
  public String mainPage(ModelMap modelMap) {
	  
	//Lista de tabla Estudiante
	  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
	  
	  estudiantes.forEach(e -> {
		  if(e.getIdEstudiante().toString().equals(estudianteLogeado.getIdEstudiante().toString())){
		  estudianteLogeado = e;
		  carreraEstudianteLogeado = carreraService.getCarreraById(e.getIdEstudiante());
	  }});
	  
	//menu atributos sobre la carrera del estudiante:
	  modelMap.put("nombreEstudiante", estudianteLogeado.getNombreEstudiante());
	  modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
	  modelMap.put("uVEstudiante", carreraEstudianteLogeado.getUvAprobadas());
	  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
    return "mainPage.jsp";
  } 
  
  
  
  @PostMapping("/userUpdateSuccess")
  public String userUpdateSuccess(@RequestParam("name") String name, 
		  @RequestParam("year") String year,
		  @RequestParam("carnet") String carnet,ModelMap modelMap){
	  
	//Lista de tabla Estudiante
	  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
	  
	  
	  estudiantes.forEach( e -> {
		 if(e.getCarnetEstudiante().toString().equals(carnet)) {
			 estudianteService.updateEstudianteName(e, name);
		 }
	  });
	  
	//Lista tabla Carrera
	  List<Carrera> carreras = new ArrayList<Carrera>();
	  carreraService.getCarreras().forEach(c -> carreras.add(c));
	    
	  
  
	  
	  if(name.isEmpty() || year.isEmpty() || carnet.isEmpty() ) {
		  modelMap.put("errorUU", "No deje espacios en blanco");
		    return "userUpdate.jsp";
	  }
	  //Si el usuario que modificara no esta en la bdd
	  else if(!carnet.equals(estudianteLogeado.getCarnetEstudiante().toString())) {
		  modelMap.put("errorUU", "Carnet incorrecto");
		    return "userUpdate.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteUUS", estudianteEjemplo.getNombreEstudiante());
		    return "userUpdateSuccess.jsp";
	  }
	  
    
  } 
  
  
  

  @GetMapping("/availableSubjects")
  public String availableSubjects(ModelMap modelmap) {
	  
	//Separa las el id de las materias aprobadas que tiene el estudiante en la tabla carrera 
	  //y busca las materias en la tabla Materia y las agrega a la lista materias para mostrarlas
	  List<Materia> materias = new ArrayList<Materia>();
	  
	  String materiasHabilesEstudiante = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
      String[] split = materiasHabilesEstudiante.split(",");
      
	  
      for (int i=0; i<split.length; i++) {
    	  materias.add(materiaService.getMateriaById(Integer.parseInt(split[i])));
      }
      
      materias.remove(null);
      
      if(materias.isEmpty()) {
    	  modelmap.addAttribute("errorSem3", "En este momento no tienes materias disponibles");
    	  return "availableSubjects.jsp";
      }
      else {
    	  modelmap.addAttribute("materias", materias);
    	  return "availableSubjects.jsp";
      }
      
      
  }
  
  @GetMapping("/activities")
  public String activities(ModelMap modelMap) {
	  
	//Lista de tabla Estudiante
	  List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
	  actividadesExtraService.getActividades().forEach(a -> actividades.add(a));
	  
	  //Lista para mostrar en la tabla de ActividadesExtra
	  List<ActividadesExtra> actividadesEstudianteLogeado = new ArrayList<ActividadesExtra>();
	  
	  actividades.forEach(a -> {
		  if(a.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
			  actividadesEstudianteLogeado.add(a);
			  
			  //a.getNombreActividadesExtra();
			  //a.getActividadHecha();
	  }});
	  
	modelMap.addAttribute("actividadesEstudianteLogeado", actividadesEstudianteLogeado);  
    return "activities.jsp";
  }
  
  @GetMapping("/activitiesUpdate")
  public String activitiesUpdate() {
    return "activitiesUpdate.jsp";
  }
  
  @GetMapping("/subjectsUpdate")
  public String subjectsUpdate(ModelMap modelmap) {
	 
	  
    return "subjectsUpdate.jsp";
  } 
  
  
  @PostMapping("/socialUpdate")
  public String socialUpdate(@RequestParam("internal") String internal, ModelMap modelMap){
  
	  
	  //Lista tabla Carrera
	  List<Carrera> carreras = new ArrayList<Carrera>();
	  carreraService.getCarreras().forEach(c -> carreras.add(c));
	  

	  
	  if(internal.isEmpty()) {
		  modelMap.put("errorSoU", "No deje espacios en blanco");
		    return "socialUpdate.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteSUS", estudianteEjemplo.getNombreEstudiante());
		    return "socialUpdateSuccess.jsp";
	  }
    
  } 
  
  @PostMapping("/socialUpdate2")
  public String socialUpdate2(@RequestParam("external") String external, ModelMap modelMap){
  
	//Lista tabla Carrera
	  List<Carrera> carreras = new ArrayList<Carrera>();
	  carreraService.getCarreras().forEach(c -> carreras.add(c));
	  
	  
	  if(external.isEmpty()) {
		  modelMap.put("errorSoU2", "No deje espacios en blanco");
		    return "socialUpdate.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteSUS", estudianteEjemplo.getNombreEstudiante());
		    return "socialUpdateSuccess.jsp";
	  }
    
  } 
  
  @PostMapping("/addSubject")
  public String addSubject(@RequestParam("materia") String materia, ModelMap modelMap){
  
	  if(materia.isEmpty()) {
		  modelMap.put("errorASS", "No deje espacios en blanco");
		    return "availableSubjects.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteASS", estudianteEjemplo.getNombreEstudiante());
		    return "addSemesterSuccess.jsp";
	  }
    
  }
  
   
  
  @PostMapping("/loginn")   
  public String login(@RequestParam("CARNET") String CARNET,
		  @RequestParam("PASSWORD") String PASSWORD, 
		  ModelMap modelMap){ 
	  
	  
	  if(CARNET.isEmpty() || PASSWORD.isEmpty()) {
		  modelMap.put("errorL","No deje espacios en blanco");
		  return "login.jsp";
	  }
	  else {
		//Lista de tabla Estudiante
		  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
		  
		  //Lista tabla Carrera
		  List<Carrera> carreras = new ArrayList<Carrera>();
		  carreraService.getCarreras().forEach(c -> carreras.add(c));
		  
		  //Si no hay usuarios:
		  if(estudiantes.isEmpty() || carreras.isEmpty()) {
			  modelMap.put("errorL","Datos incorrectos");
			  return "login.jsp";
		  }
		  
		  //Vamos a evaluar si el estudiante que desea logearse existe y manipular sus respectivas banderas:
		  estudiantes.forEach(e -> {
			  if(e.getCarnetEstudiante().toString().equals(CARNET) && e.getContrasenaEstudiante().equals(PASSWORD)){
			  estudianteLogeado = e;
			  estudianteExiste = true;
		  }});
		  
		  if(estudianteExiste) {
			  
			  carreras.forEach(c -> {
					 if(estudianteLogeado.getCarreraEstudiante().equals(c.getIdCarrera())) {
						 carreraEstudianteLogeado = c;
					 }
				  });
				  
			  
					//menu atributos sobre la carrera del estudiante:
					  modelMap.put("nombreEstudiante", estudianteLogeado.getNombreEstudiante());
					  modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
					  modelMap.put("uVEstudiante", carreraEstudianteLogeado.getUvAprobadas());
					  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
					  
					  return "mainPage.jsp";
				  
		  }
		  
		  else {
			  modelMap.put("errorL","Datos incorrectos");
			  return "login.jsp";
		  }
	  }
	   
  } 
  
//Actualizar nombre de usuario:
  @PostMapping("/userUpdateSuccess")
  public String userUpdateSuccess(@RequestParam("name") String name,
		  @RequestParam("carnet") String carnet,ModelMap modelMap){
	  
	//Lista de tabla Estudiante
	  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
	  
	  
	  if(name.isEmpty() || carnet.isEmpty() ) {
		  modelMap.put("errorUU", "No deje espacios en blanco");
		    return "userUpdate.jsp";
	  }
	  //Si el usuario que modificara no esta en la bdd
	  else if(!carnet.equals(estudianteLogeado.getCarnetEstudiante().toString())) {
		  modelMap.put("errorUU", "Carnet incorrecto");
		    return "userUpdate.jsp";
	  }
	  else{
		  
		  estudiantes.forEach( e -> {
				 if(e.getCarnetEstudiante().toString().equals(estudianteLogeado.getCarnetEstudiante().toString())) {
					 
					 estudianteService.updateEstudianteName(e, name);
				 }
			  });
		  
		  modelMap.put("nombreEstudianteUUS", estudianteEjemplo.getNombreEstudiante());
		    return "userUpdateSuccess.jsp";
	  }
	  
    
  } 
  
  //agregar o eliminar actividad:
  @PostMapping("/activitiesEdit")
  public String activitiesEdit(@RequestParam("idActivity") String idActivity, 
  		  @RequestParam("nombreActividad") String nombreActividad,
  		  ModelMap modelMap) {
  	  
  	if (idActivity.isEmpty() && nombreActividad.isEmpty()) {
  		modelMap.put("errorAE", "Llene al menos un espacio");
  		activities(modelMap);
  		return "activities.jsp";
  	} else {
  		if (!nombreActividad.isEmpty() && idActivity.isEmpty()) {
  			// Agregar una nueva actividad
  			List<ActividadesExtra> actividades = new ArrayList<>();
  			actividadesExtraService.getActividades().forEach(a -> actividades.add(a));

  			int lastIdx = actividades.size() - 1;
  			ActividadesExtra lastActividad = actividades.get(lastIdx);
  			int idActividadExtra = lastActividad.getIdActividadesExtra() + 1;

  			ActividadesExtra newActividadExtra = new ActividadesExtra();
  			newActividadExtra.setIdActividadesExtra(idActividadExtra);
  			newActividadExtra.setNombreActividadesExtra(nombreActividad);
  			newActividadExtra.setIdEstudiante(estudianteLogeado.getIdEstudiante());
  			actividadesExtraService.createActividadExtra(newActividadExtra);
  			
  			Carrera ca = carreraEstudianteLogeado;
  			int cAEA = ca.getCantidadActividadesExtracurriculares();
  			ca.setCantidadActividadesExtracurriculares(cAEA+1);
  			carreraService.updateCarrera(ca);
  			
  			modelMap.addAttribute("errorAE", "Se ha agregado la actividad");
  		}

  		if (!idActivity.isEmpty() && nombreActividad.isEmpty()) {
  			// Eliminar una actividad
  			actividadesExtraService.deleteActividadExtraById(Integer.parseInt(idActivity));
  			
  			Carrera ca = carreraEstudianteLogeado;
  			int cAEA = ca.getCantidadActividadesExtracurriculares();
  			ca.setCantidadActividadesExtracurriculares(cAEA-1);
  			carreraService.updateCarrera(ca);
  			
  			modelMap.addAttribute("errorAE", "Se ha eliminado la actividad");
  		}

  		activities(modelMap);
  		return "activities.jsp";
  	}
  }
  
  
  @PostMapping("/actualizarContrasena")
  public String actualizarContrasena(@RequestParam("nombrePR") String nombrePR,
		  @RequestParam("carnetPR") String carnetPR, 
		  @RequestParam("passwordPR") String passwordPR,
		  ModelMap modelMap){
	  
	  
	  //Lista de tabla Estudiante
	  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
	  
	  
	  estudiantes.forEach( e -> {
		 if(e.getNombreEstudiante().equals(nombrePR) && e.getCarnetEstudiante().toString().equals(carnetPR)) {
			 estudianteService.updateEstudiante(e, passwordPR);
			 contraActualizada = true;
		 }
	  });
	  
	  
	  //Si los datos escritos estan en la bdd
	  if(contraActualizada){
		  //Se actualizo la contrasena
		  
		  modelMap.put("nombreEstudiantePUS", estudianteEjemplo.getNombreEstudiante());
		  return "passUpdateSucess.jsp";
	  } 
	  else if(nombrePR.isEmpty() || carnetPR.isEmpty() || passwordPR.isEmpty()) {
		  modelMap.put("errorPR", "No deje espacios en blanco");
		  return "passwordRecover.jsp";
	  }
	  else { 
		  modelMap.put("errorPR", "Usuario no encontrado");
		  return "passwordRecover.jsp";
	  } 
	
  } 
  
  //Agregar ActividadExtra para EstudianteLogeado
  @PostMapping("/activitiesUpSuccess")
  public String activitiesUpSuccess(@RequestParam("nameActivity") String nameActivity, ModelMap modelMap){
	    
  
	  if(nameActivity.isEmpty()) {
		  modelMap.put("errorU", "No deje espacios en blanco");
		    return "activitiesUpdate.jsp";
	  }
	  else {
		  
		//Lista de tabla Estudiante
		  List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
		  actividadesExtraService.getActividades().forEach(a -> actividades.add(a));
		  
		  int lastIdx = actividades.size()-1;
		  ActividadesExtra lastActividad= actividades.get(lastIdx);
		  
		  int idActividadExtra= lastActividad.getIdEstudiante()+1;
		  
		  //Creando ActividadExtra
		  ActividadesExtra newActividad = new ActividadesExtra();
		  newActividad.setIdActividadesExtra(idActividadExtra);
		  newActividad.setIdEstudiante(estudianteLogeado.getIdEstudiante());
		  newActividad.setNombreActividadesExtra(nameActivity);
		  actividadesExtraService.createActividadExtra(newActividad);
		  
		  modelMap.put("nombreEstudianteAUS", estudianteEjemplo.getNombreEstudiante());
		    return "activitiesUpSuccess.jsp";
	  }
	  
  } 
  
//Eliminar ActividadExtra para EstudianteLogeado
  @PostMapping("/activitiesUpSuccess2")
  public String activitiesUpSuccess2(@RequestParam("nameActivity") String nameActivity, ModelMap modelMap){
	    
  
	  if(nameActivity.isEmpty()) {
		  modelMap.put("errorU", "No deje espacios en blanco");
		    return "activitiesUpdate.jsp";
	  }
	  else {
		  
		//Lista de tabla 
		  List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
		  actividadesExtraService.getActividades().forEach(a -> {
			  if(a.getNombreActividadesExtra().equals(nameActivity)) {
				  actividadesExtraService.deleteActividadExtraById(a.getIdActividadesExtra());
			  };
		  });
		 
		  
		  modelMap.put("nombreEstudianteAUS", estudianteEjemplo.getNombreEstudiante());
		    return "activitiesUpSuccess.jsp";
	  }
	  
    
  }
  
  
  @PostMapping("/registrarEstudiante")
  public String registrarEstudiante(@RequestParam("nombreRe") String nombreRe,
		  @RequestParam("carnetRe") String carnetRe, 
		  @RequestParam("passwordRe") String passwordRe,
		  @RequestParam("passwordRe2") String passwordRe2,
		  ModelMap modelMap){ 
	  
	  if(nombreRe.isEmpty()||carnetRe.isEmpty()||passwordRe.isEmpty()||passwordRe.isEmpty()){
		  //Se actualizo la contrasena
		  
		  modelMap.put("errorRe", "No deje espacios en blanco");
		  return "register.jsp";
	  } 
	  else {
		  
		   
		  Estudiante newEstudiante = new Estudiante();
		  newEstudiante.setNombreEstudiante(nombreRe);
		  newEstudiante.setCarnetEstudiante(Integer.parseInt(carnetRe));
		  newEstudiante.setContrasenaEstudiante(passwordRe2);
		  
		  //id autoincrementable:
		  
		//Lista de tabla Estudiante
		  List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		  estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));
		  
		  int lastIdx = estudiantes.size()-1;
		  Estudiante lastEstudiante= estudiantes.get(lastIdx);
		  
		  int idEstudiante= lastEstudiante.getIdEstudiante()+1;
		  newEstudiante.setIdEstudiante(idEstudiante);
		  newEstudiante.setCarreraEstudiante(idEstudiante);
		  
		  
		  //creando estudiante:
		  estudianteService.createEstudiante(newEstudiante);
		  
		  //creando Actividades Extra, Carrera y Ciclo, que esta relacionado con el estudiante
		  ActividadesExtra newActividadExtra = new ActividadesExtra();
		  newActividadExtra.setIdActividadesExtra(idEstudiante);
		  
		  //carrera de nuewEstudiante
		  Carrera newCarrera = new Carrera();
		  newCarrera.setIdCarrera(idEstudiante);
		  newCarrera.setUvAprobadas(0);
		  newCarrera.setCantidadMateriasAprobadas(0);
		  newCarrera.setMateriasAprobadas("0");
		  newCarrera.setCantidadMateriasPosibles(9);
		  newCarrera.setMateriasPosibles("1,2,3,4,17,23,32,37,43");
		  carreraService.createCarrera(newCarrera);
		  
		 
		  modelMap.put("nombreEstudianteRegistrado", nombreRe);
		  return "regUpdateSuccess.jsp";
	  }
	
  }
   
  
}

    
	  
   
    
  
  

