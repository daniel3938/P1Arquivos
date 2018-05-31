import java.io.RandomAccessFile;

public class Questaoum{
 
    public static void main(String args[]) throws Exception 
    {
       	RandomAccessFile f = new RandomAccessFile("arq1.dat", "r");
        RandomAccessFile g = new RandomAccessFile("arq2.dat", "rw");
    	Registro r = new Registro();
        long tamanhof = (f.length()/100);
        long i,j=0;
        
        for (i=tamanhof;i>0;i--) {
        	f.seek((i-1)*100);
        	r.leRegistro(f);
        	g.seek(j*100);
        	r.escreveRegistro(g);
        	j++;
        }
        f.close();
        g.close();
    }
}