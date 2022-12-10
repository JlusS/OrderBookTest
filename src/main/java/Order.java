public class Order {
    public void order_(String line){
        if (line.startsWith("o")) {
            String[] sizeOf = line.split(",");
            int numb = Integer.parseInt(sizeOf[2]);
            if (line.contains("buy")) {
                while (numb > OrderBook.ask.get(OrderBook.ask.firstKey())) {
                    numb = numb - OrderBook.ask.get(OrderBook.ask.firstKey());
                    OrderBook.ask.remove(OrderBook.ask.firstKey());
                }
                OrderBook.ask.put(OrderBook.ask.firstKey(), OrderBook.ask.get(OrderBook.ask.firstKey()) - numb);
            }
            if (line.contains("sell")) {
                while (numb > OrderBook.bid.get(OrderBook.bid.lastKey())) {
                    numb = numb - OrderBook.bid.get(OrderBook.bid.lastKey());
                    OrderBook.bid.remove(OrderBook.bid.lastKey());
                }
                OrderBook.bid.put(OrderBook.bid.lastKey(), OrderBook.bid.get(OrderBook.bid.lastKey()) - numb);
            }
        }
    }

}
