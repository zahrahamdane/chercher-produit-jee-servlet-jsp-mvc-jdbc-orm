package com.zaradev.ihm;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import com.zaradev.bo.Produit;
import com.zaradev.dao.IProduitDao;
import com.zaradev.dao.ProduitDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class ControleurServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	IProduitDao dao;
	
	@Override
	public void init() throws ServletException {
		dao = new ProduitDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			
			List<Produit> produits = dao.produitParMC("%"+motCle+"%");
			
			model.setProduitsByMC(produits);
			
			request.setAttribute("model", model);
			
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
