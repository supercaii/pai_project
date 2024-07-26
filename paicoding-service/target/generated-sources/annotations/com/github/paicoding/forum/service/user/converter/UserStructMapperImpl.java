package com.github.paicoding.forum.service.user.converter;

import com.github.paicoding.forum.api.model.vo.user.SearchZsxqUserReq;
import com.github.paicoding.forum.service.user.repository.params.SearchZsxqWhiteParams;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class UserStructMapperImpl implements UserStructMapper {

    @Override
    public SearchZsxqWhiteParams toSearchParams(SearchZsxqUserReq req) {
        if ( req == null ) {
            return null;
        }

        SearchZsxqWhiteParams searchZsxqWhiteParams = new SearchZsxqWhiteParams();

        if ( req.getPageNumber() != null ) {
            searchZsxqWhiteParams.setPageNum( req.getPageNumber() );
        }
        searchZsxqWhiteParams.setStatus( req.getState() );
        if ( req.getPageSize() != null ) {
            searchZsxqWhiteParams.setPageSize( req.getPageSize() );
        }
        searchZsxqWhiteParams.setStarNumber( req.getStarNumber() );
        searchZsxqWhiteParams.setName( req.getName() );
        searchZsxqWhiteParams.setUserCode( req.getUserCode() );

        return searchZsxqWhiteParams;
    }
}
