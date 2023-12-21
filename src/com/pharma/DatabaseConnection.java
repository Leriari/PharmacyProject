//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class DatabaseConnection {
        public boolean validateUsername(String username, String password) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                String url = "jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password = "Tobiko04";
                String db_username = "root";
                connection = DriverManager.getConnection(url, db_username, db_password);
                String sql = "SELECT * FROM tbl_users WHERE username=? AND password=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                return resultSet.next();

            } catch (Exception e) {
                e.printStackTrace();
                return false;

            }
        }

        public boolean isDoctor(String username) {
            return username.toLowerCase().contains("doc");
        }

        public boolean isPharmacist(String username) {
            return username.toLowerCase().contains("pharm");
        }

        public static List<String> searchDrugs(String Query) {
            List<String> results = new ArrayList<>();
            try {
                String url = "jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password = "Tobiko04";
                String db_username = "root";
                Connection connection = DriverManager.getConnection(url, db_username, db_password);
                String sql = "SELECT drug_name,dosage,description,quantity,expiry_date from tbl_drugs WHERE drug_name LIKE ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + Query + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String drugName = resultSet.getString("drug_name");
                    String dosage = resultSet.getString("dosage");
                    String description = resultSet.getString("description");
                    String quantity = resultSet.getString("quantity");
                    String expiry = resultSet.getString("expiry_date");
                    String result = "Drug Name: " + drugName + "\nDosage: " + dosage + "\nDescription: " + description + "\nQuantity:" +quantity +"\nExpiry Date:" +expiry+"\n" ;
                    results.add(result);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return results;

        }

        public boolean addDrugs(String drugName, String dosage, String description, String quantity,String expiryDate) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password = "Tobiko04";
                String db_username = "root";
                Connection connection = DriverManager.getConnection(url, db_username, db_password);
                String sql = "INSERT INTO tbl_drugs (drug_name,dosage,description,quantity,expiry_date)VALUES(?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, drugName);
                preparedStatement.setString(2, dosage);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, quantity);
                preparedStatement.setString(5, expiryDate);
                int rowsInserted = preparedStatement.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        public boolean removeDrugs(String drugName){
            try{
                String url="jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password="Tobiko04";
                String db_username="root";
                Connection connection=DriverManager.getConnection(url,db_username,db_password);
                String sql="DELETE FROM tbl_drugs WHERE drug_name= ?";
                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setString(1,drugName);
                int rowsDeleted= preparedStatement.executeUpdate();
                return rowsDeleted>0;
            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
        }
        public boolean sellDrugs(String drugName, int quantityToSell) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password = "Tobiko04";
                String db_username = "root";
                Connection connection = DriverManager.getConnection(url, db_username, db_password);


                String sql = "UPDATE tbl_drugs SET quantity = quantity - ? WHERE drug_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);


                preparedStatement.setInt(1, quantityToSell);
                preparedStatement.setString(2, drugName);

                int rowsUpdated = preparedStatement.executeUpdate();


                preparedStatement.close();
                connection.close();

                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle the exception appropriately (log it, throw a custom exception, etc.)
                return false;
            }
        }
        public boolean PrescribeDrugs(String Patient,String Drug, String quantity) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_peter_leriari_166913";
                String db_password = "Tobiko04";
                String db_username = "root";
                Connection connection = DriverManager.getConnection(url, db_username, db_password);
                String sql = "INSERT INTO tbl_prescription (Patient,Drug,quantity)VALUES(?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Patient);
                preparedStatement.setString(2, Drug);
                preparedStatement.setString(3, quantity);

                int rowsInserted = preparedStatement.executeUpdate();
                return rowsInserted > 0; //if at least one row is inserted,the drug is added successfully
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }

    }

