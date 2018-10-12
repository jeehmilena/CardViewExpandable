package com.jessica.digitalhouse.cardviewexpandable.model;

public class Grade {
    private String diaSemana;
    private String nomeCurso;
    private String nomeProfessor;
    private String horario;
    private int imagem;

    public Grade(String diaSemana, String nomeCurso, String nomeProfessor, String horario, int imagem) {
        this.diaSemana = diaSemana;
        this.nomeCurso = nomeCurso;
        this.nomeProfessor = nomeProfessor;
        this.horario = horario;
        this.imagem = imagem;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
