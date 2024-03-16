package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clubdeportivo.ClubDeportivo;
import clubdeportivo.ClubException;
import clubdeportivo.Grupo;

public class ClubDeportivoTest {
    ClubDeportivo club;

    @BeforeEach
    void setUp_TAMDefault() throws ClubException{
        // Código para configurar la prueba (número de grupos predeterminado)
        club = new ClubDeportivo("UMA");
    }

    @BeforeEach
    void setUp_NGrupos() throws ClubException{
        // Código para configurar la prueba (número de grupos pasado por parametro)
        club = new ClubDeportivo("UMA", 3);
    }

    @Test
    @DisplayName("Testing create a club with a negative number of groups")
    void createClub_returnsFalseWhenNumbersOfGroupsAreNegative() throws IllegalArgumentException{
        final String nombreClub = "UMA";
        final int tamGrupos = -2;

        assertThrows(ClubException.class, () -> new ClubDeportivo(nombreClub, tamGrupos));
    }

    @Test
    @DisplayName("Testing create a club correctly and verify that both the name of the club and the size of the group list are correct")
    void createClub_Correctly() throws Exception {
        final String nombreClub = "UMA";
        final int tamGrupos = 1;
        
        // Crear el club y asegurar que no se lance ninguna excepción
        assertDoesNotThrow(() -> club = new ClubDeportivo(nombreClub, tamGrupos));

        // Verificar que el nombre del club se establece correctamente
        Field nombre = ClubDeportivo.class.getDeclaredField("nombre");
        nombre.setAccessible(true);
        assertEquals(nombreClub, nombre.get(club)); // Comprueba el valor del campo 'nombre'

        // Verificar que el número de grupos se establece correctamente
        Field grupos = ClubDeportivo.class.getDeclaredField("grupos");
        grupos.setAccessible(true);
        assertEquals(tamGrupos, ((Grupo[])grupos.get(club)).length); // Comprueba el valor del campo 'grupos'
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the data is malformatted")
    void addActivity_IncorrectDataFormat_ThrowsException() throws ClubException {
            // Arrange
        String[] datos = {"Codigo", "Futbol", "diez", "cinco", "diez"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the squares data is malformatted")
    void addActivity_IncorrectSquaresFormat_ThrowsException() throws ClubException {
        String[] datos = {"Codigo", "Futbol", "2.5", "5", "10.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the enrollees data is malformatted")
    void addActivity_IncorrectEnrolleesFormat_ThrowsException() throws ClubException {
        String[] datos = {"Codigo", "Futbol", "2", "5.5", "10.0"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the fare data is malformatted")
    void addActivity_IncorrectFareFormat_ThrowsException() throws ClubException {
        String[] datos = {"Codigo", "Futbol", "2", "5", "10"};

        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when an activity is added with a higher number of enrolments than the available places")
    void addActivity_IncorrectNumberOfSquares() throws ClubException {
        club = new ClubDeportivo("UMA", 3);
        String[] datos = {"Codigo", "Futbol", "10", "11", "10.0"};

        // Verificar que se lanza una excepción al agregar una actividad con más inscripciones que plazas disponibles
        assertThrows(ClubException.class, () -> club.anyadirActividad(datos));
        
    }
    
    @Test
    @DisplayName("Testing add an activity correctly")
    void addActivity_Correctly() throws ClubException, NoSuchFieldException,  NullPointerException, SecurityException,
        IllegalAccessException,  IllegalArgumentException, ExceptionInInitializerError, InaccessibleObjectException {
        Grupo grupo = new Grupo("Codigo", "Futbol", 10, 0, 10.0);

        assertDoesNotThrow(() -> club.anyadirActividad(grupo));

            // Usando reflexión para acceder al campo privado 'ngrupos'
        Field ngruposField = ClubDeportivo.class.getDeclaredField("ngrupos");
        ngruposField.setAccessible(true);
        assertEquals(1, ngruposField.get(club)); // Comprueba el valor del campo 'ngrupos'


        // Assert
        assertThrows(IllegalArgumentException.class, () -> new ClubDeportivo("UMA", -2));
    
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new ClubDeportivo("UMA", -2));
    }
    

    @Test
    @DisplayName("Test to check that the places in an existing group are correctly updated")
    void updateExistingGroup_Success() throws ClubException, NoSuchFieldException,  NullPointerException, SecurityException,
        IllegalAccessException,  IllegalArgumentException, ExceptionInInitializerError, InaccessibleObjectException {
        Grupo grupo1 = new Grupo("Codigo", "Futbol", 10, 0, 10.0);
        Grupo grupo2 = new Grupo("Codigo", "Futbol", 10, 5, 10.0);
        try {
            club.anyadirActividad(grupo1);

            assertDoesNotThrow(() -> club.anyadirActividad(grupo2)); // Aquí se usa el objeto Grupo

            Field ngrupos = ClubDeportivo.class.getDeclaredField("ngrupos");
            ngrupos.setAccessible(true);
            assertEquals(1, ngrupos.get(club)); // Comprueba el valor del campo 'ngrupos'

            Field nmatriculados = Grupo.class.getDeclaredField("nmatriculados");
            nmatriculados.setAccessible(true);
            assertEquals(5, nmatriculados.get(grupo2)); // Comprueba el valor del campo 'nmatriculados' del grupo2

        } catch (ClubException e) {
            fail("No se pudo añadir la actividad para el test: " + e.getMessage());
        }
    }

}
