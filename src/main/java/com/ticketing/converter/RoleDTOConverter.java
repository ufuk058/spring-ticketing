package com.ticketing.converter;

import com.ticketing.dto.RoleDTO;
import com.ticketing.service.RoleService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOConverter implements Converter<String, RoleDTO> {

    private final RoleService roleService;


    public RoleDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        if(source.isEmpty()){
            return null;
        }
        return roleService.findById(Long.parseLong(source));
    }
}
