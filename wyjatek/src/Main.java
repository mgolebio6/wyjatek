import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> numbers = new ArrayList<>();
    static int counter = 0;

    public static void main(String[] args) {
        userConsole();

    }

    public static void userConsole() {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Podaj maks piec liczb");

        boolean flag = true;


        while (flag) {
            flag = false;
            System.out.println("dadaj liczne T/N");
            String s = scanner.next();
            switch (s.toUpperCase()) {

                case "T": {
                    counter++;
                    flag = true;
                    System.out.println("Podaj " + counter + " liczbę");

                    try {
                        numbers.add(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        System.err.println("podaj liczbe zamiast lietery!!");
                        userConsole();
                    }
                    break;
                }

                case "N": {
                    if (numbers.size() > 0) {

                        try {

                            fiveNumbersTab(numbers.toArray());       // to zwraca objecty dlatego rzutowanie w fivenumbers

                        } catch (ArrayIndexOutOfBoundsException e) {

                            System.err.println("maks 5 liczb");
                            userConsole();

                        } finally {
                            System.out.println("sprzątam");
                            scanner.close();
                            numbers.clear();
                        }

                    } else {

                        System.out.println("nie podałes any liczby");
                    }
                    break;
                }

                default:
                    System.out.println("wpisz T lub N");
                    userConsole();


            }

        }
    }

    public static int[] fiveNumbersTab(Object[] objects) {

        int[] tab = new int[5];
        for (int i = 0; i < objects.length; ++i) {

            tab[i] = (int) objects[i];
            System.out.println(tab[i] + " | ");

        }
        return tab;

    }

}