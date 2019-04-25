package bean;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//import javax.annotation.ManagedBean;
//import javax.faces.bean.RequestScoped;

import modelo.Usuario;

//Añadiendo anotaciones JSF
@ManagedBean
@RequestScoped
public class UsuarioBean 
{
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void registrar()
    {
        UsuarioDAO dao = new UsuarioDAO();
        try {        
            dao.registrar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
