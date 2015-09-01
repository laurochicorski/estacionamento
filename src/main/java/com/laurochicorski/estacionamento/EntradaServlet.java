package com.laurochicorski.estacionamento;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/entrada")
public class EntradaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter writer = resp.getWriter();
		writer.write(gerarTicket(req.getParameter("placa"), writer));
	}
	
	public String gerarTicket(String placa, PrintWriter writer){
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='panel panel-primary'>");
		sb.append("<div class='panel-heading'><strong>Ticket - Entrada</strong></div>");
		sb.append("<div class='panel-body'>");
		sb.append("<strong>PLACA: </strong>");
		sb.append(placa);
		sb.append("<br>");
		sb.append("<strong>DATA-HORA: </strong>");
		sb.append(formatador.format(data));
		sb.append("<br><br>");
		sb.append("<em>Tolerância de 15 minutos</em><br>");
		sb.append("<em>Primeiras 2 horas = R$5,00</em><br>");
		sb.append("<em>Hora adicional = R$2,00</em><br>");
		sb.append("<br>");
		sb.append("<button type='button' class='btn btn-default' ><a href='index.html'>Voltar</a></button>");
		sb.append("</div>");
		sb.append("</div>");		
		sb.append("</body>");
		sb.append("</html>");
		sb.append("<br>");
		
		return sb.toString();
		
	}
}
