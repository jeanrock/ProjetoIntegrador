/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "compraveiculo")
public class CompraVeiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompraveiculo", unique = true, nullable = false)
    private Integer idcompraveiculos;
    @Column(name = "valor")
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    @ManyToOne(targetEntity = Compra.class)
    @JoinColumn(name = "idcompra")
    private Compra compra;
    @ManyToOne(targetEntity = Veiculo.class)
    @JoinColumn(name = "idveiculo")
    private Veiculo veiculo;

    public Integer getIdcompraveiculos() {
        return idcompraveiculos;
    }

    public void setIdcompraveiculos(Integer idcompraveiculos) {
        this.idcompraveiculos = idcompraveiculos;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getIdCompraVeiculo() {
        return this.idcompraveiculos;
    }
}
