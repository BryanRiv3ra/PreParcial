package umg.ejercicio.DataBase.Service;

import umg.ejercicio.DataBase.Dao.ChampionsDao;
import umg.ejercicio.DataBase.Model.EquipoChampions;

import java.util.List;

public class EquipoChampionsService {
    private ChampionsDao equipoDAO = new ChampionsDao();

    public boolean insertarEquipo(EquipoChampions equipo) {
        return equipoDAO.insertar(equipo);
    }

    public List<EquipoChampions> obtenerTodosLosEquipos() {
        return equipoDAO.obtenerTodos();
    }

    public boolean actualizarEquipo(EquipoChampions equipo) {
        return equipoDAO.actualizar(equipo);
    }

    public boolean eliminarEquipo(int idEquipo) {
        return equipoDAO.eliminar(idEquipo);
    }

}
