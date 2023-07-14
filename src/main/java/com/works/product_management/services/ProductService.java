package com.works.product_management.services;

import com.works.product_management.props.Products;
import com.works.product_management.services.utils.DB;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    DB db = new DB();
    public int productAdd(Products products){
        int status = 0;
        try {
            String sql ="insert into product values(null,?,?,?,?) ";
            PreparedStatement pre=db.connect().prepareStatement(sql);
            pre.setString(1,products.getTitle());
            pre.setInt(2,products.getPrice());
            pre.setString(3,products.getDetail());
            pre.setInt(4,products.getStock());
            pre.executeUpdate();
        }catch (Exception ex){
            System.err.println("Product Add Error : " +ex);
        }finally {
            db.close();
        }


        return status;
    }
    public List<Products> getProducts(){
        List<Products> ls = new ArrayList<>();
        try{
            String sql = "select * from product";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Products p = new Products();
                p.setPid(rs.getInt("pid"));
                p.setTitle(rs.getString("title"));
                p.setDetail(rs.getString("detail"));
                p.setStock(rs.getInt("stock"));
                p.setPrice(rs.getInt("price"));
                ls.add(p);
            }
        }catch(Exception ex){
            System.err.println("Product List Error : " +ex);
        }finally {
            db.close();
        }
        return ls;
    }
}
