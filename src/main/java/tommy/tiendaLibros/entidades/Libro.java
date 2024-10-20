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

    public Integer getIdLibro() {
        return idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public Integer getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(Integer cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    public Double getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(Double precioLibro) {
        this.precioLibro = precioLibro;
    }
}
