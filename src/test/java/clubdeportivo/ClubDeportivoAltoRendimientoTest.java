package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * @author1: Manuel Fuentes Vida
 * @author2: Jose Antonio Casado Molina
 * @author3: Clemente Cano Mengíbar
 */

class ClubDeportivoAltoRendimientoTest {
    
    @Test
    @DisplayName("The constructor that doesn't receive the parameter tam works correctly")
    public void newClubDeportivoAltoRendimientoWithoutTam_createdCorrectly() throws ClubException{
        String nombre = "UMA";
        int maximo = 10;
        double incremento = 0.1;
        String expected = "UMA --> [  ]";

        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento(nombre, maximo, incremento);

        assertEquals(expected, club.toString());
    }

    @Test
    @DisplayName("The constructor that doesn't receive the parameter tam with maximo with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithoutTam_NegativeMaximo_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = -10;
        double incremento = 0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    @DisplayName("The constructor that doesn't receive the parameter tam with the increment with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithoutTam_NegativeIncremento_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = 10;
        double incremento = -0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    @DisplayName("The constructor that receives the parameter tam, works correctly")
    public void newClubDeportivoAltoRendimientoWithTam_createdCorrectly() throws ClubException{
        String nombre = "UMA";
        int tam = 8;
        int maximo = 10;
        double incremento = 0.1;
        String expected = "UMA --> [  ]";

        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento);

        assertEquals(expected, club.toString());
    }

    @Test
    @DisplayName("The constructor that receives the parameter tam with maximo with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithTam_NegativeMaximo_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = -10;
        int tam = 10;
        double incremento = 0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("The constructor that receives the parameter tam with the increment with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithTam_NegativeIncremento_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int tam = 10;
        int maximo = 10;
        double incremento = -0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("The constructor that receives the parameter tam with the increment with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithTam_withZeroMaximo_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int tam = 10;
        int maximo = 0;
        double incremento = 0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("The constructor that receives the parameter tam with the increment with negative value returns a exception")
    public void newClubDeportivoAltoRendimientoWithTam_withZeroIncremento_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int tam = 10;
        int maximo = 10;
        double incremento = 0;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("Add a activity works correctly")
    public void anyadirActividad_shouldWorksCorrectly() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8", "75.0"};
        String result = "UMA --> [ (1234 - Futbol - 75.0 euros - P:10 - M:8) ]";

        club.anyadirActividad(datos);
        
        assertEquals(club.toString(), result);
    }

    @Test
    @DisplayName("Add a activity without the enough data returns a exception")
    public void anyadirActividad_withInsufficientData_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Add a activity with the number of places with a bad format returns a exception")
    public void anyadirActividad_withIncorrectFormatSquare_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10.2", "8", "75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Add a activity with the number of enrolled with a bad format returns a exception")
    public void anyadirActividad_withIncorrectFormatNEnrolled_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8.5", "75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Add a activity with the fee with a bad format returns a excpetion")
    public void anyadirActividad_withIncorrectFormatFee_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8", "-75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Add a activity with the number of places greater than the max works correctly")
    public void anyadirActividad_withMoreSquaresThanMaximo_shouldWorksCorrectly() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "15", "8", "75.0"};
        String result = "UMA --> [ (1234 - Futbol - 75.0 euros - P:10 - M:8) ]";

        club.anyadirActividad(datos);
        
        assertEquals(club.toString(), result);
    }

    @Test
    @DisplayName("Calculate the revenue works correctly")
    public void ingresos_shouldWorksCorrectly() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8", "50.0"};
        club.anyadirActividad(datos);
        double matriculados = 8;
        double tarifa = 50;
        double cantidad = matriculados * tarifa;
        double expected = cantidad + cantidad*(0.1/100);

        double result = club.ingresos();

        assertEquals(expected, result);
    }
}