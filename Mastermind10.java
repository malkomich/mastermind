
class Mastermind10{

	public static void Menu (){
		System.out.println("================");
		System.out.println("|| MASTERMIND ||");
		System.out.println("================");
		System.out.println(" ");
		System.out.println("MENU INICIAL");
		System.out.println("     1. Un Jugador:");
		System.out.println("     2. Dos Jugadores:");
		System.out.print("Elija una opcion[1/2]: ");
	
	}

	public static void LimpiarPantalla (){
		int i;

		for (i=1;i<=25;i++){
			System.out.println(' ');
		}
	}

	public static boolean CompararClaves (int [] c1, int [] c2){
		int i,j;
		int corr = 0;
		int des = 0;
		int d1,d2,d3,d4;
		boolean valido = false;

		// Creamos dos variables auxiliares para no modificar los arrays y poder volver a inicializarlos cada
        // vez que comprobemos los correctos y descolocados
		int [] aux1;
		aux1 = new int [5];
		int [] aux2;
		aux2 = new int [5];

		// Buscar los correctos y marcarlos con -1 para que no vuelva y con -2 si esta descolocado, evitando 
        // que se duplice o que aparezcan mas descolocados de los que debe haber.
		for (i=0;i<aux1.length;i++){
			aux1[i]=c1[i];
			aux2[i]=c2[i];
		}
		for (i=0;i<aux1.length;i++){
				d1=aux1[i];
				d2=aux2[i];
				if (d1==d2){
					corr++;
					aux1[i]=-1;
					aux2[i]=-2;
				}
		}
		
		for (i=0;i<aux1.length;i++){
			d3 = aux1[i];
			for (j=0;j<aux2.length;j++){
				d4 = aux2[j];
				if (d3==d4){
					des++;
					aux1[i]=-1;
					aux2[j]=-2;
				}
			}
		}
	
		System.out.print("Correctos: "+corr+"  Descolocados: "+des+"                    ");
		if (corr==5 && des==0)
			return true;
		else
			return false;
		
	}
	
	public static void player1 (){
		int [] clavesecreta;
		int [] clavedada;
		int intentos = 0;
		int i;
		int aux;
		boolean claveValida;
		clavesecreta = new int [5];
		clavedada = new int [5];
		String texto="";
		String clav ; 
		char [] cambio; // La usamos para pasar la clave a un array de enteros 
		
			System.out.println("El sistema esta generando la contrasena secreta....");
			//Con este bucle generamos los numeros aleatorios de 0 a 9
			for (i=0;i<clavesecreta.length;i++){
				clavesecreta[i] = (int)(Math.random()*10);
			}
			
			do{
				do{
					System.out.println("Introduzca su clave de 5 numeros ["+(10-intentos)+" intentos]: ");			    	
					clav =SimpleIO.readLine();
				}while (clav.length() != 5);
				
				cambio = clav.toCharArray(); // Pasamos de String a array de caracteres
				//Con este bucle pasamos los caracteres de ASCII a su correspondiente entero
				for (i=0;i<cambio.length;i++){	
					aux = (cambio[i]);
					clavedada[i]=(int)aux-48; // Para pasar de codigo ASCII a entero es necesario restarle por 48
				}

				texto = texto + clav + " "; // Guardamos las claves dadas por el usuario separadas entre espacios
				claveValida = CompararClaves(clavesecreta,clavedada);
				System.out.println("");
				intentos++;
			}while(claveValida==false && intentos < 10);

			if (claveValida)
				System.out.println("Pass correcta!");
			else if (intentos == 10){
				System.out.println("Numero de intentos sobrepasado");
				System.out.print("La clave es: ");
				for (i=0;i<clavesecreta.length;i++){
					System.out.print(clavesecreta[i]);
				}
				System.out.println(" ");
				System.out.println("Este ha sido su proceso: ");
				for (i=0;i<texto.length();i++){
					System.out.print(texto.charAt(i));
				
				}
			}
	}

	public static void player2 (){
		int [] clavesecreta;
		int [] clavedada;
		int intentos = 0;
		int aux;
		int i;
		boolean claveValida;
		clavedada = new int [5];
		clavesecreta = new int [5];
		String texto = "";
		String clavsec;
		String clavdada;
		char [] cambio1;
		char [] cambio2;
			
			do{
				System.out.println("Introduzca la clave secreta: ");
				clavsec = SimpleIO.readLine();
				
			}while (clavsec.length() != 5);
				
				cambio1 = clavsec.toCharArray();
				for (i=0;i<cambio1.length;i++){
					aux = cambio1[i];
					clavesecreta[i] = (int)aux - 48;
				}
			do{	
				do{
					System.out.println("Introduzca su clave [" + (10-intentos) + " intentos]: ");
					clavdada = SimpleIO.readLine();
				}while (clavdada.length() != 5);
					
					cambio2 = clavdada.toCharArray();
					for (i=0;i<cambio2.length;i++){
						aux = cambio2[i];
						clavedada[i] = (int)aux - 48; 
					}
					texto = texto + clavdada + " ";
					claveValida = CompararClaves(clavesecreta,clavedada);
					intentos++;
					System.out.println("");
			}while(claveValida==false  && intentos < 10);
			
			if (claveValida)
				System.out.println("Pass acertada!");
			else if (intentos == 10){
				System.out.println("Numero de intentos sobrepasado");
				System.out.println("Este ha sido su proceso: ");
				for (i=0;i<texto.length();i++){
					System.out.print(texto.charAt(i));
				}
			}

	}
	
	public static void main (String args[]){
		char opcion;
		
		do{
			Menu();
			opcion = SimpleIO.readChar();
			LimpiarPantalla();
		}while(opcion!='1'&& opcion!='2');
		
		if (opcion=='1')
			player1();
		else
			player2();

	}
}
