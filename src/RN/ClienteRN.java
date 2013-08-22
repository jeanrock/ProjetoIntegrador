/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.ClientePers;
import Util.ClienteTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import org.hibernate.tool.stat.BeanTableModel;
/**
 *
 * @author RAFAEL
 */
public class ClienteRN {

    private Cliente cliente;
    private ClientePers pers;
    private List <String> errosValidacao;
    private ClienteTableModel clienteTableModel;

    public ClienteRN(boolean tipo) {
        cliente = new Cliente(tipo);
        pers = new ClientePers();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean gravar(boolean tipo){        
        if(isClienteValido(cliente, tipo)){
            pers.gravar(cliente);        
            return true;
        }
        return false;
    }
    
    public boolean isClienteValido(Cliente cli , boolean tipo){
        if(cli != null){
            if(tipo){
                return isPessoaFisicaValida(cli.getPessoafisica());
            }else{
                return isPessoaJuridicaValida(cli.getPessoajuridica());
            }
            
        }
        return false;
    }
    
    public boolean isPessoaFisicaValida(PessoaFisica pf){
        boolean valido = true;
        errosValidacao = new ArrayList<>();        
        if(pf != null){            
            if(pf.getNome().trim().equals("")){
                errosValidacao.add("Nome não pode ser vazio.");
                valido = false;
            }
            if(pf.getCpf().trim().equals("")){
                errosValidacao.add("Cpf não pode ser vazio.");
                valido = false;
            }
            if(pf.getRg().trim().equals("")){
                errosValidacao.add("RG não pode ser vazio.");
                valido = false;
            }
            if(pf.getEndereco().getCep().trim().equals("")){
                errosValidacao.add("Cep não pode ser vazio.");
                valido = false;
            }
            return valido;
        }
        errosValidacao.add("Pessoa não pode ser nula");
        return false;
    }
    
    public boolean isPessoaJuridicaValida(PessoaJuridica pj){
        boolean valido = true;
        errosValidacao = new ArrayList<>();        
        if(pj != null){            
            if(pj.getRazaosocial().trim().equals("")){
                errosValidacao.add("Razão Social não pode ser vazio.");
                valido = false;
            }
            if(pj.getNomefantasia().trim().equals("")){
                errosValidacao.add("Nome Fantasia não pode ser vazio.");
                valido = false;
            }
            if(pj.getCnpj().trim().equals("")){
                errosValidacao.add("CNPJ não pode ser vazio.");
                valido = false;
            }
            if(pj.getIdendereco().getCep().trim().equals("")){
                errosValidacao.add("Cep não pode ser vazio.");
                valido = false;
            }
            return valido;
        }
        errosValidacao.add("Pessoa não pode ser nula");
        return false;
    }
    
    public Object getErrosValidacao() {
        return errosValidacao;
    }

    public ClienteTableModel getClienteTableModel() {
        if(clienteTableModel==null){
            clienteTableModel = new ClienteTableModel(pers.getLista());
        }        
        return clienteTableModel;
    }

    public void setClienteTableModel(ClienteTableModel clienteTableModel) {
        this.clienteTableModel = clienteTableModel;
    }
    
    public Cliente getClienteFromTableModel(int index){
        return this.clienteTableModel.getCliente(index);
    }
}
