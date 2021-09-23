/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tootharray;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ToothArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число месяца (0 - январь, 11 - декабрь)");
        int userMonth = scanner.nextInt();
        System.out.println("Введите число дня месяца (0 - первый день месяца)");
        int userDay = scanner.nextInt();
        
        
        
        int[] [] year = new int[12][];
        
        Random random = new Random();
        
        for (int i = 0; i < 12; i++) {
            year[i] = new int[random.nextInt(31 - 28) + 28];
            // Winter
            if (i == 0 || i == 1 || i == 2) {
                for (int in = 0; in < year[i].length; in++) {
                    year[i][in] = -(random.nextInt(30 - 10) + 10);
                }
                
            }
            // Spring
            if (i == 3 || i == 4 || i == 5) {
                for (int in = 0; in < year[i].length; in++) {
                    year[i][in] = random.nextInt(10 - 0) + 0;
                }
            }
            // Summer
            if (i == 6 || i == 7 || i == 8) {
                for (int in = 0; in < year[i].length; in++) {
                    year[i][in] = random.nextInt(30 - 15) + 15;
                }
            }
            // Autumn
            if (i == 9 || i == 10 || i == 11) {
                for (int in = 0; in < year[i].length; in++) {
                    year[i][in] = random.nextInt(15 - 0) + 0;
                }
            }
          
        }
        
        System.out.println("Температура "+userDay+" дня "+userMonth+" месяца: "+year[userMonth][userDay]+" градусов");
        System.out.println("===================================================");
        
        int smallestTemp = 0;
        int smallestMonth = 0;
        int smallestDay = 0;
        int biggestTemp = 0;
        int biggestMonth = 0;
        int biggestDay = 0;
        
        for (int month = 0; month < 12; month++) {
            int average = 0;
            
            for (int day = 0; day < year[month].length; day++) {
                average += year[month][day];
                if (year[month][day] < smallestTemp) {
                    smallestTemp = year[month][day];
                    smallestMonth = month;
                    smallestDay = day;
                }
                if (year[month][day] > biggestTemp) {
                    biggestTemp = year[month][day];
                    biggestMonth = month;
                    biggestDay = day;
                }
            }
            average = average / year[month].length;
            System.out.println("Средняя температура "+month+" месяца: "+average);
        }
        System.out.println("=======================================================");
        System.out.println("Самый холодный день: "+smallestDay+", с температурой "+smallestTemp+" градусов"+" был в "+smallestMonth+" месяце");
        System.out.println("Самый жаркий день: "+biggestDay+", с температурой "+biggestTemp+" градусов"+" был в "+biggestMonth+" месяце");
        
    }
    
}
