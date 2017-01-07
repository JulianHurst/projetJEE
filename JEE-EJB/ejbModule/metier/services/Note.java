package metier.services;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="note")
@SequenceGenerator(name="note_id",sequenceName="note_id_seq",allocationSize=1)
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="note_id")
	private long id;
	@Column(name = "idCollaborateur")
	private long idCollaborateur;
	@Column(name = "dateNote")
	private Date dateNote;
}
