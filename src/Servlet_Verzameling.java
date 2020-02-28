import domain.DB.BierDB;
import domain.model.Bier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Verzameling")
public class Servlet_Verzameling extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Bier Star = new Bier("star blond","blond",0.4);
        Bier speciale= new Bier("Speciale 1900","amber",5);
        Bier Keizer= new Bier("Keizer Karel","bruin",9);
        Bier nulprocent= new Bier("null");
        Bier ander=new Bier("anders",4.3);
        BierDB database=new BierDB();
        database.addBier(Star);
        database.addBier(speciale);
        database.addBier(Keizer);
        database.addBier(nulprocent);
        database.addBier(ander);



        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"nl\">");
        out.println("<head>");
        out.println("<title>Bierverzameling van Brouwerij Haacht-verzameling</title>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"css/Style.css\">");
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<nav>");
        out.println("<ul>");
        out.println("<li><a href=\"index.jsp\">home</a></li>");
        out.println("<li><a href=\"verzameling.jsp\">verzameling</a></li>");
        out.println("<li><a href=\"formulier.jsp\">formulier</a></li>");
        out.println("</ul>");

        out.println("</nav>");
        out.println("<h1 hidden>De brouwerij van Haacht</h1>");
        out.println("</header>");
        out.println("<main>");
        out.println("");
        out.println("<a href=\"formulier.jsp\">Voeg een bier toe</a>");
        out.println("<p>Het bier met het hoogste alcoholpercentage is "+database.getBierMetHoogstePercentage().getName()+" met een percentage van "+database.getHoogstePercentage()+".</p>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Naam</th>");
        out.println("<th>bechrijving</th>");
        out.println("<th>waarde</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println(" <tbody>");
        for(int i=0;i<database.getBieren().size();i++){
            out.println("<tr>");
            out.println("<td>"+database.getBieren().get(i).getName()+"</td>");
            out.println("<td>"+database.getBieren().get(i).getBeschrijving()+"</td>");
            out.println("<td>"+database.getBieren().get(i).getPercentage()+"</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</main>");
        out.println("<footer>");
        out.println("<address>&copy;Gerben Piot Website by <a  class=\"mail\" href=\"mailto:gerben.piot@student.ucll.be\"> gerben.piot@student.ucll.be.</a>");
        out.println(" </address>");
        out.println("</footer>");
        out.println("</body>");
        out.println("</html>");
    }
}
