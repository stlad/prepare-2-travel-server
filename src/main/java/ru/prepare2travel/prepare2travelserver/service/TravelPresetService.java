package ru.prepare2travel.prepare2travelserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prepare2travel.prepare2travelserver.mapper.TravelPresetMapper;
import ru.prepare2travel.prepare2travelserver.model.TravelPreset;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelPresetDTO;
import ru.prepare2travel.prepare2travelserver.repository.TravelPresetRepository;

import java.util.List;

@Service
public class TravelPresetService {

    @Autowired
    private TravelPresetRepository travelPresetRepository;

    @Autowired
    private TravelPresetMapper travelPresetMapper;

    public List<TravelPresetDTO> findAll(){
        return travelPresetMapper.toDto(travelPresetRepository.findAll());
    }

}
