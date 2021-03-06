/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.CombustivelPers;
import Persistencia.CompraPers;
import Wrapper.CompraVeiculoWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Combustivel;
import model.Compra;
import model.CompraVeiculo;
import model.Funcionario;
import model.Veiculo;

/**
 *
 * @author Jean
 */
public class CompraVeiculoRN {

    CompraPers pers;
    private Compra compra;
    private CompraVeiculo comprav;
    private List<String> errosValidacaoVeiculo;
    private List<String> errosValidacaoCompra;

    public CompraVeiculoRN() {
        compra = new Compra();
        pers = new CompraPers();
    }

    public CompraVeiculo getComprav() {
        return comprav;
    }

    public void setComprav(CompraVeiculo comprav) {
        this.comprav = comprav;
    }

    public List<String> getErrosValidacaoVeiculo() {
        return errosValidacaoVeiculo;
    }

    public void setErrosValidacaoVeiculo(List<String> errosValidacaoVeiculo) {
        this.errosValidacaoVeiculo = errosValidacaoVeiculo;
    }

    public List<String> getErrosValidacaoCompra() {
        return errosValidacaoCompra;
    }

    public void setErrosValidacaoCompra(List<String> errosValidacaoCompra) {
        this.errosValidacaoCompra = errosValidacaoCompra;
    }

    public List popularTabelaVeiculo() {
        return compra.getVeiculos();
    }

    public boolean adicionaVeiculo(Veiculo veiculo, Double valor) {
        comprav = new CompraVeiculo();

        if (isVeiculoValido(veiculo, valor)) {
            comprav.setVeiculo(veiculo);
            compra.getVeiculos().add(comprav);
            Double total = compra.getValorcompra();
            compra.setValorcompra(total + valor);
            comprav.setValor(valor);
            return true;
        }
        return false;

    }

    public boolean gravar() {
        if (isCompraValida()) {
            pers.gravar(compra);
            return true;
        }
        return false;
    }

    public boolean isCompraValida() {
        boolean valida = true;
        errosValidacaoCompra = new ArrayList<>();
        if (compra != null) {
            if (compra.getVendedor().getRazaosocial().equals("")) {
                errosValidacaoCompra.add("Fornecedor não Pode ser vazio");
                valida = false;
            }
            if (compra.getVendedor().getNomefantasia().equals("")) {
                errosValidacaoCompra.add("Nome Fantasia não Pode ser vazio");
                valida = false;
            }
            if (compra.getVendedor().getCnpj().endsWith(" ")) {
                errosValidacaoCompra.add("CNPJ não Pode ser vazio");
                valida = false;
            }
            if (compra.getVendedor().getRazaosocial().endsWith(" ")) {
                errosValidacaoCompra.add("Telefone não Pode ser vazio");
                valida = false;
            }
            return valida;
        }
        errosValidacaoCompra.add("Compra não pode ser nula");
        return false;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public boolean isVeiculoValido(Veiculo veiculo, Double valor) {
        boolean valido = true;
        errosValidacaoVeiculo = new ArrayList<>();
        if (veiculo != null) {
            if (veiculo.getChassi().trim().equals("")) {
                errosValidacaoVeiculo.add("Chassi não pode ser vazio.");
                valido = false;
            }
            if (veiculo.getAnomodelo() <= 0) {
                errosValidacaoVeiculo.add("Ano modelo é inválido.");
                valido = false;
            }
            if (veiculo.getAnofabricacao() <= 0) {
                errosValidacaoVeiculo.add("Ano fabricação é inválido.");
                valido = false;
            }
            if (veiculo.getAnofabricacao() + 1 < veiculo.getAnomodelo()) {
                errosValidacaoVeiculo.add("O Ano do Modelo é Superior ao Ano de fabricação.");
                valido = false;
            }
            if (veiculo.getAnofabricacao() > Calendar.getInstance().get(Calendar.YEAR)) {
                errosValidacaoVeiculo.add("O ano de Fabricação não pode ser maior que o Ano Atual.");
                valido = false;
            }
            if (veiculo.getQuilometragem() < 0) {
                errosValidacaoVeiculo.add("Quilometragem inválida.");
                valido = false;
            }
            if (veiculo.getModelo().trim().equals("")) {
                errosValidacaoVeiculo.add("Modelo não pode ser vazio.");
                valido = false;
            }
            if (veiculo.getMarca().trim().equals("")) {
                errosValidacaoVeiculo.add("Marca não pode ser vazio.");
                valido = false;
            }
            if (valor <= 0) {
                errosValidacaoVeiculo.add("Valor do Veiculo é Inválido.");
                valido = false;
            }
            return valido;
        }
        errosValidacaoVeiculo.add("Veiculo não pode ser nulo");
        return false;
    }

    public Iterable<Combustivel> getListaCombustivel() {
        CombustivelPers combustivelPers = new CombustivelPers();
        return combustivelPers.getLista();
    }

    public List<CompraVeiculoWrapper> getVeiculoWrapperList() {
        List<CompraVeiculoWrapper> lista = new ArrayList<>();
        for (int i = 0; i < compra.getVeiculos().size(); i++) {
            lista.add(new CompraVeiculoWrapper(compra.getVeiculos().get(i)));
        }
        return lista;
    }

    public boolean isCompraVazia() {
        return compra.getVeiculos().size() > 0;
    }

    public void setFuncionarioCompra(Funcionario funcionario) {
        compra.setFuncionario(funcionario);
    }
}
