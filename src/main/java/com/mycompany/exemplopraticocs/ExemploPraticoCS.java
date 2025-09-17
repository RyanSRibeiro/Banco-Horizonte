
package com.mycompany.exemplopraticocs;
import java.util.Scanner;

public class ExemploPraticoCS {

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        boolean exibir = true;
        double depo = 0;
        
        System.out.println("--------------------------------------");
        System.out.println("Seja bem vindo ao Banco Horizonte");
        System.out.println("--------------------------------------");
        System.out.println("");
        System.out.println("Qual tipo de operação deseja realizar hoje?");
        
        ContaBanco pessoas = new ContaBanco();
       
        while(exibir){
     
            System.out.println("-----------------------------------");
            System.out.println("1- Abrir Conta");
            System.out.println("2- Fechar Conta");
            System.out.println("3- Depositar");
            System.out.println("4- Sacar");
            System.out.println("5- Pagar Mensal");
            System.out.println("6- Exibir contas cadastradas");
            System.out.println("7- Sair");
            System.out.println("-----------------------------------");
            int operacao = ler.nextInt();
            
            switch(operacao){
                
                case 1 -> {
                    pessoas.abrirConta();

                }
                
                case 2 -> {
                    pessoas.fecharConta();

                }
                
                case 3 -> {
                    
                    pessoas.depositar();
                }
                
                case 4 -> {
                    pessoas.sacar();
                    
                }
                
                case 5 -> {
                    pessoas.pagarMensal();
                }
                
                case 6 -> {
                    pessoas.exibirContas();
                }
                
                case 7 -> {
                    exibir = false;
                    System.out.println("Saindo...");
                }
            }
   
        }
        
        System.out.println("Muito obrigado por utilizar o Belo Horizente até a proxima!");
        
    }
}
