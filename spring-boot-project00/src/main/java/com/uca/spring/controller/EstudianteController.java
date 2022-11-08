package com.uca.spring.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uca.spring.model.Estudiante;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.util.Util;

@Controller
public class EstudianteController {
	

  @GetMapping("/")
  public String getForm() {
    return "login.jsp";
  }
  
  @GetMapping("/login")
  public String login() {
    return "login.jsp";
  } 
  
  @GetMapping("/mainPage")
  public String mainPage(ModelMap modelMap) {
	  
	//menu atributos sobre la carrera del estudiante:
	  modelMap.put("nombreEstudiante", "Omar Rafael Flores");
	  modelMap.put("anioEstudiante", "Cuarto Anio");
	  modelMap.put("numeroMateriasAprobadasEstudiante", "26");
	  modelMap.put("cumEstudiante", "8.8");
	  modelMap.put("uVEstudiante", "102");
	  modelMap.put("avanceCarreraEstudiante", "59");
	  modelMap.put("materiasDisponiblesEstudiante", "10");
	  modelMap.put("horasInternasEstudiante", "105");
	  modelMap.put("horasExternasEstudiante", "0");
    return "mainPage.jsp";
  } 
  
  @GetMapping("/semester")
  public String semester() {
    return "semester.jsp";
  } 
  
  @GetMapping("/calculateScore")
  public String calculateScore() {
    return "calculateScore.jsp";
  } 
  
  @GetMapping("/activities")
  public String activities(ModelMap modelMap) {
	  modelMap.put("nombreActividad1", "Reunirse con el grupo de Simu");
	  modelMap.put("nombreActividad2", "Entregar proyecto Arqui");
	  modelMap.put("nombreActividad3", "Meet BI");
	  modelMap.put("nombreActividad4", "Ver videos en youtube sobre CSR");
    return "activities.jsp";
  } 
  
  @GetMapping("/activitiesUpdate")
  public String activitiesUpdate() {
    return "activitiesUpdate.jsp";
  }
  
  @GetMapping("/subjectsUpdate")
  public String subjectsUpdate() {
    return "subjectsUpdate.jsp";
  } 
  
  @GetMapping("/dataUpdate")
  public String dataUpdate() {
    return "dataUpdate.jsp";
  } 
  
  @GetMapping("/socialUpdate")
  public String socialUpdate() {
    return "socialUpdate.jsp";
  } 
  
  @GetMapping("/userUpdate")
  public String userUpdate() {
    return "userUpdate.jsp";
  } 
  
  @GetMapping("/availableSubjects")
  public String availableSubjects(ModelMap modelMap) {
	  
	  //Consultando la bdd para llenar materias posibles:
	  modelMap.put("NombreMateria1", "Física I");
	  modelMap.put("UV1", "4");
	  modelMap.put("Prerrequisito1", "5,6");
	  
	  modelMap.put("NombreMateria2", "Programación de Estructuras Dinámicas");
	  modelMap.put("UV2", "4");
	  modelMap.put("Prerrequisito2", "3,4");
	  
	  modelMap.put("NombreMateria3", "Matemática Discreta");
	  modelMap.put("UV3", "3");
	  modelMap.put("Prerrequisito3", "1");
	  
	  modelMap.put("NombreMateria4", "Cálculo I");
	  modelMap.put("UV4", "4");
	  modelMap.put("Prerrequisito4", "1");
	  
	  
    return "availableSubjects.jsp";
  } 
  
  @PostMapping("/userUpdateSuccess")
  public String userUpdateSuccess(@RequestParam("name") String name, 
		  @RequestParam("year") String year,
		  @RequestParam("carnet") String carnet,ModelMap modelMap){
  
	  if(name.isBlank() || year.isBlank() || carnet.isBlank() ) {
		  modelMap.put("errorUU", "No deje espacios en blanco");
		    return "userUpdate.jsp";
	  }
	  //Si el usuario que modificara no esta en la bdd
	  else if(!carnet.equals("00038619")) {
		  modelMap.put("errorUU", "Carnet incorrecto");
		    return "userUpdate.jsp";
	  }
	  else {
		  modelMap.put("nombreEstudianteUUS", "Omar Flores Alas");
		    return "userUpdateSuccess.jsp";
	  }
	  
    
  } 
  
  @PostMapping("/activitiesUpSuccess")
  public String activitiesUpSuccess(@RequestParam("nameActivity") String nameActivity, ModelMap modelMap){
  
	  if(nameActivity.isBlank()) {
		  modelMap.put("errorU", "No deje espacios en blanco");
		    return "activitiesUpdate.jsp";
	  }
	  else {
		  modelMap.put("nombreEstudianteAUS", "Omar Flores Alas");
		    return "activitiesUpSuccess.jsp";
	  }
	  
    
  } 
  
  @PostMapping("/subjectsUpdateSuccess")
  public String subjectsUpdateSuccess(@RequestParam("subject") String subject,@RequestParam("professor") String professor,
		  ModelMap modelMap){
  
	  if(subject.isBlank() || professor.isBlank() ) {
		  modelMap.put("errorSU", "No deje espacios en blanco");
		    return "subjectsUpdate.jsp";
	  }
	  //En el caso que en la bdd no este la materia en la tabla "MiMateria"
	  else if(!subject.equals("Calculo lll") && !professor.equals("Ing")){
		  modelMap.put("errorSU", "Materia no encontrada");
		    return "subjectsUpdate.jsp";
	  }
	//En el caso 1ue en la bdd si este la materia en la tabla "MiMateria" y se 
	//haya modificado exitosamente
	  else{
		  modelMap.put("nombreEstudianteUS", "Omar Flores Alas");
		    return "subjectsUpdateSuccess.jsp";
	  }
    
  } 
  
  @PostMapping("/socialUpdate")
  public String socialUpdate(@RequestParam("internal") String internal, ModelMap modelMap){
  
	  if(internal.isBlank()) {
		  modelMap.put("errorSoU", "No deje espacios en blanco");
		    return "socialUpdate.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteSUS", "Omar Flores Alas");
		    return "socialUpdateSuccess.jsp";
	  }
    
  } 
  
  @PostMapping("/socialUpdate2")
  public String socialUpdate2(@RequestParam("external") String external, ModelMap modelMap){
  
	  if(external.isBlank()) {
		  modelMap.put("errorSoU2", "No deje espacios en blanco");
		    return "socialUpdate.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteSUS", "Omar Flores Alas");
		    return "socialUpdateSuccess.jsp";
	  }
    
  } 
  
  @PostMapping("/addSubject")
  public String addSubject(@RequestParam("materia") String materia, ModelMap modelMap){
  
	  if(materia.isBlank()) {
		  modelMap.put("errorASS", "No deje espacios en blanco");
		    return "availableSubjects.jsp";
	  }
	  else{
		  modelMap.put("nombreEstudianteASS", "Omar Flores Alas");
		    return "addSemesterSuccess.jsp";
	  }
    
  }
  
  @PostMapping("/subjectsUpdateSuccess2")
  public String subjectsUpdateSuccess2(@RequestParam("assessment") String assessment,@RequestParam("percentage") String percentage,
		  @RequestParam("date") String date, ModelMap modelMap){
  
	  if(assessment.isBlank() || percentage.isBlank() || date.isBlank()) {
		  modelMap.put("errorSU2", "No deje espacios en blanco");
		    return "subjectsUpdate.jsp";
	  }
	//En el caso que la en tabla "MiMateria" ya se haya agregado 
	//La nueva materia
	  else{
		  modelMap.put("nombreEstudianteUS", "Omar Flores Alas");
		    return "subjectsUpdateSuccess.jsp";
	  }
    
  } 
  
  @GetMapping("/closeSemester")
  public String closeSemester(ModelMap modelMap) {
	modelMap.put("nombreEstudianteCS", "Omar Flores Alas");
    return "closeSemester.jsp"; 
  } 
  
  @GetMapping("/closeSemesterSuccess")
  public String closeSemesterSuccess(ModelMap modelMap) {
	  
	modelMap.put("nombreEstudianteCSS","Omar Flores Alas");
    return "closeSemesterSuccess.jsp"; 
  }  
  
  
  
  
  
  
  
  @PostMapping("/loginn")   
  public String login(@RequestParam("CARNET") String CARNET,
		  @RequestParam("PASSWORD") String PASSWORD, 
		  ModelMap modelMap){ 
	  
	  if(CARNET.contentEquals("root") && PASSWORD.contentEquals("Snowman8")){
		  //menu atributos sobre la carrera del estudiante consultados de la bdd:
		  modelMap.put("nombreEstudiante", "Omar Rafael Flores");
		  modelMap.put("anioEstudiante", "Cuarto Anio");
		  modelMap.put("numeroMateriasAprobadasEstudiante", "26");
		  modelMap.put("cumEstudiante", "8.8");
		  modelMap.put("uVEstudiante", "102");
		  modelMap.put("avanceCarreraEstudiante", "59");
		  modelMap.put("materiasDisponiblesEstudiante", "10");
		  modelMap.put("horasInternasEstudiante", "105");
		  modelMap.put("horasExternasEstudiante", "0");
		  
		  return "mainPage.jsp";
	  }
	  else if(CARNET.isBlank() || PASSWORD.isBlank()) {
		  modelMap.put("errorL","No deje espacios en blanco");
		  return "login.jsp";
	  }
	  else {
		  modelMap.put("errorL","Carnet o Contrasena incorrecto");
		  return "login.jsp";
	  }
	
  } 
  
  
  //Metodo para colocar los datos del "Mi Proceso" cuando se diriga desde el header:
  @PostMapping("/miProceso")   
  public String miProceso(ModelMap modelMap){
	  
		  //menu atributos sobre la carrera del estudiante:
		  modelMap.put("nombreEstudiante", "Omar Rafael Flores");
		  modelMap.put("anioEstudiante", "Cuarto Anio");
		  modelMap.put("numeroMateriasAprobadasEstudiante", "26");
		  modelMap.put("cumEstudiante", "8.8");
		  modelMap.put("uVEstudiante", "102");
		  modelMap.put("avanceCarreraEstudiante", "59");
		  modelMap.put("materiasDisponiblesEstudiante", "10");
		  modelMap.put("horasInternasEstudiante", "105");
		  modelMap.put("horasExternasEstudiante", "0");
		  
		  return "mainPage.jsp"; 
	  
  } 
  
  
  
  @PostMapping("/actualizarContrasena")
  public String actualizarContrasena(@RequestParam("nombrePR") String nombrePR,
		  @RequestParam("carnetPR") String carnetPR, 
		  @RequestParam("passwordPR") String passwordPR,
		  ModelMap modelMap){
	  
	  //Si los datos escritos estan en la bdd
	  if(nombrePR.contentEquals("Omar Rafael Flores")&&carnetPR.contentEquals("00038619")){
		  //Se actualizo la contrasena
		  
		  modelMap.put("nombreEstudiantePUS", "Omar Rafael Flores");
		  return "passUpdateSucess.jsp";
	  } 
	  else if(nombrePR.isBlank() || carnetPR.isBlank() || passwordPR.isBlank()) {
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
		  modelMap.put("nombreEstudianteRegistrado", nombreRe);
		  return "regUpdateSuccess.jsp";
	  }
	
  }
  
  @GetMapping("/recoveryPasword")
  public String recoveryPasword() {
    return "passwordRecover.jsp"; 
  } 
  
  @GetMapping("/register")
  public String register() {
    return "register.jsp";      
  }  
   
  
}

    
	  
   
    
  
  

