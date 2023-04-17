import javax.swing.JOptionPane;

public class ContaBanco {
    public int numConta;
    protected char tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        tipoDaConta();
        JOptionPane.showMessageDialog(null,"Seu saldo bancario é de: R$" + this.saldo + " reais");
    }

    public ContaBanco(){
      this.setSaldo(0);; 
      this.setStatus(false);;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void abrirConta( char tipo){
        
        this.setTipo(tipo);
        this.setStatus(true);
        
        if (tipo == 'c' || tipo == 'C') {
            this.setSaldo(50.00f);
            JOptionPane.showMessageDialog(null,"Conta corrente aberta com sucesso");
        } else if(tipo == 'p' || tipo == 'P') {
            this.setSaldo(150.00f);
        }
    }

    public void fecharConta(){
        if (this.saldo > 0) {
            JOptionPane.showMessageDialog(null, "Retire todo o dinheiro da sua conta");
         }else if(this.saldo < 0) {
            JOptionPane.showMessageDialog(null, "Conta em débito");
         }else {
            JOptionPane.showMessageDialog(null, "Sua Conta foi fechada com sucesso ");
        }

    }

    public void depositar(float valor){
        if (this.status == true) {
            setSaldo(getSaldo() + valor);
        }else{
            JOptionPane.showMessageDialog(null, "Impossivel depositar");
        }
    }

    public void sacar(float valor){
        if (this.getStatus()) {
        if(this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
        }else{
            JOptionPane.showMessageDialog(null, "Impossivel sacar dinheiro");
        }
    }
    }

    public void  pagarMensal(){
         float valor = 0;
        if (this.getTipo() == 'c' || this.getTipo() == 'C') {
           valor = 15.00f;
        } else {
            valor = 20.00f;
        }
        if(this.status == true){
            setSaldo(getSaldo() - valor);
        }else{
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
        }
    }
     
     public void tipoDaConta(){
        if (tipo == 'c' || tipo == 'C') {
            JOptionPane.showMessageDialog(null,"Conta corrente");
        } else if(tipo == 'p' || tipo == 'P') {
            JOptionPane.showMessageDialog(null,"Conta poupança");
        }
     }
}