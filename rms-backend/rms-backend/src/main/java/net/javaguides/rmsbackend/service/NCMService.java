package net.javaguides.rmsbackend.service;

import net.javaguides.rmsbackend.dto.NCMDto;

import java.util.List;

public interface NCMService {
    NCMDto createNCM(NCMDto nCMDto);

    NCMDto getNCMById(Long nCMId);

    List<NCMDto> getAllNCM();

    NCMDto updateNCM(Long nCMId, NCMDto updatedNCM);

    void deleteNCM(Long nCMId);
}
