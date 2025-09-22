import cli.MainCLI;
import models.MataKuliah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainCLI cli = new MainCLI();
        cli.mainMenu(in);

        in.close();
    }
}