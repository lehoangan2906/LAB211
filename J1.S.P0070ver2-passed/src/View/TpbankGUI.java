/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Utility.Validation;
import Tpbank.Ebank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Administrator
 */

public class TpbankGUI {
    private ResourceBundle bundle;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));     
    private Ebank eb = new Ebank();
    
    //show display menu    
    private void displayMenu() {
        System.out.println("-----------------------------");
        System.out.println("|       Login Program       |");
        System.out.println("-----------------------------");
        System.out.println("|\t1. Vietnamese       |");
        System.out.println("|\t2. English          |");
        System.out.println("|\t3. Exit             |");
        System.out.println("-----------------------------");
    }
   
    public void input(){        
        int option = 0;
        
        do{        
            // display the menu out
            displayMenu();
            
            System.out.println("");
            option = Validation.getOption("Please choose one option:", "Please enter option[1-3]", 1, 3);  
            
            switch (option) {                
                case 1:
                    //language VietNamese
                    eb.setLocate("Language.language_VN");
                    
                    // tra bundle cua language sang interface 
                    bundle = eb.getBundle();
                    
                    // hien thi interface login
                    login();
                    break;   
                    
                case 2:
                    //language English
                    eb.setLocate("Language.language_Eng");
                    
                    // tra bundle cua language sang interface 
                    bundle = eb.getBundle();
                    
                    // hiien thi interface login
                    login();
                    break;   
                    
                case 3:
                    //exit program
                    System.exit(0);
                    break;         
            }
        }while (true);
    }
    
    // hien thi interface login
    public void login(){
        String exp = "";
        String accountNumber = "";
        String password = "";
        
        //kiem tra accountNumber
        do{
            System.out.println(bundle.getString("account"));
            try{
                // lay account number
                accountNumber = in.readLine();
                
                // check account number co hop le 
                exp = eb.checkAccountNumber(accountNumber);
                
            }catch (IOException ex) {
                System.out.println("IOException");
            }
            if(exp.isEmpty()){
                break;
            } 
            System.out.println(exp);
        }while(true);
        
        //check password
        do{
            System.out.println(bundle.getString("password"));
            try{
                password = in.readLine();
                exp = eb.checkPassword(password);
            }catch (IOException ex) {
                System.out.println("IOException");
            }
            if(exp.isEmpty()){
                break;
            } 
            System.out.println(exp);
        }while(true);
       
       //check captcha
        do{
            // tao mot random captcha 
            String captcha = eb.generateCaptcha();
            
            System.out.println("Captcha: " + captcha);
            
            // lay captcha tu nguoi dung
            String reCaptcha = Validation.getString(bundle.getString("captcha"),
                         bundle.getString("captcha.incorrect"), "^[a-zA-Z0-9]{5}$");  
            
            // kiem tra captcha nguoi dung nhap vao co dung voi captcha cua chuong trinh
            exp = eb.checkCaptcha(captcha, reCaptcha); 
            
            System.out.println(exp);
        }while(!exp.equals(bundle.getString("login.success")));
    }
}
