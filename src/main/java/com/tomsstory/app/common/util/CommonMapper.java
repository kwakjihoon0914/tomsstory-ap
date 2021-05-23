package com.tomsstory.app.common.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class CommonMapper {

    final private static ModelMapper modelMapper;
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                    .setFieldMatchingEnabled(true)
                    .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                    .setMatchingStrategy(MatchingStrategies.STRICT);

    }

    public static <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source,destinationType);
    }


}
