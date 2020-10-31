package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "id", source = "id.value")
    ContactEntity toJpaEntity(Contact contact);
}
