package tommy.tiendaLibros.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idLibro;
    String nombreLibro;
    String autorLibro;
    Double precioLibro;
    Integer cantidadLibro;
}
