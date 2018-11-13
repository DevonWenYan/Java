/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighttest;

import java.util.Scanner;

/**
 *
 * @author Yan
 */
public class WeightTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Weight userWeight=new Weight();
        Scanner scanner =new Scanner(System.in);
        String input=new String();
        String weight=new String();
        
        do{
            showMenu();//顯示menu
            input=scanner.next();//取得使用者輸入
            if(input.matches("[0-3]")){
                int num=Integer.parseInt(input);
                switch(num){
                    case 1:
                        System.out.print("Please enter a weight(GRAM or LB,OZ):");
                        weight=scanner.next();
                        /**
                         * 輸入條件:
                         * 1.輸入公克,可以輸入總數(e.g. 280)或小數(e.g. 485.1,280.0)
                         * 2.輸入磅和盎司,必須是整數 註:正規畫表示法"?":表示出現一次或完全沒有
                         */
                        if(weight.matches("\\d+[.]?+\\d*")){
                            System.out.println(weight+"g");
                            userWeight.setGram(Double.parseDouble(weight));
                        }else if(weight.matches("\\d+[,]\\d+")){
                            String[] units=weight.split(",");
                            int lb=Integer.parseInt(units[0]);
                            int oz=Integer.parseInt(units[1]);
                            System.out.println(lb+"lb");
                            System.out.println(oz+"oz");
                            userWeight.setGram(lb, oz);
                        }
                        break;
                    case 2:
                        System.out.print("Please enter a weight(GRAM or LB,OZ):");
                        weight=scanner.next();
                        /**
                         * 輸入條件
                         * 1.必須輸入數字(正整數與負整數)
                         * 2.輸入磅和盎司(正整數或負整數),兩數之間","間隔
                         */
                        if(weight.matches("[-]?\\d+[.]?\\d*")){
                            userWeight.adjustGram(Double.parseDouble(weight));
                            System.out.println(weight+"g");
                        }else if(weight.matches("[-]?\\d+[,][-]??\\d+")){
                            String[] units=weight.split(",");
                            int lb=Integer.parseInt(units[0]);
                            int oz=Integer.parseInt(units[1]);
                            System.out.println(lb+"lb");
                            System.out.println(oz+"oz");
                            userWeight.setGram(lb, oz);
                        }
                          break;
                    case 3:
                        System.out.printf("The current weight (g):%.4f g \n",userWeight.getGram());
                        System.out.printf("The current weight (lb,oz):%.1f 1b,%.1f oz \n",userWeight.getPound(),userWeight.getOunce());
                }
                System.out.println();
            }else{
                System.out.println("Please enter a valid number.\n");
            }
            
        }while(!input.equals("0"));
    }
    public static void showMenu(){
        System.out.println("***Weight Conversion***");
        System.out.println("1)Set a weight.");
        System.out.println("2)Adjust the weight.");
        System.out.println("3)Show the weight in different units.");
        System.out.println("Please enter a number in[1,2,3,0]:");
    }
}
