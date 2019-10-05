package saola.com.ngheluon.dataset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
@Table(name = "books")
public class Book extends BaseModel<UUID> {
  private static final long serialVersionUID = 1L;
  private String title;
  private String helper;
  private String isbn;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;
  private String thumb;
  private String banner;
  private String cover;
  @Column(name = "time_listen")
  private Long timeListen;
  @Column(name = "time_read")
  private Long timeRead;
  @Column(name = "full_desc")
  private String fullDesc;
  @Column(name = "is_free")
  private Boolean isFree;
  @Column(name = "title_en")
  private String titleEn;
  @Column(name = "num_of_chapter")
  private Long numOfChapter;
  @Column(name = "short_desc")
  private String shortDesc;
  private String slug;
  private Boolean active;
}