package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClubDeportivoAltoRendimientoTest {
    
    @Test
    @DisplayName("El constructor que no recibe el parámetro tam funciona bien")
    public void newClubDeportivoAltoRendimientoWithoutTam_createdCorrectly() throws ClubException{
        String nombre = "UMA";
        int maximo = 10;
        double incremento = 0.1;
        String expected = "UMA --> [  ]";

        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento(nombre, maximo, incremento);

        assertEquals(expected, club.toString());
    }

    @Test
    @DisplayName("El constructor que no recibe el parámetro tam con el maximo con valor negativo devuelve una excepción")
    public void newClubDeportivoAltoRendimientoWithoutTam_NegativeMaximo_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = -10;
        double incremento = 0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    @DisplayName("El constructor que no recibe el parámetro tam con el incremento con valor negativo devuelve una excepción")
    public void newClubDeportivoAltoRendimientoWithoutTam_NegativeIncremento_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = 10;
        double incremento = -0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre, maximo, incremento));
    }

    @Test
    @DisplayName("El constructor que recibe el parámetro tam funciona bien")
    public void newClubDeportivoAltoRendimientoWithTam_createdCorrectly() throws ClubException{
        String nombre = "UMA";
        int tam = 20;
        int maximo = 10;
        double incremento = 0.1;
        String expected = "UMA --> [  ]";

        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento);

        assertEquals(expected, club.toString());
    }

    @Test
    @DisplayName("El constructor que no recibe el parámetro tam con el maximo con valor negativo devuelve una excepción")
    public void newClubDeportivoAltoRendimientoWithTam_NegativeMaximo_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int maximo = -10;
        int tam = 20;
        double incremento = 0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("El constructor que no recibe el parámetro tam con el incremento con valor negativo devuelve una excepción")
    public void newClubDeportivoAltoRendimientoWithTam_NegativeIncremento_ThrowsException() throws ClubException{
        String nombre = "UMA";
        int tam = 20;
        int maximo = 10;
        double incremento = -0.1;

        assertThrows(ClubException.class, () -> new ClubDeportivoAltoRendimiento(nombre,tam, maximo, incremento));
    }

    @Test
    @DisplayName("Añadir una actividad debe funcionar bien")
    public void anyadirActividad_shouldWorksCorrectly() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8", "75.0"};
        String result = "UMA --> [ (1234 - Futbol - 75.0 euros - P:10 - M:8) ]";

        club.anyadirActividad(datos);
        
        assertEquals(club.toString(), result);
    }

    @Test
    @DisplayName("Añadir una actividad sin los datos suficientes debe devolver una excepción")
    public void anyadirActividad_withInsufficientData_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Añadir una actividad con el número de plazas con un mal formato debe devolver una excepción")
    public void anyadirActividad_withIncorrectFormatSquare_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10.2", "8", "75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Añadir una actividad con el número de matriculados con un mal formato debe devolver una excepción")
    public void anyadirActividad_withIncorrectFormatNEnrolled_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8.5", "75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Añadir una actividad con el número de matriculados con un mal formato debe devolver una excepción")
    public void anyadirActividad_withIncorrectFormatFee_returnException() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "10", "8", "-75.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Añadir una actividad con un número de plazas mayor al máximo debe funcionar")
    public void anyadirActividad_withMoreSquaresThanMaximo_shouldWorksCorrectly() throws ClubException{
        ClubDeportivoAltoRendimiento club = new ClubDeportivoAltoRendimiento("UMA", 10, 0.1);
        String[] datos = {"1234", "Futbol", "15", "8", "75.0"};
        String result = "UMA --> [ (1234 - Futbol - 75.0 euros - P:10 - M:8) ]";

        club.anyadirActividad(datos);
        
        assertEquals(club.toString(), result);
    }

    @Test
    @DisplayName("Calcular los ingresos debe funcionar correctamente")
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