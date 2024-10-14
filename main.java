package ejercicio4;

import java.util.Scanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class main {
	
	    public static void main(String[] args) {
	    	
	        Scanner scanner = new Scanner(System.in);
	        
	        /**
	         * Creación del arrayList que contendrá los alumnos
	         * 
	         * @author Juanjo
	         * @param alumnos nombre del arrayList en el que se añadirán los alumnos

	         */
	        
	        ArrayList<Alumno> alumnos = new ArrayList<>();	        
	        
	        /**
	         * Formato con el que se creará el dato de fecha de nacimiento
	         * 
	         * @author Juanjo
	         * @param dateFormatter formato de la fecha de nacimiento

	         */
	
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	      
	        System.out.println("¿En qué fichero desea guardar los alumnos? Introduzca la ruta correspondiente: ");
	        
	        /**
	         * Creación de variable para indicar el fichero en el que se trabajará
	         * 
	         * @author Juanjo
	         * @param fichero1 el fichero que se va a usar

	         */
	        
	        File fichero1 = new File(scanner.nextLine());
	       
	        boolean seguirBucle = true;
	        
	        int numAlumnos = 0;

			        while (seguirBucle) {
			        	
			        	//condicinal que determina si se ha introducido el número total de alumnos
			        	
			            if (numAlumnos < 5) {
			            	
			                boolean numeroCorrecto = false;
			                
			                String input = "";
			                
			                int nia = 0;
			
			                System.out.println("Introduce el NIA del alumno: ");
			                
			                
			                /**
			                 * Validación de si el NIA introducido es correcto.
			                 *
			                 * @author Juanjo
			                 * @param nia Variable que contendrá el valor del NIA una vez validado.
			                 * @param numeroCorrecto Variable que controla si el NIA es correcto y se puede pasar a introducir el siguiente dato.
		        	         * 
		        	         */		                    
			
			                while (!numeroCorrecto) {
			                	
			                	// Leer la entrada del usuario
			                	
			                    input = scanner.nextLine();      
			                    
			                    // Comprobar si es un número válido
			
			                    if (input.matches("\\d+")) {
			                    	
			                        nia = Integer.parseInt(input);
			                        		                        
			                        numeroCorrecto = true;
			                        			                     
			                    } else {
			                    	
			                        System.out.println("Error: El NIA debe ser un número válido. Inténtalo de nuevo.");
			                    }
			                 
			                }
			                
			                //Devuelve el nombre del alumno
			
			                System.out.println("Introduce el nombre del alumno: ");
			                
			                String nombre = scanner.nextLine();
			                
			                //Devuelve los apellidos
			                
			                System.out.println("Introduce los apellidos del alumno: ");
			                
			                String apellidos = scanner.nextLine();	      
			                
			                /**
			                 * Validación de si el género del alumno está bien introducido
			                 *
			                 * @author Juanjo
			                 * @param generoCompleto Variable que contendrá el valor del género y servirá para comprobar si es válido y pasar al siguiente dato
			                 * @param generoCaracter Variable que controla la letra que representará el dato "género" del alumno
		        	         * 

		        	         */		
			
			                System.out.println("Introduce el género del alumno (Masculino/Femenino/Otro): ");
			                
			                String generoCompleto = scanner.nextLine();
			
			                while (!generoCompleto.equals("Masculino") && !generoCompleto.equals("Femenino") && !generoCompleto.equals("Otro")) {
			                	
			                    System.out.println("Introduzca solo una de las opciones válidas (Masculino/Femenino/Otro)");
			                    
			                    generoCompleto = scanner.nextLine();
			                }
			
			                char generoCaracter = generoCompleto.charAt(0); 
			                
			                /**
			                 * Validación de si la fecha de nacimiento del alumno está bien introducido
			                 *
			                 * @author Juanjo
			                 * @param fechaNac Variable que contendrá la fecha de nacimiento que se validará para comprobar que el formato es correcto
			                 * @param fechaValida Variable determinará si se puede continuar para introducir el siguiente dato
		        	         * 

		        	         */	
			                		
			                LocalDate fechaNac = null;
			                
			                boolean fechaValida = false;                
			
			                while (!fechaValida) {
			                	
			                    System.out.println("Introduce la fecha de nacimiento del alumno (dd/MM/yyyy) por ejemplo 04/05/2004: ");
			                    
			                    String fechaNacInput = scanner.nextLine();
			
			                    try {
			                    	
			                        fechaNac = LocalDate.parse(fechaNacInput, dateFormatter);
			                        
			                        fechaValida = true;
			                        	                        
			                    } catch (DateTimeParseException e) {
			                    	
			                        System.out.println("Fecha no válida. Por favor, introduce una fecha con el formato indicado");
			                        
			                    }
			                }
			
			                //Devuelve el ciclo del alumno
			                
			                System.out.println("Introduce el ciclo del alumno: ");
			                
			                String ciclo = scanner.nextLine();	            
			                
			                //Devuelve el curso del alumno
			
			                System.out.println("Introduce el curso del alumno: ");
			                
			                String curso = scanner.nextLine();   
			                
			                //Devuelve el grupo del alumno
			                
			                System.out.println("Introduce el grupo del alumno: ");			                		                
			                
			                String grupo = scanner.nextLine();
			                
			                //Creo el objeto alumno
			                			               			
			                Alumno alumno = new Alumno(nia, nombre, apellidos, generoCaracter, fechaNac, ciclo, curso, grupo);
			                
			                //Añado el alumno al arrayList
			                
			                alumnos.add(alumno);
			                
			                numAlumnos++;
			                
			                System.out.println("");
			                
			            } else {
			            	
			                System.out.println("Ya se han introducido 5 alumnos");
			                
			                seguirBucle = false;
			                
			            }
			 
			        }
			        
			        // Intenta abrir un flujo de salida para escribir en el archivo especificado
			        
			        try (FileOutputStream fos = new FileOutputStream(fichero1);
			        		
			        	     OutputStreamWriter osw = new OutputStreamWriter(fos);
			        		
			        	     BufferedWriter bw = new BufferedWriter(osw)) {
			        	
			        	 // Recorre la lista de alumnos y escribe sus datos en el archivo
			        	    
			        	    for (int i = 0; i < alumnos.size(); i++) {
			        	    	
			        	    	// Obtiene el objeto Alumno de la lista usando el índice actual del bucle
			        	    	
			        	        Alumno alumno = alumnos.get(i);
			        	        
			        	        // Escribe el nia del alumno en el archivo
			        	        
			        	        bw.write("\nNia del alumno nº " + (i + 1) + " : " + alumno.getNia());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe el nombre del alumno en el archivo
			        	        
			        	        bw.write("Nombre del alumno nº " + (i + 1) + " : " + alumno.getNombre());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe los apellidos del alumno en el archivo
			        	        
			        	        bw.write("Apellidos del alumno nº " + (i + 1) + " : " + alumno.getApellidos());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe el género del alumno en el archivo
			        	        
			        	        bw.write("Género del alumno nº " + (i + 1) + " : " + alumno.getGenero());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe la fecha de nacimiento del alumno en el archivo
			        	        
			        	        bw.write("Fecha de nacimiento del alumno nº " + (i + 1) + " : " + alumno.getFechaNac());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe el ciclo del alumno en el archivo
			        	        
			        	        bw.write("Ciclo del alumno nº " + (i + 1) + " : " + alumno.getCiclo());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe el curso del alumno en el archivo
			        	        
			        	        bw.write("Curso del alumno nº " + (i + 1) + " : " + alumno.getCurso());
			        	        
			        	        bw.newLine();
			        	        
			        	        // Escribe el grupo del alumno en el archivo
			        	        			        	        
			        	        bw.write("Grupo del alumno nº " + (i + 1) + " : " + alumno.getGrupo());
			        	        
			        	        bw.newLine();
			        	    }
			        	    
			        	} catch (IOException e) {
			        		
			        	    System.out.println("Error al escribir en el archivo: " + e.getMessage());
			        	    
			        	    e.printStackTrace();
			        	    
			        	}

	        } 
	    }

