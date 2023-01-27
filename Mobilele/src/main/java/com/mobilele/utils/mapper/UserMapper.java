package com.mobilele.utils.mapper;

import com.mobilele.models.dtos.bindingModels.UserRegisterModel;
import com.mobilele.models.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(target = "active", constant = "true")
    User userModelToUser(UserRegisterModel userRegisterModel);
}
