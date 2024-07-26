package com.github.paicoding.forum.service.config.converter;

import com.github.paicoding.forum.api.model.vo.banner.ConfigReq;
import com.github.paicoding.forum.api.model.vo.banner.SearchConfigReq;
import com.github.paicoding.forum.api.model.vo.banner.dto.ConfigDTO;
import com.github.paicoding.forum.api.model.vo.config.GlobalConfigReq;
import com.github.paicoding.forum.api.model.vo.config.SearchGlobalConfigReq;
import com.github.paicoding.forum.api.model.vo.config.dto.GlobalConfigDTO;
import com.github.paicoding.forum.service.config.repository.entity.ConfigDO;
import com.github.paicoding.forum.service.config.repository.entity.GlobalConfigDO;
import com.github.paicoding.forum.service.config.repository.params.SearchConfigParams;
import com.github.paicoding.forum.service.config.repository.params.SearchGlobalConfigParams;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class ConfigStructMapperImpl implements ConfigStructMapper {

    @Override
    public SearchConfigParams toSearchParams(SearchConfigReq req) {
        if ( req == null ) {
            return null;
        }

        SearchConfigParams searchConfigParams = new SearchConfigParams();

        if ( req.getPageNumber() != null ) {
            searchConfigParams.setPageNum( req.getPageNumber() );
        }
        if ( req.getPageSize() != null ) {
            searchConfigParams.setPageSize( req.getPageSize() );
        }
        searchConfigParams.setType( req.getType() );
        searchConfigParams.setName( req.getName() );

        return searchConfigParams;
    }

    @Override
    public SearchGlobalConfigParams toSearchGlobalParams(SearchGlobalConfigReq req) {
        if ( req == null ) {
            return null;
        }

        SearchGlobalConfigParams searchGlobalConfigParams = new SearchGlobalConfigParams();

        if ( req.getPageNumber() != null ) {
            searchGlobalConfigParams.setPageNum( req.getPageNumber() );
        }
        searchGlobalConfigParams.setKey( req.getKeywords() );
        if ( req.getPageSize() != null ) {
            searchGlobalConfigParams.setPageSize( req.getPageSize() );
        }
        searchGlobalConfigParams.setValue( req.getValue() );
        searchGlobalConfigParams.setComment( req.getComment() );

        return searchGlobalConfigParams;
    }

    @Override
    public ConfigDTO toDTO(ConfigDO configDO) {
        if ( configDO == null ) {
            return null;
        }

        ConfigDTO configDTO = new ConfigDTO();

        configDTO.setId( configDO.getId() );
        configDTO.setCreateTime( configDO.getCreateTime() );
        configDTO.setUpdateTime( configDO.getUpdateTime() );
        configDTO.setType( configDO.getType() );
        configDTO.setName( configDO.getName() );
        configDTO.setBannerUrl( configDO.getBannerUrl() );
        configDTO.setJumpUrl( configDO.getJumpUrl() );
        configDTO.setContent( configDO.getContent() );
        configDTO.setRank( configDO.getRank() );
        configDTO.setStatus( configDO.getStatus() );
        configDTO.setExtra( configDO.getExtra() );
        configDTO.setTags( configDO.getTags() );

        return configDTO;
    }

    @Override
    public List<ConfigDTO> toDTOS(List<ConfigDO> configDOS) {
        if ( configDOS == null ) {
            return null;
        }

        List<ConfigDTO> list = new ArrayList<ConfigDTO>( configDOS.size() );
        for ( ConfigDO configDO : configDOS ) {
            list.add( toDTO( configDO ) );
        }

        return list;
    }

    @Override
    public ConfigDO toDO(ConfigReq configReq) {
        if ( configReq == null ) {
            return null;
        }

        ConfigDO configDO = new ConfigDO();

        configDO.setType( configReq.getType() );
        configDO.setName( configReq.getName() );
        configDO.setBannerUrl( configReq.getBannerUrl() );
        configDO.setJumpUrl( configReq.getJumpUrl() );
        configDO.setContent( configReq.getContent() );
        configDO.setRank( configReq.getRank() );
        configDO.setTags( configReq.getTags() );

        return configDO;
    }

    @Override
    public GlobalConfigDTO toGlobalDTO(GlobalConfigDO configDO) {
        if ( configDO == null ) {
            return null;
        }

        GlobalConfigDTO globalConfigDTO = new GlobalConfigDTO();

        globalConfigDTO.setKeywords( configDO.getKey() );
        globalConfigDTO.setId( configDO.getId() );
        globalConfigDTO.setValue( configDO.getValue() );
        globalConfigDTO.setComment( configDO.getComment() );

        return globalConfigDTO;
    }

    @Override
    public List<GlobalConfigDTO> toGlobalDTOS(List<GlobalConfigDO> configDOS) {
        if ( configDOS == null ) {
            return null;
        }

        List<GlobalConfigDTO> list = new ArrayList<GlobalConfigDTO>( configDOS.size() );
        for ( GlobalConfigDO globalConfigDO : configDOS ) {
            list.add( toGlobalDTO( globalConfigDO ) );
        }

        return list;
    }

    @Override
    public GlobalConfigDO toGlobalDO(GlobalConfigReq req) {
        if ( req == null ) {
            return null;
        }

        GlobalConfigDO globalConfigDO = new GlobalConfigDO();

        globalConfigDO.setKey( req.getKeywords() );
        globalConfigDO.setId( req.getId() );
        globalConfigDO.setValue( req.getValue() );
        globalConfigDO.setComment( req.getComment() );

        return globalConfigDO;
    }
}
