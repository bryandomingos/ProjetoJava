package pacoteLoja;

public class Celular extends Eletronico implements Notificacao{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void somDeNotificacao( ) {
		System.out.println("Celular:\n\nBling Bling Bling");		
	
	}
		
	@Override
	public void produzSom() {
		System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n"); 
		
	}
	
	public Celular(String marca, String modelo, int ano, double valor) {
		super(marca, modelo, ano, valor);
		this.tela = "Pequena";
		this.tipo = "Celular";
		this.setSurround(true);
		
	}
	
	public String portabilidade() {
		return "Portátil";	
		
	}
	
}


