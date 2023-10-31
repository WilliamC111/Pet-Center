package co.edu.uptc.PetCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.uptc.PetCenter.model.Pet;
import co.edu.uptc.PetCenter.service.PetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        Optional<Pet> existingPet = petService.getPetById(id);
        if (existingPet.isPresent()) {
            Pet updatedPet = petService.updatePet(pet, id);
            if (updatedPet != null) {
                return ResponseEntity.ok("Mascota actualizada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallo al actualizar mascota");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<Pet> getPetById(@PathVariable Long id){
        return this.petService.getPetById(id);
    }
}
