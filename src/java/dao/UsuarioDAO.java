
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author ricardo
 */
public class UsuarioDAO extends dao
{
    public void registrar(Usuario valor_usuario) throws SQLException
    {
        try {
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement("INSERT INTO Usuario (nombre, carrera_prof) VALUES(?,?) ");
            pst.setString(1,valor_usuario.getNombre());
            pst.setString(2, valor_usuario.getCarrera_prof());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            this.Cerrar();
        }
        
    }
    
    public List<Usuario> listar() throws SQLException
    {
        List<Usuario> lista =null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement pst =this.getCn().prepareCall("SELECT codigo,nombre, carrera_prof FROM Usuario");
            rs=pst.executeQuery();
            lista =new ArrayList();
            
            while(rs.next())
            {
                Usuario usu =new Usuario();
               
                    usu.setCodigo(rs.getInt("codigo"));
                    usu.setNombre(rs.getString("nombre"));
                    usu.setCarrera_prof(rs.getString("carrera_prof"));
                    lista.add(usu);
                
            }
            
        }
          catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        finally{
            this.Cerrar();
        }
        return lista;
    }
}
