/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

/**
 *
 * @author Misael
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    public PessoaFisica getPessoa(int id) {
        PessoaFisica pessoa = null;
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa = new PessoaFisica(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("logradouro"), rs.getString("cidade"),
                        rs.getString("estado"), rs.getString("telefone"),
                        rs.getString("email"), rs.getString("cpf"));
            }
        } catch (SQLException e) {
        }
        return pessoa;
    }

    public List<PessoaFisica> getPessoas() {
        List<PessoaFisica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PessoaFisica pessoa = new PessoaFisica(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("logradouro"), rs.getString("cidade"),
                        rs.getString("estado"), rs.getString("telefone"),
                        rs.getString("email"), rs.getString("cpf"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
        }
        return pessoas;
    }

    public void incluir(PessoaFisica pessoa) {
        String sql = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getLogradouro());
            stmt.setString(3, pessoa.getCidade());
            stmt.setString(4, pessoa.getEstado());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setString(7, pessoa.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void alterar(PessoaFisica pessoa) {
        String sql = "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, cpf = ? WHERE id = ?";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getLogradouro());
            stmt.setString(3, pessoa.getCidade());
            stmt.setString(4, pessoa.getEstado());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setString(7, pessoa.getCpf());
            stmt.setInt(8, pessoa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
