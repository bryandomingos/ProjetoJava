package pacoteLoja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Loja extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Eletronico> eletronicos;	
	
	private JPanel contentPane;	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Loja() {
	
		this.eletronicos = new ArrayList<Eletronico>();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setTitle("Controle de Estoque");
			
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"-------Opções-------",
				"--------------------------",
				"Novo Celular","Novo Tablet","Novo Notebook",
				"--------------------------", 
				"Exibir Lista", "Limpar Lista", "Salvar Lista", "Carregar Lista"}));
		comboBox.setBounds(20, 50, 130, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Selecione o que deseja executar:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 9, 315, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ir");
		btnNewButton.setBounds(160, 73, 90, 20);
		contentPane.add(btnNewButton); {
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
		@Override
				public void actionPerformed(ActionEvent e){

			          int selection = comboBox.getSelectedIndex();
			          switch (selection) {
			          
			          
			          case 0:
			        	  
			        	  		break;
			        	  
			          case 1:
			        	  
			        	  		break;
			          
			          case 2:	

				          		eletronicos.add((Eletronico)Cel());
				          		JOptionPane.showMessageDialog(null,"Celular inserido com sucesso!");  		
				          		break;
			        	  				        	  		
				      case 3:  
				    	  
				    	  		eletronicos.add((Eletronico)Tab());
				    	  		JOptionPane.showMessageDialog(null,"Tablet inserido com sucesso!");
								break;
		
				      case 4:	
				    	  
				    	  		eletronicos.add((Eletronico)Not());
		    	  				JOptionPane.showMessageDialog(null,"Notebook inserido com sucesso!");
		    	  				break;    	   	
			          															
				      case 5:
				    	   
			    	   			break;		
				    	   		
				    	   		
			          case 6:
			            	  
			            	  	if (eletronicos.size() == 0) {
			  					JOptionPane.showMessageDialog(null,"A lista está vazia.");
			  					break;	
			  				}
			            	  	String dados = "";
			            	  	for (int i=0; i < eletronicos.size(); i++)	{
			  					dados += eletronicos.get(i).toString() + "-----------------------------------------\n";
			  					
			  				}
			            	  	JOptionPane.showMessageDialog(null,dados);
			            	  	break;
			  				
			  				
			  				
			          case 7:
			  					if (eletronicos.size() == 0) {
			  					JOptionPane.showMessageDialog(null,"A lista está vazia.");
			  					break;
			  				}
			  					eletronicos.clear();
			  					JOptionPane.showMessageDialog(null,"Dados limpos com sucesso.");
			  					break;
			  				
			  				
			  				
			  		 case 8:
			  					if (eletronicos.size() == 0) {
			  					JOptionPane.showMessageDialog(null,"A lista está vazia.");
			  					break;
			  				}
			  					salvar(eletronicos);
			  					JOptionPane.showMessageDialog(null,"Dados salvos com sucesso.");
			  					break;
			  				
			  				
			  				
			  		 case 9:
			  					eletronicos = recuperar();
			  					if (eletronicos.size() == 0) {
			  					JOptionPane.showMessageDialog(null,"Nada a apresentar.");
			  					break;
			  				}
			  					JOptionPane.showMessageDialog(null,"Dados recuperados com sucesso.");
			  					break;
			            }
			        }
			    });
		}
		
		JButton btnNewButton_1 = new JButton("Fechar");
		btnNewButton_1.setBounds(160, 104, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);									
			}				
		});
	}

//--------------------------------------------------------------------------------------------------------------------------------------//		
		
		public void salvar (ArrayList<Eletronico> eletronicos) {
			ObjectOutputStream output = null;
			try {
				
				output = new ObjectOutputStream (new FileOutputStream("dadosLoja.dat"));
				
				for (int i=0; i < eletronicos.size(); i++)
					output.writeObject(eletronicos.get(i));
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo.");
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
				
				try {
					
					if (output != null) {
						output.flush();
						output.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();	
				}					
			} 
		}
		
//---------------------------------------------------------------------------------------------------------------------------------------//
		
		@SuppressWarnings("finally")
		public ArrayList<Eletronico> recuperar() {
			
			ArrayList<Eletronico> recuperareletronico = new ArrayList<Eletronico>();
			
			ObjectInputStream input = null;
			
			try {	
				
				input = new ObjectInputStream (new FileInputStream("dadosLoja.dat"));
				Object obj = null;
				while ((obj = input.readObject()) != null) {
					if (obj instanceof Eletronico) {
						recuperareletronico.add((Eletronico) obj);
					}   
				}    
	     
			} catch (EOFException e) {
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Arquivo não contém eletrônicos.");
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
				
				try {
					if (input != null) {
						input.close();
					}
					
				} catch (final IOException e) {
					e.printStackTrace();
			
				}
			
				return recuperareletronico;
			}			
		}
		
//--------------------------------------------------------------------------------------------------------------//     INT     //-----// 
		
		private boolean validoInt(String string) {
			
			try {
							
				Integer.parseInt(string);						
				return true;
											
			} catch (NumberFormatException exception) { 
				return false;				
			}
		}
						
			public int stringInt(String entrada) {
			@SuppressWarnings("unused")
			int num;
			
			try {
				
				if(fail == false) {	
						
					while (!this.validoInt(entrada)) {
						entrada = JOptionPane.showInputDialog(null, "Ano inválido, digite um número inteiro.");
				
						if(entrada == null) {

							break;
						}
				
					}
				}	
					
			} catch (NumberFormatException e) {
				
			  }
			
			return Integer.parseInt(entrada);
				
			
		}
						
//------------------------------------------------------------------------------------------------------------//     DOUBLE    //-----//
			
			private boolean validoDouble(String string) {
			try {
						
				Double.parseDouble(string); 
				return true;
										
			} catch (NumberFormatException exception) { 
				return false;
					
			}
		}
				
		public Double stringDouble(String entrada) {
		@SuppressWarnings("unused")
		Double num;
		
		try {
			
			if(fail == false) {	
				
				while (!this.validoDouble(entrada)) {
					entrada = JOptionPane.showInputDialog(null, "Preço inválido, digite um número em reais.");
			
					if(entrada == null) {

						break;
					}	
			
				}
			}	
			
		} catch (NumberFormatException e) {
		
		  }
		
			return Double.parseDouble(entrada);
					
		}
			
//-----------------------------------------------------------------------------------------------------------------------------------//
		
		public Celular Cel() {
					
			String [] valores = new String [4];
			String [] dados = {"Marca", "Modelo","Ano","Valor"};
			valores = leitor (dados);
					
			int ano = this.stringInt(valores[2]);			 
			double valor = this.stringDouble(valores[3]);
						
			Celular celular = new Celular (valores[0],valores[1],Math.abs(ano),Math.round(Math.abs(valor)*100)/100.0d);			
			
			return celular;
	
		}				
						
		public Tablet Tab() {
					
			String [] valores = new String [4];
			String [] dados = {"Marca", "Modelo", "Ano", "Valor"};
			valores = leitor (dados);
					
			int ano = this.stringInt(valores[2]);				
			double valor = this.stringDouble(valores[3]);
					
			Tablet tablet = new Tablet (valores[0],valores[1],Math.abs(ano),Math.round(Math.abs(valor)*100)/100.0d);
				
			return tablet;
					
		}	
				
		public Notebook Not() {
					
			String [] valores = new String [4];
			String [] dados = {"Marca", "Modelo", "Ano", "Valor"};
			valores = leitor (dados);
			
			int ano = this.stringInt(valores[2]);
			double valor = this.stringDouble(valores[3]);
				
			Notebook notebook = new Notebook (valores[0],valores[1],Math.abs(ano),Math.round(Math.abs(valor)*100)/100.0d);		
			
			return notebook;
					
		}			
		
//-------------------------------------------------------------------------------------------------------------------------------------//			
			
		boolean fail = false;
		
		public String[] leitor (String [] dadosIn){
			
			String [] dadosOut = new String [dadosIn.length];
	
			Arrays.fill(dadosOut,"");
			
			try {
				
				for (int i = 0; i < dadosIn.length; i++)	
					
						while (dadosOut[i].length() == 0) {
						
							dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");
						
							if (dadosOut[i].equals("")) {
							
								JOptionPane.showMessageDialog(null, "Entre com " + dadosIn[i]);
						
							}
													 						
						}
				
				} catch(NullPointerException e) {
				
					fail = true;
					
				}
			
			return dadosOut;
						
		} 
				
}
