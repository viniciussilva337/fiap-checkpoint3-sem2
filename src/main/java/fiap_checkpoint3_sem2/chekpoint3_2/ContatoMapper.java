package fiap_checkpoint3_sem2.chekpoint3_2;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    ContatoDTO toDTO(Contato contato);
    Contato toEntity(ContatoDTO contatoDTO);

}
