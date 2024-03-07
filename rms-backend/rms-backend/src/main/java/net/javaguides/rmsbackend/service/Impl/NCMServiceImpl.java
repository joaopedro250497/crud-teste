package net.javaguides.rmsbackend.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.rmsbackend.dto.NCMDto;
import net.javaguides.rmsbackend.entity.NCM;
import net.javaguides.rmsbackend.exception.ResourceNotFoundException;
import net.javaguides.rmsbackend.mapper.NCMMapper;
import net.javaguides.rmsbackend.repository.NCMRepository;
import net.javaguides.rmsbackend.service.NCMService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NCMServiceImpl implements NCMService {

    private NCMRepository nCMRepository;

    @Override
    public NCMDto createNCM(NCMDto nCMDto) {

        NCM nCM = NCMMapper.mapToNCM(nCMDto);
        NCM savedNCM = nCMRepository.save(nCM);
        return NCMMapper.mapToNCMDto(savedNCM);
    }

    @Override
    public NCMDto getNCMById(Long nCMId) {
        NCM nCM = nCMRepository.findById(nCMId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("NCM inexistente pelo ID fornecido: " + nCMId));
        return NCMMapper.mapToNCMDto(nCM);
    }

    @Override
    public List<NCMDto> getAllNCM() {
        List<NCM> nCMs = nCMRepository.findAll();
        return nCMs.stream().map((nCM) -> NCMMapper.mapToNCMDto(nCM))
                .collect(Collectors.toList());
    }

    @Override
    public NCMDto updateNCM(Long nCMId, NCMDto updatedNCM) {

        NCM nCM = nCMRepository.findById(nCMId).orElseThrow(
                () -> new ResourceNotFoundException("NCM inexistente pelo ID fornecido: " + nCMId)
        );


        nCM.setDescricao(updatedNCM.getDescricao());
        nCM.setClassificacao(updatedNCM.getClassificacao());

        NCM updatedNCMObj = nCMRepository.save(nCM);

        return NCMMapper.mapToNCMDto(updatedNCMObj);
    }

    @Override
    public void deleteNCM(Long nCMId) {

        NCM nCM = nCMRepository.findById(nCMId).orElseThrow(
                () -> new ResourceNotFoundException("NCM inexistente pelo ID fornecido: " + nCMId)
        );

        nCMRepository.deleteById(nCMId);
    }
}
