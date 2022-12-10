import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class OrderBook {
    private LinesReader linesReader;
    private LinesWriter linesWriter;
    private Order order;
    private Queries queries;
    private  Update update;
    static TreeMap<Integer, Integer> bid;
    static TreeMap<Integer, Integer> ask;

    public OrderBook(@Autowired LinesReader linesReader,
                     @Autowired LinesWriter linesWriter,
                     @Autowired Order order,
                     @Autowired Queries queries,
                     @Autowired Update update) {
        this.linesReader = linesReader;
        this.linesWriter = linesWriter;
        this.order = order;
        this.queries = queries;
        this.update = update;
    }
    public void lgic() throws FileNotFoundException {
        bid = new TreeMap<>();
        ask = new TreeMap<>();
        Scanner sc = new Scanner(linesReader.ReadLine());
        do {
            String line = sc.nextLine();
            update.update_(line);
            if(queries.queries_(line) != null)
                linesWriter.LineOut(queries.queries_(line));
            order.order_(line);
        }while(sc.hasNextLine());
        linesWriter.OutPutClose();
    }
}