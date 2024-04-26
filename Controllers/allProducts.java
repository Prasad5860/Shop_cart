package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DBO.getAllProducts;
import Modal.Product;

/**
 * Servlet implementation class allProducts
 */
@WebServlet("/allProducts")
public class allProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public allProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		List<Product> lp = null;
		try {
			lp = getAllProducts.get();
			// for(int i=0;i<lp.size();i++) {
			// JSONObject jo = new JSONObject();
			// jo.put("productId", lp.get(i).getProductId());
			// jo.put("productName", lp.get(i).getProductName());
			// jo.put("productPrice", lp.get(i).getProductPrice());
			// jo.put("productCategory", lp.get(i).getProductCategory());
			// jo.put("productImage", lp.get(i).getProductImageId());
			// jo.put("productHSNCode", lp.get(i).getHSNCode());
			//
			// ja.
			// }
			response.setContentType("application/json");
			response.getWriter().write(new Gson().toJson(lp));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
