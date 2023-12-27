package by.market.foodstuffs.mappers;

import by.market.foodstuffs.mappers.utils.EncodedMapping;
import by.market.foodstuffs.mappers.utils.PasswordEncoderMapper;
import by.market.foodstuffs.models.dtos.RegisterDto;
import by.market.foodstuffs.models.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {PasswordEncoderMapper.class})
public interface UserMapper {
    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User registerDtoToUser(RegisterDto registerDto);
}
