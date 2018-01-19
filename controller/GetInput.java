package queststore.controller;

import java.util.Scanner;

public class InputController {

    public String getStringInput(String text) {
        Scanner scanner = new Scanner();
        String input = scanner.nextLine();
        return input;
    }
}