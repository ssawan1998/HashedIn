import java.util.List;
import java.util.Scanner;
import java.util.Set;
import Model.Netflix;
import Services.SelectShow;
import Util.CSVReader;

public class Program {
    public  static void main(String args[]){
        List<Netflix> content = CSVReader.getContent();
        SelectShow cs = new SelectShow();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(true) {
            System.out.println("########### Welcome to Netfilx content search ##########");
            System.out.println("Search by options below:\n1. Search by content type\n2. Search by listed_in (genre)\n3. Search by content type and country\n4. Exit");
            choice = Integer.parseInt(sc.nextLine());
            if(choice == 4) break;
            System.out.println("How many records do you want in the output?: ");
            int limit = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter the Date range you want to search for:");
            System.out.println("Start Date: ");
            String startDate = sc.nextLine();
            System.out.println("End Date: ");
            String endDate = sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter type of the content (eg. TV show/Movie): ");
                    String type = sc.nextLine();
                    cs.getByType(content, type, startDate, endDate, limit);
                    break;

                case 2:
                    System.out.println("Enter the genre of the content (eg. Horror Movies): ");
                    String genre = sc.nextLine();
                    cs.getByListed(content, genre, startDate, endDate, limit);
                    break;

                case 3:
                    System.out.println("Enter the country and the type of the content: (eg. Type = Movie, Country = India):");
                    System.out.println("Country: ");
                    String country = sc.nextLine();
                    System.out.println("Type:");
                    String type1 = sc.nextLine();
                    cs.getByCountry(content, type1, country,startDate, endDate, limit);
            }
        }


    }
}

