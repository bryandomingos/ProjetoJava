package pacoteLoja;

public interface Notificacao extends Speaker{
	
	void somDeNotificacao();
	
	@Override
	public default void produzSom() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
			
	}
	
}
