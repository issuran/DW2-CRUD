/*
 Trabalho Prático de Desenvolvimento Web 2 (IFSP - ADS, 2015/2)

    Desenvolvido por:
        Lucas Masalskas RA: 1101579
        Tiago Oliveira  RA: 1101986
*/
package com.primeiro.projeto1.classes;

public class Produto{
    private Integer id;
    private String nome;
    private String descricao;
    private String imagem;
    private String preco;
    private String estoque;    
    
    public Produto(Integer id, String nome, String descricao, String imagem, String preco, String estoque){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }
    
    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
    
    public String getImagem() {
	return imagem;
    }

    public void setImagem(String imagem) {
	this.imagem = imagem;
    }
    
    public String getPreco() {
	return preco;
    }

    public void setPreco(String preco) {
	this.preco = preco;
    }
    
    public String getEstoque() {
	return estoque;
    }

    public void setEstoque(String estoque) {
	this.estoque = estoque;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
