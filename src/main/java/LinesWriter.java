import java.io.*;

public class LinesWriter {
    PrintWriter output = new PrintWriter(new FileWriter("output.txt"));
    public LinesWriter() throws IOException {
    }
    public void LineOut(String line){
        output.println(line);
    }
    protected void OutPutClose(){
        output.close();
    }
}
