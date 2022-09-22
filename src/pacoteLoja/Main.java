package pacoteLoja;

import java.awt.EventQueue;

public class Main {
	
public static void main(String[] args) {	
		
		EventQueue.invokeLater(new Runnable() {
						
			public void run() {
					
				try {
					
					Loja LojaDeEletronicos = new Loja();
					LojaDeEletronicos.setVisible(true);
					
					Celular celular = new Celular(null, null, 0, 0);
					Tablet tablet = new Tablet(null, null, 0, 0);
					Notebook notebook = new Notebook(null, null, 0, 0);
					
					celular.somDeNotificacao( );
					celular.produzSom();
					if(Celular.getIsSurround() == true) {
						System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					
					tablet.somDeNotificacao( );
					tablet.produzSom();
					}
					else if(Tablet.getIsSurround() == true) {
						System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					}
					notebook.somDeNotificacao( );
					notebook.produzSom();
					if(Notebook.getIsSurround() == true) {
						System.out.println("c)~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					}
									
				}
				
					catch (Exception e) {
					e.printStackTrace();
					
				}
			
			};
		
		});
				
	}

}
