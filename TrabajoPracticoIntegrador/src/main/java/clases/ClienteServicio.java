package clases;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ClienteServicio {
    private int cuit;
    private int servicioId;
    private Date fechaIcontratacion;
}
