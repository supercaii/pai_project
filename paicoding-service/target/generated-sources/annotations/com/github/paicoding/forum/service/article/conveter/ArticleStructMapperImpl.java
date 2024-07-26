package com.github.paicoding.forum.service.article.conveter;

import com.github.paicoding.forum.api.model.vo.article.SearchArticleReq;
import com.github.paicoding.forum.service.article.repository.params.SearchArticleParams;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class ArticleStructMapperImpl implements ArticleStructMapper {

    @Override
    public SearchArticleParams toSearchParams(SearchArticleReq req) {
        if ( req == null ) {
            return null;
        }

        SearchArticleParams searchArticleParams = new SearchArticleParams();

        searchArticleParams.setPageNum( req.getPageNumber() );
        searchArticleParams.setPageSize( req.getPageSize() );
        searchArticleParams.setTitle( req.getTitle() );
        searchArticleParams.setArticleId( req.getArticleId() );
        searchArticleParams.setUserId( req.getUserId() );
        searchArticleParams.setUserName( req.getUserName() );
        searchArticleParams.setStatus( req.getStatus() );
        searchArticleParams.setOfficalStat( req.getOfficalStat() );
        searchArticleParams.setToppingStat( req.getToppingStat() );

        return searchArticleParams;
    }
}
