
package tarea1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tarea1 {
    
    /*public static void saludar(){
        System.out.println("Hola Mundo");
    }
    
    public static int sumar(int a, int b){
        return a+b;
    }
    
    public static int promedio(int n){
        Scanner sc = new Scanner(System.in);
        short promedio =0;
        int notas =0;
        for (int i = 0; i < n; i++) {
            System.out.println("Igrese la nota");
            notas = sc.nextInt();
            //promedio = (short)(notas) + promedio; 
        }
        
        
        
        return promedio;
    }*/
    
    /*public static double[][] minor(double[][] matrix, int row, int col) {
        double[][] minor = new double[3][3];
        int minorRow = 0, minorCol = 0;
        for (int i = 0; i < 4; i++) {
            if (i != row) {
                minorCol = 0;
                for (int j = 0; j < 4; j++) {
                    if (j != col) {
                        minor[minorRow][minorCol++] = matrix[i][j];
                    }
                }
                minorRow++;
            }
        }
        return minor;
    }*/
    
    public static double determinant(double[][] matriz){
        double det = 0;
        for (int i = 0; i < 4; i++) {
            det += matriz[0][i]*cofactor(minor(matriz, 0, i), 1, i+1);
        }
        return det;
                
    }
    
    public static double[][] minor(double[][] matriz, int row, int col){
        double minorC[][]= new double[3][3];
        int minorRow = 0, minorCol = 0;
        for (int i = 0; i < 4; i++) {
            if (i != row) {
                minorCol = 0;
                for (int j = 0; j < 4; j++) {
                    if (j != col) {
                        minorC[minorRow][minorCol++] = matriz[i][j];
                    }
                }
                minorRow++;
            }
        }
        
        return minorC;
    }
    
    public static double cofactor(double[][] matriz, int fil, int col){
        double cof = 0;
        
        cof = matriz[0][0]*matriz[1][1]*matriz[2][2]+matriz[0][1]*matriz[1][2]*matriz[2][0]+matriz[1][0]*matriz[2][1]*matriz[0][2]
            -(matriz[2][0]*matriz[1][1]*matriz[0][2]+matriz[1][0]*matriz[0][1]*matriz[2][2]+matriz[2][1]*matriz[1][2]*matriz[0][0]);
        cof = cof*Math.pow(-1, fil+col);
        return cof;
    }
    
    public static double[][] matrizCo(double[][]matriz){
        double matrizCof[][] = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizCof[i][j]=cofactor(minor(matriz, i, j), i+1, j+1);
            }
        }
        return matrizCof;
    }
    
    public static double[][] transpuesta(double[][]matriz){
        double matrizTrans[][] = new double[4][4];
        double matrizCof[][] = new double[4][4];
        matrizCof=matrizCo(matriz);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizTrans[i][j]=matrizCof[j][i];
            }
        }
        return matrizTrans;
    }
    
     public static double[][] matrizInversa(double[][]matriz){
        double matrizInv[][] = new double[4][4];
        double matrizTrans[][] = new double[4][4];
        matrizTrans=transpuesta(matriz);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrizInv[i][j]=matrizTrans[i][j]*(1/determinant(matriz));
            }
        }
        return matrizInv;
    }
    
    public static double[][] multiplicacion(double[][]matrixA,double[][]matrixB){
        double matrizMulti[][] = new double[4][4];
        int col =0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    matrizMulti[i][j]+=matrixA[i][k]*matrixB[k][col];
                }
                col++;
            }
            col=0;
        }
        
        return matrizMulti;
        
    }
    
    
            
            
    
    
    public static void main(String[] args){
        
        /*double matrix[][] = {{2,1,-3,2},{-4,2,4,-1},{-2,1,1,4},{1,-2,-1,4},};
        double minorC[][]= new double[3][3];
        double[][] matrixA = {{5,10,1,3},{9,14,2,6},{7,8,15,3},{6,8,9,2}};
        double[][] matrixB = {{5,13,9,4},{1,9,6,3},{8,11,69,33},{25,6,7,4}};
        
        
        
        minorC=multiplicacion(matrixA, matrixB);
        System.out.println(minorC[0][0]+minorC[3][0]);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(minorC[i][j] + " | ");
            }
            System.out.println("");   
        }
        
        
        
      
        //System.out.println(cofactor(minor(matrix, 0, 1), 1, 2));
        System.out.println(determinant(matrix));
        /*Scanner sc = new Scanner(System.in);
        
        int matriz[][] = new int[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = sc.nextInt();
            }
            System.out.print(" " + "\n");
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.print(" " + "\n");
        }
        
        /*Tarea1.saludar();
        System.out.println(sumar(4, 5));
        
        System.out.println("---PROMEDIO---");
        System.out.println("Ingrese el numero de notas que desea calcular promedio");*/
        
        /*double num = 4.2156899;
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(num));*/
 
        
      
    }
    
}
