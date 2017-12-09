/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import Conect.Connection_bd;
import com.beans.TabelaArtistaBean;
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
public class Artista_dao {
    public Connection con;
    public Statement st;

    public Artista_dao() {
        con = Connection_bd.getConnection();
    }
    
    public void create(TabelaArtistaBean p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into Artista values (?)");
            stmt.setString(1, p.getNome());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Artista cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }

    public void update(TabelaArtistaBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Artista SET nomeArtista = ? where codigoArtista = ?");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Artista " + p.getNome() + " foi atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    public void delete(TabelaArtistaBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Artista WHERE codigoArtista = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    
    public List<TabelaArtistaBean> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaArtistaBean> ta = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from artista");
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaArtistaBean a = new TabelaArtistaBean();

                a.setId(rs.getInt("codigoartista"));
                a.setNome(rs.getString("nomeartista"));
                ta.add(a);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return ta;

    }
    
    public List<TabelaArtistaBean> findByPrimaryKey(TabelaArtistaBean p){

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaArtistaBean> te = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from artista where codigoartista = ?");
            stmt.setInt(1, p.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaArtistaBean a = new TabelaArtistaBean();

                a.setId(rs.getInt("codigoartista"));
                a.setNome(rs.getString("nomeartista"));
                te.add(a);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return te;

    }
    
    
    
}
