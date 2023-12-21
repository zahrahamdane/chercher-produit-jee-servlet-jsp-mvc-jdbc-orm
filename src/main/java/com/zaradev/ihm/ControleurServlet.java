package com.zaradev.ihm;

import java.io.IOException;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (path.equals("/index.do")) {
			
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);

			List<Produit> produits = dao.produitParMC("%" + motCle + "%");

			model.setProduitsByMC(produits);

			request.setAttribute("model", model);

			request.getRequestDispatcher("produits.jsp").forward(request, response);

		} else if (path.equals("/saisie.do")) {

			request.getRequestDispatcher("saisie-produit.jsp").forward(request, response);
			
		} else if (path.equals("/SaveProduit.do") && request.getMethod().equals("POST")) {
			
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite")) ;
			
			Produit produit = dao.save(new Produit(designation, prix, quantite));
			
			request.setAttribute("produit", produit);
			
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);

		} else if (path.equals("/supprimer.do")){
			
			Long id = Long.parseLong(request.getParameter("id"));
			dao.deleteProduit(id);
			// request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
			
		}else if(path.equals("/edit.do")) {
			Long id =Long.parseLong(request.getParameter("id")) ;
			Produit produit = dao.getProduit(id);
			request.setAttribute("produit", produit);
			
			request.getRequestDispatcher("edit-produit.jsp").forward(request, response);
			
		} else if(path.equals("/UpdateProduit.do") && request.getMethod().equals("POST")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String designation = request.getParameter("designation");
			Double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			
			Produit produit = new Produit(designation, prix, quantite);
			produit.setId(id);
			
			dao.update(produit);
			
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		
		else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,"La ressource n'est pas trouvée");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
