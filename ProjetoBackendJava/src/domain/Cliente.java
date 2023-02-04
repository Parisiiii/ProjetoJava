package domain;

public class Cliente {
    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;

    
    public String getNome() {
        return nome;
    }
    public Long getCpf() {
        return cpf;
    }
    public Long getTel() {
        return tel;
    }
    public String getEnd() {
        return end;
    }
    public Integer getNumero() {
        return numero;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente(String nome, String cpf, String tel, String end, String numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        this.numero = Integer.valueOf(numero.trim());
        this.cidade = cidade;
        this.estado = estado;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + "]";
    }


    
}
