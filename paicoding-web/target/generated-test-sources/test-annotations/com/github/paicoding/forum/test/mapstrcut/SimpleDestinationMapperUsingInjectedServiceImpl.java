package com.github.paicoding.forum.test.mapstrcut;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T11:24:12+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
@Component
public class SimpleDestinationMapperUsingInjectedServiceImpl extends SimpleDestinationMapperUsingInjectedService {

    @Override
    public SimpleDestination sourceToDestination(SimpleSource source) {
        if ( source == null ) {
            return null;
        }

        SimpleDestination simpleDestination = new SimpleDestination();

        return simpleDestination;
    }
}
