import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileNotFoundException;
import java.io.IOException;
public class MainStart {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext javaConfiguredContext = new AnnotationConfigApplicationContext(OrderBookConfiguration.class);
        OrderBook orderBook = javaConfiguredContext.getBean(OrderBook.class);
        orderBook.lgic();
    }
}
@Configuration
class OrderBookConfiguration{
    @Bean
    public LinesReader linesReader(){return new LinesReader();}
    @Bean
    public LinesWriter linesWriter() throws IOException {return new LinesWriter();}
    @Bean
    public Order order(){return new Order();}
    @Bean
    public Queries queries(){return new Queries();}
    @Bean
    public Update update(){return new Update();}
    @Bean OrderBook orderBook(LinesReader linesReader,
                              LinesWriter linesWriter,
                              Order order,
                              Queries queries,
                              Update update)
    {return new OrderBook(linesReader, linesWriter, order, queries, update);}

}
