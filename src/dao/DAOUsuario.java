// Alunos: Wellington da Silva e Rebeka Moreira

package dao;

import com.db4o.query.Query;
import modelo.Usuario;

import java.util.List;

public class DAOUsuario extends DAO<Usuario>{

    public Usuario read(Object chave){
        String chaveUsuario = (String) chave;
        Query q = manager.query();
        q.constrain(Usuario.class);
        q.descend("nomesenha").constrain(chave);
        List<Usuario> resultado = q.execute();

        if (resultado.size() > 0){
            return resultado.get(0);
        }else {
            return null;
        }

    }
}
