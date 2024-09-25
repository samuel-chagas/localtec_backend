package com.Localtec.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name= "Avaliacao")
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name= "nota")
	private int nota;

	@Column(name= "comentario")
	private String comentario;
	
	@Column(name= "data")
	private LocalDate data;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
	
	
	@PrePersist
	  protected void onCreate() {
	    data = LocalDate.now();
	    System.out.println(data);
	  }
	
	public Avaliacao() {
		
	}
	
	public Avaliacao(int nota, String comentario, LocalDate data, Usuario usuario) {
		super();
		this.nota = nota;
		this.comentario = comentario;
		this.data = data;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", nota=" + nota + ", comentario=" + comentario + ", data=" + data + ", usuario="
				+ usuario + "]";
	}

	public long getId() {
		return id;
	}
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
