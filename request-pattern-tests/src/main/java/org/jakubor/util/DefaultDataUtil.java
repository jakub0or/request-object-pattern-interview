package org.jakubor.util;

import io.swagger.client.model.Category;
import io.swagger.client.model.Pet;
import io.swagger.client.model.Tag;

import java.util.List;

public class DefaultDataUtil {

    public static Pet getDefaultPet() {
        Pet pet = new Pet();
        Category category = new Category();
        category.setId(1L);
        category.setName("Dogs");

        Tag tag = new Tag();
        tag.setId(0L);
        tag.setName("testTag");

        pet.setName("doggie");
        pet.setId(10L);
        pet.setTags(List.of(tag));
        pet.setStatus(Pet.StatusEnum.AVAILABLE);
        pet.setPhotoUrls(List.of("string"));
        pet.setCategory(category);
        return pet;
    }
}
