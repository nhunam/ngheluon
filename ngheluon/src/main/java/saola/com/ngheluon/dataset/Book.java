package saola.com.ngheluon.dataset;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
@Table(name = "books")
public class Book extends BaseModel {
  private static final long serialVersionUID = 1L;
  private String title;
  private Date time;
  private String synopsis;
  private String helper;
  private String isbn;  

  /*TODO: one-to-many with table author_id highlight_books */
  private long author_id;
  private String thumb;
  private String banner;
  private String cover;
  private Date time_listen;
  private Date time_read;
  private String full_desc;
  private Boolean is_free;

}