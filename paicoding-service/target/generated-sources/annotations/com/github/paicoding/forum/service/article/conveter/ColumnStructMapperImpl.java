package com.github.paicoding.forum.service.article.conveter;

import com.github.paicoding.forum.api.model.vo.article.ColumnReq;
import com.github.paicoding.forum.api.model.vo.article.SearchColumnReq;
import com.github.paicoding.forum.api.model.vo.article.dto.ColumnDTO;
import com.github.paicoding.forum.api.model.vo.article.dto.SimpleColumnDTO;
import com.github.paicoding.forum.service.article.repository.entity.ColumnInfoDO;
import com.github.paicoding.forum.service.article.repository.params.SearchColumnParams;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
@Component
public class ColumnStructMapperImpl implements ColumnStructMapper {

    @Override
    public SearchColumnParams reqToSearchParams(SearchColumnReq req) {
        if ( req == null ) {
            return null;
        }

        SearchColumnParams searchColumnParams = new SearchColumnParams();

        searchColumnParams.setPageSize( req.getPageSize() );
        searchColumnParams.setColumn( req.getColumn() );

        return searchColumnParams;
    }

    @Override
    public ColumnDTO infotoDto(ColumnInfoDO columnInfoDO) {
        if ( columnInfoDO == null ) {
            return null;
        }

        ColumnDTO columnDTO = new ColumnDTO();

        columnDTO.setColumnId( columnInfoDO.getId() );
        columnDTO.setColumn( columnInfoDO.getColumnName() );
        columnDTO.setAuthor( columnInfoDO.getUserId() );
        columnDTO.setIntroduction( columnInfoDO.getIntroduction() );
        columnDTO.setCover( columnInfoDO.getCover() );
        columnDTO.setSection( columnInfoDO.getSection() );
        columnDTO.setState( columnInfoDO.getState() );
        columnDTO.setNums( columnInfoDO.getNums() );
        columnDTO.setType( columnInfoDO.getType() );

        columnDTO.setPublishTime( columnInfoDO.getPublishTime().getTime() );
        columnDTO.setFreeStartTime( columnInfoDO.getFreeStartTime().getTime() );
        columnDTO.setFreeEndTime( columnInfoDO.getFreeEndTime().getTime() );

        return columnDTO;
    }

    @Override
    public List<ColumnDTO> infoToDtos(List<ColumnInfoDO> columnInfoDOs) {
        if ( columnInfoDOs == null ) {
            return null;
        }

        List<ColumnDTO> list = new ArrayList<ColumnDTO>( columnInfoDOs.size() );
        for ( ColumnInfoDO columnInfoDO : columnInfoDOs ) {
            list.add( infotoDto( columnInfoDO ) );
        }

        return list;
    }

    @Override
    public SimpleColumnDTO infoToSimpleDto(ColumnInfoDO columnInfoDO) {
        if ( columnInfoDO == null ) {
            return null;
        }

        SimpleColumnDTO simpleColumnDTO = new SimpleColumnDTO();

        simpleColumnDTO.setColumnId( columnInfoDO.getId() );
        simpleColumnDTO.setColumn( columnInfoDO.getColumnName() );
        simpleColumnDTO.setCover( columnInfoDO.getCover() );

        return simpleColumnDTO;
    }

    @Override
    public List<SimpleColumnDTO> infoToSimpleDtos(List<ColumnInfoDO> columnInfoDOs) {
        if ( columnInfoDOs == null ) {
            return null;
        }

        List<SimpleColumnDTO> list = new ArrayList<SimpleColumnDTO>( columnInfoDOs.size() );
        for ( ColumnInfoDO columnInfoDO : columnInfoDOs ) {
            list.add( infoToSimpleDto( columnInfoDO ) );
        }

        return list;
    }

    @Override
    public ColumnInfoDO toDo(ColumnReq req) {
        if ( req == null ) {
            return null;
        }

        ColumnInfoDO columnInfoDO = new ColumnInfoDO();

        columnInfoDO.setColumnName( req.getColumn() );
        columnInfoDO.setUserId( req.getAuthor() );
        columnInfoDO.setIntroduction( req.getIntroduction() );
        columnInfoDO.setCover( req.getCover() );
        columnInfoDO.setState( req.getState() );
        columnInfoDO.setSection( req.getSection() );
        columnInfoDO.setNums( req.getNums() );
        columnInfoDO.setType( req.getType() );

        columnInfoDO.setFreeStartTime( new java.util.Date(req.getFreeStartTime()) );
        columnInfoDO.setFreeEndTime( new java.util.Date(req.getFreeEndTime()) );

        return columnInfoDO;
    }
}
