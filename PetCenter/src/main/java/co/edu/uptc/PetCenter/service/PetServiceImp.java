package co.edu.uptc.PetCenter.service;

import co.edu.uptc.PetCenter.model.Pet;
import co.edu.uptc.PetCenter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImp implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet updatePet(Pet pet, Long id) {
        Optional<Pet> existingPet = petRepository.findById(id);
        if (existingPet.isPresent()) {
            pet.setId(id); 
            return petRepository.save(pet);
        }
        return null; 
    }
}
