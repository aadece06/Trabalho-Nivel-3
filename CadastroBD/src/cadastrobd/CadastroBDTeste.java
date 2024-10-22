/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;
/**
 *
 * @author Misael
 */


public class CadastroBDTeste {
    
    public static void main(String[] args) {
        
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        // Teste com Pessoa Física
        PessoaFisica pessoaFisica = new PessoaFisica(0, "João Silva", "Rua A", "São Paulo", "SP", "1111-1111", "joao@example.com", "123.456.789-00");
        pessoaFisicaDAO.incluir(pessoaFisica);

        // Alterar dados
        pessoaFisica.setTelefone("2222-2222");
        pessoaFisicaDAO.alterar(pessoaFisica);

        // Consultar e listar
        System.out.println("Pessoas Físicas:");
        for (PessoaFisica pf : pessoaFisicaDAO.getPessoas()) {
            pf.exibir();
        }

        // Excluir
        pessoaFisicaDAO.excluir(pessoaFisica.getId());

        // Teste com Pessoa Jurídica
        PessoaJuridica pessoaJuridica = new PessoaJuridica(0, "Empresa X", "Rua B", "São Paulo", "SP", "3333-3333", "empresa@example.com", "12.345.678/0001-90");
        pessoaJuridicaDAO.incluir(pessoaJuridica);

        // Alterar dados
        pessoaJuridica.setTelefone("4444-4444");
        pessoaJuridicaDAO.alterar(pessoaJuridica);

        // Consultar e listar
        System.out.println("Pessoas Jurídicas:");
        for (PessoaJuridica pj : pessoaJuridicaDAO.getPessoas()) {
            pj.exibir();
        }

        // Excluir
        pessoaJuridicaDAO.excluir(pessoaJuridica.getId());
    }
}
