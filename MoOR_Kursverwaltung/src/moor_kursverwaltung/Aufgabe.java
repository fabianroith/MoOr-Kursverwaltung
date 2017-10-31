/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moor_kursverwaltung;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Aufgabe {
    private Date date;
    private String autor;
    private String thema;
    private String beschreibung;
    private LinkedList<Hashtag>hashtags = new LinkedList<>();
    private LinkedList<MyFile>musterloesungen = new LinkedList<>();
    private LinkedList<MyFile>zusatzmaterialien = new LinkedList<>();

    public Aufgabe() {
    }

    public Aufgabe(Date date, String autor, String thema, String beschreibung) {
        this.date = date;
        this.autor = autor;
        this.thema = thema;
        this.beschreibung = beschreibung;
    }

    public Aufgabe(Date date, String autor, String thema, String beschreibung, LinkedList<Hashtag> hashtags, LinkedList<MyFile>musterloesungen, LinkedList<MyFile>zusatzmaterialien) {
        this.date = date;
        this.autor = autor;
        this.thema = thema;
        this.beschreibung = beschreibung;
        this.hashtags = hashtags;
        this.musterloesungen = musterloesungen;
        this.zusatzmaterialien = zusatzmaterialien;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public LinkedList<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(LinkedList<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
    
    public void addHashtag(Hashtag htg){
        this.hashtags.add(htg);
    }

    public LinkedList<MyFile> getMusterloesungen() {
        return musterloesungen;
    }

    public void setMusterloesungen(LinkedList<MyFile> musterloesungen_files) {
        this.musterloesungen = musterloesungen_files;
    }
    
    public void addMusterloesung(MyFile file){
        this.musterloesungen.add(file);
    }

    public LinkedList<MyFile> getZusatzmaterialien() {
        return zusatzmaterialien;
    }

    public void setZusatzmaterialien(LinkedList<MyFile> zusatzmat_files) {
        this.zusatzmaterialien = zusatzmat_files;
    }
    
    public void addZusatzmaterial(MyFile file){
        zusatzmaterialien.add(file);
    }
    
}
