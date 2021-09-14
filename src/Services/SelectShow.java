package Services;
import java.util.Set;
import Model.Netflix;
import Util.CSVReader;

import java.util.List;

public class SelectShow {
    public void getByType(List<Netflix> content, String type, String startDate, String endDate, int limit) {
        long start = System.currentTimeMillis();
        int i = 1;
        boolean flag = true;
        if(CSVReader.convertDate(endDate).before(CSVReader.convertDate(startDate))) {
            System.out.println("Incorrect Range of Dates");
            return;
        }
        for(Netflix n: content) {
            if(n.getType().equals(type) && n.getDateAdded() != null && n.getDateAdded().after(CSVReader.convertDate(startDate)) && n.getDateAdded().before(CSVReader.convertDate(endDate))) {
                System.out.println(n);
                i++;
            }
            if(i == limit) break;
        }
        if(flag) {
            System.out.println("No records found");
            return;
        }
        long end = System.currentTimeMillis();
        System.out.println("RECORDS: "+i+ "\t\tTIME: "+(end - start)+"ms");
    }
    public void getByCountry(List<Netflix> content, String type, String country, String startDate, String endDate, int limit) {
        long start = System.currentTimeMillis();
        int i = 1;
        boolean flag = true;
        if(CSVReader.convertDate(startDate).before(CSVReader.convertDate(endDate))) {
            System.out.println("Incorrect Range of Dates");
            return;
        }
        for(Netflix n: content) {
            Set<String> countries = n.getCountry();
            if(countries.contains(country) && n.getType().equals(type) && n.getDateAdded() != null && n.getDateAdded().after(CSVReader.convertDate(startDate)) && n.getDateAdded().before(CSVReader.convertDate(endDate))) {
                System.out.println(n);
                i++;
            }
            if(i == limit) break;
        }
        if(flag) {
            System.out.println("No records found");
            return;
        }
        long end = System.currentTimeMillis();
        System.out.println("RECORDS: "+i+ "\t\tTIME: "+(end - start)+"ms");
    }
    public void getByListed(List<Netflix> content, String inListed, String startDate, String endDate, int limit) {
        long start = System.currentTimeMillis();
        int i = 1;
        if(CSVReader.convertDate(startDate).before(CSVReader.convertDate(endDate))) {
            System.out.println("Incorrect Range of Dates");
            return;
        }
        boolean flag = true;
        for(Netflix n: content) {
            Set<String> genre = n.getListedIn();
            if(genre.contains(inListed) && n.getDateAdded() != null && n.getDateAdded().after(CSVReader.convertDate(startDate)) && n.getDateAdded().before(CSVReader.convertDate(endDate))) {
                flag = false;
                System.out.println(n);
                i++;
            }
            if(i == limit) break;
        }
        if(flag) {
            System.out.println("No records found");
            return;
        }
        long end = System.currentTimeMillis();
        System.out.println("RECORDS: "+i+ "\t\tTIME: "+(end - start)+"ms");
    }

}
