package ui.controller;

import domain.DB.BierDB;
import domain.model.Bier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Verzameling")
public class Servlet_Verzameling extends HttpServlet {
    BierDB db=new BierDB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam =request.getParameter("naam");
        String beschrijving= request.getParameter("beschrijving");
        String procent= request.getParameter("waarde") ;
        String toward;

        if(naam.equals("")){
            toward= "formulier.jsp";
        } else if(procent==""){
            toward= "formulier.jsp";
        }else if(beschrijving=="" && procent ==""){
            Bier bier=new Bier(naam);
            db.addBier(bier);
            toward="verzameling.jsp";

        }else if(beschrijving== ""){
            double waarde = Double.parseDouble(procent);
            Bier bier=new Bier(naam,waarde);
            db.addBier(bier);
            toward="verzameling.jsp";
        }else {
            double waarde = Double.parseDouble(procent);
            Bier bier=new Bier(naam,beschrijving,waarde);
            db.addBier(bier);
            toward="verzameling.jsp";

        }
        request.setAttribute("db",db);
        String bierhoogstwaarde= db.getBierMetHoogstePercentage().getName();
        double percentage = db.getHoogstePercentage();
        request.setAttribute("bierhoogste",bierhoogstwaarde);
        request.setAttribute("percentage",percentage);
        RequestDispatcher view= request.getRequestDispatcher(toward);
        view.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("db",db);
        String bierhoogstwaarde= db.getBierMetHoogstePercentage().getName();
        double percentage = db.getHoogstePercentage();
        request.setAttribute("bierhoogste",bierhoogstwaarde);
        request.setAttribute("percentage",percentage);
        RequestDispatcher view= request.getRequestDispatcher("verzameling.jsp");
        view.forward(request,response);

    }
}
