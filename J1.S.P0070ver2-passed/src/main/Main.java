package main;

import Tpbank.Ebank;
import View.TpbankGUI;
import Utility.Validation;

public class Main {

    public static void main(String[] args) {
        TpbankGUI tbBank = new TpbankGUI();
        
        while (true) {
            tbBank.input();
        }
    }
}
