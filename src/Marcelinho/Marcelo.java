package Marcelinho;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//import java.io.FileInput;

//java fornece um mecaniso, serializacao que converte um qualquer objeto numa 
//sequencia de bits permitindo assim, grava-los num ficheiro binario, incuido os seus dados.
/*
 * o processo inverso chamase deserilizacao e consiste em ler os bits do ficheiro binario e recriar o objeto em
 * memoria, onde o podemos usar normalmente
 * 
 * NOTA IMPORTANTE: o presente processo é plataform independent, ou seja, podemos serializar com java e deserializar com
 * C#, ou outra qualquer plataforma (linguagem).
 * 
 * Livrarias 
 * 		java.io.FileOutputStream;      - para a abertura e manipulação de files
 * 		java.io.ObjectOutPutStream;    - contém os métodos de serialização
 *      java.io.ObjectInputStream;     - Contém os métodos de desSerialização
 *      
 * observações seguintes tem que ser acompanhadas de correspondentes observação de codigo.
 * A classe ObjectOutPutStream temo método [void writeObject(Object x)]
 * 		recebe um objeto qualquer, serializa-o e escreve-o numa file binária.
 * 		Pode atirar uma exceções: Se não encontrar o ficheiro throws IOException
 * 
 * A classe ObjectInputStream tem o método[Object readObject()]
 * 		Faz a desSerializacao a partir de um ficheiro e devolve um objeto de tipo Object que é
 * 		necessario converter para o objecto pretendido através de um simples cast.
 * 		Pode atirar duas exceções
 * 			-Se não encontrar o ficheiro - throws IOException
 * 			-Se não encontrar a classe   - throw ClassNotFOundException
 */
//package Marcelinho;

public class Marcelo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileLocation = "C:\\Users\\a46505\\Desktop\\ficheiro.bin";
		
		Pessoa p1 = new Pessoa("David Sousa");
		
		serializar(fileLocation,p1);
		
		Pessoa p2 = (Pessoa) desSerializar(fileLocation);
		
		System.out.println(p2.getNome() + " " + p2.getapelido());

	}
	
	
	
	public static void serializar(String fileLocation, Object obj)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(fileLocation);
			ObjectOutputStream serialize = new ObjectOutputStream(fileOut);
			
			serialize.writeObject(obj);
			serialize.close();
			fileOut.close();
			System.out.println("Serializado para " + fileLocation);
		}catch(IOException i)
		{
			System.out.println("ERRO: Impossivel criar ou abrir o ficheiro:");
			i.printStackTrace(); //imprime o erro tecnico
		}

	}
	
	public static Object desSerializar(String fileLocation)
	{
		try
		{
			FileInputStream fileIn = new FileInputStream(fileLocation);
			ObjectInputStream deserialize = new ObjectInputStream(fileIn);
			Object obj = deserialize.readObject();
			
			deserialize.close();
			fileIn.close();


			return obj;
		}catch(IOException i)
		{
			System.out.println("ERRO: Impossivel aceder ao ficheiro");
			i.printStackTrace(); //imprime o erro tecnico
			return null;
		} catch (ClassNotFoundException c) {
			// TODO Auto-generated catch block
			System.out.println("Objeto não foi encontrado no ficheiro");
			c.printStackTrace();
			return null;
		}

	}
	

}


