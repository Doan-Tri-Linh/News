package com.laptrinhjavaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class AutoConvert {
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
