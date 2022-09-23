package pacoteLoja;

public class Tablet extends Eletronico implements Notificacao{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void somDeNotificacao( ) {
		System.out.println("Tablet:\n\nZiiiip");
	
	}

	@Override
	public void produzSom() {
		System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	private int caneta;
	
	public void caneta() {
		System.out.println("Contem " + caneta + " caneta.\n");
		
	}
		
	public Tablet(String marca, String modelo, int ano, double valor) {
		super(marca, modelo, ano, valor);
		this.tela = "Média";
		this.tipo = "Tablet";
		this.setSurround(false);
		this.caneta = 1;

	}
	
	public String portabilidade() {
		return "Média";
		
	}
	
}
