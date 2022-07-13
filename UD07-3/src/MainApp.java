import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class MainApp {

	static Scanner sc = new Scanner(System.in);
	//es para que solo salgan 2 deciamles
	static DecimalFormat df = new DecimalFormat("#.00");
	
	static Hashtable<String, String[]> productos= new Hashtable<String, String[]>();
	
	
	
	
	public static void main(String[] args) {
		
		anadir("id01", "10.21", "10");
		anadir("id02", "5.51", "10");
		anadir("id03", "20.99", "10");
		anadir("id04", "27.45", "10");
		anadir("id05", "7.25", "10");
		anadir("id06", "9.98", "10");
		anadir("id07", "15.15", "10");
		anadir("id08", "10.00", "10");
		anadir("id09", "9.05", "10");
		anadir("id10", "33.14", "10");
		
		menu();	
		
	}
	
	public static void anadir(String id, String precio, String stock) {
		
		String data[] = {precio,stock};
		
		productos.put(id, data);
	}
	
	public static void menu() {
		
		int res;
		boolean fin=false;
		
		while(!fin) {
			System.out.println("\nCONTROL DEL STOCK DE PRODUCTOS: ");
			System.out.println("Que quieres hacer: ");
			System.out.println("1-Anadir producto");
			System.out.println("2-Ver informacion de un producto");
			System.out.println("3-Mostrar todos los productos");
			System.out.println("0-Salir");
			res =sc.nextInt();
			
			switch (res) {
			case 0:
				fin=true;
				break;
			case 1:
				anadirProducto();
				break;
			case 2:
				mostrarProducto();
				break;
			case 3:
				mostrarTodo();
				break;

			default:
				System.out.println("Esta opcion no esta disponivle, vuelve a intentar-lo.");
				break;
			}
			
		}
	}
	
	public static void anadirProducto() {
		
		String id, precio, stock, res;
		
		System.out.println("\nVamos a a anadir un producto nuevo.");
		
		System.out.print("Introduce el id del producto: ");
		id=sc.next();
		
		if(productos.get(id) != null) {
			System.out.println("Este producto ya existe, quieres modificar-lo: (y/n)");
			res=sc.next();
			
			switch (res) {
			case "y":
				System.out.print("Introduce el precio del producto: ");
				precio=sc.next();
				
				System.out.print("Introduce el stock del producto: ");
				stock=sc.next();
				
				anadir(id,precio,stock);
				break;
			case "n":
				
				break;

			default:
				System.out.println("(n/y)");
				break;
			}
			
		}else {
			System.out.print("Introduce el precio del producto: ");
			precio=sc.next();
			
			System.out.print("Introduce el stock del producto: ");
			stock=sc.next();
			
			anadir(id,precio,stock);
		}	
		
	}
	
	public static void mostrarProducto() {
		
		String id;
		
		System.out.println("\nIntroduce una id de un producto para ver sus caracteristicas: ");
		id=sc.next();
		
		if(productos.get(id) != null) {
			String precio= productos.get(id)[0];
			String stock= productos.get(id)[1];
			System.out.println(id+" - "+precio+" - "+stock);	
		}else {
			System.out.println("Este producto no existe");
		}
		
	}

	public static void mostrarTodo() {
		
		System.out.println("\n");
				
		Enumeration<String> llaves= productos.keys();
		
		while (llaves.hasMoreElements()) {
			String id=llaves.nextElement();
			String[] array= productos.get(id);
			System.out.println(id+" - "+array[0]+" - "+array[1]);
		}
	}

}
