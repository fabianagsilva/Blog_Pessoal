package com.gerenation.blogpessoal.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Fabiana
 * @version 1.0
 */
@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Insira um título")
	@Size(min = 0, max = 100, message = "O atributo deve ter 100 caracteres")
	private String titulo;

	@NotBlank(message = "Insira o texto")
	@Size(min = 0, max = 1000, message = "O atributo deve ter 1000 caracteres")
	private String texto;

	@UpdateTimestamp
	public static LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static LocalDateTime getData() {
		return data;
	}

	public static void setData(LocalDateTime data) {
		Postagem.data = data;
	}

}
