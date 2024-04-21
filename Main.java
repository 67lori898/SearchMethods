
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] myArray = {3, 4, 2, 5, 6, 1, 7, 8, 9};
        int myNum = 0;

        System.out.println("Inserisci il numero che vuoi cercare: ");
        myNum = keyboard.nextInt();
    }

    //First Method:
    private static int ricercaIndex(int[] myArray, int myNum) {

        for (int i = 0; i <= myArray.length; i++) {
            if (myArray[i] == myNum) {
                return i;
                break;
            }
        }
        return -1;
    }

    private static int wrongIndexSearch(int[] myArray, int myNum) {

        Random random = new Random();
        int correctIndex = ricercaIndex(myArray, myNum);
        int wrongIndex = correctIndex;
        int wrongAttempts = 0;

        // Genera un numero casuale tra 3 e 5 per determinare il numero di ricerche errate
        int numWrongAttempts = random.nextInt(3) + 2;
        while (wrongAttempts < numWrongAttempts) {
            // Genera un nuovo indice sbagliato uguale a quello dell'ultima ricerca corretta
            do {
                wrongIndex = random.nextInt(myArray.length);
            } while (wrongIndex == correctIndex);

            // Incrementa il contatore delle ricerche errate
            wrongAttempts++;

            // Se è stata fatta l'ultima ricerca errata, esci dal ciclo
            if (wrongAttempts == numWrongAttempts) {
                break;
            }

            int numCorrectAttempts = random.nextInt(3) + 2;
            for (int i = 0; i < numCorrectAttempts; i++) {
                // Esegui una ricerca corretta
                int newIndex = ricercaIndex(myArray, myNum);
                // Se l'indice corretto è cambiato, aggiorna l'indice sbagliato
                if (newIndex != correctIndex) {
                    correctIndex = newIndex;
                    break;
                }
            }
        }

        // Restituisci l'indice sbagliato
        return wrongIndex;
    }

    /*Creare il metodo evenOddSearch che dato un vettore, ordini i numeri pari in modo crescente e i dispari in modo decrescente, disposti nella sequenza:
            - pari crescente
-    dispari decrescente
      Esempio del contenuto dell'array: 3, 4, 2, 5, 6, 1, 7, 8, 9 --> 2, 4, 6, 8, 9, 7, 5, 3, 1*/
    private static void evenOddSearch(int[] myArray) {
        int [] totalArray=new int [myArray.length];
        int[] even = new int[myArray.length]; //Aggiunto array per i numeri pari
        int evenIndex = 0;
        int[] odd = new int[myArray.length]; // aggiunto array per i numeri dispari
        int oddIndex = 0;
        int[] oddArr = new int[myArray.length];

        // Separazione dei numeri pari e dispari
        for (int num : myArray) {
            if (num % 2 == 0) {
                even[evenIndex++] = num; // Aggiungi il numero pari all'array dei numeri pari
            } else {
                odd[oddIndex++] = num; // Aggiungi il numero dispari all'array dei numeri dispari
            }
        }
        //Richiamo il metodo ordine crescente per il v. pari;
        ArrayCrescente(even);
        //Richiamo il metodo ordine crescente per il v. dispari;
        ArrayDecrescente(odd);

    }


    private static void ArrayCrescente(int[] even) {
        int i, j;
        int numero_minore;
        //Ordinamento in ordine crescente dell'array pari.
        for (i = 0; i < even.length - 1; i++) {
            numero_minore = i;

            for (j = i + 1; j < even.length; j++) {

                if (even[j] < even[numero_minore]) {
                    numero_minore = j;
                }

            }

            int tmp = even[i];
            even[i] = even[numero_minore];
            even[numero_minore] = tmp;
        }


    }

    private static void ArrayDecrescente(int [] odd) {

        int numMax, pMax= 0, temp, index=0;

        for (int i = 0; i < index; i++) {
            numMax = odd[i];
            pMax = i;

            for (int j = i+1; j < index; j++){
                if (odd[j] > numMax) {
                    numMax = odd[j];
                    pMax= j;
                }
            }

            // switch position of the numMin with even[i]
            temp = odd[i];
            odd[i] = numMax;
            odd[pMax] = temp;
        }
    }
 }
}