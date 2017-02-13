/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.entity.Cliente;
import clienti.service.ClienteService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */

@WebServlet(urlPatterns = "/cliente")
public class ClientiServlet extends HttpServlet{   
    
    //applicazione web con java
    //è una classe java che pubblicata sul server java può fare richieste ad un server http 
    
    @Inject //passa un'istanza della mia classe ClienteService
    ClienteService clienteService;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init()...");
    }

    // lo fa quando mandi un'altra richiesta
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("destroy()...");
    }        
    
    // interagisci con la richiesta che arriva e la risposta che invii
    // per fare la rischiesta, nella barra dell'indirizzo aggiungi: ?id=10
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* per visualizzare il parametro della richiesta
        String p=req.getParameter("id");
        System.out.println("Chiamata a doGet... Ok.. "+p);
        
        //per rispondere ==> e aggiungo il paragrafo
        //stampo direttamente perché ha il metodo
        //posso creare html in modo dinamico
        resp.getWriter().println("<p>Ciao</p>");*/
        
        StringBuilder sb=new StringBuilder("<html><head><title>Elenco Clienti</title></head>");
        sb.append("<body><table>");
        for (Cliente cli : clienteService.findAll()) {
            //resp.getWriter().println(cli.toString());
            sb.append("<tr>");
            sb.append("<td>"+cli.getId_cliente()+"</td>");
            sb.append("<td>"+cli.getRagioneSociale()+"</td>");
            sb.append("<td>"+cli.getIndirizzo()+"</td>");
            sb.append("</tr>");
        }
        sb.append("</table></body></html>");
        resp.getWriter().println(sb.toString());        
    }            

    //usiamo doPost perché il form in html usa il method="POST"
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ragsoc = req.getParameter("ragsoc");        
        Cliente cli=new Cliente(ragsoc);
        String indi = req.getParameter("indi");
        cli.setIndirizzo(indi);
        clienteService.save(cli);
        System.out.println("doPost va bene...  "+ragsoc+" - "+indi);
        //torna alla pag index.html
        resp.sendRedirect("index.html");
    }
    
    
}