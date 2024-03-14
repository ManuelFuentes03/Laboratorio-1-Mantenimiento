package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import clubdeportivo.ClubDeportivo;

/*
 * @author Jose Antonio Casado Molina
 */

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
    void createClub_returnsFalseWhenNumbersOfGroupsAreNegative(){
        // Test para comprobar si al crear un club con un numero negativo de grupos salta la excepción correspondiente

        // Assert
        assertThrows(IllegalArgumentException.class, () -> new ClubDeportivo("UMA", -2));
    }

    @Test
    @DisplayName("Testing find a group in a club")
    void searchGroup_InClub_ReturnsIndexInListOfGroups() throws ClubException{
        // Test para buscar un grupo en un club, deberá devolver el índice de la lista de grupos donde se encuentre

        // Arrange
        ClubDeportivo club = new ClubDeportivo("UMA", 8);

        // Act
        

        // Assert
        assertThrows(IllegalArgumentException.class, () -> new ClubDeportivo("UMA", -2));
    }


}