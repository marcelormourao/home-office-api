package br.com.mourao.homeoffice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.mourao.homeoffice.util.JsonTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name="tb_atividade", schema="home_office")
@Getter @Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Activity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tb_atividade_seq")
	@Column(name="id_atividade", nullable=false)
    @SequenceGenerator(name="tb_atividade_seq",
    		sequenceName="tb_atividade_seq", allocationSize=1)
	private Integer id;
	
	@JoinColumn(name="id_usuario", nullable=false)
	@ManyToOne
	private User user;
	
	@Column(name="descricao", nullable=false)
	private String description;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone="America/Sao_Paulo")
	@Column(name="data", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm", timezone="America/Sao_Paulo")
	@Column(name="batida_inicial", nullable=false)
//	@JsonSerialize(using=JsonTimeSerializer.class)
	@Temporal(TemporalType.TIME)
	private Date initialTime;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm", timezone="America/Sao_Paulo")
	@Column(name="saida_almoco", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date lunchTime;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm", timezone="America/Sao_Paulo")
	@Column(name="retorno_almoco", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date lunchReturn;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm", timezone="America/Sao_Paulo")
	@Column(name="batida_final", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date finalPeriod;
	
}
