package lesson1;


import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        Homework homework = new Homework();
        Scanner in = new Scanner(System.in);

        while (!homework.isGameFinish()) {
            System.out.println("Your hp is : " + homework.getHp() + " enter your move");
            String step = in.nextLine();
            homework.move(step.charAt(0));
            Runtime.getRuntime().exec("clear");
        }
        System.out.println("Game is finished");
    }
}