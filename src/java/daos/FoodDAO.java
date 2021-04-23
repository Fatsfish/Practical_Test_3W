/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.FoodDTO;
import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author User-PC
 */
public class FoodDAO {

    public boolean add(FoodDTO food) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblFoods (ID, Name, Description, Price, CookingTime, isDelete, CreateDate) values(?,?,?,?,?,?,CURRENT_TIMESTAMP)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, food.getID());
                stm.setString(2, food.getName());
                stm.setString(3, food.getDescription());
                stm.setString(4, food.getPrice());
                stm.setString(5, food.getCookingTime());
                stm.setBoolean(6, true);
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public ArrayList<FoodDTO> searchAvailable(String search) throws SQLException {
        ArrayList<FoodDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select ID, Name, Description, Price, CookingTime, isDelete, CreateDate from tblFoods where Name=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ID = rs.getString("ID");
                    String Name = rs.getString("Name");
                    String Description = rs.getString("Description");
                    String Price = rs.getString("Price");
                    String CookingTime = rs.getString("CookingTime");
                    boolean status = rs.getBoolean("isDelete");
                    String CD = rs.getString("CreateDate");
                    if (status) {
                        FoodDTO food = new FoodDTO(ID, Name, Description, Price, CookingTime, status, CD);
                        list.add(food);
                    }
                }

            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ArrayList<FoodDTO> searchDeleted(String search) throws SQLException {
        ArrayList<FoodDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select ID, Name, Description, Price, CookingTime, isDelete, CreateDate from tblFoods where Name=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ID = rs.getString("ID");
                    String Name = rs.getString("Name");
                    String Description = rs.getString("Description");
                    String Price = rs.getString("Price");
                    String CookingTime = rs.getString("CookingTime");
                    boolean status = rs.getBoolean("isDelete");
                    String CD = rs.getString("CreateDate");
                    if (!status) {
                        FoodDTO food = new FoodDTO(ID, Name, Description, Price, CookingTime, status, CD);
                        list.add(food);
                    }
                }

            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public ArrayList<FoodDTO> search(String search) throws SQLException {
        ArrayList<FoodDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select ID, Name, Description, Price, CookingTime, isDelete, CreateDate from tblFoods where Name=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, search);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ID = rs.getString("ID");
                    String Name = rs.getString("Name");
                    String Description = rs.getString("Description");
                    String Price = rs.getString("Price");
                    String CookingTime = rs.getString("CookingTime");
                    boolean status = rs.getBoolean("isDelete");
                    String CD = rs.getString("CreateDate");
                    FoodDTO food = new FoodDTO(ID, Name, Description, Price, CookingTime, status, CD);
                    list.add(food);

                }

            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public FoodDTO getFood(String id) throws SQLException {
        FoodDTO food = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select ID, Name, Description, Price, CookingTime, isDelete, CreateDate from tblFoods where ID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String ID = rs.getString("ID");
                    String Name = rs.getString("Name");
                    String Description = rs.getString("Description");
                    String Price = rs.getString("Price");
                    String CookingTime = rs.getString("CookingTime");
                    boolean status = rs.getBoolean("isDelete");
                    String CD = rs.getString("CreateDate");
                    food = new FoodDTO(ID, Name, Description, Price, CookingTime, status, CD);
                }

            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return food;
    }

    public boolean update(FoodDTO food) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblFoods ( Name, Description, Price, CookingTime, isDelete, CreateDate) values(?,?,?,?,?,CURRENT_TIMESTAMP) where ID like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, food.getName());
                stm.setString(2, food.getDescription());
                stm.setString(3, food.getPrice());
                stm.setString(4, food.getCookingTime());
                stm.setBoolean(5, food.isIsDelete());
                stm.setString(6, food.getID());

                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean delete(FoodDTO food) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblFoods (isDelete, CreateDate) values(?,CURRENT_TIMESTAMP) where ID like ?";
                stm.setBoolean(1, food.isIsDelete());
                stm.setString(2, food.getID());
                check = stm.executeUpdate() == 0 ? false : true;
            }
        } catch (Exception e) {
            log("Something went wrong" + e.toString());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
