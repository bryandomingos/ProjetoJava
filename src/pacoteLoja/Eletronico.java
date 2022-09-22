package pacoteLoja;

import java.io.Serializable;

public abstract class Eletronico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public abstract String portabilidade();
	
	private String marca;
	private String modelo;
	private int ano;
	private double valor;
	protected String tela;
	protected String tipo;	
	protected static boolean isSurround;
	
	public Eletronico(String marca, String modelo, int ano, double valor) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		
	}
		
	public String toString() {
		String mostrar = "";
		mostrar += "Tipo: " +this.tipo + "\n";
		mostrar += "Marca: " + this.marca + "\n";
		mostrar += "Modelo: " + this.modelo + "\n";
		mostrar += "Ano: " + this.ano + "\n";
		mostrar += "Valor: " + this.valor + "\n";
		mostrar += "Tela: " +this.tela + "\n";
		mostrar += "Portabilidade: " + portabilidade() + "\n";
		return mostrar;
		
	}
	
	public static boolean getIsSurround() {
		try {
			try {
				return isSurround;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSurround;
	}

	@SuppressWarnings("static-access")
	public void setSurround(boolean isSurround) {
		this.isSurround = isSurround;
		
	}
	
}
