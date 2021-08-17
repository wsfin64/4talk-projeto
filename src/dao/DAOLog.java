package dao;

import com.db4o.query.Query;
import modelo.Log;

import java.util.List;

public class DAOLog extends DAO<Log>{

    @Override
    public Log read(Object chave) {
        String nome = (String) chave;
        Query q = manager.query();
        q.constrain(Log.class);
        q.descend("nome").constrain(nome);
        List<Log> resultados = q.execute();

        if (resultados.size() > 0){
            return resultados.get(0);
        }else {
            return null;
        }
    }

}
