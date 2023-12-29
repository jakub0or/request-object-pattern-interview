import io.swagger.client.model.Pet;
import org.jakubor.PostPetStoreApiRequest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jakubor.util.DefaultDataUtil.getDefaultPet;


public class PostPetStoreApiTest extends BaseTest {

    @Test
    public void creteNewDogTest() {
        Pet defaultPet = getDefaultPet();

        Pet createdPet = new PostPetStoreApiRequest()
                .pet(defaultPet)
                .sendRequest()
                .assertStatusCode(200)
                .getResponseModel();

        assertThat(createdPet.getTags()).hasSameSizeAs(defaultPet.getTags());
        assertThat(createdPet.getTags().get(0).getId()).isEqualTo(defaultPet.getTags().get(0).getId());
        assertThat(createdPet.getTags().get(0).getName()).isEqualTo(defaultPet.getTags().get(0).getName());
    }
}
