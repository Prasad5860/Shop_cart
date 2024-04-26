package DBO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modal.Product;

public class getAllProducts {
	public static List<Product> get() throws Exception {
		List<Product> lp = new ArrayList<>();
		Connection con = dbCon.initialize();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from h_products");
		while (rs.next()) {

			Product p = new Product();
			p.setProductId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setProductPrice(rs.getDouble(3));
			p.setHSNCode(rs.getString(4));
			p.setProductCategory(rs.getString(5));
			p.setProductImageId(rs.getString(6));
			lp.add(p);
		}

		return lp;

	}
}
