import java.util.ArrayList;

public class MatrizPersonas {

    public static void main(String[] args) {
        int[][] matriz = {
                {5, 7, 1, 3},
                {6, 45, 13,89},
                {2, 28,496, 8128},
                {11,4,8,89},
                {31,37,43,10}
        };
        ArrayList<Integer> listaPerfectos = new ArrayList<>();
        ArrayList<Integer> listaPrimos = new ArrayList<>();

        recorrerMatrizRecursiva(matriz, 0 , 0, listaPrimos,listaPerfectos);

        System.out.println("Lista de edades primas: ");
        mostrarArray(listaPrimos,0);
        System.out.println("Lista de edades perfectas: ");
        mostrarArray( listaPerfectos, 0 );

    }


    public static void recorrerMatrizRecursiva(int[][] matriz , int i , int j , ArrayList<Integer> listaPrimos , ArrayList<Integer> listaPerfectos) {
        if ( j == matriz[0].length ) {
            j = 0;
            i++;
        }

        if ( i < matriz.length ) {
            if ( isNumeroPerfecto( matriz[i][j] ) && isPrimo( matriz[i][j] ) ) {
                listaPerfectos.add( matriz[i][j] );
                listaPrimos.add( matriz[i][j] );
            } else {
                if ( isNumeroPerfecto( matriz[i][j] ) )
                    listaPerfectos.add( matriz[i][j] );
                else {
                    if ( isPrimo( matriz[i][j] ) )
                        listaPrimos.add( matriz[i][j] );
                }
            }
            recorrerMatrizRecursiva( matriz , i , j + 1 , listaPrimos , listaPerfectos );

        } else {
            if ( i + 1 < matriz.length ) {
                recorrerMatrizRecursiva( matriz , i + 1 , j , listaPrimos , listaPerfectos );
            } else {
                return;
            }
        }
    }


    public static boolean isNumeroPerfecto(int numero) {
        // Llama a la función auxiliar con índice inicial 1 y suma inicial 0
        return isNumeroPerfectoAux( numero , 1 , 0 );
    }

    public static boolean isNumeroPerfectoAux(int numero , int divisor , int sumaDivisores) {
        if ( divisor >= numero ) {
            // Hemos revisado todos los divisores, verificamos si la suma es igual al número
            return sumaDivisores == numero;
        }

        if ( numero % divisor == 0 ) {
            // Si el divisor es un divisor válido, agrégalo a la sumaDivisores
            sumaDivisores += divisor;
        }

        // Llama recursivamente con el siguiente divisor
        return isNumeroPerfectoAux( numero , divisor + 1 , sumaDivisores );
    }

    public static boolean isPrimo(int numero) {
        // Casos base
        if ( numero <= 1 ) {
            return false;
        }
        if ( numero <= 3 ) {
            return true;
        }

        // Verificar si el número es divisible por algún número menor o igual a su raíz cuadrada
        return isPrimoRecursivo( numero , 2 );
    }

    private static boolean isPrimoRecursivo(int numero , int divisor) {
        // Caso base: si el divisor alcanza la raíz cuadrada del número, no es divisible
        if ( divisor * divisor > numero ) {
            return true;
        }

        // Verificar si el número es divisible por el divisor actual
        if ( numero % divisor == 0 ) {
            return false;
        }

        // Intentar el siguiente divisor
        return isPrimoRecursivo( numero , divisor + 1 );
    }

    public static void mostrarArray(ArrayList<Integer> arreglo , int indice) {
        if ( indice != arreglo.size() ) {
            if ( indice == 0 ) {
                System.out.print( "[" + arreglo.get( indice ) + ", " );

            } else {
                System.out.print( arreglo.get( indice ) + ", " );
            }

            mostrarArray( arreglo , indice + 1 );
        } else {
            System.out.println( "]" );
        }
    }

}
