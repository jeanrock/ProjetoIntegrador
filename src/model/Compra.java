/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
//@NamedQuery(name = "Compra.findByStatusAutorizacao", query = "SELECT c FROM Compra c WHERE c.statusautorizacao = :statusautorizacao"),
@NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra"),
@NamedQuery(name = "Compra.findByDatacompra", query = "SELECT c FROM Compra c WHERE c.datacompra = :datacompra"),
@NamedQuery(name = "Compra.findByValorcompra", query = "SELECT c FROM Compra c WHERE c.valorcompra = :valorcompra")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    
    @Column(name = "datacompra")
    @Temporal(TemporalType.DATE)
    private Date datacompra;

    public Date getDataautorizacao() {
        return dataautorizacao;
    }

    public void setDataautorizacao(Date dataautorizacao) {
        this.dataautorizacao = dataautorizacao;
    }
    
    @Column(name = "dataautorizacao")
    @Temporal(TemporalType.DATE)
    private Date dataautorizacao;
    
    @Column(name = "valorcompra")
    private Double valorcompra;
    
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    @OneToMany(targetEntity=CompraVeiculo.class, fetch= FetchType.EAGER , cascade={CascadeType.MERGE, CascadeType.PERSIST} )
    private List<CompraVeiculo> veiculos;
    
    @JoinColumn(name = "idvendedor", referencedColumnName = "idpessoajuridica")
    @ManyToOne(optional = false)
    private PessoaJuridica vendedor;
    
    public List<CompraVeiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<CompraVeiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Compra() {
        veiculos = new ArrayList<>();
        valorcompra = 0.0;
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public Double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Compra[ idcompra=" + idcompra + " ]";
    }

    public PessoaJuridica getVendedor() {
        return vendedor;
    }

    public void setVendedor(PessoaJuridica vendedor) {
        this.vendedor = vendedor;
    }
    
}
