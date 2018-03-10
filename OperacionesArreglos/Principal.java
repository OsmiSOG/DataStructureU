package OperacionesArreglos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * Clase principal con las opciones para escojer 
 * @author Santaigo Otalora
 */
public class Principal {

	/**
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int Opcion;
		
		bw.write("Taller No. 1 - Operaciones con Arreglos\n");
		bw.write("Por favor escriba el numero del problema que desea ver:\n"
				+ "0. Salir\n1. Problema parejas\n2. Problema multiplicacion\n3. Problema parejas\n4. Problema precios\n");
		bw.flush();
		Opcion = Integer.parseInt(br.readLine());
		
		while(Opcion != 0) 
		{
			switch(Opcion)
			{
				case 1://Primer Problema
				{
					PrimerPunto pp = new PrimerPunto();
					pp.Couples();
				}break;
				case 2:// Segundo Problema
				{
					SegundoPunto sp = new SegundoPunto();
					sp.Problema();
				}break;
				case 3://Tercer Problema
				{
					TercerPunto tp = new TercerPunto();
					tp.Problema();
				}break;
				case 4:// Cuarto Problema
				{
					CuartoPunto cp = new CuartoPunto();
					cp.Problema();
				}break;
				default://En caso de no escojer ninguna opcion
				{
					bw.write("El numero "+Opcion+" no es ua opcion valida\n");
				}
			}
			bw.write("Por favor escriba el numero del problema que desea ver:\n"
			+ "0. Salir\n1. Problema parejas\n2. Problema multiplicacion\n3. Problema parejas\n4. Problema precios\n");
			bw.flush();
			Opcion = Integer.parseInt(br.readLine());
		}
	}

}
