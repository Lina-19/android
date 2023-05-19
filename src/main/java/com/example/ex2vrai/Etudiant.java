package com.example.ex2vrai;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Etudiant {
    private  int id;
    private String nom,prenom,classe,phone;
    private Bitmap image;
    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void addnote(Note n ){
        if(this.notes==null)
           this.notes=new ArrayList<Note>() ;
        this.notes.add(n);

    }
    public Bitmap getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getClasse() {
        return classe;
    }

    public String getNom() {
        return nom;
    }

    public String getPhone() {
        return phone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Etudiant(){

    }
    public Etudiant(int id,String nom,String prenom,String classe,String phone,Bitmap image){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.classe=classe;
        this.phone=phone;
        this.image=image;
    }
}
