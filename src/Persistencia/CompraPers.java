/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.Query;
import model.Compra;

/**
 *
 * @author Jean
 */
public class CompraPers extends BasePers implements IPersistencia<Compra> {

    @Override
    public Compra gravar(Compra compra) {
        beginTransaction();        
        compra = getEm().merge(compra);
        commitTransaction();
        return compra;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Compra t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Compra atualizar(Compra compra) {
        return this.gravar(compra);
    }

    @Override
    public Compra procurarPorId(int id) {
        Query query = getEm().createNamedQuery("Compra.findByIdcompra");
        query.setParameter("idcompra", id);
        return (Compra)query.getSingleResult();
    }

    @Override
    public List<Compra> getLista() {
        return (List<Compra>) getEm().createNamedQuery("Compra.findAll").getResultList();
    }
    
    
}
