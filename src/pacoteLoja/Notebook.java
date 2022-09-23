package pacoteLoja;

public class Notebook extends Eletronico implements Notificacao{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void somDeNotificacao( ) {
		System.out.println("Notebook:\n\nTrululululu");
	
	}

	@Override	
	public void produzSom() {
		System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
	}
	
	private boolean tecladoFisico;
	
	public void tecladoFisico() {
		
		if(tecladoFisico == true) {
			
			System.out.println("Contem teclado fisico.");
			
		}
		
	}
		
		
	public Notebook(String marca, String modelo, int ano, double valor) {
		super(marca, modelo, ano, valor);
		this.tela = "Grande";
		this.tipo = "Notebook";
		this.setSurround(true);
		this.tecladoFisico = true;

	}
	
	
	public String portabilidade() {
		return "Grande";
		
	}
	
}



