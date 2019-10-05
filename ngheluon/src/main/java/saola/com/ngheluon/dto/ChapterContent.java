package saola.com.ngheluon.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import saola.com.ngheluon.dataset.Chapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChapterContent implements Serializable {
  private static final long serialVersionUID = 1L;
  private UUID id;
  private String title;
  private String content;
  private Integer order;

  public ChapterContent(Chapter chapter) {
    this(chapter, true);
  }

  public ChapterContent(Chapter chapter, boolean withContent) {
    setId(chapter.getId());
    setTitle(chapter.getTitle());
    setOrder(chapter.getOrder());
    if (withContent) {
      setContent(chapter.getContent());
    }
  }
}