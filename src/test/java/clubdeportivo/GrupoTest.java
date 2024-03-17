package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GrupoTest {
    @Test
    @DisplayName("Testing the constructor of Grupo's class")
    void testConstructorConDatosValidos() throws ClubException {
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
    void TestConstructorWithNplazasNegative(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = -15;
        int matriculados = 10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class with a negative parameter of alums")
    void TestConstructorWithMatriculadosNegative(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = -10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class with a negative price")
    void TestConstructorWithTarifaNegative(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = -15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing the constructor of Grupo's class whith more alumns than places")
    void TestConstructorWithMatriculadosBiggerThanNplazas(){
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 5;
        int matriculados = 10;
        double tarifa = 15.6;
        
        assertThrows(ClubException.class, () -> new Grupo(codigo, actividad, nplazas, matriculados, tarifa));
    }

    @Test
    @DisplayName("Testing getCodigo 's method")
        void TestGetCodigo() throws ClubException{
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
        void TestGetActvidad() throws ClubException{
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
    void TestGetPlazas() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assert(grupo.getPlazas() == nplazas);
        
    }

    @Test
    @DisplayName("Testing getMatriculados 's method")
    void TestGetMatriculados() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assert(grupo.getMatriculados() == matriculados);
        
    }

    @Test
    @DisplayName("Testing getTarifa 's method")
    void TestGetTarifa() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assert(grupo.getTarifa() == tarifa);
        
    }

    @Test
    @DisplayName("Testing PlazasLibres 's method with more alums than places")
    void TestPlazasLibres() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assert(grupo.plazasLibres() == nplazas-matriculados);
        
    }

    @Test
    @DisplayName("Testing ActualizarPlazas 's method with positive parameter")
    void TestActualizarPlazasPositiveParameter() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int actualizarPlazas = 20;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        grupo.actualizarPlazas(actualizarPlazas);
        
        assert(grupo.getPlazas() == actualizarPlazas);
        
    }

    @Test
    @DisplayName("Testing ActualizarPlazas 's method with negative places")
    void TestActualizarPlazasNegativePlazas() throws ClubException{
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
    @DisplayName("Testing ActualizarPlazas 's method with more matriculados than places")
    void TestActualizarPlazasPlazasLessThanMatriculados() throws ClubException{
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
    @DisplayName("Testing Matricular's methods with positive parameter")
    void TestMatricularPositiveParemater() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        int alumnos = 3;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        grupo.matricular(alumnos);
        
        assert(grupo.getMatriculados() == matriculados+alumnos);
        
    }

    @Test
    @DisplayName("Testing Matricular's method with more alumns than places")
    void TestMatricularNplazasLessThanAlumnos() throws ClubException{
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
    @DisplayName("Testing Matricular's methods with negative alumns")
    void TestMatricularNegativeAlumnos() throws ClubException{
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
    void TestString() throws ClubException{
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
    void testEqualsObjetosIguales() throws ClubException {
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
    void testEqualsConObjetoNoGrupo() throws ClubException {
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
    void testEqualsConDistintasMayusculas() throws ClubException {
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
    @DisplayName("Testing Equals's method with no equals Goups")
    void testEqualsObjetosDiferentes() throws ClubException {
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
    @DisplayName("Testing Equals's method with no Objetc Group")
    void testEqualsConObjetosNoGrupo() throws ClubException {
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
    @DisplayName("Testing HashCode's method")
    void TestHashCode() throws ClubException{
        String codigo = "1234";
        String actividad = "Boxeo";
        int nplazas = 15;
        int matriculados = 10;
        double tarifa = 15.6;
        Grupo grupo = new Grupo(codigo, actividad, nplazas, matriculados, tarifa);
        
        assertEquals(codigo.toUpperCase().hashCode()+actividad.toUpperCase().hashCode(), grupo.hashCode());
        
    }
    
}