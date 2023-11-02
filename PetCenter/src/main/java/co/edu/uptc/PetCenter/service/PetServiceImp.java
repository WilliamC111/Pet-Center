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
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return null;
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return Optional.empty();
    }

    @Override
    public Pet updatePet(Pet pet, Long id) {
        Optional<Pet> existingPet = petRepository.findById(id);
        if (existingPet.isPresent()) {
            pet.setId(id); 
            return petRepository.save(pet);
        }
        return null; 
    }

    @Override
    public boolean deletePet(Long id){
        try{
            petRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
