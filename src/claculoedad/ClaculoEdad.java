/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package claculoedad;

/**
 *
 * @author edwin
 */
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.util.Scanner;
 import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ClaculoEdad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          try {
     
        int dia, mes, anio;
        Calendar fActual= new GregorianCalendar();
        int diaA = fActual.get (Calendar.DAY_OF_MONTH);
        int mesA = fActual.get (Calendar.MONTH);
        int anioA = fActual.get (Calendar.YEAR);
        
        do {
            
            String diaN = JOptionPane.showInputDialog(null, "Digite su dia de nacimiento");
            dia=Integer.parseInt(diaN);
           
        }while (dia<1 || dia>31);
        do {
            String mesN = JOptionPane.showInputDialog(null, "Digite su mes de nacimiento");
            mes=Integer.parseInt(mesN);
            
        } while (mes<1 || mes>12);
            String anioN = JOptionPane.showInputDialog(null, "Digite su año de nacimiento");
            anio=Integer.parseInt(anioN);
        
        if (diaA<dia){
            diaA=diaA+30;
            mesA=mesA-1;
            dia=diaA-dia; 
        }else{
            dia=diaA-dia; 
        }
        if(mesA<mes){
            mesA=mesA+12;
            anioA=anioA-1;
            mes=mesA-mes;
        }else 
        {
            mes=mesA-mes;
        }
        if (anio==anioA){
            anio=0;
            
        }else {
        
            anio=anioA-anio;
        }
        
        JOptionPane.showMessageDialog(null,"Tiene la edad de: " + dia + "dias/ " + mes + " meses/ " + anio + " a;nos ");
       paraArchivar(dia, mes, anio); 
    }catch (Exception ex) {
            System.out.println("Ha habido un error " + ex.toString());
           
    }
    }
    public static void paraArchivar(int dia, int mes, int anio) {
		FileWriter flwriter = null;
              File directorio = new File("C:\\Ingeneria_S");
               directorio.mkdir();
                
		try {
                       flwriter = new FileWriter("C:\\Ingeneria_S\\CalculoEdad.txt", true);
		BufferedWriter bfwriter = new BufferedWriter(flwriter);
     		
                        
		bfwriter.write( "Su edad es = " + anio + " años " + mes + " meses "+ dia + " dias" +"\n");
		bfwriter.close();
		
		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
				}
			}
	}
	}
}
