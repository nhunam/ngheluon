package saola.com.ngheluon.dataset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "chapters")
@Table(name = "chapters")
public class Chapter extends BaseModel {
  private static final long serialVersionUID = 1L;
  private String synopsis;
  private String content;
  private String file;
  @Column(name = "\"order\"")
  private Integer order;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "book_id")
  private Book book;
  private String title;
}