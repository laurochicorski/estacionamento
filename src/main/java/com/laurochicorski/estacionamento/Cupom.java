package com.laurochicorski.estacionamento;

import java.util.Date;

public class Cupom {

	private Date dataChegada;
	private Date dataSaida;
	private Long tempo;
	private Double valor;
	private String placa;
	
	public Cupom(Date dataChegada, String placa){
		this.dataChegada = dataChegada;
		this.dataSaida = new Date();
		this.placa = placa;
		calculatempo();
		calculaValor();
		
	}
	
	public void calculatempo(){
		this.tempo = (dataSaida.getTime() - dataChegada.getTime())/60000;
	}
	
	public void calculaValor(){
		if(tempo <= 15){
			this.valor = 0.0;
		}else if(tempo <= 120){
			this.valor = 5.0;
		}else{
			Long dif = tempo - 120;
			Double vlr = 5.0;
			while(dif > 0){
				vlr += 2.0;
				dif -= 60;
			}
			this.valor = vlr;
		}
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public Long getTempo() {
		return tempo;
	}

	public Double getValor() {
		return valor;
	}

	public String getPlaca() {
		return placa;
	}
}
