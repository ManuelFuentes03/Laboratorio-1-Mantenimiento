package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClubDeportivoTest {
    ClubDeportivo club;

    @BeforeEach
    void setUp_TAMDefault() throws Exception{
        club = new ClubDeportivo("UMA");
    }

    @BeforeEach
    void setUp_NGrupos() throws Exception{
        club = new ClubDeportivo("UMA", 3);
    }

    @Test
    @DisplayName("Test create a club with a negative number of groups")
    void createClub_throwsExceptionWhen_NumbersOfGroupsNegative() throws Exception{
        final String clubName = "UMA";
        final int groupSize = -2;

        assertThrows(ClubException.class, () -> new ClubDeportivo(clubName, groupSize));
    }

    @Test
    @DisplayName("Test that when creating a club with a number of groups greater than the maximum size, it throws the exception correctly")
    void createClub_throwsExceptionWhen_NumbersOfGroupsGreaterThanTAM() throws Exception{
        final String clubName = "UMA";
        final int groupSize = 11;

        assertThrows(ClubException.class, () -> new ClubDeportivo(clubName, groupSize));
    }

    @Test
    @DisplayName("Test create a club correctly and verify that both the name of the club and the size of the group list are correct")
    void createClub_Correctly() throws Exception {
            // Arrange
        final String clubName = "UMA";
        final int groupSize = 1;

            // Arrange & Act
                // Crear el club y asegurar que no se lance ninguna excepción
        assertDoesNotThrow(() -> club = new ClubDeportivo(clubName, groupSize));

            // Assert
        assertEquals(club.toString(), "UMA --> [  ]");

    }

    @Test
    @DisplayName("Test add an activity correctly")
    void addActivity_Correctly() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "12", "5", "10.0"};

            // Act 
        club.anyadirActividad(data);
            // Assert
        assertEquals("UMA --> [ (Code - Football - 10.0 euros - P:12 - M:5) ]", club.toString());
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the data is malformatted")
    void addActivity_IncorrectDataFormat_ThrowsException() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "ten", "five", "ten"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));

    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the squares data is malformatted")
    void addActivity_IncorrectSquaresFormat_ThrowsException() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "12.5", "5", "10.0"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the enrollees data is malformatted")
    void addActivity_IncorrectEnrolleesFormat_ThrowsException() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "12", "5.5", "10.0"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when the fare data is malformatted")
    void addActivity_IncorrectFareFormat_ThrowsException() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "12", "5", "ab"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));
    }

    @Test
    @DisplayName("Test to verify that an exception is thrown when an activity is added with a higher number of enrolments than the available places")
    void addActivity_IncorrectNumberOfPlaces() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "10", "11", "10.0"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));
        
    }

    @Test
    @DisplayName("Test to verify that adding an activity with insufficient data throws the correct exception")
    void addActivity_IncorrectDataLength() throws Exception {
            // Arrange
        String[] data = {"Code", "Football", "10", "11"};

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(data));
        
    }
    
    
    @Test
    @DisplayName("Test add an activity correctly")
    void addActivity_Correctly_Places() throws Exception {
            // Arrange
        Grupo group = new Grupo("Code", "Football", 10, 0, 10.0);

            // Act & Assert
        assertDoesNotThrow(() -> club.anyadirActividad(group));

        assertEquals("UMA --> [ (Code - Football - 10.0 euros - P:10 - M:0) ]", club.toString());
    }

    @Test
    @DisplayName("Test add an activity correctly")
    void addActivity_Correctly_Enrollees() throws Exception {
            // Arrange
        Grupo group = new Grupo("Code", "Football", 10, 7, 10.0);

            // Act & Assert
        assertDoesNotThrow(() -> club.anyadirActividad(group));

        assertEquals("UMA --> [ (Code - Football - 10.0 euros - P:10 - M:7) ]", club.toString());
    }

    @Test
    @DisplayName("Test add an activity correctly")
    void addActivity_Correctly_Fare() throws Exception {
            // Arrange
        Grupo group = new Grupo("Code", "Football", 10, 7, 12.0);

            // Act & Assert
        assertDoesNotThrow(() -> club.anyadirActividad(group));

        assertEquals("UMA --> [ (Code - Football - 12.0 euros - P:10 - M:7) ]", club.toString());
    }

    @Test
    @DisplayName("Test add an activity in a null group")
    void addActivity_NullGroup() throws Exception {
            // Arrange
        Grupo group = null;

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(group));
    }

    @Test
    @DisplayName("Test to check that the places in an existing group are correctly updated")
    void updateExistingGroup_Success() throws Exception {
            // Arrange
        Grupo group1 = new Grupo("Code", "Football", 10, 0, 10.0);
        Grupo group2 = new Grupo("Code", "Football", 20, 0, 10.0);

            // Act & Assert
        assertDoesNotThrow(() -> club.anyadirActividad(group1));
        assertDoesNotThrow(() -> club.anyadirActividad(group2));

            // Arrange
        assertEquals("UMA --> [ (Code - Football - 10.0 euros - P:20 - M:0) ]", club.toString());

    }

    @Test
    @DisplayName("Test that adding a new group to a club whose number of groups is the maximum size triggers the correct exception")
    void addActivity_Limit_Groups() throws Exception {
            // Arrange
        club = new ClubDeportivo("UMA");
        Grupo group1 = new Grupo("Code", "Football", 10, 10, 10.0);
        Grupo group2 = new Grupo("Code", "Basketball", 20, 18, 20.0);
        Grupo group3 = new Grupo("Code", "Tennis", 8, 5, 40.0);
        Grupo group4 = new Grupo("Code", "Volleyball", 20, 10, 15.0);
        Grupo group5 = new Grupo("Code", "Golf", 15, 4, 55.0);
        Grupo group6 = new Grupo("Code", "Rugby", 30, 16, 16.0);
        Grupo group7 = new Grupo("Code", "Athletics", 40, 20, 7.0);
        Grupo group8 = new Grupo("Code", "Baseball", 20, 11, 14.0);
        Grupo group9 = new Grupo("Code", "Swimming", 40, 13, 9.0);
        Grupo group10 = new Grupo("Code", "Cricket", 15, 2, 17.0);

        assertDoesNotThrow(() -> club.anyadirActividad(group1));
        assertDoesNotThrow(() -> club.anyadirActividad(group2));
        assertDoesNotThrow(() -> club.anyadirActividad(group3));
        assertDoesNotThrow(() -> club.anyadirActividad(group4));
        assertDoesNotThrow(() -> club.anyadirActividad(group5));
        assertDoesNotThrow(() -> club.anyadirActividad(group6));
        assertDoesNotThrow(() -> club.anyadirActividad(group7));
        assertDoesNotThrow(() -> club.anyadirActividad(group8));
        assertDoesNotThrow(() -> club.anyadirActividad(group9));
        assertDoesNotThrow(() -> club.anyadirActividad(group10));

        Grupo group11 = new Grupo("Code", "Ski", 5, 2, 35.0);

            // Act & Assert
        assertThrows(ClubException.class, () -> club.anyadirActividad(group11));
    }

    @Test
    @DisplayName("Test check the correct number of free places")
    void testFreePlaces_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 1);
        Grupo group1 = new Grupo("Code", "Football", 10, 0, 10.0);
        club.anyadirActividad(group1);

            // Act
        int result = club.plazasLibres("Football");
        
            // Assert
        assertEquals(group1.plazasLibres(), result);
    }

    @Test
    @DisplayName("Test check the correct number of free places")
    void testFreePlaces_MultipleGroups_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 2);
        Grupo group1 = new Grupo("Code", "Football", 10, 0, 10.0);
        Grupo group2 = new Grupo("Code", "Football", 5, 0, 10.0);
        club.anyadirActividad(group1);
        club.anyadirActividad(group2);

            // Act
        int result = club.plazasLibres("Football");
        
            // Assert
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test free places with no matching activity")
    void testFreePlaces_NoMatchingActivity_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 1);
        Grupo group = new Grupo("Code", "Football", 10, 0, 10.0);
        club.anyadirActividad(group);

            // Act
        int result = club.plazasLibres("Basketball");
        
            // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test free places with empty groups")
    void testFreePlaces_EmptyGroups_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 1);

            // Act
        int result = club.plazasLibres("Football");
        
            // Assert
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test that the correct exception is made when there are not enough free places for that activity in the club")
    void registerPeople_NotEnoughFreePlaces() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 9, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertThrows(ClubException.class, () -> club.matricular("Football", 3));
    }

    @Test
    @DisplayName("Test that register is made correctly when there are free places")
    void registerPeople_NotEnoughFreePlacesClub() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group1 = new Grupo("Code", "Football", 10, 5, 10.0);
        Grupo group2 = new Grupo("Code", "Basketball", 20, 15, 25.0);
        Grupo group3 = new Grupo("Code", "Tennis", 5, 1, 40.0);
        club.anyadirActividad(group1);
        club.anyadirActividad(group2);
        club.anyadirActividad(group3);

            // Act 
        club.matricular("Football", 5);
        club.matricular("Basketball", 5);
        club.matricular("Tennis", 4);

            //Assert
        assertEquals("UMA --> [ (Code - Football - 10.0 euros - P:10 - M:10), (Code - Basketball - 25.0 euros - P:20 - M:20), (Code - Tennis - 40.0 euros - P:5 - M:5) ]", club.toString());
    }

    @Test
    @DisplayName("Test that the exception is correctly launched when more people enroll than available places")
    void registerPeople_MorePlaces_Than_Available_Places() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 0, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertThrows(ClubException.class, () -> club.matricular("Football", 11));
    }

    @Test
    @DisplayName("Test that a person registers in an activity correctly")
    void registerAPerson_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 5, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertDoesNotThrow(() -> club.matricular("Football", 1));
    }

    @Test
    @DisplayName("Test that people registers in an activity correctly")
    void registerPeople_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 5, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertDoesNotThrow(() -> club.matricular("Football", 3));
    }

    @Test
    @DisplayName("Test that no one register in an activity correctly")
    void registerNoOne_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 5, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertDoesNotThrow(() -> club.matricular("Football", 0));
    }

    @Test
    @DisplayName("Test register a person in a non-existent activity")
    void registerPerson_NonExistentActivity() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group = new Grupo("Code", "Football", 10, 5, 10.0);
        club.anyadirActividad(group);

            // Act & Assert
        assertThrows(ClubException.class, () -> club.matricular("Basketball", 2));
    }

    @Test
    @DisplayName("Test that a club's revenue is calculated correctly")
    void calculateRevenue_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);
        Grupo group1 = new Grupo("Code", "Football", 10, 5, 10.0);
        Grupo group2 = new Grupo("Code", "Basketball", 20, 15, 25.0);
        Grupo group3 = new Grupo("Code", "Tennis", 5, 5, 40.0);
        club.anyadirActividad(group1);
        club.anyadirActividad(group2);
        club.anyadirActividad(group3);

            // Act
                // (10x5) + (25x15) + (40x5) = 625
        double revenue = club.ingresos();

            // Assert
        assertEquals(625, revenue);
    }

    @Test
    @DisplayName("Test that a club's revenue is calculated correctly")
    void calculateRevenue_NoGroups_Correctly() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 3);

            // Act
        double revenue = club.ingresos();

            // Assert
        assertEquals(0, revenue);
    }

    @Test
    @DisplayName("Test that when calculating the income of a club that has fewer groups than indicated when creating it, null groups are not taken into account")
    void calculateRevenue_Groups_Limit() throws Exception{
            // Arrange
        club = new ClubDeportivo("UMA", 9);
        Grupo group1 = new Grupo("Code", "Football", 10, 5, 10.0);
        Grupo group2 = new Grupo("Code", "Basketball", 20, 15, 25.0);
        Grupo group3 = new Grupo("Code", "Tennis", 5, 5, 40.0);
        club.anyadirActividad(group1);
        club.anyadirActividad(group2);
        club.anyadirActividad(group3);

            // Act
                // (10x5) + (25x15) + (40x5) + 0 + 0 = 625
        double revenue = club.ingresos();

            // Assert
        assertEquals(625, revenue);
    }
}
