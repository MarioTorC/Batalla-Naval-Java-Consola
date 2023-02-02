/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author USER
 */

public class Logica {

    static int matriz [][]= new int [6][7];
    static String matrizCadena [][]= new String [6][7];    
    public static void mostrarTablerosIniciales(){
        System.out.println("\t      BATALLA NAVAL\n" + 
                           "\t     TABLEROS DE JUEGO");
     
        System.out.println("JUGADOR 1\t\t\t\t\t");
        System.out.println("");
        System.out.println("     1      2      3      4      5      6    7 ");
        System.out.println("   --------------------------------------------");
          for (int x=0; x < matrizCadena.length; x++) {
               int i = (int) (Math.random()*5+1);
                System.out.print((x+1)+"|");
                for (int y=0; y < matrizCadena[x].length; y++) {
                 matrizCadena[1][y]="";
                    if (x==i&&y==3) {
                           matrizCadena[1][y]="***";
                           matrizCadena[5][y]="***";
                           matrizCadena[3][y]="***";
                    }
                      if (y==i&&x==4) {
                           matrizCadena[1][y]="**";
                            matrizCadena[3][y]="**";
                    }
               System.out.print ("["+matrizCadena[1][y]+"]");
                 if (y!=matrizCadena[x].length-1) System.out.print("\t");
                }
                System.out.println("|");
        }
       
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("JUGADOR 2\t\t\t\t\t");
        System.out.println("");
        System.out.println("     1      2      3      4      5      6    7 ");
        System.out.println("   --------------------------------------------");
          for (int x=0; x < matrizCadena.length; x++) {
               System.out.print((x+1)+"|");
               int i = (int) (Math.random()*5+1);
                for (int y=0; y < matrizCadena[x].length; y++) {
                     matrizCadena[1][y]="";
                    if (x==i&&y==3) {
                           matrizCadena[1][y]="***";
                           matrizCadena[5][y]="***";
                           matrizCadena[3][y]="***";
                    }
                      if (y==i&&x==4) {
                           matrizCadena[1][y]="**";
                            matrizCadena[3][y]="**";
                    }
                  System.out.print ("["+matrizCadena[1][y]+"]");
                 if (y!=matrizCadena[x].length-1) System.out.print("\t");
                }
                System.out.println("|");
        }
          
          
          
          
          
    }
    
    
        public static void TirosJuego(){
        System.out.println("\t      TIROS \n" + 
                           "\t     TABLEROS DE JUEGO");
     
        System.out.println("JUGADOR 1\t\t\t\t\t");
        System.out.println("");
        System.out.println("     1      2      3      4      5      6    7 ");
        System.out.println("   --------------------------------------------");
          for (int x=0; x < matrizCadena.length; x++) {
               int i = (int) (Math.random()*5+1);
                System.out.print((x+1)+"|");
                for (int y=0; y < matrizCadena[x].length; y++) {
                 matrizCadena[1][y]="";
                    if (x==i&&y==3) {
                         matrizCadena[1][y]="O";
                           matrizCadena[5][y]="O";
                           matrizCadena[3][y]="O";
                    }
                      if (y==i&&x==4) {
                           matrizCadena[1][y]="X";
                            matrizCadena[3][y]="X";
                             matrizCadena[3][y]="0";
                    }
               System.out.print ("["+matrizCadena[1][y]+"]");
                 if (y!=matrizCadena[x].length-1) System.out.print("\t");
                }
                System.out.println("|");
        }
       
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("JUGADOR 2\t\t\t\t\t");
        System.out.println("");
        System.out.println("     1      2      3      4      5      6    7 ");
        System.out.println("   --------------------------------------------");
          for (int x=0; x < matrizCadena.length; x++) {
               System.out.print((x+1)+"|");
               int i = (int) (Math.random()*5+1);
                for (int y=0; y < matrizCadena[x].length; y++) {
                     matrizCadena[1][y]="";
                    if (x==i&&y==3) {
                           matrizCadena[1][y]="X";
                           matrizCadena[5][y]="X";
                           matrizCadena[3][y]="O";
                    }
                      if (y==i&&x==4) {
                           matrizCadena[1][y]="O";
                            matrizCadena[3][y]="X";
                             matrizCadena[3][y]="O";
                    }
                  System.out.print ("["+matrizCadena[1][y]+"]");
                 if (y!=matrizCadena[x].length-1) System.out.print("\t");
                }
                System.out.println("|");
        }

    }
}