/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

import java.util.Scanner;

/**
 *
 * @author Yan
 */
public class TimeLengthTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TimeLength usertime=new TimeLength();
        Scanner scanner =new Scanner(System.in);
        String input=new String();
        String second=new String();
        
        do{
            showMenu();//Show menu
            input=scanner.next();//Get user input
            if(input.matches("[0-3]")){
                int num=Integer.parseInt(input);
                switch(num){
                    case 1:
                        System.out.print("Please enter time(second or hh:mm:ss):");
                        second=scanner.next();
                      
                        if(second.matches("\\-?[1-9]\\d*")){
                             usertime.setTime(Double.parseDouble(second));
                        }else if(second.matches("\\-?\\d{2,}\\:\\d{2}\\:\\d{2}")){
                            String[] units=second.split(":");
                            int hour=Integer.parseInt(units[0]);
                            int minute=Integer.parseInt(units[1]);
                             int s=Integer.parseInt(units[2]);
                        
                            usertime.setTime(hour, minute,s);   
                        }
                        break;
                    case 2:
                        System.out.print("Please enter time(second or hh:mm:ss):");
                        second=scanner.next();
                       
                        if(second.matches("\\-?[1-9]\\d*")){
                            usertime.adjustTime(Double.parseDouble(second));
                           
                        }else if(second.matches("\\-?\\d{2,}\\:\\d{2}\\:\\d{2}")){
                            String[] units=second.split(":");
                            int hour=Integer.parseInt(units[0]);
                            String[] x=units[0].split("");
                            int minute=Integer.parseInt(units[1]);
                            int s=Integer.parseInt(units[2]);
                         if(x[0].equals("-")){
                             minute=minute*-1;
                             s=s*-1;
                         }
                         
                            usertime.adjustTime(hour, minute,s);
                         
                        }
                          break;
                    case 3:
                        
                        System.out.printf("The current time (s):%d s \n",(int)usertime.getTime());
                        System.out.printf("The current length of time (hh:mm:ss):%02d:%02d:%02d\n",(int)usertime.gethour(),(int)usertime.getminute(),(int)(usertime.getTime()%60));
                }
                System.out.println();
            }else{
                System.out.println("Please enter a valid number.\n");
            }
            
        }while(!input.equals("0"));
    }
    public static void showMenu(){
        System.out.println("***Convert Length of Time***");
        System.out.println("1)Set  length of time.");
        System.out.println("2)Adjust the Length of Time.");
        System.out.println("3)Show the length of time in different units.");
        System.out.println("Please enter a number in[1,2,3,0]:");
    }
    }
    

