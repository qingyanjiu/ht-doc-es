package live.moku.search.repository;

import live.moku.search.models.HtDocDto;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.repository.CrudRepository;

public interface HtDocRepository extends CrudRepository<HtDocDto, String> {


    @Highlight(fields = @HighlightField(name = "message"),
            parameters = @HighlightParameters(preTags = "<b style='color:red'>", postTags = "</b>"))
    SearchHits<HtDocDto> findByMessage(String searchWord);

}
