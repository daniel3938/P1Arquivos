import java.io.RandomAccessFile;

public class Questaodois{
 
    public static void main(String args[]) throws Exception 
    {
       	RandomAccessFile f = new RandomAccessFile("arq1.dat", "r");
        RandomAccessFile g = new RandomAccessFile("arq2.dat", "rw");
    	Registro r = new Registro();
        long tamanhof = (f.length()/100);
        long i;
        String s;
        
        for (i=0;i<tamanhof;i++) {
        	f.seek(i*100);
        	r.leRegistro(f);
        	s = r.getEmail();
        	if (terminaCom(s,"gmail.com")) {
        		r.escreveRegistro(g);
        	}
        }
        f.close();
        g.close();
    }
    public static boolean terminaCom(String s, String t) {
    	String g[] = s.split(" ");
    	
    	if (g[0].length() <= t.length()) {
    		return false;
    	}
    	else if(g[0].substring(g[0].length() - t.length()).equals(t)) 
    			return true;
      	return false;
    }
}    