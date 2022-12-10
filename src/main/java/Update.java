public class Update {
    public void update_(String line) {
        if (line.startsWith("u")) {
            String[] numbs = line.split(",");
            if (line.contains("bid")) {
                OrderBook.bid.put(Integer.parseInt(numbs[1]), Integer.parseInt(numbs[2]));
            }
            if (line.contains("ask")) {
                OrderBook.ask.put(Integer.parseInt(numbs[1]), Integer.parseInt(numbs[2]));
            }
        }
    }
}
