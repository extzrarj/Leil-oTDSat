/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public int cadastrarProduto(ProdutosDTO produto) {

        int status;

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO produtos (nome, valor) VALUES (?, ?)");
            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());

            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
            return -1;
        }

    }

    public List<ProdutosDTO> listarProdutos() {

        List<ProdutosDTO> listarProdutos = new ArrayList<>();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM filmes");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                listarProdutos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter filmes: " + e.getMessage());
        } finally {
        }
        return listarProdutos;
    }

}
