package StringEjemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class StringEjemplo {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Escoja una opción para el ejemplo \n 1.Split\n 2.indexOf\n 3.Substring\n 4.Lenght\n 5.cahrAt\n 6.Salir\n");
		bw.flush();
		int option = Integer.parseInt(br.readLine());

		do {
			bw.write(todosEjemplos(option));
			bw.write("Escoja una opción para el ejemplo\n 1.Split\n 2.indexOf\n 3.Substring\n 4.Lenght\n 5.cahrAt\n 6.Salir\n");
			bw.flush();
			option = Integer.parseInt(br.readLine());
		}
		while(option != 6);
		
	}
	
	/**
	 * 
	 * @param option
	 * @return
	 * @throws IOException
	 */
	public static int todosEjemplos(int option) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int numero = 0;
		switch(option) {
			case 1: // MEtodo Split() 
			{
				bw.write("igrese palabras separadas con puntos\n");
				bw.flush();
				String lecturaEjemplo = br.readLine();
				String ejemploArray[] = lecturaEjemplo.split(".");
				bw.write("La magia de split!!!!!\n");
				bw.flush();
				for(String ejemplo:ejemploArray){
					bw.write(ejemplo+"\n");
					bw.flush();
				}
			}
			break;
			case 2:// Metodo indexOf()
			{
				bw.write("ingrese una frase\n");
				bw.flush();
				String lecturaEjemplo = br.readLine();
				bw.write("Ahora ingrese la primer letra que desea encontrar\n");
				bw.flush();
				String letra = br.readLine();
				bw.write("El primer indice encontrado se encuentra en la poscición:\n"+lecturaEjemplo.indexOf(letra));
				bw.flush();
				numero = lecturaEjemplo.indexOf(letra);
			}
			break;
			case 3:// Metodo substring()
			{
				bw.write("ingrese una frase\n");
				bw.flush();
				String lecturaEjemplo = br.readLine();
				bw.write("Desde que poscicion desea cortar la palabra");
				bw.flush();
				int poscicion = Integer.parseInt(br.readLine());
				bw.write("Su nueva palabra: "+ lecturaEjemplo.substring(poscicion)+"\n");
				bw.flush();
			}
			break;
			case 4:// Metodo lenght()
			{
				bw.write("Ingrese una frase\n");
				bw.flush();
				String lecturaEjemplo = br.readLine();
				bw.write("La cantidad de letras y espacios de su frase es: "+lecturaEjemplo.length()+"\n");
				bw.write(lecturaEjemplo.length());
				bw.flush();
			}
			break;
			case 5:// Metodo charAt()
			{
				bw.write("Ingrese una frase\n");
				bw.flush();
				String lecturaEjemplo = br.readLine();
				bw.write("Cual es la posición de la letra que desea sacar");
				bw.flush();
				int posicion = Integer.parseInt(br.readLine());
				bw.write("Esta es la letra : "+lecturaEjemplo.charAt(posicion)+"\n");
				bw.flush();
			}
			break;
			default:
			{
				System.exit(0);
			}
		}
		return numero;
	}

}
