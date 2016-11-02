package br.edu.utfpr.spring.trab.consts;

public enum StatusPedido {

	
	ABERTO("Aberto"), FINALIZADO("Finalizado"), CANCELADO("Cancelado");

	private String tipoStatus;

	StatusPedido(String tipoStatus){
        this.tipoStatus = tipoStatus;
    }	

	public String getTipoStatusNome() {
		return this.tipoStatus;
	}

}
