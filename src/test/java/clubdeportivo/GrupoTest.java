package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * @author1: Manuel Fuentes Vida
 * @author2: Jose Antonio Casado Molina
 * @author3: Clemente Cano Mengíbar
 */

public class GrupoTest {
    @Test
    @DisplayName("Testing the constructor of Grupo's class")
    void TestConstructor_WithValidArguments_ReturnEquals() throws ClubException {
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);

        assertEquals(codigo, grupo.getCodigo());
        assertEquals(actividad, grupo.getActividad());
        assertEquals(nplazas, grupo.getPlazas());
        assertEquals(matriculados, grupo.getMatriculados());
        assertEquals(tarifa, grupo.getTarifa());
    }

   @Test
    @DisplayName("Testing the constructor of Grupo's class with a megative parameter of places")
    void TestConstructor_WithNegativePlaces_ThrowException(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = -15;
        int matriculados = 10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class with a negative parameter of alums")
    void TestConstructor_WithsNegativeAlums_ThrowException(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = -10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class with a negative price")
    void TestConstructor_WithNegativeFare_ThrowException(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = -15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class whith more alumns than places")
    void TestConstructor_WithMoreAlumsThanPlaces_ThrowException(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 5;
        int matriculados = 10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing getCodigo 's method")
        void TestGetCodigo_WithCorrectArguments_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.getCodigo(), codigo);
        
    }

    @Test
    @DisplayName("Testing getActividad 's method")
        void TestGetActvidad_WithCorrectArguemnts_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.getActividad(), actividad);
        
    }

    @Test
    @DisplayName("Testing getPlazas 's method")
    void TestGetPlazas_WithCorrectArguments_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.getPlazas(), nplazas);
        
    }

    @Test
    @DisplayName("Testing getMatriculados 's method")
    void TestGetMatriculados_WithCorrectArguments_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.getMatriculados(), matriculados);
        
    }

    @Test
    @DisplayName("Testing getTarifa 's method")
    void TestGetTarifa_WithCorrectArguments_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.getTarifa(),tarifa);
        
    }

    @Test
    @DisplayName("Testing PlazasLibres 's method with more places than alumns")
    void TestPlazasLibres_WithCorrectArguments_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.plazasLibres(), nplazas-matriculados);
        
    }

    @Test
    @DisplayName("Testing ActualizarPlazas 's method with positive parameter")
    void TestActualizarPlazas_WithPositiveParameter_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int actualizarPlazas = 20;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        grupo.actualizarPlazas(actualizarPlazas);
        
        assertEquals(grupo.getPlazas(), actualizarPlazas);
        
    }

    @Test
    @DisplayName("Testing ActualizarPlazas 's method with negative places")
    void TestActualizarPlazas_WithNegativePlaces_ThrowException() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int actualizarPlazas = -3;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertThrows(clubdeportivo.ClubException.class, () -> grupo.actualizarPlazas(actualizarPlazas));
        
    }
    @Test
    @DisplayName("Testing ActualizarPlazas 's method with more alums than places")
    void TestActualizarPlazas_MoreAlumsThanPlaces_ThrowException() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int actualizarPlazas = 5;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertThrows(clubdeportivo.ClubException.class, () -> grupo.actualizarPlazas(actualizarPlazas));
        
    }

    @Test
    @DisplayName("Testing Matricular's methods with correct parameter")
    void TestMatricular_WithPositiveParemater_ReturnEquals() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int alumnos = 3;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        grupo.matricular(alumnos);
        
        assertEquals(grupo.getMatriculados(), matriculados+alumnos);
        
    }

    @Test
    @DisplayName("Testing Matricular's method with more people than places")
    void TestRegister_WithMorePeopleThanPlaces_ThrowsException() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int alumnos = 10;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertThrows(clubdeportivo.ClubException.class, () -> grupo.matricular(alumnos));
        
    }

    @Test
    @DisplayName("Testing Matricular's methods with negative people")
    void TestRegister_WithNegativePeople_ThrowsException() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int alumnos = -10;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertThrows(clubdeportivo.ClubException.class, () -> grupo.matricular(alumnos));
        
    }

    @Test
    @DisplayName("Testing String's methods")
    void TestString_worksCorrectly() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;

        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(grupo.toString(), "("+ codigo + " - "+actividad+" - " + tarifa + " euros "+ "- P:" + nplazas +" - M:" + matriculados+")");
        
    }

    @Test
    @DisplayName("Testing Equals's method with two equals Groups")
    void TestEquals_WithSameGroups_ReturnsTrue() throws ClubException {
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;        
        Grupo grupo1 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        Grupo grupo2 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);

        assertTrue(grupo1.equals(grupo2));
    }

    @Test
    @DisplayName("Testing Equals's method with a non-Grupo object")
    void TestEquals_WithNonGroup_ReturnsFalse() throws ClubException {
    String codigo = "1234";
    String actividad = "Boxeo";
    int nplazas = 15;
    int matriculados = 10;
    double tarifa = 15.6;
    Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
    String otroObjeto = "no soy un Grupo";

    assertFalse(grupo.equals(otroObjeto));
}


    @Test
    @DisplayName("Testing Equals's method with the same activity, in upper and in low case")
    void TestEquals_WithDifferentCapitalLetters_ReturnsTrue() throws ClubException {
        String codigo = "1234";
        String actividad = "Boxeo";
        String actividad2 = "boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo1 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        Grupo grupo2 = new Grupo(codigo, actividad2, nplazas, matriculados, tarifa);

        assertTrue(grupo1.equals(grupo2));
    }

    @Test
    @DisplayName("Testing Equals's method with no equals Groups")
    void TestEquals_WithDiferentGroups_ReturnsFalse() throws ClubException {
        String codigo = "1234";
        String codigo2 = "5678";
        String actividad = "Boxeo";
        String actividad2 = "Natacion";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo1 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        Grupo grupo2 = new Grupo(codigo2, actividad2, nplazas, matriculados, tarifa);

        assertFalse(grupo1.equals(grupo2));
    }

    @Test
    @DisplayName("Testing Equals's method with the same code but different activity")
    void TestEquals_WithDifferentActivity_ReturnsFalse() throws ClubException {
        String codigo = "1234";
        String codigo2 = "1234";
        String actividad = "Boxeo";
        String actividad2 = "Natacion";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo1 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        Grupo grupo2 = new Grupo(codigo2, actividad2, nplazas, matriculados, tarifa);

        assertFalse(grupo1.equals(grupo2));
    }

    @Test
    @DisplayName("Testing Equals's method with the same activity but different code")
    void TestEquals_WithDifferentCode_ReturnsFalse() throws ClubException {
        String codigo = "1234";
        String codigo2 = "5678";
        String actividad = "Boxeo";
        String actividad2 = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo1 = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        Grupo grupo2 = new Grupo(codigo2, actividad2, nplazas, matriculados, tarifa);

        assertFalse(grupo1.equals(grupo2));
    }

    @Test
    @DisplayName("Testing HashCode's method")
    void TestHashCode_worksCorrectly() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(codigo.toUpperCase().hashCode()+actividad.toUpperCase().hashCode(), grupo.hashCode());
        
    }
    
}