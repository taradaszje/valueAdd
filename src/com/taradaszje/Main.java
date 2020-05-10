package com.taradaszje;

import com.taradaszje.services.TextService;
import com.taradaszje.services.TextServiceImpl;

public class Main {

    public static void main(String[] args){
        final TextService textService = new TextServiceImpl();
        textService.doService("src/resources/zadanie.txt");
    }
}
