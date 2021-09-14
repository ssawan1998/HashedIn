package Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Model.Netflix;

public class CSVReader {
    public static List<Netflix> getContent() {
        List<Netflix> shows = null;
        final String DELIMITER;
        DELIMITER = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\swatantra sawan\\Assigment\\src\\App_Data\\netflix_titles.csv"))) {
            Stream<String> lines = br.lines();

            shows = lines.skip(1).map(line -> {
                String[] record = line.split(DELIMITER);
                if(record.length==11) {
                    List<String> countries = CustomSplit.mySplit(record[5]);
                    List<String> genre = CustomSplit.mySplit(record[10]);

                    Date date = null;

                    if (!record[6].isEmpty()) {
                        try {
                            String pattern = "";
                            if (record[6].charAt(1) == ' ') {
                                record[6] = "\"" + record[6].substring(2);
                                pattern = "\"MMMM dd, yyyy\"";
                            } else {
                                pattern = "\"MMMM dd, yyyy\"";
                            }
                            date = new SimpleDateFormat(pattern).parse(record[6]);
                        } catch (ParseException e) {
                            e.printStackTrace();

                        }
                    }

                    Set<String> countySet = countries.stream().collect(Collectors.toCollection(HashSet::new));
                    Set<String> listedIn = genre.stream().collect(Collectors.toCollection(HashSet::new));


                    return new Netflix(
                            record[0],
                            record[1],
                            record[2],
                            record[3],
                            record[4],
                            countySet,
                            date,
                            record[7],
                            record[8],
                            record[9],
                            listedIn,
                            record[11]
                    );
                }
                return null;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shows;
    }
    public static Date convertDate(String date) {
        Date resultDate = null;
        try {
            resultDate = new SimpleDateFormat("MMMM dd, yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("Incorrect Date: "+e.getMessage());
            e.printStackTrace();
        }
        return resultDate;
    }



}
