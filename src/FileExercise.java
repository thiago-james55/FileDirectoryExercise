import controller.FileInOut;
import entities.Product;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/*

Exercicio de manipulação de diretorios e arquivos
Pegamos um arquivo .csv in.csv ou qualquer outro nome
com Produto,Valor,Quantidade Ex:

TV LED, 1290.99,1
Video Game Chair,350.50,3
Iphone X,900.00,2
Samsung Galaxy 9,850.00,2

E geramos um arquivo sumario "summary.csv" dentro da subpasta
"out" gerada na raiz do arquivo lido, com o nome do produto
e somente o valor total com a multiplicação de quantidade x valor Ex:

TV LED,1290.99
Video Game Chair,1051.50
Iphone X,1800.00
Samsung Galaxy 9,1700.00

 */

public class FileExercise {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o caminho do arquivo (.csv) :");

        String path = sc.nextLine();

        File file = new File(path);

        List<Product> products = FileInOut.fileToProductList(file);

        boolean success = FileInOut.listToCsvOut(products, file);

        System.out.println( (success)?"Procedimento efetuado com sucesso":"Erro!");

        sc.close();

    }


}
