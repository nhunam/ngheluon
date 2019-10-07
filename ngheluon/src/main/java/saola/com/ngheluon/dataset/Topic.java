package saola.com.ngheluon.dataset;

import javax.persistence.CascadeType;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "topics")
@Table(name = "topics")
public class Topic extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String slug;
  private String description;

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "topic_books", joinColumns = { @JoinColumn(name = "topic_id") }, inverseJoinColumns = {
      @JoinColumn(name = "book_id") })
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnore
  private Set<Book> books;
  private Boolean active = true;
}
