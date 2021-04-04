package controller;

public class Enfeites {
	private String codTema;
	private String temaEnfeite;
	private String descricaoEnfeite;
	private String preco;
	
	public Enfeites(String codTema, String TemaEnfeite, String DescricaoTema, String preco) {
		this.codTema = codTema;
		this.temaEnfeite = temaEnfeite;
		this.descricaoEnfeite = descricaoEnfeite;
		this.preco = preco;
	} // fim enfeites

	public String getCodTema() {
		return codTema;
	}

 	public void setCodTema(String codTema) {
 		this.codTema = codTema;
 	}

	public String getTemaEnfeite() {
		return temaEnfeite;
	}

	public void setTemaEnfeite(String temaEnfeite) {
		this.temaEnfeite = temaEnfeite;
	}

	public String getDescricaoEnfeite() {
		return descricaoEnfeite;
	}

	public void setDescricaoEnfeite(String descricaoEnfeite) {
		this.descricaoEnfeite = descricaoEnfeite;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}  // fim classe.
