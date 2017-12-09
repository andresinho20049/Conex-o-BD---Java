/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import Conect.Connection_bd;
import com.beans.TabelaArtistaBean;
import com.beans.TabelaCDsBean;
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
public class CDs_dao {
    public Connection con;
    public Statement st;

    public CDs_dao() {
        con = Connection_bd.getConnection();
    }
    
    public void create(TabelaCDsBean p) {
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into CDs (titulo,preco,codigoArtista,codigoGenero) values (?,?,?,?)");
            stmt.setString(1, p.getTitulo());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getArtista().getId());
            stmt.setInt(4, p.getGenero().getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "CD cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: \n " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }

    public void update(TabelaCDsBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE CDs SET titulo = ?,preco = ?,codigoArtista = ?, codigoGenero = ? "
                    + "where codigoCD = ?");
            stmt.setString(1, p.getTitulo());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getArtista().getId());
            stmt.setInt(4, p.getGenero().getId());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "CD " + p.getTitulo()+ " foi atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    public void delete(TabelaCDsBean p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM CDs WHERE codigoCD = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Connection_bd.closeConnection(con, stmt);
        }

    }
    
    public List<TabelaCDsBean> findAll() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaCDsBean> ta = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select codigoCD,titulo,preco,Artista.codigoArtista,nomeArtista,Genero.codigoGenero,nomeGenero "
                    + "from CDs inner join Artista on Artista.codigoArtista = CDs.codigoArtista "
                    + "inner join Genero on Genero.codigoGenero = CDs.codigoGenero");
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaCDsBean c = new TabelaCDsBean();
                TabelaArtistaBean a = new TabelaArtistaBean();
                TabelaGeneroBean g = new TabelaGeneroBean();

                c.setId(rs.getInt("codigoCD"));
                c.setTitulo(rs.getString("titulo"));
                c.setPreco(rs.getDouble("preco"));
                a.setId(rs.getInt("codigoArtista"));
                a.setNome(rs.getString("nomeArtista"));
                g.setId(rs.getInt("codigoGenero"));
                g.setNome(rs.getString("nomeGenero"));
                c.setArtista(a);
                c.setGenero(g);
                ta.add(c);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return ta;

    }
    
    public List<TabelaCDsBean> findByPrimaryKey(TabelaCDsBean p){

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TabelaCDsBean> te = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select codigoCD,titulo,preco,Artista.codigoArtista,nomeArtista,Genero.codigoGenero,nomeGenero "
                    + "from CDs inner join Artista on Artista.codigoArtista = CDs.codigoArtista "
                    + "inner join Genero on Genero.codigoGenero = CDs.codigoGenero where codigoCD = ?");
            stmt.setInt(1, p.getId());
            rs = stmt.executeQuery();

            while (rs.next()) {

                TabelaCDsBean c = new TabelaCDsBean();
                TabelaArtistaBean a = new TabelaArtistaBean();
                TabelaGeneroBean g = new TabelaGeneroBean();

                c.setId(rs.getInt("codigoCD"));
                c.setTitulo(rs.getString("titulo"));
                c.setPreco(rs.getDouble("preco"));
                a.setId(rs.getInt("codigoArtista"));
                a.setNome(rs.getString("nomeArtista"));
                g.setId(rs.getInt("codigoGenero"));
                g.setNome(rs.getString("nomeGenero"));
                c.setArtista(a);
                c.setGenero(g);
                te.add(c);
                          
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca! \n" + ex);
        } finally {
        }

        return te;

    }
    
    
}
