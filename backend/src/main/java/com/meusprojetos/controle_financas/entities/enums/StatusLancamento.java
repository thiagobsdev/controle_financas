package com.meusprojetos.controle_financas.entities.enums;

public enum StatusLancamento {
	
		PENDENTE("Pendente"),
		CANCELADO("Cancelado"),
		EFETIVADO("Efetivado");
	
		private final String statusLancamento;
	
		private StatusLancamento (String statusLancamento) {
        this.statusLancamento = statusLancamento;
    }
	
	
	public String getStatusLancamento() {
        return statusLancamento;
    }

}
