/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Fraccion;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class FraccionServicio {
    Fraccion fr = new Fraccion();
    Scanner leer = new Scanner(System.in);

    int num1,num2,den1,den2,div,den1_aux,den2_aux,numT,denT;
    
    public Fraccion crearFraccion(){
        System.out.println("FRACCION 1");
        System.out.print("Ingrese numerador: ");
        fr.setNum1(leer.nextInt());
        System.out.print("Ingrese denominador: ");
        fr.setDen1(leer.nextInt());
        System.out.println("FRACCION 2");
        System.out.print("Ingrese numerador: ");
        fr.setNum2(leer.nextInt());
        System.out.print("Ingrese denominador: ");
        fr.setDen2(leer.nextInt());
        
        num1 = fr.getNum1();
        num2 = fr.getNum2();
        den1 = fr.getDen1();
        den2 = fr.getDen2();
        den1_aux=den1;
        den2_aux=den2;
        
        return fr;
    }
    public void iniciarPrograma(){
        int opc;
        crearFraccion();
        System.out.println("MENU DE OPERACIONES"
                + "\n1. SUMA"
                + "\n2. RESTA"
                + "\n3. MULTIPLICACION"
                + "\n4. DIVISION");
        do{
            System.out.println("Ingrese una opción (1-4): ");
            opc = leer.nextInt();
            if(opc<1 || opc>4){
                System.out.println("Ingrese una opción válida!!!!");
            }
        }while(opc<1 || opc>4);
        
        switch(opc){
            case 1:
                sumaFraccion();
                break;
            case 2:
                restaFraccion();
                break;
            case 3:
                multiplicacionFraccion();
                break;
            case 4:
                divisionFraccion();
                break;
        }
    }
     
    public void sumaFraccion(){
        int mcm = 1;
        int i = 2;
        while (i <= den1 || i <= den2) {
            if (den1 % i == 0 || den2 % i == 0) {
                mcm = mcm * i;
                if (den1 % i == 0) {
                    den1 = den1 / i;
                }
                if (den2 % i == 0) {
                    den2 = den2 / i;
                }
            } else {
                i = i + 1;
            }
        }
        numT = ((mcm/den1_aux)*num1)+((mcm/den2_aux)*num2);
        div = mcd(numT,mcm);
        numT /= div;
        mcm /= div;
        if(mcm==numT){
            if (mcm == 1) {
                System.out.println(fr.getNum1() + "/" + fr.getDen1() + " + " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT);
            } else {
                System.out.println(fr.getNum1() + "/" + fr.getDen1() + " + " + fr.getNum2() + "/" + fr.getDen2() + " = 1");
            }
        }else{
            System.out.println(fr.getNum1()+"/"+fr.getDen1()+" + "+fr.getNum2()+"/"+fr.getDen2()+" = "+numT+"/"+mcm);
        }
        
    }
    
    public void restaFraccion() {
        int mcm = 1;
        int i = 2;

        while (i <= den1 || i <= den2) {
            if (den1 % i == 0 || den2 % i == 0) {
                mcm = mcm * i;
                if (den1 % i == 0) {
                    den1 = den1 / i;
                }
                if (den2 % i == 0) {
                    den2 = den2 / i;
                }
            } else {
                i = i + 1;
            }
        }
        numT = ((mcm / den1_aux) * num1) - ((mcm / den2_aux) * num2);

        div = mcd(numT,mcm);
        numT /= div;
        mcm /= div;
        
        if (numT == 0) {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " - " + fr.getNum2() + "/" + fr.getDen2() + " = 0");
        } else if (mcm == 1) {
                System.out.println(fr.getNum1() + "/" + fr.getDen1() + " - " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT);
        } else {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " - " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT + "/" + mcm);
        }

    }

    public void multiplicacionFraccion(){
        numT = num1 * num2;
        denT = den1 * den2;
        
        int divT = mcd(numT,denT);
        numT/=divT;
        denT/=divT;
        
        if (denT == 1) {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " * " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT);
        } else {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " * " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT + "/" + denT);
        }

    }
    
    public void divisionFraccion(){
        numT = num1 * den2;
        denT = den1 * num2;
        
        int divT = mcd(numT,denT);
        numT/=divT;
        denT/=divT;
        
        if (denT == 1) {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " / " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT);
        } else {
            System.out.println(fr.getNum1() + "/" + fr.getDen1() + " / " + fr.getNum2() + "/" + fr.getDen2() + " = " + numT + "/" + denT);
        }
    }
    
    public int mcd(int num, int den){
        int u = Math.abs(num);
        int v = Math.abs(den);
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
    
}
