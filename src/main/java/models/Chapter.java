package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chapter {
    private String chapterId, title, numChapter, externalUrl, availibleLanguage;
}
