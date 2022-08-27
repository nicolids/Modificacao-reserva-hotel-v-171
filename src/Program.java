import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException { // desse jeito essa exceção vai ser propagada e não tratada
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner src = new Scanner(System.in);

        System.out.print("Número do quarto:");
        int quarto= src.nextInt();
        System.out.print("Data de Entrada:");
        Date entrada = sdf.parse(src.next());// o parce que exige o tratamento de exceção
        System.out.print("Data de Saída:");
        Date saida = sdf.parse(src.next());
        Reserva reserva = new Reserva(quarto,entrada,saida);

        if(saida.after(entrada)){
            System.out.println("Reserva: "+ reserva);}
        else
            System.out.println("Data de saída incorreta");


        System.out.println();
        System.out.println("Digite os dados para atualizar a reserva");
        System.out.print("Nova data de Entrada:");
        entrada = sdf.parse(src.next());// o parce que exige o tratamento de exceção
        System.out.print("Nova data de Saída:");
        saida = sdf.parse(src.next());
        reserva.atualizarDatas(entrada,saida);

        String erro = reserva.atualizarDatas(entrada,saida);
        if(erro != null){
            System.out.println("Erro na reserva:" + erro);
        }else
            System.out.println("Reserva atualizada: "+ reserva);


    }

}
