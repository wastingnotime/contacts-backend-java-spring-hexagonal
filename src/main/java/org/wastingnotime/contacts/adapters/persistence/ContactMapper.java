package org.wastingnotime.contacts.adapters.persistence;

import org.wastingnotime.contacts.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target = "id", source = "id.value")
    ContactEntity toJpaEntity(Contact contact);
}
