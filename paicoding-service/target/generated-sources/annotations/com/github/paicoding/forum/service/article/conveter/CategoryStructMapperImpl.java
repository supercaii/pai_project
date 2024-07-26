package com.github.paicoding.forum.service.article.conveter;

import com.github.paicoding.forum.api.model.vo.article.CategoryReq;
import com.github.paicoding.forum.api.model.vo.article.SearchCategoryReq;
import com.github.paicoding.forum.api.model.vo.article.dto.CategoryDTO;
import com.github.paicoding.forum.service.article.repository.entity.CategoryDO;
import com.github.paicoding.forum.service.article.repository.params.SearchCategoryParams;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class CategoryStructMapperImpl implements CategoryStructMapper {

    @Override
    public SearchCategoryParams toSearchParams(SearchCategoryReq req) {
        if ( req == null ) {
            return null;
        }

        SearchCategoryParams searchCategoryParams = new SearchCategoryParams();

        if ( req.getPageNumber() != null ) {
            searchCategoryParams.setPageNum( req.getPageNumber() );
        }
        if ( req.getPageSize() != null ) {
            searchCategoryParams.setPageSize( req.getPageSize() );
        }
        searchCategoryParams.setCategory( req.getCategory() );

        return searchCategoryParams;
    }

    @Override
    public CategoryDTO toDTO(CategoryDO categoryDO) {
        if ( categoryDO == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setCategoryId( categoryDO.getId() );
        categoryDTO.setCategory( categoryDO.getCategoryName() );
        categoryDTO.setRank( categoryDO.getRank() );
        categoryDTO.setStatus( categoryDO.getStatus() );

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> toDTOs(List<CategoryDO> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDTO> list1 = new ArrayList<CategoryDTO>( list.size() );
        for ( CategoryDO categoryDO : list ) {
            list1.add( toDTO( categoryDO ) );
        }

        return list1;
    }

    @Override
    public CategoryDO toDO(CategoryReq categoryReq) {
        if ( categoryReq == null ) {
            return null;
        }

        CategoryDO categoryDO = new CategoryDO();

        categoryDO.setCategoryName( categoryReq.getCategory() );
        categoryDO.setRank( categoryReq.getRank() );

        return categoryDO;
    }
}
