package com.principal;

import Conect.Connection_bd;
import com.beans.TabelaArtistaBean;
import com.dao.Artista_dao;
import com.interfaces.FrPrincipal;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 8644879
 */
public class Principal {
    Connection con;
    
    public static void main(String args[]){
        
        try{
            
        Connection_bd.getConnection();
        System.out.println("Conectado com sucesso!!!");
        new FrPrincipal().setVisible(true);
        
        /*
        for(int i=0;i<lis.size();i++)

        {

        Artista_bean b = lis.get(i);

        System.out.println(b.getNome());

}*/
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
