import java.util.Arrays;
import java.util.Scanner;

class MetodoOrdenamiento{
	public int[] llenarVectorAleatorio(int tam) {
		tam = 1000;
		int numeros[]= new int [tam];
		for (int i = 0; i < tam; i++) {
			numeros[i] = (int) (Math.random()*100);
		}
		return numeros;
	}
	public void mostrarVector(int numeros[]) {
		System.out.println(Arrays.toString(numeros));
	}
	public void ordenamientoBurbuja1(int numeros[]) {
		long totalTiempo;
        long tiempoInicio;
        
        tiempoInicio =  System.currentTimeMillis();
		for (int i =0; i < numeros.length-1; i++) {
			for (int j = 0; j < numeros.length-1; j++) {
				if (numeros[j]>numeros[j+1]) {
					int aux = numeros[j+1];
					numeros[j+1] = numeros[j];
					numeros[j] = aux;
				}	
			}
		}
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		 
	     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
	   //Terminar tiempo
	}
	public void ordenamientoInsercionDirecta(int [] numeros) {
	int recorridos = 0,intercambios=0,comparaciones=0;
	long totalTiempo;
    long tiempoInicio;
    int i,j;
    
    tiempoInicio =  System.currentTimeMillis();
		for ( i = 0; i < numeros.length; i++) {
			int aux = numeros[i];
			j = i-1;//Empezamos a comprobar con el anterior
			comparaciones++;
			while((j>=0)&&(aux<numeros[j])) {//Mientras queden posciiones y el valor de aux//sea menor que los de la izquierda, se desplaza a la derecha
					numeros[j+1] = numeros[j];
					j--;
					intercambios++;
			}
			numeros[j+1] = aux; //colocamos aux en su sitio
			recorridos++;
			
		}
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		 
	     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
		 mostrarVector(numeros);
	     System.out.println("Recorridos: "+ recorridos);
	     System.out.println("Intercambios: "+ intercambios);
	     System.out.println("Comparaciones: "+ comparaciones);
	}
	public void ordenamientoPorSeleccion(int []numeros) {
		int recorridos = 0,intercambios=0,comparaciones=0;
		long totalTiempo;
        long tiempoInicio;
        
        tiempoInicio =  System.currentTimeMillis();
		for (int i = 0; i < numeros.length; i++) {
			int minimo = i;
			for (int j = i+1; j < numeros.length; j++) {
				
				if (numeros[j]<numeros[minimo]) {
					minimo = j;
					comparaciones++;
				}
				int aux = numeros[i];
				numeros[i] = numeros[minimo];
				numeros[minimo] = aux;
				intercambios++;
				recorridos++;
				//recorridos++;
				
			}
			//recorridos++;
			/*totalTiempo = System.currentTimeMillis() - tiempoInicio;
			 mostrarVector(numeros);
		     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
		     System.out.println("Recorridos: "+ recorridos);
		     */
		}
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		 mostrarVector(numeros);
	     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
	     System.out.println("Recorridos: "+ recorridos);
	     System.out.println("Intercambios: "+ intercambios);
	     System.out.println("Comparaciones: "+ comparaciones);
		
	}
	public void ordenamientoShellSort(int [] numeros) {
		llenarVectorAleatorio(1000);
		int salto,aux,i;
		boolean cambios;
		int recorridos = 0,intercambios=0,comparaciones=0;
		long totalTiempo;
        long tiempoInicio;
        
        tiempoInicio =  System.currentTimeMillis();
		for(salto = numeros.length / 2; salto !=0; salto/=2  ) {
			recorridos++;
			cambios =  true;
			while(cambios) {//Mientras intercambia un elemento
				comparaciones++;
				cambios = false;
				for (i = salto; i < numeros.length; i++) {// se da una pasada
					if(numeros[i-salto]>numeros[i]) {//Si estan desordenados
						
						aux = numeros[i]; //Se reordena
						numeros[i]=numeros[i-salto];
						numeros[i-salto] = aux;
						cambios = true; //Y se marca como cambio
						intercambios++;
					}
				}
			}
			
		}
		totalTiempo = System.currentTimeMillis() - tiempoInicio;
		 mostrarVector(numeros);
	     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
	     System.out.println("Recorridos: "+ recorridos);
	     System.out.println("Intercambios: "+ intercambios);
	     System.out.println("Comparaciones: "+ comparaciones);
	}
	public void ordenamientoQuickSort(int numeros[], int primero , int ultimo) {
		int recorridos = 0,intercambios=0,comparaciones=0;
		long totalTiempo;
        long tiempoInicio;
        
        tiempoInicio =  System.currentTimeMillis();
		int i,j,pivote,aux;
		i = primero;
		j = ultimo;
		pivote = numeros[primero];
		while (i < j) {
            while (numeros[i] <= pivote && i < j) {
                i++;
            }
            while (numeros[j] > pivote) {
                j--;
            }
            if (i < j) {
            	comparaciones++;
                aux = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = aux;
                intercambios++;
            }
        }
		recorridos++;
		numeros[primero] = numeros[j];
        numeros[j] = pivote;
        intercambios++;
        if (primero < j - 1) {
            ordenamientoQuickSort(numeros, primero, j - 1);
        }
        if (j + 1 < ultimo) {
            ordenamientoQuickSort(numeros, j + 1, ultimo);
        }
        
        totalTiempo = System.currentTimeMillis() - tiempoInicio;
		 mostrarVector(numeros);
	     System.out.println("Tiempo demorado: " + totalTiempo + " milisegundos.");
	     System.out.println("Recorridos: "+ recorridos);
	     System.out.println("Intercambios: "+ intercambios);
	     System.out.println("Comparaciones: "+ comparaciones);
        
		
	}
	
}

public class PruebaEjemploMetodosOrdenamiento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte opcion = 0;
		
		int numeros[] = {34,25,12,87,9,10,34,37,24,2};
		/*
		System.out.println("=========== METODOS DE ORDENAMIENTO ==========");
		System.out.println("##############################################");
		System.out.println("============= METODO ORDENAMIENTO CON BURBUJA ===============");
		
		MetodoOrdenamiento metodoBurbuja = new MetodoOrdenamiento();
		
		//int numeros[] = {34,25,12,87,9,10,34,37,24,2};
		metodoBurbuja.ordenamientoBurbuja1(numeros);
		metodoBurbuja.mostrarVector(numeros);
		
		System.out.println("\nDatos de eficienicia del algoritmo");
		//Recorridos o pasadas  
		//Comparacion ==> 45
		//Intercambio==> 25
		//Tiempo de ejeccion
		 */	 
		/*System.out.println("==========================================");
		System.out.println("========= METODO DE ORDENAMIENTO CON SELECCION ====================");
		MetodoOrdenamiento metodoSeleccion = new MetodoOrdenamiento();
		metodoSeleccion.mostrarVector(numeros);
		metodoSeleccion.ordenamientoPorSeleccion(numeros);
		System.out.println("============================================================");
		*/
		/*System.out.println("============================================================");
		System.out.println("================= METODO DE ORDENAMIENTO INSERCION DIRECTA =================");
		MetodoOrdenamiento metodoInsercionDirecta = new MetodoOrdenamiento();
		metodoInsercionDirecta.mostrarVector(numeros);
		metodoInsercionDirecta.ordenamientoInsercionDirecta(numeros);
		System.out.println("========================================================");
		*/
		/*
		System.out.println("====================================================");
		System.out.println("=========== METODO DE ORDENAMIENTO CON SHELL =================");
		MetodoOrdenamiento metodoShell = new MetodoOrdenamiento();
		metodoShell.llenarVectorAleatorio(1000);
		metodoShell.mostrarVector(numeros);
		metodoShell.ordenamientoShellSort(numeros);
		*/
	
		System.out.println("==========================================");
		System.out.println("========= METODO DE ORDENAMIENTO CON QUICK ====================");
		
		MetodoOrdenamiento metodoQuick =  new MetodoOrdenamiento();
		int numeros2[] = {5,
				
				3,7,6,2,1,4};
		System.out.println();
		metodoQuick.mostrarVector(numeros2);
		metodoQuick.ordenamientoQuickSort(numeros2, 0, numeros2.length-1); //como primero es el indice le podremos un 0
																		//Ultimo indice es la medida o tamanio 
	}

}
