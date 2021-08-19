// Alunos: Wellington da Silva e Rebeka Moreira

package dao;

import com.db4o.query.Query;
import modelo.Mensagem;

import java.util.List;

public class DAOMensagem extends DAO<Mensagem>{

    public Mensagem read(Object chave){
        int id = (Integer) chave;
        Query q = manager.query();
        q.constrain(Mensagem.class);
        q.descend("id").constrain(id);
        List<Mensagem> resultado = q.execute();

        if (resultado.size() > 0){
            return resultado.get(0);
        }else {
            return null;
        }
    }

    public List<Mensagem> listarMensagens(String termo){
        Query q = manager.query();
        q.constrain(Mensagem.class);
        q.descend("texto").constrain(termo).like();

        List<Mensagem> resultado = q.execute();

        if (resultado.size() > 0){
            return resultado;
        }else {
            return null;
        }
    }


}
