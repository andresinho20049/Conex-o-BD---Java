/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

/**
 *
 * @author 8644879
 */
public class TabelaCDsBean {
    private int id;
    private String titulo;
    private double preco;
    private TabelaGeneroBean genero;
    private TabelaArtistaBean artista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TabelaGeneroBean getGenero() {
        return genero;
    }

    public void setGenero(TabelaGeneroBean genero) {
        this.genero = genero;
    }

    public TabelaArtistaBean getArtista() {
        return artista;
    }

    public void setArtista(TabelaArtistaBean artista) {
        this.artista = artista;
    }
    
    public String toString() {
        return getTitulo();
    }
    
    
}
