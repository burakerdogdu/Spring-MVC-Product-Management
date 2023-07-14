package com.works.product_management.services;

import com.works.product_management.props.Products;
import com.works.product_management.services.utils.DB;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchService {
    DB db = new DB();
    public List<Products> products(String q) {
        List<Products> ls = new ArrayList<>();

        try {
            q = "%"+q+"%";
            String sql = "select * from product where title like ? or detail like ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1,q);
            pre.setString(2,q);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Products p = new Products();
                p.setPid( rs.getInt("pid") );
                p.setTitle( rs.getString("title") );
                p.setDetail( rs.getString("detail") );
                p.setPrice( rs.getInt("price") );
                p.setStock( rs.getInt("stock") );
                ls.add(p);
            }
        }catch (Exception ex) {
            System.err.println("Products Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }

}
