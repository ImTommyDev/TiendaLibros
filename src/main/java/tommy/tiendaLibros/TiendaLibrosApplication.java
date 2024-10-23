package tommy.tiendaLibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import tommy.tiendaLibros.interfazUsuario.FormularioInicioSesion;
import tommy.tiendaLibros.interfazUsuario.FormularioLibro;

import java.awt.*;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contextoString = new SpringApplicationBuilder(TiendaLibrosApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE)
				.run(args);

		EventQueue.invokeLater(() ->{
			//Obtengo el objeto formulario a través de spring
			FormularioInicioSesion formularioInicioSesion = contextoString.getBean(FormularioInicioSesion.class);
			formularioInicioSesion.setVisible(true);
		});

	}

}
