import entities.Cliente;
import entities.Fatura;
import entities.Item;
import repositories.ClienteRepository;
import repositories.FaturaRepository;
import repositories.ItemRepository;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteRepository clienteRepository = new ClienteRepository();
        ItemRepository itemRepository = new ItemRepository();
        FaturaRepository faturaRepository = new FaturaRepository();

        Cliente c1 = new Cliente("Gustavo", "Cotrim");
        Cliente c2 = new Cliente("John", "Doe");
        Cliente c3 = new Cliente("Jane", "Doe");

        clienteRepository.salvar(c1);
        clienteRepository.salvar(c2);
        clienteRepository.salvar(c3);

        clienteRepository.imprimir();

        System.out.println("Insira o ID fo CLiente que deseja buscar: ");
        String id = sc.nextLine();
        System.out.println(clienteRepository.buscarPorId(id));

        System.out.println("Insira o ID do Cliente que deseja excluir: ");
        id = sc.nextLine();
        clienteRepository.deletarPorId(id);

        Item i1 = new Item("Notebook", 1, 5000.0);
        Item i2 = new Item("Monitor", 2, 800.0);
        Item i3 = new Item("Kit Teclado + Mouse", 1, 600.0);

        itemRepository.salvar(i1);
        itemRepository.salvar(i2);
        itemRepository.salvar(i3);

        itemRepository.imprimir();

        System.out.println("Insira o Código do Item que deseja excluir: ");
        id = sc.nextLine();
        itemRepository.deletarPorId(id);


        Fatura f = new Fatura(c1, itemRepository.buscarTodos());
        faturaRepository.salvar(f);
        faturaRepository.imprimir();

        sc.close();
    }
}
