package Convertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author Osmi OG
 *
 */
public class Convertor {

	/**
	 * Esta es la clase principal que se encargara de ejecuatar el programa
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int salida = 0;
		do {
			String infija = Infija();//Primero leo un string con la notacion infija
			String posfija = Posfija(infija);//En está variable almaceno la notacion convertida a posfijo mediante la funcion
			String prefija = Prefija(infija);//En está variable almaceno la notacion convertida a prefijo mediante la funcion
			System.out.println("Posfija:  "+posfija+"\nPrefija:  "+prefija);//Imprimo las nuevas notacion 
			System.out.println("Desea volver a intentarlo: \n1. Si\t0. No");
			try {
				salida = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(salida != 0);
	}
	
	/**
	 * En esta funcion pido al usuario que me agrege una notacion infija
	 * retorna un string con la notacion infija ingresada por el usuario
	 * @return
	 */
	public static String Infija() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String infija = null;
		System.out.println("Escriba una notacion infija:  ");
		try {
			infija = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infija;
	}
	
	/**
	 * En esta funcion convierto una notacion infija obtenida por el usuario a posfija
	 * Retorna un string con la notacion posfija convertida del parametro que se le pasa a la funcion con la notacion infija
	 * @param infija
	 * @return
	 */
	public static String Posfija(String infija) {
		Stack<Character> pila = new Stack<Character>();//Pila con el orden de los operdores
		String posfija = "";//En este string almacenare la conversion ademas es el que sera retornado por la funcion
		char simbolo;//Agrego los simbolos de la notacion infija
		
		for(int i=0; i<infija.length(); i++) //Este ciclo es para rrecorrer la notacion infija a convertir
		{
			simbolo = infija.charAt(i);//Tomo el caracter de la notacion infija que se encuentra en la posicion i
			if(simbolo == '(') {//En caso de que el sibolo sea el parentesis izquierdo lo agrego a la pila
				pila.push(simbolo);
			}else {
				if(simbolo == ')') {//En caso de que el simbolo sea el parentesis derecho agrego lo que haya en la pila a posfija -sin parentesis-
					while(pila.peek() != '(') {
						posfija = posfija + pila.pop();
					}
					pila.pop();
				}else {//si el simbolo no es ninguno de los parentesis
					if(!isOperador(simbolo)) {//si el simbolo es un operando -letra o numero- agrego a posfijo
						posfija = posfija + simbolo;
					}else if(isOperador(simbolo)) {//si es un operador
						if(pila.isEmpty()) {//si la pila esta vacia agrego el simbolo a la pila
							pila.push(simbolo);
						}else if(Prioridad(simbolo) > Prioridad(pila.peek())) {//si la pila no esta vacia y
							//si la prioridad operador en simbolo es mayor a la prioridad del operador que esta en la cima de pila, agrega el simbolo a la pila
							pila.push(simbolo);
						}else {//si la prioridad de los operadores es alcontrario, el de la pila mayor que el del simbolo
							//Lo que esta en pila lo agrega a posfija y luego agrega el simbolo a la pila
							while(!pila.isEmpty()) {
								if(pila.peek() == '(' ) {
									break;
								}
								posfija = posfija + pila.pop();
							}
							pila.push(simbolo);
						}
					}
				}
			}
		}
		while(!pila.isEmpty()) {//por si quedo algo en pila, que lo termine de agregar a posfija
			posfija = posfija + pila.pop();
		}
		return posfija;
	}
	
	/**
	 * En esta funcion convierto la funcion infija dada por el usuario a prefija
	 * retorna un String con el valor de la conversion de infijo a prefijo
	 * @param infija
	 * @return
	 */
	public static String Prefija(String infija) {
		Stack<Character> pila = new Stack<Character>();//Pila con el orden de los operdores
		String prefija = "";//En este string almacenare la conversion ademas es el que sera retornado por la funcion
		char simbolo;//Agrego los simbolos de la notacion infija
		
		for(int i=infija.length()-1; i>=0; i--) {//Este ciclo es para rrecorrer la notacion infija a convertir
			simbolo = infija.charAt(i);//Tomo el caracter de la notacion infija que se encuentra en la posicion i
			if(simbolo == ')') {//Si el simbolo es el parentesis de la derecha lo almacena en pila
				pila.push(simbolo);
			}else {//si no es el parentesis derecho
				if(simbolo =='(') {//Si el simbolo es el parentesis izquierdo agrega a prefija lo que haya pila hasta el parentesis derecho-sin parentesis-
					while(pila.peek() != ')') {
						prefija = pila.pop() + prefija;
					}
					pila.pop();
				}else {//si no es ninguno de los parentesis
					if(!isOperador(simbolo)) {//si el simbolo es un operando -letra o numero-lo agrega en en prefija
						prefija = simbolo + prefija;
					}else if(isOperador(simbolo)) {//Si el simbolo es un operador
						if(pila.isEmpty()) {//si la pila esta vacia agrego el simbolo a pila
							pila.push(simbolo);
						}else if(Prioridad(simbolo)<Prioridad(pila.peek())) {//si la prioridad del operador en simbolo es menor a la prioridad del operador en pila
							//Agrega a prefija siempre y cuando cumpla condicion y esten despues del parentesis derecho segun sea el caso
							while(!pila.isEmpty()) {
								if(pila.peek() == ')') {
									break;
								}else if(Prioridad(simbolo)<Prioridad(pila.peek())){
									prefija = pila.pop() + prefija;
								}else {
									break;
								}
							}
							pila.push(simbolo);
						}else {//En caso de que la prioridad los operadores sea alcontraria, simbolo >= a pila 
							//Agrego en pila a simbolo
							pila.push(simbolo);
						}
					}
				}
			}
		}
		while(!pila.isEmpty()) {//En caso de que quede algo en pila, lo agrego a prefija
			prefija = pila.pop() + prefija;
		}
		return prefija;
	}
	
	/**
	 * Esta funcion es para saber si un caracter es o no un operador
	 * @param simbolo
	 * @return
	 */
	public static boolean isOperador(char simbolo) {
		
		boolean is = false;
		if(simbolo == '(' || simbolo == ')' || simbolo == '+' || simbolo == '-'||
				simbolo == '*'|| simbolo == '/'|| simbolo == '^') {
			is = true;
			return is;
		}
		return is;
	}
	
	/**
	 * Esta funcion contiene el valor de las prioridades de los operadores
	 * Retorna el valor de la prioridad de cada simbolo
	 * @param simbolo
	 * @return
	 */
	public static int Prioridad(char simbolo) {
		
		switch (simbolo) {
		case '^':
			return 4;
		case '*':
			return 3;
		case '/':
			return 3;
		case '+':
			return 2;
		case '-':
			return 2;
		case '(':
			return 1;
		default:
			return 5;
		}
	}

}
