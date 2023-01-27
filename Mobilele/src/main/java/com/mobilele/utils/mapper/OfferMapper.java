package com.mobilele.utils.mapper;

import com.mobilele.models.dtos.bindingModels.AddOfferModel;
import com.mobilele.models.entities.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    Offer addOfferModelToOffer(AddOfferModel addOfferModel);
}
