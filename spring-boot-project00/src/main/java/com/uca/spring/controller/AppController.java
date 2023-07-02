package com.uca.spring.controller;
//
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
import com.uca.spring.model.Logs;
import com.uca.spring.model.Materia;
import com.uca.spring.service.ActividadesExtraService;
import com.uca.spring.service.CarreraService;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.service.LogsService;
import com.uca.spring.service.MateriaService;
import com.uca.spring.util.Util;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/")
public class AppController {
	
	//services para DML de la bdd
	@Autowired
	ActividadesExtraService actividadesExtraService;
	@Autowired
	CarreraService carreraService;
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	LogsService logsService;
	
	//actividades extras temporales
	ActividadesExtra actividadExtra1 = new ActividadesExtra();
	ActividadesExtra actividadExtra2 = new ActividadesExtra();
	Estudiante estudianteEjemplo = new Estudiante();
	Carrera carreraEstudianteEjemplo = new Carrera();
	
	//Creando estudiante ejemplo:
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
	
	//Crear todos los objetos para la malla curricular (ing informatica):
	Materia materiaEstudianteEjemplo0= new Materia();
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
	
	//vars que se ocupan a nivel global para cada action
	boolean contraActualizada = false;
	boolean usuarioActualizado = false;
	boolean miMateriaEncontrada = false;
	boolean materiaPosible = false;
	String nuevasMateriasPosibles = "";
	String nuevasMateriasAprobadas = "";
	
	
	
	
	
	////ACTIONS PARA RUTAS (para cargar jsp):
	//-------------------------------------------------------------------------------------------------------------------------
	
	//Action que se invoca al iniciar la app en la ruta (/)
  @GetMapping("/")
  public String getForm() {
	  
	  //seteando y creando actividades para estudiante1
	  actividadExtra1.setIdActividadesExtra(2);
	  actividadExtra1.setIdEstudiante(1);
	  actividadExtra1.setNombreActividadesExtra("Reunirse con el grupo de ARI 10:00pm");
	  
	  actividadExtra2.setIdActividadesExtra(3);
	  actividadExtra2.setIdEstudiante(1);
	  actividadExtra2.setNombreActividadesExtra("Renovar CARNET miercoles 7 junio");
	  
	  actividadesExtraService.createActividadExtra(actividadExtra1);
	  actividadesExtraService.createActividadExtra(actividadExtra2);
	  
	  //Seteando atributos para estudiante1 y crearlo en bdd para ejemplo:
	  estudiante1.setCarnetEstudiante(38619);
	  estudiante1.setIdEstudiante(1);
	  estudiante1.setNombreEstudiante("Omar Flores Alas");
	  estudiante1.setContrasenaEstudiante("123");
	  estudiante1.setCarreraEstudiante(1);
	  estudianteService.createEstudiante(estudiante1);
	  
	  
	  //seteando carrera1 para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	  carreraEstudiante1.setIdCarrera(1);
	  carreraEstudiante1.setUvAprobadas(102);
	  carreraEstudiante1.setCantidadMateriasAprobadas(4);
	  carreraEstudiante1.setMateriasAprobadas("1,2,3,4");
	  //carreraEstudiante1.setNotaAprobada("10,5,5,5");
	  carreraEstudiante1.setNotaAprobada("10,5,10,5");
	  carreraEstudiante1.setCantidadMateriasPosibles(4);
	  carreraEstudiante1.setMateriasPosibles("5,6,7,8");
	  carreraEstudiante1.setCantidadActividadesExtracurriculares(2);
	  carreraService.createCarrera(carreraEstudiante1);
	  
	  
	  //seteando materias (seran las materias aprobadas relacionadas al estudiante) para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	  //OBJETO DE MALLA (prerequisito =0 cuando sea bachillerato)
	  //materias de ingenieria informatica:
	  materiaEstudianteEjemplo0.setNombreMateria("Bachillerato");
	  materiaEstudianteEjemplo0.setIdMateria(0);
	  materiaEstudianteEjemplo0.setUv(0);
	  materiaEstudianteEjemplo0.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo0);
	  
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
  
  //Para menu:
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
	  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
	  modelMap.put("actividadesExtracurricularesEstudiante", carreraEstudianteLogeado.getCantidadActividadesExtracurriculares());
    return "mainPage.jsp";
  }
  
  //Para las materias habiles:
  @GetMapping("/availableSubjects")
  public String availableSubjects(ModelMap modelmap) {
	  
	  //Separa las el id de las materias aprobadas que tiene el estudiante en la tabla carrera 
	  //y busca las materias en la tabla Materia y las agrega a la lista materias para mostrarlas
	  List<Materia> materiasP = new ArrayList<Materia>();
	  List<Materia> materiasA = new ArrayList<Materia>();
	  List<Double> notaAprobada = new ArrayList<Double>();
	  
      String[] split1 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles().split(",");
      String[] split2 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas().split(",");
      String[] split3 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada().split(",");
      
	  //Agregando las materias posibles
      for (int i=0; i<split1.length; i++) {
    	  materiasP.add(materiaService.getMateriaById(Integer.parseInt(split1[i])));
      }
      materiasP.remove(null);
     
      //Agregando las materias aprobadas y sus notas
      for (int i=0; i<split2.length; i++) {
    	  materiasA.add(materiaService.getMateriaById(Integer.parseInt(split2[i])));
    	  notaAprobada.add(Double.valueOf(split3[i]));
      }
      materiasA.remove(null);
      notaAprobada.remove(null);
      
      //Obteniendo las materias recomendadas desde la clase Util
      List<Materia> materiasR = Util.materiasRecomendadas(materiasP, materiasA, notaAprobada);
      
      
      
      if(materiasP.isEmpty()) {
    	  modelmap.addAttribute("errorSem3", "En este momento no tienes materias disponibles");
    	  modelmap.addAttribute("errorSem3", "En este momento no tienes materias recomendadas");
    	  return "availableSubjects.jsp";
      }
      else {
    	  
    	  if(materiasA.isEmpty()) {
    		  modelmap.addAttribute("materias", materiasP);
    		  modelmap.addAttribute("errorSem3", "En este momento no tienes materias recomendadas");
        	  return "availableSubjects.jsp";
    	  }
    	  else {
    		  modelmap.addAttribute("materias", materiasP);
        	  modelmap.addAttribute("materiasR", materiasR);
        	  return "availableSubjects.jsp";
    	  }
    	  
      }
      
      
  }
  
  //para las actividades extracurriculares:
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
	  
	  if(actividadesEstudianteLogeado.isEmpty()) {
		  
		  modelMap.addAttribute("errorAE", "No tiene actividades pendientes");  
		  return "activities.jsp";
	  }
	  else {
		  modelMap.addAttribute("actividadesEstudianteLogeado", actividadesEstudianteLogeado);  
		    return "activities.jsp";
	  }
	  
	
  }
  
  //Para las materias aprovadas:
  @GetMapping("/approvedSubjects")
  public String approvedSubjects(ModelMap modelmap) {
	  
	//Separa las el id de las materias aprobadas que tiene el estudiante en la tabla carrera 
	  //y busca las materias en la tabla Materia y las agrega a la lista materias para mostrarlas
	  List<Materia> materiasMA = new ArrayList<Materia>();
	  
	  String materiasAprobadasEstudiante = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
      String[] split = materiasAprobadasEstudiante.split(",");
      
	  
      for (int i=0; i<split.length; i++) {
    	  materiasMA.add(materiaService.getMateriaById(Integer.parseInt(split[i])));
      }
      
      materiasMA.remove(null);
      
      if(materiasMA.isEmpty()) {
    	  modelmap.addAttribute("errorMA", "En este momento no tienes materias aprobadas");
    	  return "approvedSubjects.jsp";
      }
      else {
    	  modelmap.addAttribute("materiasMA", materiasMA);
    	  return "approvedSubjects.jsp";
      }
      
      
  }
  
  
  //Al volver al login o al deslogearse para que reinicie el estudiante logeado
  @GetMapping("/login")
  public String login() {
	  
	  carreraEstudianteLogeado = null;
	  estudianteLogeado = null;
	  estudianteExiste = false;
	  
    return "login.jsp";
  } 
 
  
  @GetMapping("/dataUpdate")
  public String dataUpdate() {
    return "dataUpdate.jsp";
  } 
  
  @GetMapping("/semester")
  public String semester() {
    return "availableSubjects.jsp";
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
  
  @GetMapping("/activitiesUpdate")
  public String activitiesUpdate() {
    return "activitiesUpdate.jsp";
  }
  
  
   
  
 

  ////ACTIONS PARA post mapping (para botones):
  //-------------------------------------------------------------------------------------------------------------------------
	
  
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

  //Action para marcar una materia de "materias habiles" (por medio se su correlativo) como aprobada 
  //y removerla de las posibles y agregar las nuevas posibles en funcion de esa aprobada
  int cantMateriasAprobadas = 0,cantMateriasPosibles=0;
  List<String> prerrequisitos;
  
  @PostMapping("/subjectsUpdateSuccess2")
  public String subjectsUpdateSuccess2(@RequestParam("subject") String subject, ModelMap modelMap){
	  
	  
	  if(subject.isEmpty() ) {
		  modelMap.put("errorMA", "No deje espacios en blanco");
		  
		  approvedSubjects(modelMap);
		    return "approvedSubjects.jsp";
	  }
	  else {
		  
		  //POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
		  List<String> materias0 = new ArrayList<String>();
		  
		  String materiasPosiblesEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
	      String[] split = materiasPosiblesEstudianteLogeado.split(",");
	      
	      for (int i=0; i<split.length; i++) {
	    		  materias0.add(split[i]);
	      } 
	      
	      cantMateriasPosibles = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasPosibles());
	      
	      //materias aprobadas del estudiante logueado:
	      List<String> materias1 = new ArrayList<String>();
	      
		  String materiasAprobadasEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
	      String[] split1 = materiasAprobadasEstudianteLogeado.split(",");
	      
	      for (int i=0; i<split1.length; i++) {
	    		  materias1.add(split1[i]);
	      }
	      
	      cantMateriasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasAprobadas());
	      
	      
	      
	      
	      //verificamos si la materia que quiere remover en subject
	      //la tiene disponible y la puede agregar
	      if(!materias1.contains(subject)) {
	    	  modelMap.put("errorMA", "No puede remover una materia que no tiene aprobada");
	    	  
	    	  approvedSubjects(modelMap);
	    	  return "approvedSubjects.jsp";
	      }
	      else {
	    	  //sino se elimina de la lista de ids de materias aprobadas y
	    	  //se pasa al string de las materias posibles (eliminado de aqui todas aquellas en las cuales
	    	  //esta removida es prequisito)
	    	  
	    	  //Agregando las materias posibles en funcion de la que se esta removiendo:
	    	  //
	    	  //
	    	  
	    	//Lista de tabla Materia
	  		  List<Materia> materias= new ArrayList<Materia>();
	  		materiaService.getMaterias().forEach(m->{
	  			  materias.add(m);
	  		  });
	  		
	  		//obteniendo las materias posibles a partir del id aprobado removido
	  		  //y buscando las materias que tengan ese prerrequisito
	  		  materias.forEach(m->{
	  			  

	  			  //por cada materia existente, se iran guardando los prerrequisitos
	  			  prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));
	  			  
	  			  prerrequisitos.forEach(p ->{
	  				  
	  				//para cada prerrequisito veremos si es el mismo id de la materia aprobada removida
	  				  if(subject.equals(p)) {
	  					  
	  					  //entonces si el prerrequisito es el mismo 
	  					  //seleccionaremos la materia
	  					  //si esa materia esta en materias posibles ya la removeremos:
	  					  if(materias0.contains(m.getIdMateria().toString())) {
	  						  
	  						  materias0.remove(m.getIdMateria().toString());
	  						  cantMateriasPosibles--;
	  						  
	  					  }
	  				 } 
	  			  });
	  			  
	  		  });
	  		  
	  		  //Sumandole la aprobada removida
	  		  cantMateriasPosibles += 1;
	  		  
	  		  //Agregando la aprobada removida a las posibles
	  		  materias0.add(subject);
	    	  nuevasMateriasPosibles = String.join(",", materias0);
	    	  
	    	  
	    	  //Removiendo la materia aprobada de las materias aprobadas:
	    	  int indexNota = materias1.indexOf(subject);
		      materias1.remove(subject);
		      nuevasMateriasAprobadas = String.join(",", materias1);
		      
	 
		      //eliminando la nota de la materia a remover (en su indice respectivo)
		      String [] notasAprobadas = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada().split(",");
		      
		      List<String> na = new ArrayList<>();
		      
		      for(int i=0; i<notasAprobadas.length; i++) {
		    	  if(i!=indexNota) {
		    		  na.add(notasAprobadas[i]);
		    	  }
		      }
		      
		      String nuevasNotasAprobadas = String.join(",", na);
		      
		      //cantidad de materia aprobadas
		      cantMateriasAprobadas -= 1;
		      
		      //Actualizando materias posibles y materias aprobadas
		      Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
	    	  newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
	    	  newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
	    	  newCarrera.setNotaAprobada(nuevasNotasAprobadas);
	    	  newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
	    	  newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
	    	  carreraService.updateCarreraG(newCarrera, carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()) );
	    	  
	    	  
	    	  //Reiniciando variables:
	    	  cantMateriasAprobadas = 0;
	  		  cantMateriasPosibles=0;
	  		  prerrequisitos= new ArrayList<>();
	    	  
	      }
	    
	      
	     
	      //mostrar mensaje que la lista se ha actualizado correctamente
    	  modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());
    	  
    	  return "subjectsUpdateSuccess.jsp";
    	  
	      }
	     
  } 
  
  
  //Action para marcar una materia de "materias habiles" (por medio se su correlativo) como aprobada 
  //y removerla de las posibles y agregar las nuevas posibles en funcion de esa aprobada
  List<String> prerrequisitosExcepto;
  
  @PostMapping("/subjectsUpdateSuccess")
  public String subjectsUpdateSuccess(@RequestParam("subject") String subject, 
		  @RequestParam("score") String score, ModelMap modelMap){
	  
	  
	  if(subject.isEmpty() || score.isEmpty()) {
		  modelMap.put("errorSU", "No deje espacios en blanco");
		  
		  availableSubjects(modelMap);
		    return "availableSubjects.jsp";
	  }
	  else {
		  
		//PARA MOSTRAR LAS POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
		  List<String> materias0 = new ArrayList<String>();
		  
		  String materiasPosiblesEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
	      String[] split = materiasPosiblesEstudianteLogeado.split(",");
	      
	      for (int i=0; i<split.length; i++) {
	    		  materias0.add(split[i]);
	      } 
	      
	      //Para mostrar las materias aprobadas del estudiante logueado:
	      List<String> materias1 = new ArrayList<String>();
	      
		  String materiasAprobadasEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
	      String[] split1 = materiasAprobadasEstudianteLogeado.split(",");
	      
	      for (int i=0; i<split1.length; i++) {
	    		  materias1.add(split1[i]);
	      }
	      
	      
	      //verificamos si la materia que quiere agregar en subject (como aprobada)
	      //la tiene disponible y la puede agregar
	      if(!materias0.contains(subject)) {
	    	  modelMap.put("errorSU", "No puede inscribir una materia que no tiene habilitada");
	    	  
	    	  availableSubjects(modelMap);
	    	  return "availableSubjects.jsp";
	      }
	      else {
	    	  //sino se elimina de la lista de ids de posibles materias y
	    	  //se pasa al string de las materias aprobadas
	    	  
	    	  //Solo se esta actualizando (removiendo) las materias posibles:
	    	  materias0.remove(subject);
	    	  
	    	  //Agregando las materias posibles en funcion de la que se esta aprobando:
	    	  //
	    	  //
	    	  
	    	//Lista de tabla Materia
	  		  List<Materia> materias= new ArrayList<Materia>();
	  		materiaService.getMaterias().forEach(m->{
	  			  materias.add(m);
	  		  });
	  		
	  	//obteniendo las materias posibles a partir del los id aprobado
	  		  //y buscando las materias que tengan esos prerrequisitos
	  		  materias.forEach(m->{
	  			  

	  			  //por cada materia existente, se iran guardando los prerrequisitos
	  			  prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));
	  			  
	  			  //lista exceptuando el id de la materia y poder comprobar si ya se aprobaron las demas
	  			  //materias (si los ids de las demas paterias prerrequisito estan en aprobadas)
	  			  prerrequisitosExcepto = new ArrayList<>(prerrequisitos);
	  			  prerrequisitosExcepto.remove(subject);
	  			  
	  			  prerrequisitos.forEach(p ->{
	  				  
	  				//para cada prerrequisito veremos si es la materia aprobada
	  				  if(subject.equals(p) && materias1.containsAll(prerrequisitosExcepto)) {
	  					  
	  					  //entonces si el prerrequisito es el mismo y los demas prerrequisito ya se aprobaron
	  					  //seleccionaremos la materia
	  					  //si esa materia no esta en materias posibles ya:
	  					  if(!materias0.contains(m.getIdMateria().toString())) {
	  						  
	  						  materias0.add(m.getIdMateria().toString());
	  						  cantMateriasPosibles++;
	  						  
	  					  }
	  				 } 
	  			  });
	  			  
	  		  });
	  		  
	  		  //Sumando las nuevas que se contaron, mas las que ya estan posibles y restandole la aprobada
	  		  cantMateriasPosibles += (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasPosibles()) -1;
	  		  
	    	  nuevasMateriasPosibles = String.join(",", materias0);
	          
	    	  
	    	  //Actualizando las materias aprobadas:
		      materias1.add(subject);
		      nuevasMateriasAprobadas = String.join(",", materias1);
		      String nuevasNotasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada())+","+score;
		      
		      //cantidad de materia aprobadas
		      cantMateriasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasAprobadas()) +1;
		      
		      //Actualizando materias posibles y materias aprobadas
		      Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
	    	  newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
	    	  newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
	    	  newCarrera.setNotaAprobada(nuevasNotasAprobadas);
	    	  newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
	    	  newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
	    	  carreraService.updateCarreraG(newCarrera, carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()) );
	    	  
	    	  
	    	  //Reiniciando variables:
	    	  cantMateriasAprobadas = 0;
	  		  cantMateriasPosibles=0;
	  		  prerrequisitos= new ArrayList<>();
	    	  
	      }
	    
	      
	     
	      //mostrar mensaje que la lista se ha actualizado correctamente
    	  modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());
    	  
    	  return "subjectsUpdateSuccess.jsp";
    	  
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
  
   
  //para loggearse
  @PostMapping("/loginn")   
  public String login(@RequestParam("CARNET") String CARNET,
		  @RequestParam("PASSWORD") String PASSWORD, 
		  ModelMap modelMap){ 
	  
	  
	  if(CARNET.isEmpty() || PASSWORD.isEmpty()) {
		  modelMap.put("errorL","No deje espacios en blanco");
		  return "login.jsp";
	  }
	  else {
		  
		  //Registrando log
		  Logs newLog = new Logs();
		  // Obteniendo la fecha y hora actual
		  LocalDateTime fechaActual = LocalDateTime.now();

		  // Formateando la fecha como una cadena de texto en el formato deseado
		  DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		  String fechaFormateada = fechaActual.format(formatoFecha);

		  // Estableciendo la fecha en el objeto newLog
		  newLog.setFecha(fechaFormateada);
		  newLog.setCarnet(CARNET);
		  logsService.createLog(newLog);
		  
		  
		  
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
			  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
			  modelMap.put("actividadesExtracurricularesEstudiante", carreraEstudianteLogeado.getCantidadActividadesExtracurriculares());
					  
					  return "mainPage.jsp"; 
				  
		  }
		  
		  else {
			  modelMap.put("errorL","Datos incorrectos");
			  return "login.jsp";
		  }
	  }
	   
  } 
  
  //para actualizar contrasena
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
  
  //para registrar estudiante
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
		  newCarrera.setNotaAprobada("0");
		  newCarrera.setCantidadMateriasPosibles(9);
		  newCarrera.setMateriasPosibles("1,2,3,4,17,23,32,37,43");
		  newCarrera.setCantidadActividadesExtracurriculares(0);
		  carreraService.createCarrera(newCarrera);
		  
		 
		  modelMap.put("nombreEstudianteRegistrado", nombreRe);
		  return "regUpdateSuccess.jsp";
	  }
	
  }
   
  
}

    
	  
   
    
  
  

