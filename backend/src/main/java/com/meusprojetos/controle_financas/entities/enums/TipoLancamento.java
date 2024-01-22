package com.meusprojetos.controle_financas.entities.enums;

public enum TipoLancamento {
	
		RECEITA("Receita"),
		DESPESA("Despesa");
	
		private final String tipoLancamento;
		
		private TipoLancamento(String tipoLancamento) {
	        this.tipoLancamento = tipoLancamento;
	    }
		
		
		public String getTipoLancamento() {
	        return tipoLancamento;
	    }
		
	

}
