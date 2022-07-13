import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainApp {
	
	static Scanner sc = new Scanner(System.in);
	//es para que solo salgan 2 deciamles
	static DecimalFormat df = new DecimalFormat("#.00");
	
	public static void main(String[] args) {
		//ir anadiendo precios de productos, hasta que el usuario no quiera anadir mas
		//sumamos todos los precios, preguntamos que IVA queremos usar
		//pedimos pago, i mostramos cuanto tenemos que devolver.
		
		ArrayList<Double> preciosP= new ArrayList<>();
		Double precioF;
		
		preciosP=productos();
		precioF=precioFinal(preciosP);
		pago(precioF);

	}
	
	//funcion de leer i guardar todos los precios entrados
	public static ArrayList<Double> productos(){
		
		ArrayList<Double> productos= new ArrayList<>();
		Double precio=1.0;
		
		//parara de entrar precios quando entre un 0
		while(precio!=0) {
			System.out.print("Introduce el precio del producto: (quando quieras parar, introduce 0): ");
			precio=sc.nextDouble();
						
			productos.add(precio);
		}
		
		//mostramos la cantidad e productos entrados
		System.out.println("Has entrado "+ productos.size()+" productos.");
		return productos;
		
	}
	
	// funcion para calcular el precio total, el iva i el precio total + iva
	public static Double precioFinal(ArrayList<Double> productos) {
		
		Double precioF=0.0;
		final double IVA21=0.21;
		final double IVA4=0.04;
		int iva;
		boolean fin=false;
		
		Iterator<Double> it=productos.iterator();
		
		//sumamos todos los precios introducidos anteriormente
		while(it.hasNext()) {
			precioF+=it.next();
		}
		
		//oreguntamos que tipo de IVA vamos a aplicar
		System.out.println("El precio bruto es: "+df.format(precioF));
		System.out.println("Que IVA quieres aplicar: ");
		System.out.println("1- 21%");
		System.out.println("2- 4%");
		iva=sc.nextInt();
		
		//bucle para que introduzca un IVA correcto
		while(!fin)
			switch (iva) {
				case 1:
					System.out.println("El resultado del 21% de IVA es: "+df.format(precioF*IVA21));
					precioF*=(1+IVA21);
					fin=true;
					break;
				case 2:
					System.out.println("El resultado del 21% de IVA es: "+df.format(precioF*IVA4));
					precioF*=(1+IVA4);
					fin=true;
					break;

				default:
					System.out.println("ERROR en la entrada, vuelve a intentar-lo: ");
					iva=sc.nextInt();
					break;
		}
		System.out.println("El precio final con el IVA es: "+df.format(precioF));
		return precioF;
		
	}

	//funcion para introducir el paga i el cambio
	public static void pago(Double precioF) {
		
		Double pago;
		System.out.print("Introduce el pago: ");
		pago=sc.nextDouble();
		boolean con =false;
		
		//aqui comprovamos que el pago es mayor o igual al precio final, si es mayor mosramos el cambio, si es igual nada, i si es menor pedimos que entre otra vez el pago
		while(!con) {
			if(pago<precioF) {
				System.out.println("La cantidad introducida no es suficiente, vuleve a intentar-lo");
				pago=sc.nextDouble();
			}else if (pago==precioF){
				con=true;
				System.out.println("Muchas gracias!");
			}else {
				con=true;
				System.out.println("El cambio sera: "+df.format(pago-precioF)+". Muchas gracias!");	
			}
		}
				
	}
}
