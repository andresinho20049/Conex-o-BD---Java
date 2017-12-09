/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import Conect.Connection_bd;
import com.beans.TabelaArtistaBean;
import com.beans.TabelaGeneroBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 8644879
 */
public class Genero_dao {
    public Connection con;
    public Statement st;

    public Genero_dao() {
        con = Connection_bd.getConnection();
    }
    
    public void create(TabelaGeneroBean p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Genero values (?)");
            stmt.setString(1, p.getNome());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Genero cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }

    public void update(TabelaGeneroBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Genero SET nomeGenero = ? where codigoGenero = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Genero " + p.getNome() + " foi atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    public void delete(TabelaGeneroBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Genero WHERE codigoGenero = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    
    public List<TabelaGeneroBean> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaGeneroBean> ta = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from genero");
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaGeneroBean g = new TabelaGeneroBean();

                g.setId(rs.getInt("codigogenero"));
                g.setNome(rs.getString("nomegenero"));
                ta.add(g);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return ta;

    }
    
    public List<TabelaGeneroBean> findByPrimaryKey(TabelaGeneroBean p){

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaGeneroBean> te = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from genero where codigogenero = ?");
            stmt.setInt(1, p.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaGeneroBean g = new TabelaGeneroBean();

                g.setId(rs.getInt("codigogenero"));
                g.setNome(rs.getString("nomegenero"));
                te.add(g);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return te;

    }
    
}
