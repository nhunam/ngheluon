package saola.com.ngheluon.dataset;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "highlights")
@Table(name = "highlights")
public class Highlight extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String description;
  private String thumb;
  @Column(name = "num_of_book")
  private Integer numOfBook;
  private String slug;
  private String banner;

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "highlight_books", joinColumns = { @JoinColumn(name = "highlight_id") }, inverseJoinColumns = {
      @JoinColumn(name = "book_id") })
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnore
  private Set<Book> books;
  private Boolean active;
}