package com.jalarbee.lindo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.Jsr310Converters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

@Configuration
public class LindoRestConfig {


    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(new HashSet<>(getConverters()));
        bean.afterPropertiesSet();
        ConversionService service = bean.getObject();
        return service;
    }


    private Set<Converter<?, ?>> getConverters() {
        Set<Converter<?,?>> converters = new HashSet<>();
        converters.addAll(Jsr310Converters.getConvertersToRegister());
        converters.add(new TimeWriteConverter());
        converters.add(new TimeReadConverter());
        converters.add(new StringToUUIDConverter());
        converters.add(new UUIDToStringConverter());
        return converters;
    }

    public static class StringToUUIDConverter implements Converter<String, UUID> {
        public UUID convert(String source) {
            return UUID.fromString(source);
        }
    }

    public static class UUIDToStringConverter implements Converter<UUID, String> {
        public String convert(UUID uuid) {
            return uuid.toString();
        }
    }

    public static class TimeWriteConverter implements Converter<LocalDateTime, Long> {
        @Override
        public Long convert(LocalDateTime source) {
            return source.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }
    }
    public static class TimeReadConverter implements Converter<Long, LocalDateTime> {
        @Override
        public LocalDateTime convert(Long source) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(source), ZoneId.systemDefault());
        }
    }
}
