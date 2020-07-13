/**********************************************************************************************
Code generated by MKL Plug-in
Copyright: Kerubin - kerubin.platform@gmail.com

WARNING: DO NOT CHANGE THIS CODE BECAUSE THE CHANGES WILL BE LOST IN THE NEXT CODE GENERATION.
***********************************************************************************************/


package br.com.kerubin.api.cadastros.fornecedor.entity.fotoimage;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import br.com.kerubin.api.servicecore.mapper.ObjectMapper;

@Component
public class FotoImageDTOConverter {

	@Inject
	private ObjectMapper mapper;

	public FotoImage convertEntityToDto(FotoImageEntity entity) {
		FotoImage dto = null;
		if (entity != null) {
			dto = mapper.map(entity, FotoImage.class, true); // Do not permit passwords fields go outside.
		}
		return dto;
	}


	public FotoImageEntity convertDtoToEntity(FotoImage dto) {
		FotoImageEntity entity = null;
		if (dto != null) {
			entity = mapper.map(dto, FotoImageEntity.class);
		}
		return entity;
	}


}