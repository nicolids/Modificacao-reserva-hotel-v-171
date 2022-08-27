import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numQuarto;
    private Date entrada;
    private Date saida;

    public Reserva() {
    }

    public Reserva(Integer numQuarto, Date entrada, Date saida) throws ReservaException {
    // sempre bom já tratar exceções no começo do método
        if( !saida.after(entrada)){
            throw new ReservaException("A data de saída deve ser posterior a data de entrada.");
        }
        this.numQuarto = numQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }
    //Método que cálcula a diferença em milisegundos e depois converte para dias
    //
    public long duracao(){
        long diferenca = saida.getTime() - entrada.getTime();
        return  TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date entrada,Date saida) throws ReservaException {
        //lanço a exceção no método para ser tratar no Principal pelo catch
        Date agora=new Date(); // a reserva só pode ser alterada para datas futuras
        if(entrada.before(agora)){
            //trata o uso de argumentos inválidos para chamar ela fazer um catch no Programa
           throw new ReservaException("Datas de atualização devem ser futuras.");}
        if (!saida.after(entrada)){
            throw new ReservaException("Data de saída incorreta, deve ser escolhida uma data posterior a de entrada.");}
        this.entrada = entrada;
        this.saida = saida;
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public String toString() {
        return "Reserva{" +
                "Numero do Quarto= " + numQuarto +
                ", data de entrada=" + sdf.format(entrada) +
                ", data de saída=" + sdf.format(saida) +" "+
                duracao()+ " noites"+
                '}';
    }


}
