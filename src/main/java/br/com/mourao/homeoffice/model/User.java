package br.com.mourao.homeoffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="tb_usuario", schema="home_office")
@Getter @Setter
@NoArgsConstructor
@Accessors(chain = true)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tb_usuario_seq")
	@Column(name="id_usuario", nullable=false)
    @SequenceGenerator(name="tb_usuario_seq",
    		sequenceName="tb_usuario_seq", allocationSize=1)
	private Integer id;
	
	private String nome;
}
