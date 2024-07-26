package com.github.paicoding.forum.service.article.conveter;

import com.github.paicoding.forum.api.model.vo.article.ColumnArticleReq;
import com.github.paicoding.forum.api.model.vo.article.SearchColumnArticleReq;
import com.github.paicoding.forum.service.article.repository.entity.ColumnArticleDO;
import com.github.paicoding.forum.service.article.repository.params.ColumnArticleParams;
import com.github.paicoding.forum.service.article.repository.params.SearchColumnArticleParams;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class ColumnArticleStructMapperImpl implements ColumnArticleStructMapper {

    @Override
    public SearchColumnArticleParams toSearchParams(SearchColumnArticleReq req) {
        if ( req == null ) {
            return null;
        }

        SearchColumnArticleParams searchColumnArticleParams = new SearchColumnArticleParams();

        searchColumnArticleParams.setPageSize( req.getPageSize() );
        searchColumnArticleParams.setColumn( req.getColumn() );
        searchColumnArticleParams.setColumnId( req.getColumnId() );
        searchColumnArticleParams.setArticleTitle( req.getArticleTitle() );

        return searchColumnArticleParams;
    }

    @Override
    public ColumnArticleParams toParams(ColumnArticleReq req) {
        if ( req == null ) {
            return null;
        }

        ColumnArticleParams columnArticleParams = new ColumnArticleParams();

        columnArticleParams.setColumnId( req.getColumnId() );
        columnArticleParams.setArticleId( req.getArticleId() );

        return columnArticleParams;
    }

    @Override
    public ColumnArticleDO reqToDO(ColumnArticleReq req) {
        if ( req == null ) {
            return null;
        }

        ColumnArticleDO columnArticleDO = new ColumnArticleDO();

        columnArticleDO.setId( req.getId() );
        columnArticleDO.setColumnId( req.getColumnId() );
        columnArticleDO.setArticleId( req.getArticleId() );

        return columnArticleDO;
    }
}
