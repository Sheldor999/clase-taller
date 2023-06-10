package ubilapaz.edu.bo.clasetaller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DescuentoDto {
    public String nombre;
    public String cod;
    public Double precio;
    public Double descuento;

    public DescuentoDto() {

    }
}
