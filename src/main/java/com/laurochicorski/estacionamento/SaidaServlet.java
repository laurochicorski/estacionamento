package com.laurochicorski.estacionamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/saida")
public class SaidaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			PrintWriter writer = resp.getWriter();		
			writer.write(gerarCupom(new Cupom(formatador.parse(req.getParameter("data")), req.getParameter("placa")), formatador));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public String gerarCupom(Cupom cupom, SimpleDateFormat formatador){
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='panel panel-danger'>");
		sb.append("<div class='panel-heading'><strong>Cupom</strong></div>");
		sb.append("<div class='panel-body'>");
		sb.append("<strong>PLACA: </strong>");
		sb.append(cupom.getPlaca());
		sb.append("<br>");
		sb.append("<strong>DATA-HORA ENTRADA: </strong>");
		sb.append(formatador.format(cupom.getDataChegada()));
		sb.append("<br>");
		sb.append("<strong>DATA-HORA SAIDA: </strong>");
		sb.append(formatador.format(cupom.getDataSaida()));
		sb.append("<br>");
		sb.append("<strong>TEMPO: </strong>");
		sb.append(cupom.getTempo());
		sb.append(" minutos");
		sb.append("<br>");
		sb.append("<strong>VALOR: </strong>");
		sb.append("R$ ");
		sb.append(cupom.getValor());
		sb.append("<br>");
		sb.append("<br>");
		sb.append("<em>Volte Sempre!!!!</em><br>");
		sb.append("</div>");
		sb.append("<button type='button' class='btn btn-default' ><a href='index.html'>Voltar</a></button>");
		sb.append("<br>");
		sb.append("</div>");
		sb.append("</div>");		
		sb.append("</body>");
		sb.append("</html>");
		sb.append("<br>");
		
		return sb.toString();

	}
}
