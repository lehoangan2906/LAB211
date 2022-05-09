/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpbank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class Ebank {

    private ResourceBundle bundle;

    //chon ngon ngu
    public void setLocate(String locate) {
        bundle = ResourceBundle.getBundle(locate);
    }

    //tra ngon ngu sang interface
    public ResourceBundle getBundle() {
        return bundle;
    }

    //check tk nguoi dung
    public String checkAccountNumber(String accountnumber) {
        //check mot chuoi co 10 chu so va la so
        String regex = "^\\d{10}$";
        
        if (accountnumber.matches(regex)) {
            return "";
        } else {    
            return bundle.getString("account.error");
        }
    }

    //check password  
    
    public String checkPassword(String str) {
        
        //chi duoc chua chu thuong, chu hoa va so
        // mat khau phai trong khoang 8-31 ky tu
        if (str.matches("^[!@#&()–[{}]:;',?/*~$^+=<>||a-zA-Z0-9]*[[!@#&()–[{}]:;',?/*~$^+=<>]||a-zA-Z]+[!@#&()–[{}]:;',?/*~$^+=<>||a-zA-Z0-9]*$")
                && (str.length() >= 8 && str.length() <= 31)) {
            return "";
        } else {
            return bundle.getString("password.error");
        }
    }
    
    
    
    // check password
    // Positive lookahead (?=) ensures something followed by something else.
    // For example, b(?=c) matches a b that is followed by a c. 
    /*
    public String checkPassword(String password) {
        Pattern PASSWORD_FORMAT = Pattern.compile(""
                + "^"               // start of line
                + "(?=.*[0-9])"     // positive lookahead, digit[0-9]
                + "(?=.*[a-z])"     // positive lookahead, one lowercase character [a-z]
                + "(?=.*[A-Z])"     // positive lookahead, one uppercase character [A-Z]
                + "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])"       // positive lookahead, one of the special character
                + "."               // matches anything
                + "{8,31}"          // length at least 8 character and maximum of 31 character
                + "$"); //end of line
        
        // neu input khong match voi pattern thi in ra message cho user
        if (!PASSWORD_FORMAT.matcher(password).matches()) {
            return bundle.getString("password.error");
        }
        return "";
    }
*/
    

    // random ra mot captcha
    public String generateCaptcha() {
        
        // tao instance cua random va stringbuilder
        Random rand = new Random();
        StringBuilder anphabet = new StringBuilder();
        
        // khoi tao cac bien de check cac yeu cau captcha
        boolean isLowerExisted = false;
        boolean isUpperExisted = false;
        boolean isDigitExisted = false;

        //luu string anphabet chua chu thuong, chu hoa va so
        for (char i = 'a'; i <= 'z'; i++) {
            anphabet.append(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            anphabet.append(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            anphabet.append(i);
        }
        
        // khoi tao mot bien StringBuilder chua captcha
        StringBuilder captCha;
        
        do {
            captCha = new StringBuilder();
            
            for (int i = 0; i < 5; i++) {
                // lay mot ky tu random trong stringbuilder alphabet
                int index = rand.nextInt(anphabet.length());
                char randomChar = anphabet.charAt(index);
                
                if (randomChar >= 'a' && randomChar <= 'z') {
                    isLowerExisted = true;
                } else if (randomChar >= 'A' && randomChar <= 'Z') {
                    isUpperExisted = true;
                } else {
                    isDigitExisted = true;
                }
                
                //them ky tu random vao bien captcha
                captCha.append(randomChar);
            }
            
            //check xem co du ca chu thuong chu hoa ca so hay ko neu ko thi random mot chuoi moi
        } while (!isLowerExisted || !isUpperExisted || !isDigitExisted);
        
        // tra ve dang string cua captcha
        return captCha.toString();
    }

    //check nhap trung captcha   
    public String checkCaptcha(String captchaInput, String reCaptcha) {

        // neu captcha cua nguoi dung nhap trung voi captcha cua chuong trinh thi in ra login success
        if (reCaptcha.contains(captchaInput) && !captchaInput.isEmpty()) {
            return bundle.getString("login.success");
        } else {
            return bundle.getString("captcha.incorrect");
        }
    }

}
