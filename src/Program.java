import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner src = new Scanner(System.in);

        try {
            System.out.print("Número do quarto:");
            int quarto = src.nextInt();
            System.out.print("Data de Entrada:");
            Date entrada = sdf.parse(src.next());// o parce que exige o tratamento de exceção
            System.out.print("Data de Saída:");
            Date saida = sdf.parse(src.next());
            Reserva reserva = new Reserva(quarto, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite os dados para atualizar a reserva");
            System.out.print("Nova data de Entrada:");
            entrada = sdf.parse(src.next());// o parce que exige o tratamento de exceção
            System.out.print("Nova data de Saída:");
            saida = sdf.parse(src.next());
            reserva.atualizarDatas(entrada, saida);
            System.out.println("Reserva atualizada: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Formato de data inválido");
        }
        catch (ReservaException e){
            System.out.println("Erro na reserva: " +e.getMessage());
            // o getMessege busca a mensagem escrita lá no método da classe Reserva
        }
        catch (RuntimeException e){ // captura qualquer outro erro que não tenha sido levado em conta
            System.out.println("Erro inesperado");
        }



    }

}
