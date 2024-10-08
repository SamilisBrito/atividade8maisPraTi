import abstraction.employeemanagement.*;
import abstraction.paymentsystem.Boleto;
import abstraction.paymentsystem.CartaoCredito;
import abstraction.paymentsystem.FormaPagamento;
import abstraction.paymentsystem.Pix;
import encapsulation.Product;
import inheritance.Developer;
import inheritance.Manager;
import polymorphism.abstractclasses.Animal;
import polymorphism.abstractclasses.Cachorro;
import polymorphism.abstractclasses.Gato;
import polymorphism.abstractclasses.Vaca;
import polymorphism.interfaces.Bicicleta;
import polymorphism.interfaces.Carro;
import polymorphism.interfaces.IMeioTransporte;
import polymorphism.interfaces.Trem;

public class Main {
    public static void main(String[] args) {
        Product produto1 = new Product("Tal", 12, 17);
        System.out.println("Nome:" + produto1.getName() + " Preço:" + produto1.getPrice() + " Quantidade:" + produto1.getQuantity());

        Manager gerente1 = new Manager("Samilis", 10000);
        Developer developer = new Developer("Lucas", 10000);

        System.out.println("Nome:" + gerente1.getNome() + " Salario:" + gerente1.getSalary() + " Bonus:" + gerente1.calcularBonus() + " Trabalho é: "+ gerente1.trabalhar());
        System.out.println("Nome:" + developer.getNome() + " Salario:" + developer.getSalary() + " Bonus:" + developer.calcularBonus()  + " Trabalho é: "+ developer.trabalhar());

        IMeioTransporte[] transportes = new IMeioTransporte[3];
        transportes[0] = new Carro();
        transportes[1] = new Bicicleta();
        transportes[2] = new Trem();

        for (IMeioTransporte transporte : transportes){
            System.out.println("Transporte: "+ transporte.getClass().getSimpleName());
            transporte.acelerar();
            transporte.frear();
            System.out.println();
        }
        Animal[] animais = new Animal[3];
        animais[0] = new Gato();
        animais[1] = new Cachorro();
        animais[2] = new Vaca();

        for (Animal animal : animais) {
            System.out.println("Animal: " + animal.getClass().getSimpleName());
            animal.emitirSom();
            System.out.println();
        }

        FormaPagamento pix = new Pix("012.200.0");
        FormaPagamento cartao = new CartaoCredito("1234567812345678", "12/25", "123");
        FormaPagamento boleto = new Boleto("1234567890123456789789012345678901234567", "12/24");

        FormaPagamento[] formasDePagamento = {pix, cartao, boleto};

        double valorPagamento = 150.00;

        for (FormaPagamento forma : formasDePagamento) {
            forma.processarPagamento(valorPagamento);
            System.out.println("-----------------------");
        }

        GerenciadorFolhaPagamento gerenciador = new GerenciadorFolhaPagamento();

        Funcionario gerente = new Gerente("Alice", 5000);
        Funcionario desenvolvedor = new Desenvolvedor("Bob", 4000);
        Funcionario estagiario = new Estagiario("Charlie", 2000);

        gerenciador.adicionarFuncionario(gerente);
        gerenciador.adicionarFuncionario(desenvolvedor);
        gerenciador.adicionarFuncionario(estagiario);

        gerenciador.calcularFolhaPagamento();

        desenvolvedor.promover("Gerente");
        gerenciador.calcularFolhaPagamento();
    }
}