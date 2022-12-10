public class Queries {
    public String queries_(String line){
        String out = null;
        if (line.startsWith("q")) {
            String[] sizeOf = line.split(",");
            if (line.contains("best_bid")) {
                while(OrderBook.bid.get(OrderBook.bid.lastKey()) == 0 && OrderBook.bid.size() > 1)
                    OrderBook.bid.remove(OrderBook.bid.lastKey());
                if (OrderBook.bid.get(OrderBook.bid.lastKey()) > 0)
                    out = OrderBook.bid.lastKey() + "," + OrderBook.bid.get(OrderBook.bid.lastKey());
                else out = "0";
            }
            if (line.contains("best_ask")) {
                while(OrderBook.ask.get(OrderBook.ask.firstKey()) == 0 && OrderBook.ask.size() > 1)
                    OrderBook.ask.remove(OrderBook.ask.firstKey());
                if (OrderBook.ask.get(OrderBook.ask.firstKey()) > 0)
                    out = OrderBook.ask.firstKey() + "," + OrderBook.ask.get(OrderBook.ask.firstKey());
                else out = "0";
            }
            if (line.contains("size")) {
                if (OrderBook.bid.containsKey(Integer.parseInt(sizeOf[2]))) {
                    out = String.valueOf(OrderBook.bid.get(Integer.parseInt(sizeOf[2])));
                } else if (OrderBook.ask.containsKey(Integer.parseInt(sizeOf[2]))) {
                    out = String.valueOf(OrderBook.ask.get(Integer.parseInt(sizeOf[2])));
                } else out = "0";
            }
        }
        return out;
    }
}
