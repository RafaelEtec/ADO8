package DAO;
/**
   por Rafael Ferreira Goulart
**/
import MODEL.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
   por Rafael Ferreira Goulart
**/
public class ComputadorDAO {
    
    public static String url = "jdbc:mysql://localhost:3301/db_lojainformatica";
    public static String login = "root";
    public static String senha = "";
    
    public static boolean salvar(Computador obj){
        
        Connection con = null;
        boolean retorno = false;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,login,senha);
            PreparedStatement sql = con.prepareStatement("INSERT INTO tb_computador(Marca, HD, Processador) VALUES(?, ?, ?)");
            sql.setString(1,obj.getMarca());
            sql.setString(2,obj.getHD());
            sql.setString(3,obj.getProcessador());
            
            int linhasAfetadas = sql.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public static boolean atualizar(Computador obj){
        
        Connection con = null;
        boolean retorno = false;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,login,senha);
            PreparedStatement comandoSQL = con.prepareStatement("UPDATE tb_computador SET HD = ?, Processador = ? WHERE ID = ?");
            comandoSQL.setString(1,obj.getHD());
            comandoSQL.setString(2,obj.getProcessador());
            comandoSQL.setInt(3,obj.getIDPC());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public static ArrayList<Computador> listar() {
        ArrayList<Computador> listaRetorno = new ArrayList<>();
        Connection con = null;
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, senha);
            PreparedStatement sql = con.prepareStatement("SELECT * FROM tb_computador;");
            ResultSet rs = sql.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Computador objComputador = new Computador();
                    objComputador.setIDPC(rs.getInt("ID"));
                    objComputador.setMarca(rs.getString("Marca"));
                    objComputador.setHD(rs.getString("HD"));
                    objComputador.setProcessador(rs.getString("Processador"));
                    listaRetorno.add(objComputador);
                }
            }
            else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {
            listaRetorno = null;
        }
        return listaRetorno;
    }
    
    public static boolean excluir(int id){
        Connection conexao = null;
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url,login,senha);
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM tb_computador WHERE ID = ?");
            comandoSQL.setInt(1,id);            
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
    
    public static ArrayList<Computador> listarPro(String processador) {
        ArrayList<Computador> listaRetorno = new ArrayList<>();
        Connection con = null;
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, senha);
            PreparedStatement sql = con.prepareStatement("SELECT * FROM tb_computador WHERE Processador = ?;");
            sql.setString(1, processador);
            ResultSet rs = sql.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    Computador objComputador = new Computador();
                    objComputador.setIDPC(rs.getInt("ID"));
                    objComputador.setMarca(rs.getString("Marca"));
                    objComputador.setHD(rs.getString("HD"));
                    objComputador.setProcessador(rs.getString("Processador"));
                    listaRetorno.add(objComputador);
                }
            }
            else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            listaRetorno = null;
        } catch (ClassNotFoundException ex) {
            listaRetorno = null;
        }
        return listaRetorno;
    }
}