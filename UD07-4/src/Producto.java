
public class Producto {

	private String nombre;
	private String ref;
	private Double precio;
	private int stock;
	private final double IVA;
	
	//constructor del objeto prodcuto
	public Producto(String nombre, String ref, Double precio, Double iva, int stock) {
		this.nombre = nombre;
		this.ref = ref;
		this.precio = precio;
		this.IVA = iva;
		this.stock = stock;
	}

	//Geters i seters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public double getIVA() {
		return IVA;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//metodo para restar stock
	public void restarStock(Double stock) {
		this.stock-=stock;
	}
	
	//metodo toString para mostrar por pantalla
	public String toString() {
		return ref+"---"+nombre+"---"+precio+"---"+IVA+"---"+stock;
	}
}
