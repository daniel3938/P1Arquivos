import java.io.RandomAccessFile;

public class Questaotres{
 
    public static void main(String args[]) throws Exception 
    {
       	RandomAccessFile f = new RandomAccessFile("arq1.dat", "r");
        RandomAccessFile g = new RandomAccessFile("arq2.dat", "r");
        RandomAccessFile h = new RandomAccessFile("arq3.dat", "rw");
    	Registro r = new Registro();
    	Registro s = new Registro();
        long tamanhof = (f.length()/100);
        long tamanhog = (g.length()/100);
        long i;
        String c,d;
        int a,b;
        
        for (i=0;i<tamanhof;i++) {
        	f.seek(i*100);
        	r.leRegistro(f);
        	c = r.getChave();
        	a = Integer.parseInt(c);
        	        	
        	g.seek(0);
        	long primeiro = g.getFilePointer();
        
        	g.seek((tamanhog-1)*100);
        	long ultimo = g.getFilePointer();
        
        	g.seek((((ultimo/100)-(primeiro/100))/2)*100);
        	long meio = g.getFilePointer();
        	
        	do 
        	{
        		g.seek(meio);
        		s.leRegistro(g);
        		d = s.getChave();
        		b = Integer.parseInt(d);
        		
        		if (a == b) 
        		{
        			s.escreveRegistro(h);
        			break;
        		}
        		if (a < b)
        			ultimo = meio-100;
        		else if (a > b)
        			primeiro = meio+100;
        		
        		meio = (((primeiro+ultimo)/100)/2)*100;
        	} while (primeiro <= ultimo);
        }
        f.close();
        g.close();
        h.close();
    }
}    