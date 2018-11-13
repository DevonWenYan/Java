/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weighttest;

/**
 *磅(1b),盎司(oz),公克(g)
 * 1磅=453.59237公克
 * 1磅=16盎司
 * 1盎司=28.349公克
 * @author Yan
 */
public class Weight {
     /**
 *磅(1b),盎司(oz),公克(g)
 * 1磅=453.59237公克
 * 1磅=16盎司
 * 1盎司=28.349公克
 */
    private static final double OZ_TO_GRAM =28.349523125;
    private static final double LB_TO_GRAM =453.59237;
    private static final double LB_TO_OZ =16.0;
    private double gram;
    
    public Weight(){
        gram=0.0;
    }
    
    //設置公克數,參數為公克
    public void setGram(double gram){
        this.gram=gram;
    }
    
    //設置公克數,參數為磅和盎司
    public void setGram(int lb,int oz){
        double weight=convertToGram(lb,oz);
        gram=weight;
    }
    
    //磅和盎司轉換為公克
    private double convertToGram(int lb,int oz){
        return lb*LB_TO_GRAM+oz*OZ_TO_GRAM;
    }
    
    //調整公克數,參數為公克
    public void adjustGram(double gram){
        this.gram+=gram;
    }
    
    //調整公克數,參數為磅和盎司
    public void adjustGram(int lb,int oz){
        adjustGram(convertToGram(lb,oz));
    }
    
    //取得磅數
    public double getPound(){
        return (int)Math.floor(gram/LB_TO_GRAM);
    }
    //取得公克數
    public double getGram(){
        return gram;
    }
    
    //取得盎司數
    public double getOunce(){
        double decimalPound=gram/LB_TO_GRAM;  //先將公克換算成磅
        double fractionalValue=decimalPound-getPound();//將算出的磅-整數的磅(小於1的部分)
        return (int) Math.round(fractionalValue*LB_TO_OZ); //將小數的磅轉換成盎司並四捨五入
    }
}
