package ru.prepare2travel.prepare2travelserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelDTO;
import ru.prepare2travel.prepare2travelserver.mapper.TravelMapper;
import ru.prepare2travel.prepare2travelserver.model.Travel;
import ru.prepare2travel.prepare2travelserver.repository.DayRepository;
import ru.prepare2travel.prepare2travelserver.repository.ItemRepository;
import ru.prepare2travel.prepare2travelserver.repository.TravelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TravelMapper travelMapper;

    public List<TravelDTO> findAll(){
        return travelRepository.findAll().stream().map(travelMapper::toDto).collect(Collectors.toList());
    }

    public TravelDTO saveTravel(TravelDTO dto){
        Travel travel = travelMapper.fromDto(dto);
        travel = travelRepository.save(travel);
        return travelMapper.toDto(travel);
    }

    public TravelDTO findById(Long id){
        Travel travel = travelRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Cannot find entity with id: "+id));
        return travelMapper.toDto(travel);
    }
}
