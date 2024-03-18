import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateInputFile {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("input.txt"))) {
            writer.println("A,Ford,2016,4200");
            writer.println("A,Ford,2016,44300");
            writer.println("A,Mazda,1998,21300");
            writer.println("A,BMW,2008,32100");
            writer.println("A,Volkswagen,2009,23200");
            writer.println("A,Audi,1994,21200");
            writer.println("D,Audi,1994");
            writer.println("A,Peugeot,1992,19200");
            writer.println("A,Cadillac,1989,14500");
            writer.println("A,Mini,1965,25400");
            writer.println("A,Suzuki,1981,25700");
            writer.println("A,Jaguar,1988,8200");
            writer.println("A,Infiniti,1966,26200");
            writer.println("A,Fiat,2013,26100");
            writer.println("A,Chevrolet,2015,29700");
            writer.println("A,Suzuki,1999,21400");
            writer.println("A,Volvo,2004,9500");
            writer.println("A,Lexus,1989,29000");
            writer.println("A,Mitsubishi,2006,22300");
            writer.println("A,Cadillac,1982,25400");
            writer.println("A,Mini,2010,18500");
            writer.println("A,Suzuki,1973,23800");
            writer.println("A,Jaguar,1969,29200");
            writer.println("A,Infiniti,1974,28000");
            writer.println("A,Fiat,1972,16500");
            writer.println("A,Chevrolet,1977,27200");
            writer.println("A,Suzuki,2002,26100");
            writer.println("A,Volvo,1963,16100");
            writer.println("A,Lexus,2005,7000");
            writer.println("A,Mitsubishi,1989,7700");
            writer.println("D,Infiniti,1966");
            writer.println("D,Fiat,2013");
            writer.println("D,Chevrolet,2015");
            writer.println("D,Suzuki,1999");
            writer.println("D,Volvo,2004");
            writer.println("D,Lexus,1989");
            writer.println("D,Mitsubishi,2006");
            writer.println("D,Cadillac,1982");
            writer.println("D,Mini,2010");
            writer.println("A,Kia,2007,4000");
            writer.println("A,Honda,2009,10000");
            writer.println("A,Toyota,1999,1800");
            writer.println("D,Kia,2007");
            writer.println("D,Toyota,2000");

            System.out.println("Input file 'input.txt' created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating the input file.");
            e.printStackTrace();
        }
    }
}