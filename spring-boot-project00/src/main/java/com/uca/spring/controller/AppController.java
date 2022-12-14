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
import com.uca.spring.model.Evaluacion;
import com.uca.spring.model.Materia;
import com.uca.spring.model.MiMateria;
import com.uca.spring.service.ActividadesExtraService;
import com.uca.spring.service.CarreraService;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.service.MateriaService;
import com.uca.spring.service.MiMateriaService;
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
	@Autowired
	MiMateriaService miMateriaService;
	
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
	
	//objeto de la tabla MiMateria del estudiante1:
	MiMateria miMateria1 = new MiMateria();
	
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
	  carreraEstudiante1.setHorasSocialesInternas(105);
	  carreraEstudiante1.setHorasSocialesExterna(1);
	  carreraEstudiante1.setAnioCarrera(4);
	  carreraService.createCarrera(carreraEstudiante1);
	  
//Creando objetos tipo ActividadExtra (seran las actividades relacionadas al estudiante) para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	  
	  actividadExtraEstudianteEjemplo1.setNombreActividadesExtra("Reunirse con el grupo de Simu");
	  actividadExtraEstudianteEjemplo2.setNombreActividadesExtra("Entregar proyecto Arqui");
	  actividadExtraEstudianteEjemplo3.setNombreActividadesExtra("Meet BI 6:30pm");
	  actividadExtraEstudianteEjemplo4.setNombreActividadesExtra("Ver videos en youtube sobre CSR");
	  
	  //MiMateria Estudiante1
	  miMateria1.setIdMiMateria(1);
	  miMateria1.setNombreMateria("Fundamentos de Programaci??n");
	  miMateria1.setCatedratico("Ing1");
	  miMateria1.setEvaluacion("Sin Editar");
	  miMateria1.setFecha("Sin Editar");
	  miMateria1.setNota("Sin Editar");
	  miMateria1.setPonderacion("Sin Editar");
	  miMateria1.setIdMateria(4);
	  miMateria1.setIdEstudiante(1);
	  miMateriaService.createMiMateria(miMateria1);
	  
	  
	  
	//Creando objetos tipo materia (seran las materias aprobadas relacionadas al estudiante) para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
	//OBJETOD DE MALLA (prerequisito =0 cuando sea bachillerato)
	  materiaEstudianteEjemplo1.setNombreMateria("Prec??lculo");
	  materiaEstudianteEjemplo1.setIdMateria(1);
	  materiaEstudianteEjemplo1.setUv(4);
	  materiaEstudianteEjemplo1.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo1);
	  
	  materiaEstudianteEjemplo2.setNombreMateria("Optativa T??cnica I");
	  materiaEstudianteEjemplo2.setIdMateria(2);
	  materiaEstudianteEjemplo2.setUv(3);
	  materiaEstudianteEjemplo2.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo2);

	  materiaEstudianteEjemplo3.setNombreMateria("Matem??tica Discreta I");
	  materiaEstudianteEjemplo3.setIdMateria(3);
	  materiaEstudianteEjemplo3.setUv(3);
	  materiaEstudianteEjemplo3.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo3);

	  materiaEstudianteEjemplo4.setNombreMateria("Fundamentos de Programaci??n");
	  materiaEstudianteEjemplo4.setIdMateria(4);
	  materiaEstudianteEjemplo4.setUv(4);
	  materiaEstudianteEjemplo4.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo4);

	  materiaEstudianteEjemplo5.setNombreMateria("??lgebra Vectorial y Matrices");
	  materiaEstudianteEjemplo5.setIdMateria(5);
	  materiaEstudianteEjemplo5.setUv(4);
	  materiaEstudianteEjemplo5.setPreRequisito("1");	 
	  materiaService.createMateria(materiaEstudianteEjemplo5);
	  

	  materiaEstudianteEjemplo6.setNombreMateria("C??lculo I");
	  materiaEstudianteEjemplo6.setIdMateria(6);
	  materiaEstudianteEjemplo6.setUv(4);
	  materiaEstudianteEjemplo6.setPreRequisito("1");	
	  materiaService.createMateria(materiaEstudianteEjemplo6);
	  

	  materiaEstudianteEjemplo7.setNombreMateria("Programaci??n de Estructuras Din??micas");
	  materiaEstudianteEjemplo7.setIdMateria(7);
	  materiaEstudianteEjemplo7.setUv(4);
	  materiaEstudianteEjemplo7.setPreRequisito("3,4");
	  materiaService.createMateria(materiaEstudianteEjemplo7);
	  

	  materiaEstudianteEjemplo8.setNombreMateria("Matem??tica Discreta II");
	  materiaEstudianteEjemplo8.setIdMateria(8);
	  materiaEstudianteEjemplo8.setUv(3);
	  materiaEstudianteEjemplo8.setPreRequisito("3");
	  materiaService.createMateria(materiaEstudianteEjemplo8);

	  materiaEstudianteEjemplo9.setNombreMateria("F??sica I");
	  materiaEstudianteEjemplo9.setIdMateria(9);
	  materiaEstudianteEjemplo9.setUv(5);
	  materiaEstudianteEjemplo9.setPreRequisito("5,6");
	  materiaService.createMateria(materiaEstudianteEjemplo9);

	  materiaEstudianteEjemplo10.setNombreMateria("C??lculo II");
	  materiaEstudianteEjemplo10.setIdMateria(10);
	  materiaEstudianteEjemplo10.setUv(4);
	  materiaEstudianteEjemplo10.setPreRequisito("5,6");
	  materiaService.createMateria(materiaEstudianteEjemplo10);

	  materiaEstudianteEjemplo11.setNombreMateria("Programaci??n Orientada a Objetos");
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
	  

	  materiaEstudianteEjemplo14.setNombreMateria("C??lculo III");
	  materiaEstudianteEjemplo14.setIdMateria(14);
	  materiaEstudianteEjemplo14.setUv(4);
	  materiaEstudianteEjemplo14.setPreRequisito("10");
	  materiaService.createMateria(materiaEstudianteEjemplo14);
	  

	  materiaEstudianteEjemplo15.setNombreMateria("Programaci??n WEB");
	  materiaEstudianteEjemplo15.setIdMateria(15);
	  materiaEstudianteEjemplo15.setUv(4);
	  materiaEstudianteEjemplo15.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo15);
	  

	  materiaEstudianteEjemplo16.setNombreMateria("Administraci??n de Bases de Datos");
	  materiaEstudianteEjemplo16.setIdMateria(16);
	  materiaEstudianteEjemplo16.setUv(4);
	  materiaEstudianteEjemplo16.setPreRequisito("12");
	  materiaService.createMateria(materiaEstudianteEjemplo16);
	  

	  materiaEstudianteEjemplo17.setNombreMateria("Optativa Human??stico Social I");
	  materiaEstudianteEjemplo17.setIdMateria(17);
	  materiaEstudianteEjemplo17.setUv(3);
	  materiaEstudianteEjemplo17.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo17);
	  

	  materiaEstudianteEjemplo18.setNombreMateria("An??lisis Num??rico");
	  materiaEstudianteEjemplo18.setIdMateria(18);
	  materiaEstudianteEjemplo18.setUv(4);
	  materiaEstudianteEjemplo18.setPreRequisito("14");
	  materiaService.createMateria(materiaEstudianteEjemplo18);
	  

	  materiaEstudianteEjemplo19.setNombreMateria("Redes de Computadoras");
	  materiaEstudianteEjemplo19.setIdMateria(19);
	  materiaEstudianteEjemplo19.setUv(4);
	  materiaEstudianteEjemplo19.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo19);

	  
	  materiaEstudianteEjemplo20.setNombreMateria("Programaci??n de Dispositivos M??viles");
	  materiaEstudianteEjemplo20.setIdMateria(20);
	  materiaEstudianteEjemplo20.setUv(4);
	  materiaEstudianteEjemplo20.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo20);
	  

	  materiaEstudianteEjemplo21.setNombreMateria("An??lisis de Sistemas");
	  materiaEstudianteEjemplo21.setIdMateria(21);
	  materiaEstudianteEjemplo21.setUv(3);
	  materiaEstudianteEjemplo21.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo21);
	  

	  materiaEstudianteEjemplo22.setNombreMateria("F??sica II");
	  materiaEstudianteEjemplo22.setIdMateria(22);
	  materiaEstudianteEjemplo22.setUv(5);
	  materiaEstudianteEjemplo22.setPreRequisito("9,10");
	  materiaService.createMateria(materiaEstudianteEjemplo22);
	  

	  materiaEstudianteEjemplo23.setNombreMateria("Optativa Human??stico Social II");
	  materiaEstudianteEjemplo23.setIdMateria(23);
	  materiaEstudianteEjemplo23.setUv(3);
	  materiaEstudianteEjemplo23.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo23);
	  

	  materiaEstudianteEjemplo24.setNombreMateria("An??lisis de Algoritmos");
	  materiaEstudianteEjemplo24.setIdMateria(24);
	  materiaEstudianteEjemplo24.setUv(4);
	  materiaEstudianteEjemplo24.setPreRequisito("8");
	  materiaService.createMateria(materiaEstudianteEjemplo24);
	  

	  materiaEstudianteEjemplo25.setNombreMateria("Programaci??n de Artefactos");
	  materiaEstudianteEjemplo25.setIdMateria(25);
	  materiaEstudianteEjemplo25.setUv(4);
	  materiaEstudianteEjemplo25.setPreRequisito("13,15");
	  materiaService.createMateria(materiaEstudianteEjemplo25);
	  

	  materiaEstudianteEjemplo26.setNombreMateria("Probabilidad y Estad??stica");
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
	  

	  materiaEstudianteEjemplo29.setNombreMateria("T??cnicas de Simulaci??n en Computadoras");
	  materiaEstudianteEjemplo29.setIdMateria(29);
	  materiaEstudianteEjemplo29.setUv(4);
	  materiaEstudianteEjemplo29.setPreRequisito("26");
	  materiaService.createMateria(materiaEstudianteEjemplo29);
	  

	  materiaEstudianteEjemplo30.setNombreMateria("Programaci??n N-Capas");
	  materiaEstudianteEjemplo30.setIdMateria(30);
	  materiaEstudianteEjemplo30.setUv(4);
	  materiaEstudianteEjemplo30.setPreRequisito("11");
	  materiaService.createMateria(materiaEstudianteEjemplo30);
	  

	  materiaEstudianteEjemplo31.setNombreMateria("Fundamentos de Inteligencia de Negocios");
	  materiaEstudianteEjemplo31.setIdMateria(31);
	  materiaEstudianteEjemplo31.setUv(4);
	  materiaEstudianteEjemplo31.setPreRequisito("16");
	  materiaService.createMateria(materiaEstudianteEjemplo31);
	  

	  materiaEstudianteEjemplo32.setNombreMateria("Optativa Human??stico Social III");
	  materiaEstudianteEjemplo32.setIdMateria(32);
	  materiaEstudianteEjemplo32.setUv(3);
	  materiaEstudianteEjemplo32.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo32);

	  
	  materiaEstudianteEjemplo33.setNombreMateria("Sistemas Operativos");
	  materiaEstudianteEjemplo33.setIdMateria(33);
	  materiaEstudianteEjemplo33.setUv(4);
	  materiaEstudianteEjemplo33.setPreRequisito("28");
	  materiaService.createMateria(materiaEstudianteEjemplo33);

	  materiaEstudianteEjemplo34.setNombreMateria("Programaci??n Declarativa");
	  materiaEstudianteEjemplo34.setIdMateria(34);
	  materiaEstudianteEjemplo34.setUv(4);
	  materiaEstudianteEjemplo34.setPreRequisito("15");
	  materiaService.createMateria(materiaEstudianteEjemplo34);

	  materiaEstudianteEjemplo35.setNombreMateria("Ingenier??a de Software");
	  materiaEstudianteEjemplo35.setIdMateria(35);
	  materiaEstudianteEjemplo35.setUv(4);
	  materiaEstudianteEjemplo35.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo35);

	  materiaEstudianteEjemplo36.setNombreMateria("Formulaci??n y Evaluaci??n de Proyectos");
	  materiaEstudianteEjemplo36.setIdMateria(36);
	  materiaEstudianteEjemplo36.setUv(4);
	  materiaEstudianteEjemplo36.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo36);
	  

	  materiaEstudianteEjemplo37.setNombreMateria("Optativa Human??stico Social IV");
	  materiaEstudianteEjemplo37.setIdMateria(37);
	  materiaEstudianteEjemplo37.setUv(3);
	  materiaEstudianteEjemplo37.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo37);

	  materiaEstudianteEjemplo38.setNombreMateria("Optativa T??cnica II");
	  materiaEstudianteEjemplo38.setIdMateria(38);
	  materiaEstudianteEjemplo38.setUv(4);
	  materiaEstudianteEjemplo38.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo38);

	  materiaEstudianteEjemplo39.setNombreMateria("Aplicaciones de C??digo Abierto");
	  materiaEstudianteEjemplo39.setIdMateria(39);
	  materiaEstudianteEjemplo39.setUv(4);
	  materiaEstudianteEjemplo39.setPreRequisito("21");
	  materiaService.createMateria(materiaEstudianteEjemplo39);

	  materiaEstudianteEjemplo40.setNombreMateria("Pr??ctica Profesional I");
	  materiaEstudianteEjemplo40.setIdMateria(40);
	  materiaEstudianteEjemplo40.setUv(4);
	  materiaEstudianteEjemplo40.setPreRequisito("36");
	  materiaService.createMateria(materiaEstudianteEjemplo40);

	  materiaEstudianteEjemplo41.setNombreMateria("Optativa T??cnica III");
	  materiaEstudianteEjemplo41.setIdMateria(41);
	  materiaEstudianteEjemplo41.setUv(4);
	  materiaEstudianteEjemplo41.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo41);

	  materiaEstudianteEjemplo42.setNombreMateria("Teor??as de Lenguaje de Programaci??n");
	  materiaEstudianteEjemplo42.setIdMateria(42);
	  materiaEstudianteEjemplo42.setUv(4);
	  materiaEstudianteEjemplo42.setPreRequisito("24");
	  materiaService.createMateria(materiaEstudianteEjemplo42);

	  materiaEstudianteEjemplo43.setNombreMateria("Optativa Human??stico Social V");
	  materiaEstudianteEjemplo43.setIdMateria(43);
	  materiaEstudianteEjemplo43.setUv(3);
	  materiaEstudianteEjemplo43.setPreRequisito("0");
	  materiaService.createMateria(materiaEstudianteEjemplo43);

	  materiaEstudianteEjemplo44.setNombreMateria("Pr??ctica Profesional II");
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
	  
	//Lista de tabla MiMateria
	  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
	  
	//Lista de  MiMaterias del estudiante logeado:
	  List<MiMateria> misMateriasEL= new ArrayList<MiMateria>();
	  
	  //Lista de evaluaciones de cada materia:
	  List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
	  
	  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
	  
	  misMaterias.forEach(m->{
		  if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
			  misMateriasEL.add(m);
			  
			  }
	  }); 
	  
	  if(misMateriasEL.isEmpty()) {
		  modelmap.addAttribute("errorSem", "No ha agregado materias");
	  }
	  else {
		  
	      
		  misMateriasEL.forEach(m->{
			  String[] splitNombre = m.getEvaluacion().split(",");
		      String[] splitPonderacion = m.getPonderacion().split(",");
		      String[] splitFecha = m.getFecha().split(",");
		      String[] splitNota = m.getNota().split(",");
		      
		      for (int i=0; i<splitNombre.length; i++) {
		    	  
		    	  Evaluacion newEvaluacion = new Evaluacion();
				  newEvaluacion.setEvaluacion(splitNombre[i]);
				  newEvaluacion.setPonderacion(splitPonderacion[i]);
				  newEvaluacion.setFecha(splitFecha[i]);
				  newEvaluacion.setNota(splitNota[i]);
				  newEvaluacion.setIdMateria(m.getIdMateria());
				  
				  evaluaciones.add(newEvaluacion);
		      }
		      
		  });
		  
		  
		  //devuelve la lista que se quiere mostrar
		  modelmap.addAttribute("misMateriasEL", misMateriasEL);
		  
		 
		  //Evaluaciones de cada materia (materia.getId() == evaluacion.getIdMateria())
		  modelmap.addAttribute("evaluaciones", evaluaciones);
		  
	  }
	  
	  
	  
	  
    return "semester.jsp";
  } 
 
  
  Double suma = 0.0;
  
  @GetMapping("/calculateScore")
  public String calculateScore(ModelMap modelmap) {
	  
	//Lista de tabla MiMateria
	  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
	  
	//Lista de  MiMaterias del estudiante logeado:
	  List<MiMateria> misMateriasEL= new ArrayList<MiMateria>();
	  
	  //Lista de evaluaciones de cada materia:
	  List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
	  
	  
	  //Posiciones de las evaluaciones que tienen 0.0
	  List<Integer> posiciones = new ArrayList<Integer>();
	  List<Double> multiplicados = new ArrayList<Double>();
	  List<Double> sumados = new ArrayList<Double>();
	  
	  
	  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
	  
	  misMaterias.forEach(m->{
		  if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
			  misMateriasEL.add(m);
			  
			  }
	  }); 
	  
	  if(misMateriasEL.isEmpty()) {
		  modelmap.addAttribute("errorCS", "No ha agregado materias");
	  }
	  else {
		  
	      
		  misMateriasEL.forEach(m->{
			  String[] splitNombre = m.getEvaluacion().split(",");
		      String[] splitPonderacion = m.getPonderacion().split(",");
		      String[] splitFecha = m.getFecha().split(",");
		      String[] splitNota = m.getNota().split(",");
		      
		      if(!m.getNota().equals("Sin Editar")) {
		    	  
		    	  
		    	//guardo posiciones
			      for (int i=0; i<splitNombre.length; i++) {
			    	  if(splitNota[i].equals("0.0")) {
			    		  posiciones.add(i);
			    	  }
			      }
			      
			      while(suma<6.0) {
			    	  
			    	  posiciones.forEach(i->{
			    		  
			    		  if(splitNota[i].equals("0.0")) {
			    			  splitNota[i] = Double.toString((Double.parseDouble(splitNota[i])+6.0));
			    		  }
			    		  else {
			    			  
			    			  splitNota[i] = Double.toString((Double.parseDouble(splitNota[i])+1.0));
			    		  }
			    		  
			    	  });
			    	  
			    	  for (int i=0; i<splitNombre.length; i++) {
				    	  
				    	  multiplicados.add( Double.parseDouble(splitNota[i]) * Double.parseDouble(splitPonderacion[i]) );
				    	  
				      }
				      
			    	  for(int i=0; i<multiplicados.size(); i++) {
			    		  suma += multiplicados.get(i);
			    	  }
				      
			      }
			      suma =0.0;
			      
			      
		      }
		      
		      
		      
		      for (int i=0; i<splitNombre.length; i++) {
		    	  
		    	  Evaluacion newEvaluacion = new Evaluacion();
				  newEvaluacion.setEvaluacion(splitNombre[i]);
				  newEvaluacion.setPonderacion(splitPonderacion[i]);
				  newEvaluacion.setFecha(splitFecha[i]);
				  newEvaluacion.setNota(splitNota[i]);
				  newEvaluacion.setIdMateria(m.getIdMateria());
				  
				  evaluaciones.add(newEvaluacion);
		      }
		      
		  });
		  
		  
		  //devuelve la lista que se quiere mostrar
		  modelmap.addAttribute("misMateriasELCS", misMateriasEL);
		  
		 
		  //Evaluaciones de cada materia (materia.getId() == evaluacion.getIdMateria())
		  modelmap.addAttribute("evaluacionesCS", evaluaciones); 
		  
	  }
	  
	  
	  
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
	  modelMap.put("anioEstudiante", "Estudiante de "+carreraEstudianteLogeado.getAnioCarrera()+" a??o");
	  modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
	  modelMap.put("uVEstudiante", carreraEstudianteLogeado.getUvAprobadas());
	  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
	  modelMap.put("horasInternasEstudiante", carreraEstudianteLogeado.getHorasSocialesInternas());
	  modelMap.put("horasExternasEstudiante", carreraEstudianteLogeado.getHorasSocialesExterna());
    return "mainPage.jsp";
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
	  
	  carreras.forEach( c -> {
			 if(c.getIdCarrera().toString().equals(estudianteLogeado.getCarreraEstudiante().toString())) {
				 carreraService.updateCarreraAnio(c,Integer.parseInt(year));
			 }
		  });
	  
	  
  
	  
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
  
  @PostMapping("/activitiesEdit")
  public String activitiesEdit(@RequestParam("idActivity") String idActivity, @RequestParam("nombreActividad") String nombreActividad,
		  ModelMap modelMap) {
	  
	  if(idActivity.isEmpty() && nombreActividad.isEmpty() ) {
		  modelMap.put("errorSU", "Llene al menos un espacio");
		  
		  availableSubjects(modelMap);
		    return "availableSubjects.jsp";
	  }
	  else {
		  
		  List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
		  actividadesExtraService.getActividades().forEach(a -> actividades.add(a));
		  
		  int lastIdx = actividades.size()-1;
		  ActividadesExtra lastActividad= actividades.get(lastIdx);
		  int idActividadExtra= lastActividad.getIdEstudiante()+1;
		  
		  if(nombreActividad.isEmpty()){
			  
			  actividades.forEach(a ->{
				  if(a.getIdActividadesExtra().toString().equals(idActivity)) {
					  actividadesExtraService.deleteActividadExtraById(Integer.parseInt(idActivity));
					  modelMap.addAttribute("${errorU}", "Se ha eliminado la actividad");
				  }});
				  
		  }
		  else {

			  ActividadesExtra newActividadExtra = new ActividadesExtra();
			  newActividadExtra.setIdActividadesExtra(idActividadExtra);
			  newActividadExtra.setNombreActividadesExtra(nombreActividad);
			  newActividadExtra.setIdEstudiante(estudianteLogeado.getIdEstudiante());
			  actividadesExtraService.createActividadExtra(newActividadExtra);
			  
			  modelMap.addAttribute("${errorU}", "Se ha agregado la actividad");
		  }
			  
		  activities(modelMap);
		   return "activities.jsp";
		  
	  }
	  
	
	  
	  
	  
	
  }
  
  
  
  @PostMapping("/subjectsUpdateSuccess")
  public String subjectsUpdateSuccess(@RequestParam("subject") String subject,@RequestParam("professor") String professor,
		  ModelMap modelMap){
	  
	
	  
  
	  if(subject.isEmpty() || professor.isEmpty() ) {
		  modelMap.put("errorSU", "No deje espacios en blanco");
		  
		  availableSubjects(modelMap);
		    return "availableSubjects.jsp";
	  }
	  else {
		  
		//PARA MOSTRAR LAS POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO!!!!!!!!!!!!!!
		  List<String> materias0 = new ArrayList<String>();
		  
		  String materiasPosiblesEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
	      String[] split = materiasPosiblesEstudianteLogeado.split(",");
	      
	      for (int i=0; i<split.length; i++) {
	    		  materias0.add(split[i]);
	      } 
	      
	      if(!materias0.contains(subject)) {
	    	  modelMap.put("errorSem3", "No puede inscribir una materia que no tiene habilitada");
	    	  
	    	  availableSubjects(modelMap);
	    	  return "availableSubjects.jsp";
	      }
	      else {
	    	  
	    	//Lista de tabla MiMateria
			  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
			  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
			  
			  misMaterias.forEach(m ->{
				  //En el caso que la encuentre, le modificara el profesor:
				  if(m.getIdMateria().toString().equals(subject) && m.getCatedratico().equals(professor)) {
					  
					  MiMateria oldMiMateria = m, newMiMateria = m;
					  newMiMateria.setCatedratico(professor);
					  
					  miMateriaService.updateMateria(oldMiMateria, newMiMateria);
					  
					  miMateriaEncontrada = true;
				  }
			  });
			  //Si no la encuentra, creara la materia
			  if(!miMateriaEncontrada) {
				  
				  MiMateria newMiMateria = new MiMateria();
				  
				  int lastIdx3 = misMaterias.size()-1;
				  MiMateria lastMiMateria= misMaterias.get(lastIdx3);
				  int idMiMateria= lastMiMateria.getIdMiMateria()+1;
				  
				  newMiMateria.setIdMiMateria(idMiMateria);
				  newMiMateria.setCatedratico(professor);
				  newMiMateria.setIdEstudiante(estudianteLogeado.getIdEstudiante());
				  newMiMateria.setEvaluacion("Sin Editar");
				  newMiMateria.setFecha("Sin Editar");
				  newMiMateria.setNota("Sin Editar");
				  newMiMateria.setPonderacion("Sin Editar");
				  
				  
				  List<Materia> materias= new ArrayList<Materia>();
				  materiaService.getMaterias().forEach(m -> materias.add(m));
				  
				  materias.forEach(m -> {
					  if(m.getIdMateria().toString().equals(subject)) {
						  newMiMateria.setIdMateria(m.getIdMateria());
						  newMiMateria.setNombreMateria(materiaService.getMateriaById(m.getIdMateria()).getNombreMateria());
					  }
				  });
				  
				  
				  
				  miMateriaService.createMiMateria(newMiMateria);
			  }
		  }
	     
	      materias0.remove(subject);
    	  
    	  nuevasMateriasPosibles = String.join(",", materias0);
          
    	  
    	  Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
    	  newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
    	  
    	  carreraService.updateCarreraG(newCarrera, carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()) );
    	  
    	  modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());
    	  
    	  return "subjectsUpdateSuccess.jsp";
    	  
	      }
	      
	      
  } 
  
  int cantMateriasAprobadas = 0,cantMateriasPosibles=0;
  List<String> prerrequisitos;
  
  @GetMapping("/closeSemesterSuccess")
  public String closeSemesterSuccess(ModelMap modelMap) {
	  
	//Lista de tabla MiMateria
	  List<MiMateria> miMateria= new ArrayList<MiMateria>();
	  
	  //Lista de  MiMaterias del estudiante logeado:
	  List<MiMateria> misMateriasEL= new ArrayList<MiMateria>();
	  
	  //Lista que contiene los id de las materias que aprobo
	  List<String> idsMateriasAprobadas = new ArrayList<>();
	  
	  
	  miMateriaService.getMisMaterias().forEach(m -> miMateria.add(m));
	  
	  miMateria.forEach(m->{
		  if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
			  misMateriasEL.add(m);
			  }
	  });
	  
	  misMateriasEL.forEach(m ->{
		  idsMateriasAprobadas.add(m.getIdMateria().toString());
		  cantMateriasAprobadas++;
	  });
	  
	  Carrera carreraEstudianteLogeado = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
	  
	  Carrera newCarrera = new Carrera();
	  newCarrera = carreraEstudianteLogeado;
	  //Actualizando materias aprobadas y cantidad de materias aprobadas:
	  newCarrera.setMateriasAprobadas(newCarrera.getMateriasAprobadas()+String.join(",", idsMateriasAprobadas));
	  newCarrera.setCantidadMateriasAprobadas(carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasAprobadas()+cantMateriasAprobadas);
	  carreraService.updateCarreraG(carreraEstudianteLogeado, newCarrera);
	  
	  
	  
	//Lista de tabla Materia
	  List<Materia> materias= new ArrayList<Materia>();
	  List<String> materiasPosibles = new ArrayList<String>();
	  
	  List<String> matPosiblesOld = 
	  Arrays.asList(carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles().split(","));
	  
	  
	  List<String> matPosiblesFinal = new LinkedList<>(matPosiblesOld);
	  
	  
	  
	  materiaService.getMaterias().forEach(m->{
		  materias.add(m);
	  });
	  
	  //obteniendo las materias posibles a partis de los ids aprobados
	  //y buscando las materias que tengan esos prerrequisitos
	  materias.forEach(m->{
		  prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));
		  
		  prerrequisitos.forEach(p ->{
			  if(idsMateriasAprobadas.contains(p)) {
				  if(!materiasPosibles.contains(m)) {
					  
					  materiasPosibles.add(m.getIdMateria().toString());
					  cantMateriasPosibles++;
					  
				  }
			 } 
		  });
		  
	  });
	  
	  //Sumando las que ya estan posibles y restandole las aprobadas
	  cantMateriasPosibles += carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getCantidadMateriasPosibles();
	  cantMateriasPosibles -= cantMateriasAprobadas;
	  
	  //quitando las materias posibles que ya se aprobaron en bdd 
	  //y luego agregandole las nuevas posibles
	  
	  //Quitamos de matPosiblesFinal las que ya se pasaron
	  idsMateriasAprobadas.forEach(m->{
		  if(matPosiblesFinal.contains(m)) {
			  matPosiblesFinal.remove(m);
		  }
	  });
	  
	  //Agregamos las materias posibles nuevas a matPosibles final:
	  materiasPosibles.forEach(m->{
		 if(!matPosiblesFinal.contains(m)) {
			 matPosiblesFinal.add(m);
		 } 
	  });
	  
	  //convertimos matPosiblesFinal a string para actualizarlo
	  
	  newCarrera = carreraEstudianteLogeado;
	  //error
	  newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
	  newCarrera.setMateriasPosibles(String.join(",", matPosiblesFinal));
	  carreraService.updateCarreraG(carreraEstudianteLogeado, newCarrera);
	  
	  cantMateriasAprobadas = 0;
	  cantMateriasPosibles=0;
	  prerrequisitos= new ArrayList<>();
	  
	  //Eliminanto materias del ciclo del estudiante
	  miMateria.forEach(m->{
		 if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())) {
			 miMateriaService.deleteMiMateriaById(m.getIdMiMateria());
		 } 
	  });
	  
	  
	modelMap.put("nombreEstudianteCSS", estudianteEjemplo.getNombreEstudiante());
    return "closeSemesterSuccess.jsp"; 
  }  
  
  
  
  boolean miMateriaActualizada = false;
  
  @PostMapping("/subjectsUpdateSuccess2")
  public String subjectsUpdateSuccess2(@RequestParam("subject") String subject,@RequestParam("nameEvaluation") String nameEvaluation,
		  @RequestParam("percentageEvaluation") String percentageEvaluation, @RequestParam("dateEvaluation") String dateEvaluation, 
		  @RequestParam("scoreEvaluation") String scoreEvaluation,
		  ModelMap modelMap){
  
	  
	  
	  if(percentageEvaluation.isEmpty() && dateEvaluation.isEmpty() && !nameEvaluation.isEmpty() && !scoreEvaluation.isEmpty()) {
		  
		  
		  //Lista de tabla MiMateria
		  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
		  
		  //Lista de  MiMaterias del estudiante logeado:
		  List<MiMateria> misMateriasEL= new ArrayList<MiMateria>();
		  
		  //Lista de evaluaciones de cada materia:
		  List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
		  
		  
		  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
		  
		  misMaterias.forEach(m->{
			  if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
				  misMateriasEL.add(m);
				  
				  }
		  }); 
		  
		  if(misMateriasEL.isEmpty()) {
			  modelMap.addAttribute("errorSem", "No ha agregado materias");
		  }
		  else {
			  
			  //ACTUALIZARA LA NOTA MIMATERIA (UN SOLO STRING):
			  
		      //Busca la materia que contenga el nombre de la evaluacion
			  //y en ese indice modifica la nota en el arreglo
			  //luego lo hace string para actualizar toda la materia
			  
			  
			  
			  misMateriasEL.forEach(m->{
				  String[] splitNombre = m.getEvaluacion().split(",");
			      String[] splitPonderacion = m.getPonderacion().split(",");
			      String[] splitFecha = m.getFecha().split(",");
			      String[] splitNota = m.getNota().split(",");
			      
			      
			      for (int i=0; i<splitNombre.length; i++) {
			    	  
			    	  if(splitNombre[i].equals(nameEvaluation) && m.getIdMateria().toString().equals(subject)){
			    		  splitNota[i] = scoreEvaluation;
			    		  miMateriaActualizada= true;
			    	  }
			    	  else {
			    		  modelMap.put("errorSU2", "Evaluacion incorrecta");
			    		  
			    	  }
			      }
			      
			      m.setEvaluacion(String.join(",", splitNombre));
			      m.setPonderacion(String.join(",", splitPonderacion));
			      m.setFecha(String.join(",", splitFecha));
			      m.setNota(String.join(",", splitNota));
			      
			      miMateriaService.updateMateria(miMateriaService.getMiMateriaById(m.getIdMiMateria()), m);
			      
			  });
			  
			  
		  }
		  
		  if(miMateriaActualizada){
			  modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());
			  miMateriaActualizada = false;
			  return "subjectsUpdateSuccess.jsp"; 
		  }
		  else{
			  subjectsUpdate(modelMap);
			  return "subjectsUpdate.jsp"; 
		  }
		  
	  }
	  else if(subject.isEmpty() || nameEvaluation.isEmpty() || percentageEvaluation.isEmpty() || dateEvaluation.isEmpty()) {
		  modelMap.put("errorSU2", "No deje espacios en blanco");
		  subjectsUpdate(modelMap);
		    return "subjectsUpdate.jsp";
	  }
	  else {
		  
			  
			//Lista de tabla MiMateria
			  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
			  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
			  
			  misMaterias.forEach(m ->{
				  //En el caso que encuentre la materia, le modificara la evaluacion, fecha realizacion, nota, ponderacion:
				  if(m.getIdMateria().toString().equals(subject) && m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())) {
					  
					  MiMateria oldMiMateria = m, newMiMateria = m;
					  
					  if(m.getEvaluacion().equals("Sin Editar")) {
						  
						  newMiMateria.setEvaluacion(nameEvaluation);
						  newMiMateria.setNota("0.0");
						  newMiMateria.setFecha(dateEvaluation);
						  newMiMateria.setPonderacion(percentageEvaluation);
						  
						  miMateriaService.updateMateria(oldMiMateria, newMiMateria);
						  
						  miMateriaEncontrada = true;
					  }
					  else {
						  
						  newMiMateria.setEvaluacion(m.getEvaluacion()+","+nameEvaluation);
						  newMiMateria.setNota(m.getNota()+",0.0");
						  newMiMateria.setFecha(m.getFecha()+","+dateEvaluation);
						  newMiMateria.setPonderacion(m.getPonderacion()+","+percentageEvaluation);
						  
						  miMateriaService.updateMateria(oldMiMateria, newMiMateria);
						  miMateriaEncontrada = true;
					  }
					  
				  }
			  });
			  //Si no la encuentra la materia
			  if(!miMateriaEncontrada) {
				  modelMap.put("errorSU2", "No tienes registrada esa materia en el ciclo");
				  subjectsUpdate(modelMap);
				  return "subjectsUpdate.jsp";
			  }
			  else {
				  modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());
				  return "subjectsUpdateSuccess.jsp";
			  }
		  }
	  
  } 
  
  @GetMapping("/activitiesUpdate")
  public String activitiesUpdate() {
    return "activitiesUpdate.jsp";
  }
  
  @GetMapping("/subjectsUpdate")
  public String subjectsUpdate(ModelMap modelmap) {
	  
	//Lista de tabla MiMateria
	  List<MiMateria> misMaterias= new ArrayList<MiMateria>();
	  
	//Lista de  Materias del estudiante logeado:
	  List<MiMateria> misMateriasEL= new ArrayList<MiMateria>();
	  
	  miMateriaService.getMisMaterias().forEach(m -> misMaterias.add(m));
	  
	  misMaterias.forEach(m->{
		  if(m.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())){
			  misMateriasEL.add(m);
			  }
	  }); 
	  
	  if(misMateriasEL.isEmpty()) {
		  modelmap.addAttribute("errorSem2", "No ha agregado materias");
	  }
	  else {
//			
		  modelmap.addAttribute("misMateriasEL2", misMateriasEL);
	  }
	  
    return "subjectsUpdate.jsp";
  } 
  
  
  @PostMapping("/socialUpdate")
  public String socialUpdate(@RequestParam("internal") String internal, ModelMap modelMap){
  
	  
	  //Lista tabla Carrera
	  List<Carrera> carreras = new ArrayList<Carrera>();
	  carreraService.getCarreras().forEach(c -> carreras.add(c));
	  
	  carreras.forEach(c -> {
		  if(c.getIdCarrera().toString().equals(estudianteLogeado.getIdEstudiante().toString())){
		  carreraService.updateCarreraHI(c, Integer.parseInt(internal));
	  }});
	  
	  
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
	  
	  carreras.forEach(c -> {
		  if(c.getIdCarrera().toString().equals(estudianteLogeado.getIdEstudiante().toString())){
		  carreraService.updateCarreraHE(c, Integer.parseInt(external));
	  }});
	  
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
					  modelMap.put("anioEstudiante", "Estudiante de "+carreraEstudianteLogeado.getAnioCarrera()+" Anio");
					  modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
					  modelMap.put("uVEstudiante", carreraEstudianteLogeado.getUvAprobadas());
					  modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
					  modelMap.put("horasInternasEstudiante", carreraEstudianteLogeado.getHorasSocialesInternas());
					  modelMap.put("horasExternasEstudiante", carreraEstudianteLogeado.getHorasSocialesExterna());
					  
					  return "mainPage.jsp";
				  
		  }
		  
		  else {
			  modelMap.put("errorL","Datos incorrectos");
			  return "login.jsp";
		  }
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
		  newCarrera.setHorasSocialesInternas(0);
		  newCarrera.setHorasSocialesExterna(0);
		  newCarrera.setAnioCarrera(1);
		  carreraService.createCarrera(newCarrera);
		  
		 
		  modelMap.put("nombreEstudianteRegistrado", nombreRe);
		  return "regUpdateSuccess.jsp";
	  }
	
  }
   
  
}

    
	  
   
    
  
  

