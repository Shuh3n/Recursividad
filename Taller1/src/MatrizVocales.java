import java.util.ArrayList;

public class MatrizVocales {

    public static void main(String[] args) {
        String[][] matriz = {
                {"vacio", "carro", "baul", "perro"},
                {"colombia", "casa", "moto", "caza"},
                {"llanta", "reir", "archivo", "silla"},
                {"cocina", "ola", "ave", "freir"}
        };

        ArrayList<String> palabrasVocales = new ArrayList<>();
        recorrerMatrizRecursiva(matriz,0,0,palabrasVocales);
        System.out.println(palabrasVocales);


    }

    public static void recorrerMatrizRecursiva(String[][] matriz, int i, int j, ArrayList<String> miA) {
        if(j == matriz[0].length){
            j= 0;
            i++;
        }

        if(i < matriz.length){
            if (matriz[i][j] != null) {
                verificarVocalesSeguidas(matriz[i][j], 0, miA);
                recorrerMatrizRecursiva(matriz,i,j+1,miA);
            }else{
                recorrerMatrizRecursiva(matriz, i, j+1, miA);
            }
        }else{
            if(i+1 < matriz.length){
                recorrerMatrizRecursiva(matriz, i+1, j, miA);
            }
            else{
                return;
            }
        }
    }

    public static void verificarVocalesSeguidas(String pal, int indice, ArrayList<String> miA){
        if(indice == pal.length()-1){
            return;
        }
        else{
            if(pal != null || pal!= ""){
                if(isVocal(pal.charAt(indice)) && isVocal(pal.charAt(indice + 1))){
                    miA.add(pal);
                    return;
                }
                else{
                    verificarVocalesSeguidas(pal,indice+1,miA);
                }
            }

        }
    }

    public static boolean isVocal(char letra){
        if(letra == 'a' || letra== 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            return true;
        }
        else{
            return false;
        }
    }
}

