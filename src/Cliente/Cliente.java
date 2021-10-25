/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Utils.Decrypt;
import java.util.logging.Level;
import java.util.logging.Logger;


    
public class Cliente {
    
    private String code;
    private int company;
    private boolean encrypt;
    private boolean male;
    private double balance;

    public Cliente(String code, int company, boolean encrypt, boolean male, double balance) {
        this.code = code;
        this.company = company;
        this.encrypt = encrypt;
        if(encrypt){
            try {
                this.code = Decrypt.code(code);
            } catch (Exception ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.male = male;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
    
    
}
