package com.fagon.web.entities.enums;

public enum EstadoPagamento {

	AGUARDANDO_PAGAMENTO(1, "Aguardando Pagamento"),
	PAGO(2, "Pagamento efetuado"),
	ENVIADO(3, "Saindo para entrega"),
	ENTREGUE(4, "Entregue"),
	CANCELADO(5, "Cancelado");
	
	private int code;
	private String descricao;
	
	private EstadoPagamento(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public int getCode() {
		return code;
	}

	public String getDescricao(){
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer code) {
		if(code == null){
			return null;
		}
		
		for(EstadoPagamento value : EstadoPagamento.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Codigo do status invalido!" + code);
	}
}
