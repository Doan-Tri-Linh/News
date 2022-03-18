    package com.laptrinhjavaweb.converter;

    import com.laptrinhjavaweb.dto.NewDTO;
    import com.laptrinhjavaweb.entity.NewEntity;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;

    @Component
    public class NewConverter {

        @Autowired
        ModelMapper modelMapper;

    //    public NewEntity toEntity(NewDTO newDTO){
    //        NewEntity entity = new NewEntity();
    //        entity.setTitle(newDTO.getTitle());
    //        entity.setContent(newDTO.getContent());
    //        entity.setThumbnail(newDTO.getThumbnail());
    //        entity.setShortdescription(newDTO.getShortDescription());
    //
    //        return entity;
    //    }

        public NewEntity toEntity(NewDTO newDTO){
            NewEntity entity = new NewEntity();
            entity = modelMapper.map(newDTO,NewEntity.class);
            return entity;
        }


    //    public NewDTO toNewDTO(NewEntity newEntity){
    //        NewDTO dto = new NewDTO();
    //        if (newEntity.getId() != null) {
    //            dto.setId(newEntity.getId());
    //        }
    //
    //        dto.setTitle(newEntity.getTitle());
    //        dto.setContent(newEntity.getContent());
    //        dto.setThumbnail(newEntity.getThumbnail());
    //        dto.setShortDescription(newEntity.getShortdescription());
    //        dto.setCreatedDate(newEntity.getCreatedDate());
    //        dto.setCreatedBy(newEntity.getCreatedBy());
    //        dto.setModifiedDate(newEntity.getModifiedDate());
    //        dto.setModifiedBy(newEntity.getModifiedBy());
    //
    //        return dto;
    //    }

        public NewDTO toNewDTO(NewEntity newEntity){
            NewDTO dto = new NewDTO();
            if (newEntity.getId() != null) {
                dto.setId(newEntity.getId());
            }
            dto = modelMapper.map(newEntity,NewDTO.class);
            return dto;
        }

        public NewEntity toEntity(NewDTO dto , NewEntity entity){
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            entity.setThumbnail(dto.getThumbnail());
            entity.setShortdescription(dto.getShortDescription());

            return entity;
        }

    //    public NewEntity toEntity(NewDTO dto , NewEntity entity){
    //        entity = modelMapper.map(dto,NewEntity.class);
    //        return entity;
    //    }
    }
