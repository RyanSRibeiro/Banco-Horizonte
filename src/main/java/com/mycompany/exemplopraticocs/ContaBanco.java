
package com.mycompany.exemplopraticocs;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    public int qntFatura;
    public double fatura;
    ArrayList<Integer> contas = new ArrayList<>();
    ArrayList<String> donos = new ArrayList<>();
    private final Scanner ler;

    public ContaBanco() {
      this.ler = new Scanner (System.in);
      qntFatura = 1;
      saldo = 0;
      fatura = 0;
      status = false; 
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void abrirConta(){
        status = true;
        
        System.out.println("Digite o tipo de conta que deseja abrir CC = Conta"
                + "Corrente CP = Conta poupança");
        
        tipo = ler.nextLine();
        tipo = tipo.toUpperCase();
        System.out.println("Digite o nome do dono da Conta: ");
        dono = ler.nextLine();
        
        if (tipo.equals("CC")){ 
            
            saldo = 50.0;
            System.out.println("Foi debitado em sua conta R$50,00");
        }else if(tipo.equals("CP")){
            
           saldo = 150; 
           System.out.println("Foi debitado em sua conta R$150,00"); 
        }
        numConta = ThreadLocalRandom.current().nextInt(10000000, 100000000);
                
        System.out.println( "Conta aberta com sucesso!");
        System.out.println( "Número da conta: " + numConta);
        contas.add(numConta);
        donos.add(dono);
       
    }
    
    public void fecharConta(){
        System.out.print("Digite o número da conta: ");
        int conta = ler.nextInt();
        
        if(qntFatura == 0 && saldo == 0){
        contas.remove(Integer.valueOf(conta));
        donos.remove(String.valueOf(dono));
        System.out.println("Conta encerrada com sucesso!");
        
        }else{
            System.out.println("Para realizar está operação é necessário "
            + "que sua conta esteja zerada e com nenhum débito em aberto." );
            
            System.out.println("Saldo atual: " + saldo);
            System.out.println("Quantidade de débitos em aberto: " + qntFatura);
        }
        
    }
    
    public void depositar(){
        System.out.println("Saldo em conta: "+saldo);
        if(contas.isEmpty()){
            System.out.println("Abra uma conta para realizar está operação");
            System.exit(0);
            
        }else{
            System.out.print("Digite o valor que deseja depositar: ");
            double depo = ler.nextDouble();
        this.saldo += depo;
        
        } 
        System.out.println("Este é seu saldo atual: " + saldo);
    }
    
    public void sacar(){
        System.out.println("Saldo em conta: "+saldo);
        if(contas.isEmpty()){
            System.out.println("Abra uma conta para realizar está operação");
            System.exit(0);
        }else{
            System.out.print("Digite o valor que deseja sacar: ");
        double saque = ler.nextDouble();
        saldo -=saque;
        }
        System.out.println("Este é seu saldo atual: " + saldo);
    }
    
    public void pagarMensal(){
        if(tipo.equals("CC")){
            
            fatura = 12.0;
            this.saldo -= fatura;
            qntFatura --;
            
        }else if(tipo.equals("CP")){
            fatura = 20.0;
            saldo -= fatura;
            qntFatura --;
        }
        System.out.println("Debitos a ser pago: " + qntFatura);
        System.out.println("Este é seu saldo atual após o pagamento da fatura: " + saldo);
    }
    
    public void exibirContas(){
        System.out.println("Contas abertas");
        for(int i = 0; i < contas.size(); i++){
            System.out.println(contas.get(i ) + "-" + donos.get(i));
      }            
        
    }


}    


