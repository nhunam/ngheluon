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

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
@Table(name = "categories")
public class Category extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String description;
  private String icon;
  private String slug;
  private String thumb;

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "category_books", joinColumns = { @JoinColumn(name = "category_id") }, inverseJoinColumns = {
      @JoinColumn(name = "book_id") })
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnore
  private Set<Book> books;
  private Boolean active;
}