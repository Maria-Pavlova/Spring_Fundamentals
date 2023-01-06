package com.mobilele.utils.mapper;

import com.mobilele.models.dtos.UserRegisterModel;
import com.mobilele.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "active", constant = "true")
    User userModelToUser(UserRegisterModel userRegisterModel);
}
