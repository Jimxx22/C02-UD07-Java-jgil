import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class MainApp {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Producto> productos= new ArrayList<Producto>();
	static Hashtable<String, Double[]> carrito = new Hashtable<String, Double[]>();
	static DecimalFormat df = new DecimalFormat("#.00");
	
	public static void main(String[] args) {
		
		int res;
		boolean fin=false;
		
		bd();
		//menu de control del programa
		while(!fin) {
			System.out.println("\nCONTROL DEL STOCK DE PRODUCTOS: ");
			System.out.println("Que quieres hacer: ");
			System.out.println("1-Crear producto");
			System.out.println("2-Anadir stock de un producto");
			System.out.println("3-Mostrar un producto");
			System.out.println("4-Mostrar todos los productos");
			System.out.println("5-Iniciar compra");
			System.out.println("0-Salir");
			res =sc.nextInt();
			
			switch (res) {
			case 0:
				fin=true;
				break;
			case 1:
				crearProducto();
				break;
			case 2:
				anadirStock();
				break;
			case 3:
				mostrarProducto();
				break;
			case 4:
				mostrarTodo();
				break;
			case 5:
				compra();
				break;
				
			default:
				System.out.println("Esta opcion no esta disponivle, vuelve a intentar-lo.");
				break;
			}
			
		}

	}
	
	//base de datos generada automaticamente
	public static void bd() {
		
		productos.add(new Producto("Zanahoria", "ref001", 0.75, 0.04, 20));
		productos.add(new Producto("Cebolla", "ref002", 1.45, 0.04, 20));
		productos.add(new Producto("Espinaca", "ref003", 5.12, 0.04, 20));
		productos.add(new Producto("Coliflor", "ref004", 1.79, 0.04, 20));
		productos.add(new Producto("Patata", "ref005", 1.29, 0.04, 20));
		productos.add(new Producto("Brócoli", "ref006", 0.99, 0.04, 20));
		productos.add(new Producto("Lechuga", "ref007", 1.99, 0.04, 20));
		productos.add(new Producto("Puerro", "ref008", 3.40, 0.04, 20));
		productos.add(new Producto("Tomate", "ref009", 1.99, 0.04, 20));
		productos.add(new Producto("Apio", "ref010", 1.98, 0.04, 20));
	}

	//funcion para crear un producto i anadir-lo a la bd, si el producto existe preguntaremos si queremos modificar-lo completamente
	public static void crearProducto(){
		
		String ref, nombre;
		Double precio, iva;
		int stock,i=0;
		String res;
		boolean exist=false;
		
		System.out.println("\nVamos a a anadir un producto nuevo.");
		
		System.out.print("Introduce la ref del producto: ");
		ref=sc.next();
		
		for (Producto p : productos) {
			
			if (p.getRef().equalsIgnoreCase(ref)) {
				exist=true;
				System.out.println("Este producto ya existe, quieres modificar-lo: (y/n)");
				res=sc.next();
				
				switch (res) {
				case "y":
					System.out.println("Actual: "+p.getRef());
					System.out.print("Introduce la ref del producto: (si no quieres canviar la ref pulsa 0)");
					ref=sc.next();
					
					System.out.println("Actual: "+p.getNombre());
					System.out.print("Introduce el nombre del producto: (si no quieres canviar el nombre pulsa 0)");
					nombre=sc.next();
					
					System.out.println("Actual: "+p.getPrecio());
					System.out.print("Introduce el precio del producto: (si no quieres canviar el precio pulsa 0)");
					precio=sc.nextDouble();
					
					System.out.println("Actual: "+p.getStock());
					System.out.print("Introduce el stock del producto: (si no quieres canviar el IVA pulsa 0)");
					stock=sc.nextInt();
					
					if(ref=="0") {
						ref=p.getRef();
					}
					if(nombre=="0") {
						nombre=p.getNombre();
					}
					if(precio==0) {
						precio=p.getPrecio();
					}
					if(stock==0) {
						stock=p.getStock();
					}
					
					productos.get(i).setRef(ref);
					productos.get(i).setNombre(nombre);
					productos.get(i).setPrecio(precio);
					productos.get(i).setStock(stock);
					
					ref=null;
					i++;
					break;
				case "n":
					
					break;

				default:
					System.out.println("(n/y)");
					break;
				}
			}
		}
		
		if (!exist) {
			System.out.print("Introduce la ref del producto: ");
			ref=sc.next();
			
			System.out.print("Introduce el nombre del producto: ");
			nombre=sc.next();
			
			System.out.print("Introduce el precio del producto: ");
			precio=sc.nextDouble();
			
			System.out.print("Introduce el iva del producto: ");
			iva=sc.nextDouble();
			
			System.out.print("Introduce el stock del producto: )");
			stock=sc.nextInt();
			
			productos.add(new Producto(ref, nombre, precio, iva/100, stock));
		}		
	}
	
	//funcion para mostrar todos los produtcos en labd
	public static void mostrarTodo() {
		
		System.out.println("Productos: ");
		for (Producto p : productos) {
			
			System.out.println(p.toString());
			
		}
		
	}
	
	//funcion para anadir stock de un producto
	public static void anadirStock(){
		
		String ref;
		int stock;
		
		System.out.print("Introduce la ref del producto: ");
		ref=sc.next();
		
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getRef().equalsIgnoreCase(ref)) {
				System.out.println("Actual: "+productos.get(i).getStock());
				System.out.print("Introduce el stock que queremos anadir al producto: ");
				stock=sc.nextInt();
				
				
				productos.set(i, new Producto(productos.get(i).getNombre(), productos.get(i).getRef(), productos.get(i).getPrecio(), productos.get(i).getIVA(), productos.get(i).getStock()+stock));
				
				System.out.println("Stock modificado");
			}else {
				System.out.println("Este prodcuto no existe.");
			}
		}	
	}
	
	//funcion para mostrar un producto en conctero
	public static void mostrarProducto() {
		
		String ref;
		
		System.out.print("Introduce la ref del producto: ");
		ref=sc.next();
		
		for (Producto p : productos) {
			if (p.getRef().equalsIgnoreCase(ref)) {
				System.out.println(p.toString());
			}
		}
		
	}
	
	//funcion de compra, introduciremos las refs de los productos i las canidades de estos, i los guardaremos en una Hashtable.
	public static void compra() {
		
		boolean fin=false, fin2=false;
		String ref, res;
		Double cantidad;
		
		mostrarTodo();
		System.out.println("Introduce las refs de los productos: ");
		
		while (!fin) {
			System.out.print("REF: ");
			ref =sc.next();
			for (Producto p : productos) {
				if(p.getRef().equalsIgnoreCase(ref)) {
					System.out.println(".");
					System.out.println("Cantidad actual: "+p.getStock());
					System.out.println("Cantidad: ");
					cantidad=sc.nextDouble();
					if(cantidad>p.getStock()) {
						System.out.println("NO hay suficiente stock. NO se ha introducido al carrito.");
					}else if(cantidad<=0){
						System.out.println("La cantidad entrada no es valida.  NO se ha introducido al carrito.");
					}else {
						System.out.println(cantidad);
						//0-cantidad, 1-precio, 2-IVA
						Double[] precioCantiad=new Double[3];
						precioCantiad[0]=cantidad;
						precioCantiad[1]=p.getPrecio();
						precioCantiad[2]=p.getIVA();
						carrito.put(ref, precioCantiad);
					}
				}
			}
			
			verCarrit();
			while(!fin2) {
				System.out.println("Quieres introducir algun producto mas: (y/n)");
				res=sc.next();
				switch (res) {
				case "y":
					fin2=true;
					break;
				case "n":
					fin2=true;
					fin=true;
					break;
				default:
					System.out.println("(y/n)");
					break;
				}
			}
		}
		pago();	
	}
	
	//funcion para pagar, mostraremos el precio final, sumando todos los productos.
	public static void pago() {
		
		Double precioF=0.0;
		Double pago;
		boolean con =false;
		
		verCarrit();
		
		Enumeration<String> e= carrito.keys();
		
		while (e.hasMoreElements()) {
			String ref=e.nextElement();
			Double[] array= carrito.get(ref);
			precioF+=(array[2]+1)*(array[0]*array[1]);
			for (Producto p : productos) {
				if(p.getRef().equalsIgnoreCase(ref)) {
					p.restarStock(array[0]);
				}
			}
		}
		
		System.out.println("El precio final con el IVA es: "+df.format(precioF));
		System.out.print("Introduce el pago: ");
		pago=sc.nextDouble();
		
		//aqui comprovamos que el pago es mayor o igual al precio final, si es mayor mostramos el cambio, si es igual nada, i si es menor pedimos que entre otra vez el pago
		while(!con) {
			if(pago<precioF) {
				System.out.println("La cantidad introducida no es suficiente, vuleve a intentar-lo");
				pago=sc.nextDouble();
			}else if (pago==precioF){
				con=true;
				System.out.println("COMPRA REALIZADA. ");
				System.out.println("Muchas gracias!");
			}else {
				con=true;
				System.out.println("COMPRA REALIZADA. ");
				System.out.println("El cambio sera: 0"+df.format(pago-precioF)+". Muchas gracias!");	
			}
		}
		
	}
	
	//funcion para visualizar el carrito que seria la Hashtable
	public static void verCarrit() {
		Enumeration<String> e= carrito.keys();
		
		System.out.println("Aqui tienes tu carrito: ");
		
		while (e.hasMoreElements()) {
			String ref=e.nextElement();
			Double[] array= carrito.get(ref);
			System.out.println(ref+"---"+array[0]+"---"+array[1]+"---"+array[2]);
		}
	}
		
}
