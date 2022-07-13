import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class MainApp {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//arraylist con las nostas de 1 alunno
		//hacemos la media de notas de array list
		//anadiremos esta nosta generada a la hash table con el usuario unico del alumno		
		
		ArrayList<Double> notas=new ArrayList<>(); 
		Hashtable<String, Double> mediaAlumnos= new Hashtable<>();
		Boolean fin = false, fin2;
		String nAlumno;
		Double media;
		int con;
		
		//hacemos un bucle para poder introducir tantos alumnos como queramos
		while(!fin) {
			fin2=false;
			System.out.print("Introduce el usuario unico del alumno a anadir: ");
			nAlumno=sc.next();
			notas=notasAlumno();
			media=media(notas);
			mediaAlumnos=mediaAlumnos(nAlumno, media, mediaAlumnos);			
			
			System.out.println("Quieres entrar un alumno nuevo: ");
			System.out.println("0: NO");
			System.out.println("1: SI");
			con=sc.nextInt();
			
			//preguntamos si queremos introducir otro alumno
			while(!fin2)
				switch (con) {
					case 0:
						fin=true;
						fin2=true;
						break;
					case 1:
						fin=false;
						fin2=true;
						break;

					default:
						System.out.println("ERROR en la entrada, vuelve a intentar-lo: ");
						con=sc.nextInt();
						break;
			}
		}
		mostrarMediaAlumnos(mediaAlumnos);
		sc.close();
	}
	
	//funcion para introducir las notas que queramos en una ArrayList.
	public static ArrayList<Double> notasAlumno(){
		
		boolean fin= false;
		ArrayList<Double> notas=new ArrayList<>();  
		Double nota;
		
		System.out.println("Vamos a anadir las notas. Quando quieras para de entrar notas ponemos un numero mayor a 10.");
		
		while(!fin) {
			System.out.print("Nota: ");
			nota=sc.nextDouble();
			//si la nota es mayor que 10 o menor a 0, dejaremos de introducir notas al ArrayList
			if(nota>10 || nota<0) {
				fin=true;
			}else {
				notas.add(nota);
			}			
		}
	
		return notas;
	}
	
	//funcion para calcular la media de las notas de un alumno, introducidas en un ArrayList
	public static Double media(ArrayList<Double> nAlumno) {
		
		Iterator<Double> it = nAlumno.iterator();
		int nNotas=0;
		Double sNotas=0.0;
		
		while(it.hasNext()) {
			nNotas++;
			sNotas+=it.next();
		}
		
		return sNotas/nNotas;
	}
	
	//funcion para anadir en la HashTable el nombre del alumno i la nota media de este
	public static Hashtable<String, Double> mediaAlumnos(String nombre, Double nota, Hashtable<String, Double> mediaA){
		
		mediaA.put(nombre, nota);
		
		return mediaA;
	}
	
	//funcion para leer y mostrar el nombre i la nota media de todos los alumnos.
	public static void mostrarMediaAlumnos(Hashtable<String, Double> mediaA) {
		
		Enumeration<String> llaves= mediaA.keys();
		
		while (llaves.hasMoreElements()) {
			String key = llaves.nextElement();
			System.out.println("El Alumno "+key+" tiene una media de "+mediaA.get(key));
		}
	}

}
