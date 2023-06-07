package usuarios;

public interface IUsuario {
    public String getNome();
    public void setNome(String nome);
    public String getEmail();
    public void setEmail(String email);
    public String getTelefone();
    public void setTelefone(String telefone);
    public String toString();
}