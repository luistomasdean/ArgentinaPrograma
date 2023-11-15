package clases;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Cliente {
    private int cuil;
    private String razonSocial;

    private String mail;

    public Cliente() {
    }


    public Cliente(int cuil, String razonSocial, String mail) {
        this.razonSocial = razonSocial;
        this.cuil = cuil;
        this.mail = mail;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cuil == cliente.cuil;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cuil=" + cuil +
                ", razonSocial='" + razonSocial + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
