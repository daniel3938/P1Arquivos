import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.charset.Charset;
 
public class Registro {
     
    private String chave;
    private String nome;
    private String email;
    private String telefone;
 
    public void leRegistro(DataInput din) throws IOException
    {
        byte chave[] = new byte[8];
        byte nome[] = new byte[40];
        byte email[] = new byte[40];
        byte telefone[] = new byte[12];
         
        din.readFully(chave);
        din.readFully(nome);
        din.readFully(email);
        din.readFully(telefone);
                
        Charset enc = Charset.forName("ISO-8859-1");
         
        this.chave = new String(chave,enc);
        this.nome = new String(nome,enc);
        this.email = new String(email,enc);
        this.telefone = new String(telefone,enc);
    }
    
    public void escreveRegistro(DataOutput dout) throws IOException
    {       
        Charset enc = Charset.forName("ISO-8859-1");
        dout.write(this.chave.getBytes(enc));
        dout.write(this.nome.getBytes(enc));
        dout.write(this.email.getBytes(enc));
        dout.write(this.telefone.getBytes(enc));
    }
	
    public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
     
  
}