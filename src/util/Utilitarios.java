package util;

import java.util.Scanner;

public class Utilitarios {
    private static Scanner scanner;


    /**
     * Manipula o input de nome
     *
     * @return nome do usuário
     */
    public static String inputNome() {
        scanner = new Scanner(System.in);
        System.out.println("Digite o nome:");

        return scanner.nextLine();
    }

    /**
     * Manipula o input de idade
     *
     * @return idade do usuário
     */
    public static int inputIdade() {
        scanner = new Scanner(System.in);
        System.out.println("Digite a idade:");
        return Utilitarios.validateInput();
    }
    /**
     * Valida o tipo de entrada
     */
    public static int validateInput() {
        try{
            return scanner.nextInt();
        }catch (Exception e){
            System.out.println("Entrada inválida. Tente novamente");
            scanner.next();
            validateInput();
        }
        return 0;
    }
}
