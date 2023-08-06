package nl.vanbijleveld.dev.recipemanager.service;

import nl.vanbijleveld.dev.recipemanager.dao.RecipeRepository;
import nl.vanbijleveld.dev.recipemanager.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.ofNullable;
import static nl.vanbijleveld.dev.recipemanager.fixture.RecipeFixture.mockRecipe;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @Test
    void testFindRecipe_ok() {
        var mockRecipe = mockRecipe(3L);
        when(recipeRepository.findById(3L)).thenReturn(ofNullable(mockRecipe));

        assertEquals(recipeService.getRecipeById(3L), mockRecipe);
    }

    @Test
    void testFindRecipe_notFound() {
        assertThrows(ResourceNotFoundException.class, () -> recipeService.getRecipeById(3L));
    }

}